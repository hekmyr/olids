package dev.hekmyr.holidays.api.dto;

import dev.hekmyr.holidays.api.entity.User;
import java.time.LocalDate;

public class UserUpdateDTO {

    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String street;
    private String number;
    private String postalCode;
    private LocalDate birthDate;

    public UserUpdateDTO() {}

    public UserUpdateDTO(User model) {
        this.lastName = model.getLastName();
        this.firstName = model.getFirstName();
        this.phoneNumber = model.getPhoneNumber();
        this.street = model.getStreet();
        this.number = model.getNumber();
        this.postalCode = model.getPostalCode();
        this.birthDate = model.getBirthDate();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
}
