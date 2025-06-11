package dev.hekmyr.holidays.api.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import dev.hekmyr.holidays.api.dto.*;
import dev.hekmyr.holidays.api.exception.*;
import dev.hekmyr.holidays.api.model.ErrorCodes;

@Service
public class ReservationService {

    private static final Duration MINIMUM_STAY_DURATION = Duration.ofDays(1);

    private final OdooService odooService;
    private final RentalPropertyService rentalPropertyService;
    private final PaymentService paymentService;

    private final String MODEL_NAME = "sale.order.line";
    private final List<String> FIELDS = List.of(
        "id",
        "product_id",
        "date_stay_begin",
        "date_stay_end"
    );
    private final List<String> SALE_ORDER_FIELDS = List.of(
        "id",
        "amount_total"
    );

    public ReservationService(
        OdooService odooService,
        RentalPropertyService rentalPropertyService,
        PaymentService paymentService
    ) {
        this.paymentService = paymentService;
        this.odooService = odooService;
        this.rentalPropertyService = rentalPropertyService;
    }

    public Session createReservation(
        int userId,
        ReservationCreateDTO dto
    ) throws BadRequestException, InternalErrorException, NotFoundException, StripeException {

        OdooRentalPropertyDTO property = rentalPropertyService.findById(dto.getPropertyId());

        if (dto.getGuests() > property.getMaxGuests()) {
            throw new BadRequestException(
                ErrorCodes.TOO_MANY_GUEST,
                "Number of guests exceeds property capacity."
            );
        }

        if (dto.getDateStayBegin() == null || dto.getDateStayEnd() == null) {
            throw new BadRequestException(
                ErrorCodes.NO_DATE_PROVIDED,
                "Stay start and end dates must be provided."
            );
        }
        if (!dto.getDateStayBegin().isBefore(dto.getDateStayEnd())) {
            throw new BadRequestException(
                ErrorCodes.END_DATE_BEFORE_START,
                "Stay start date must be before stay end date."
            );
        }

        var stayDuration = Duration.between(
            dto.getDateStayBegin(),
            dto.getDateStayEnd()
        );
        if (stayDuration.compareTo(MINIMUM_STAY_DURATION) < 0) {
            throw new BadRequestException(
                ErrorCodes.TOO_SHORT_DURATION,
                "Minimum stay duration is " +
                MINIMUM_STAY_DURATION.toDays() +
                " night(s)."
            );
        }

        OdooOrderCreateDTO orderDTO = new OdooOrderCreateDTO();
        orderDTO.setPartnerId(userId);

        OdooOrderCreateResponseDTO response = odooService.save("sale.order", orderDTO, OdooOrderCreateResponseDTO.class);

        OdooOrderLineCreateDTO orderLineDTO = new OdooOrderLineCreateDTO();
        int orderId = response.getResult().intValue();
        orderLineDTO.setOrderId(orderId);
        orderLineDTO.setProductId(dto.getPropertyId());
        orderLineDTO.setDateStayEnd(dto.getDateStayEnd());
        orderLineDTO.setDateStayBegin(dto.getDateStayBegin());

        odooService.save("sale.order.line", orderLineDTO, OdooResponseDTO.class);
        OdooSaleOrderDTO saleOrder = findSaleOrderById(orderId);
        long amount = saleOrder.getAmountTotal();

        return paymentService.createCheckoutSession(amount);
    }

    public List<OdooReservationDTO> findAllByUserId(int userId) throws InternalErrorException {
        List<List<String>> conditions = List.of();
        OdooReservationGetDTO response = odooService.find(MODEL_NAME, FIELDS, conditions, OdooReservationGetDTO.class);
        return response.getResult();
    }

    public OdooSaleOrderDTO findSaleOrderById(int id) throws InternalErrorException {
        List<List<String>> conditions = List.of(List.of("id", "=", Integer.toString(id)));
        OdooSaleOrderGetResponseDTO response = odooService.find(
            "sale.order",
            SALE_ORDER_FIELDS,
            conditions,
            OdooSaleOrderGetResponseDTO.class
        );
        return response.getResult().getFirst();
    }
}
