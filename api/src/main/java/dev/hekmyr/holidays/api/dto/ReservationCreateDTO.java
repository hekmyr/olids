package dev.hekmyr.holidays.api.dto;

import java.time.LocalDateTime;

public class ReservationCreateDTO {

    private int propertyId;
    private LocalDateTime dateStayBegin;
    private LocalDateTime dateStayEnd;
    private int guests;

    public ReservationCreateDTO() {}

    public ReservationCreateDTO(
        int propertyId,
        LocalDateTime dateStayBegin,
        LocalDateTime dateStayEnd
    ) {
        this.propertyId = propertyId;
        this.dateStayBegin = dateStayBegin;
        this.dateStayEnd = dateStayEnd;
    }

    public ReservationCreateDTO(
        int propertyId,
        LocalDateTime dateStayBegin,
        LocalDateTime dateStayEnd,
        int guests
    ) {
        this.propertyId = propertyId;
        this.dateStayBegin = dateStayBegin;
        this.dateStayEnd = dateStayEnd;
        this.guests = guests;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDateTime getDateStayBegin() {
        return dateStayBegin;
    }

    public void setDateStayBegin(LocalDateTime dateStayBegin) {
        this.dateStayBegin = dateStayBegin;
    }

    public LocalDateTime getDateStayEnd() {
        return dateStayEnd;
    }

    public void setDateStayEnd(LocalDateTime dateStayEnd) {
        this.dateStayEnd = dateStayEnd;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
}
