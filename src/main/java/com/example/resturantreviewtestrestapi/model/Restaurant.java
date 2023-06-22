package com.example.resturantreviewtestrestapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    Long restaurantId;

    @Column
    String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_address" )
    public Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_review" )
    public List<Review> reviews;


    @Column
    String website;

    @Column
    Cuisine cuisine;
    public enum Cuisine{
        Chineese,
        Italian,
        American,
        Indian
    };

  /*  @Override
    public String toString() {
        return "User [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address
                + ", reviews=" + reviews + ", website=" + website + ", cuisinetype=" + cuisinetype + "]";
    }*/
}