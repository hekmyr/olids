package dev.hekmyr.holidays.api.entity;

import dev.hekmyr.holidays.api.dto.AccessibilityDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accessibilities")
public class Accessibility {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "toilet_grab_bar", nullable = false)
    private boolean toiletGrabBarAvailable;

    @Column(name = "shower_grab_bar", nullable = false)
    private boolean showerGrabBarAvailable;

    @Column(name = "step_free_shower", nullable = false)
    private boolean stepFreeShowerAvailable;

    @Column(name = "shower_bath_chair", nullable = false)
    private boolean showerBathChairAvailable;

    @Column(name = "step_free_bedroom_access", nullable = false)
    private boolean stepFreeBedroomAccessAvailable;

    @Column(name = "wide_bedroom_entrance", nullable = false)
    private boolean wideBedroomEntranceAvailable;

    @Column(name = "step_free_access", nullable = false)
    private boolean stepFreeAccessAvailable;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false)
    private LocalDateTime dateUpdated;

    public Accessibility() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isToiletGrabBarAvailable() {
        return toiletGrabBarAvailable;
    }

    public void setToiletGrabBarAvailable(boolean toiletGrabBarAvailable) {
        this.toiletGrabBarAvailable = toiletGrabBarAvailable;
    }

    public boolean isShowerGrabBarAvailable() {
        return showerGrabBarAvailable;
    }

    public void setShowerGrabBarAvailable(boolean showerGrabBarAvailable) {
        this.showerGrabBarAvailable = showerGrabBarAvailable;
    }

    public boolean isStepFreeShowerAvailable() {
        return stepFreeShowerAvailable;
    }

    public void setStepFreeShowerAvailable(boolean stepFreeShowerAvailable) {
        this.stepFreeShowerAvailable = stepFreeShowerAvailable;
    }

    public boolean isShowerBathChairAvailable() {
        return showerBathChairAvailable;
    }

    public void setShowerBathChairAvailable(boolean showerBathChairAvailable) {
        this.showerBathChairAvailable = showerBathChairAvailable;
    }

    public boolean isStepFreeBedroomAccessAvailable() {
        return stepFreeBedroomAccessAvailable;
    }

    public void setStepFreeBedroomAccessAvailable(
        boolean stepFreeBedroomAccessAvailable
    ) {
        this.stepFreeBedroomAccessAvailable = stepFreeBedroomAccessAvailable;
    }

    public boolean isWideBedroomEntranceAvailable() {
        return wideBedroomEntranceAvailable;
    }

    public void setWideBedroomEntranceAvailable(
        boolean wideBedroomEntranceAvailable
    ) {
        this.wideBedroomEntranceAvailable = wideBedroomEntranceAvailable;
    }

    public boolean isStepFreeAccessAvailable() {
        return stepFreeAccessAvailable;
    }

    public void setStepFreeAccessAvailable(boolean stepFreeAccessAvailable) {
        this.stepFreeAccessAvailable = stepFreeAccessAvailable;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public static Accessibility fromDTO(AccessibilityDTO dto) {
        var entity = new Accessibility();
        entity.toiletGrabBarAvailable = dto.isToiletGrabBarAvailable();
        entity.showerGrabBarAvailable = dto.isShowerGrabBarAvailable();
        entity.stepFreeShowerAvailable = dto.isStepFreeShowerAvailable();
        entity.showerBathChairAvailable = dto.isShowerBathChairAvailable();
        entity.stepFreeBedroomAccessAvailable =
            dto.isStepFreeBedroomAccessAvailable();
        entity.wideBedroomEntranceAvailable =
            dto.isWideBedroomEntranceAvailable();
        entity.stepFreeAccessAvailable = dto.isStepFreeAccessAvailable();
        entity.dateCreated = LocalDateTime.now();
        entity.dateUpdated = LocalDateTime.now();
        return entity;
    }
}
