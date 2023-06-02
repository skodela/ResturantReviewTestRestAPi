package com.example.resturantreviewtestrestapi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewModel {
    @Id
    @Column(columnDefinition = "Long ")
    Long reviewId;
    @Column(columnDefinition = "integer default 0")
    int rating;

    @Column
    Long restaurentId;
    @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    String reviewerName;
    @Column(columnDefinition = "varchar(255) default 'Anonymous'")
    Date dateCreated;

}
