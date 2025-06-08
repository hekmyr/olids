package dev.hekmyr.holidays.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooRentalPropertyDTO {

    private int id;
    private String name;

    @JsonProperty("categ_id")
    private List<Object> categId; // [int, String]

    @JsonProperty("list_price")
    private double listPrice;

    @JsonProperty("base_unit_price")
    private double baseUnitPrice;

    @JsonProperty("is_published")
    private boolean isPublished;

    @JsonProperty("write_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime writeDate;

    @JsonProperty("description")
    private String description;
    @JsonProperty("beds")
    private int beds;
    @JsonProperty("bedrooms")
    private int bedrooms;
    @JsonProperty("bathrooms")
    private int bathrooms;
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private String number;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("max_guests")
    private Integer maxGuests;

    // Amenity
    @JsonProperty("air_conditioning_available")
    private boolean airConditioningAvailable;
    @JsonProperty("terrace_available")
    private boolean terraceAvailable;
    @JsonProperty("garden_available")
    private boolean gardenAvailable;
    @JsonProperty("pool_available")
    private boolean poolAvailable;
    @JsonProperty("hot_tub_available")
    private boolean hotTubAvailable;
    @JsonProperty("ev_charger_available")
    private boolean evChargerAvailable;
    @JsonProperty("indoor_fireplace_available")
    private boolean indoorFireplaceAvailable;
    @JsonProperty("outdoor_fireplace_available")
    private boolean outdoorFireplaceAvailable;
    @JsonProperty("dedicated_workspace_available")
    private boolean dedicatedWorkspaceAvailable;
    @JsonProperty("gym_available")
    private boolean gymAvailable;

    // Accessibiliy
    @JsonProperty("toilet_grab_bar_available")
    private boolean toiletGrabBarAvailable;
    @JsonProperty("shower_grab_bar_available")
    private boolean showerGrabBarAvailable;
    @JsonProperty("step_free_shower_available")
    private boolean stepFreeShowerAvailable;
    @JsonProperty("shower_bath_chair_available")
    private boolean showerBathChairAvailable;
    @JsonProperty("step_free_bedroom_access_available")
    private boolean stepFreeBedroomAccessAvailable;
    @JsonProperty("wide_bedroom_entrance_available")
    private boolean wideBedroomEntranceAvailable;
    @JsonProperty("step_free_access_available")
    private boolean stepFreeAccessAvailable;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Object> getCategId() {
        return categId;
    }

    public double getListPrice() {
        return listPrice;
    }

    public double getBaseUnitPrice() {
        return baseUnitPrice;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategId(List<Object> categId) {
        this.categId = categId;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public void setBaseUnitPrice(double baseUnitPrice) {
        this.baseUnitPrice = baseUnitPrice;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public void setWriteDate(LocalDateTime writeDate) {
        this.writeDate = writeDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(Integer maxGuests) {
        this.maxGuests = maxGuests;
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

    public void setOutdoorFireplaceAvailable(boolean outdoorFireplaceAvailable) {
        this.outdoorFireplaceAvailable = outdoorFireplaceAvailable;
    }

    public boolean isDedicatedWorkspaceAvailable() {
        return dedicatedWorkspaceAvailable;
    }

    public void setDedicatedWorkspaceAvailable(boolean dedicatedWorkspaceAvailable) {
        this.dedicatedWorkspaceAvailable = dedicatedWorkspaceAvailable;
    }

    public boolean isGymAvailable() {
        return gymAvailable;
    }

    public void setGymAvailable(boolean gymAvailable) {
        this.gymAvailable = gymAvailable;
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

    public void setStepFreeBedroomAccessAvailable(boolean stepFreeBedroomAccessAvailable) {
        this.stepFreeBedroomAccessAvailable = stepFreeBedroomAccessAvailable;
    }

    public boolean isWideBedroomEntranceAvailable() {
        return wideBedroomEntranceAvailable;
    }

    public void setWideBedroomEntranceAvailable(boolean wideBedroomEntranceAvailable) {
        this.wideBedroomEntranceAvailable = wideBedroomEntranceAvailable;
    }

    public boolean isStepFreeAccessAvailable() {
        return stepFreeAccessAvailable;
    }

    public void setStepFreeAccessAvailable(boolean stepFreeAccessAvailable) {
        this.stepFreeAccessAvailable = stepFreeAccessAvailable;
    }
}
