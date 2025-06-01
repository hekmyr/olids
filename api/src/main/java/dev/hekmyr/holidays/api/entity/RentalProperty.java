package dev.hekmyr.holidays.api.entity;

import dev.hekmyr.holidays.api.dto.RentalPropertyDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rental_properties")
public class RentalProperty implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @OneToOne
    private Accessibility accessibility;

    @OneToOne
    private Amenity amenity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_listed", nullable = false)
    private boolean listed;

    @Column(name = "listed_at")
    private LocalDateTime listedAt;

    @Column(name = "price_per_night")
    private int pricePerNight;

    @Column(name = "beds", nullable = false)
    private int beds;

    @Column(name = "bedrooms", nullable = false)
    private int bedrooms;

    @Column(name = "bathrooms", nullable = false)
    private int bathrooms;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "max_guests", nullable = false)
    private int maxGuests;

    @Column(name = "image")
    private String image;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated", nullable = false)
    private LocalDateTime dateUpdated;

    public RentalProperty() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Accessibility getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }

    public Amenity getAmenity() {
        return amenity;
    }

    public void setAmenity(Amenity amenity) {
        this.amenity = amenity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }

    public LocalDateTime getListedAt() {
        return listedAt;
    }

    public void setListedAt(LocalDateTime listedAt) {
        this.listedAt = listedAt;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
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

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static RentalProperty fromDTO(RentalPropertyDTO dto) {
        var entity = new RentalProperty();
        entity.amenity = Amenity.fromDTO(dto.getAmenity());
        entity.accessibility = Accessibility.fromDTO(dto.getAccessibility());
        entity.name = dto.getName();
        entity.description = dto.getDescription();
        entity.listed = dto.isListed();
        entity.listedAt = entity.listed ? LocalDateTime.now() : null;
        entity.pricePerNight = dto.getPricePerNight();
        entity.beds = dto.getBeds();
        entity.bedrooms = dto.getBedrooms();
        entity.bathrooms = dto.getBathrooms();
        entity.street = dto.getStreet();
        entity.number = dto.getNumber();
        entity.postalCode = dto.getPostalCode();
        entity.image = dto.getImage();
        entity.maxGuests = dto.getMaxGuests();
        entity.dateCreated = LocalDateTime.now();
        entity.dateUpdated = LocalDateTime.now();
        return entity;
    }
}
