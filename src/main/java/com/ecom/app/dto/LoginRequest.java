package com.ecom.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginRequest {

	@NotNull(message = "username can not be blank")
    @NotBlank(message = "username can not be blank")
    @Email
    private String username;

    @NotNull(message = "password can not be blank")
    @NotBlank(message = "password can not be blank")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
