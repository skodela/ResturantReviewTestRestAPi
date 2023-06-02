package com.example.resturantreviewtestrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    Long restaurantId;

    @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    String name;

    @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    String address;

    @Column
    Long reviews;

    @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    String website;

    @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    String cuisinetype;

    @Override
    public String toString() {
        return "User [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address
                + ", reviews=" + reviews + ", website=" + website + ", cuisinetype=" + cuisinetype + "]";
    }
}