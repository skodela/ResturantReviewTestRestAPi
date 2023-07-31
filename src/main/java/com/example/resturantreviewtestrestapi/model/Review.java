package com.example.resturantreviewtestrestapi.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reviewId")
public class Review {
   /* @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;*/
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long reviewId;
    private Integer rating;

    private String reviewerName;
     private LocalDate dateCreated =  LocalDate.now() ;
    @ManyToOne
    @JoinColumn(name = "user1")
    private User_Info user1;
    @ManyToOne
   /* @JoinColumn(name = "restaurantId")*/
    private Restaurant restaurant;

    @Override
    public String toString() {
        return "Review : {" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", reviewerName='" + reviewerName + '\'' +
                ", dateCreated=" + dateCreated +
                ", user1=" + user1.getUserId()+
                ", restaurant=" + restaurant.getRestaurantId() +
                '}';
    }
}
