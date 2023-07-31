package com.example.resturantreviewtestrestapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "restaurantId")
public class Restaurant {
  /*  @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;*/
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long restaurantId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address" )
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_info" )
    private User_Info user;

   /* @OneToMany(targetEntity =Review.class, cascade = CascadeType.ALL)
    @JoinColumn(name="reviews",referencedColumnName = "restaurantId")*/

   @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
   @Column(name = "Reviews")
   private List<Review> reviews;

    String website;

    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    @Override
    public String toString() {
        return "Restaurant : {" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", user=" + user +
                ", reviews=" + user.getReviews().get(0).getReviewId() +
                ", website='" + website + '\'' +
                ", cuisine=" + cuisine +
                '}';
    }
}