package dev.hekmyr.holidays.api.entity;

import dev.hekmyr.holidays.api.dto.AmenityDTO;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "amenities")
public class Amenity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "air_conditioning", nullable = false)
    private boolean airConditioningAvailable;

    @Column(name = "terrace", nullable = false)
    private boolean terraceAvailable;

    @Column(name = "garden", nullable = false)
    private boolean gardenAvailable;

    @Column(name = "pool", nullable = false)
    private boolean poolAvailable;

    @Column(name = "hot_tub", nullable = false)
    private boolean hotTubAvailable;

    @Column(name = "ev_charger", nullable = false)
    private boolean evChargerAvailable;

    @Column(name = "indoor_fireplace", nullable = false)
    private boolean indoorFireplaceAvailable;

    @Column(name = "outdoor_fireplace", nullable = false)
    private boolean outdoorFireplaceAvailable;

    @Column(name = "dedicated_workspace", nullable = false)
    private boolean dedicatedWorkspaceAvailable;

    @Column(name = "gym", nullable = false)
    private boolean gymAvailable;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false)
    private LocalDateTime dateUpdated;

    public Amenity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isAirConditioningAvailable() {
        return airConditioningAvailable;
    }

    public void setAirConditioningAvailable(boolean airConditioningAvailable) {
        this.airConditioningAvailable = airConditioningAvailable;
    }

    public boolean isTerraceAvailable() {
        return terraceAvailable;
    }

    public void setTerraceAvailable(boolean terraceAvailable) {
        this.terraceAvailable = terraceAvailable;
    }

    public boolean isGardenAvailable() {
        return gardenAvailable;
    }

    public void setGardenAvailable(boolean gardenAvailable) {
        this.gardenAvailable = gardenAvailable;
    }

    public boolean isPoolAvailable() {
        return poolAvailable;
    }

    public void setPoolAvailable(boolean poolAvailable) {
        this.poolAvailable = poolAvailable;
    }

    public boolean isHotTubAvailable() {
        return hotTubAvailable;
    }

    public void setHotTubAvailable(boolean hotTubAvailable) {
        this.hotTubAvailable = hotTubAvailable;
    }

    public boolean isEvChargerAvailable() {
        return evChargerAvailable;
    }

    public void setEvChargerAvailable(boolean evChargerAvailable) {
        this.evChargerAvailable = evChargerAvailable;
    }

    public boolean isIndoorFireplaceAvailable() {
        return indoorFireplaceAvailable;
    }

    public void setIndoorFireplaceAvailable(boolean indoorFireplaceAvailable) {
        this.indoorFireplaceAvailable = indoorFireplaceAvailable;
    }

    public boolean isOutdoorFireplaceAvailable() {
        return outdoorFireplaceAvailable;
    }

    public void setOutdoorFireplaceAvailable(
        boolean outdoorFireplaceAvailable
    ) {
        this.outdoorFireplaceAvailable = outdoorFireplaceAvailable;
    }

    public boolean isDedicatedWorkspaceAvailable() {
        return dedicatedWorkspaceAvailable;
    }

    public void setDedicatedWorkspaceAvailable(
        boolean dedicatedWorkspaceAvailable
    ) {
        this.dedicatedWorkspaceAvailable = dedicatedWorkspaceAvailable;
    }

    public boolean isGymAvailable() {
        return gymAvailable;
    }

    public void setGymAvailable(boolean gymAvailable) {
        this.gymAvailable = gymAvailable;
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

    public static Amenity fromDTO(AmenityDTO dto) {
        var entity = new Amenity();
        entity.id = dto.getId();
        entity.airConditioningAvailable = dto.isAirConditioningAvailable();
        entity.terraceAvailable = dto.isTerraceAvailable();
        entity.gardenAvailable = dto.isGardenAvailable();
        entity.poolAvailable = dto.isPoolAvailable();
        entity.hotTubAvailable = dto.isHotTubAvailable();
        entity.evChargerAvailable = dto.isEvChargerAvailable();
        entity.indoorFireplaceAvailable = dto.isIndoorFireplaceAvailable();
        entity.outdoorFireplaceAvailable = dto.isOutdoorFireplaceAvailable();
        entity.dedicatedWorkspaceAvailable =
            dto.isDedicatedWorkspaceAvailable();
        entity.gymAvailable = dto.isGymAvailable();
        entity.dateCreated = LocalDateTime.now();
        entity.dateUpdated = LocalDateTime.now();
        return entity;
    }
}
