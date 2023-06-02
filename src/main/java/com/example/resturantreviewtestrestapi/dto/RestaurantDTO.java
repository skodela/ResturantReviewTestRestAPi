package com.example.resturantreviewtestrestapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RestaurantDTO {
    //Name, Address, Reviews, Website, Cuisine Type
    private String name;
    private String address;
    private Integer reviews;
    private String website;
    private String cuisineType;
}
