package dev.hekmyr.holidays.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class PaymentService {

    @Value("${STRIPE_API_KEY}")
    private String apiKey;

    @Value("${STRIPE_CURRENCY}")
    private String currency;

    @Value("${PAYMENT_SUCCESS_ENDPOINT}")
    private String successEndpoint;

    @Value("${PAYMENT_CANCEL_ENDPOINT}")
    private String cancelEndpoint;

    @Value("${CLIENT_URL}")
    private String clientUrl;

    public Session createCheckoutSession(long amount) throws StripeException {
        Stripe.apiKey = apiKey;
        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(clientUrl + "/" + successEndpoint)
            .setCancelUrl(clientUrl + "/" + cancelEndpoint)
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency(currency)
                            .setUnitAmount(amount)
                            .setProductData(
                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                    .setName("Reservation")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build();
        return Session.create(params);
    }
}
