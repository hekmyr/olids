package dev.hekmyr.holidays.api.dto;

import java.time.LocalDate;

import dev.hekmyr.holidays.api.entity.User;

public class UserDTO {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private String street;
    private String number;
    private String postalCode;
    private LocalDate birthDate;

    public UserDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public static UserDTO fromUserDTO(User model) {
        var user = new UserDTO();
        user.lastName = model.getLastName();
        user.firstName = model.getFirstName();
        user.email = model.getEmail();
        user.phoneNumber = model.getPhoneNumber();
        user.street = model.getStreet();
        user.number = model.getNumber();
        user.postalCode = model.getPostalCode();
        user.birthDate = model.getBirthDate();
        return user;
    }

    public static UserDTO fromOdooUserDTO(OdooUserCreateDTO dto) {
        var user = new UserDTO();
        user.email = dto.getEmail();
        return user;
    }
}
