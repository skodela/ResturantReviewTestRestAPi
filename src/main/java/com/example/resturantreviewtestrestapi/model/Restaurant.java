package com.example.resturantreviewtestrestapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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


    @OneToMany(targetEntity =Review.class, cascade = CascadeType.ALL)
    @JoinColumn(name="review_fk",referencedColumnName = "restaurantId")
    private List<Review> reviews = new ArrayList<>();


    @Column
    String website;

    @Column
    @Enumerated(EnumType.STRING)
    Cuisine cuisine;
    /*public enum Cuisine{
        Chineese,
        Italian,
        American,
        Indian
    };*/

  /*  @Override
    public String toString() {
        return "User [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address
                + ", reviews=" + reviews + ", website=" + website + ", cuisinetype=" + cuisinetype + "]";
    }*/
}