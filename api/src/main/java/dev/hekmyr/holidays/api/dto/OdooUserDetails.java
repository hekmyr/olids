package dev.hekmyr.holidays.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdooUserDetails {

    @JsonProperty("id")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
