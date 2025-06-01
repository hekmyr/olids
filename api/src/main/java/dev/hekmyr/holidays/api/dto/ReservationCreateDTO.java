package dev.hekmyr.holidays.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationCreateDTO {

    private UUID propertyId;
    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;
    private int guests;

    public ReservationCreateDTO() {}

    public ReservationCreateDTO(
        UUID propertyId,
        LocalDateTime stayStart,
        LocalDateTime stayEnd
    ) {
        this.propertyId = propertyId;
        this.stayStart = stayStart;
        this.stayEnd = stayEnd;
    }

    public ReservationCreateDTO(
        UUID propertyId,
        LocalDateTime stayStart,
        LocalDateTime stayEnd,
        int guests
    ) {
        this.propertyId = propertyId;
        this.stayStart = stayStart;
        this.stayEnd = stayEnd;
        this.guests = guests;
    }

    public UUID getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDateTime getStayStart() {
        return stayStart;
    }

    public void setStayStart(LocalDateTime stayStart) {
        this.stayStart = stayStart;
    }

    public LocalDateTime getStayEnd() {
        return stayEnd;
    }

    public void setStayEnd(LocalDateTime stayEnd) {
        this.stayEnd = stayEnd;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
}
