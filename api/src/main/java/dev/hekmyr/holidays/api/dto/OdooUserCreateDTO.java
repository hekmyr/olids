package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooUserCreateDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("customer_rank")
    private int customerRank = 1;

    public OdooUserCreateDTO(String email, String password) {
        this.name = "Default name - " + email;
        this.email = email;
        this.password = password;
    }

    public OdooUserCreateDTO(UserCreateDTO dto) {
        this.name = dto.getEmail();
        this.password = dto.getPassword();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(int customerRank) {
        this.customerRank = customerRank;
    }
}
