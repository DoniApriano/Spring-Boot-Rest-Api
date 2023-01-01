package com.latihan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class SupplierData {

    @NotEmpty(message = "Masukkan nama")
    private String name;

    @NotEmpty(message = "Masukkan alamat")
    private String address;

    @NotEmpty(message = "Masukkan email")
    @Email(message = "Emali tidak valdi")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
