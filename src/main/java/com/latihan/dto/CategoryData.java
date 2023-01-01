package com.latihan.dto;

import jakarta.validation.constraints.NotEmpty;

public class CategoryData {

    @NotEmpty(message = "Masukkan nama")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
