package com.example.resturantreviewtestrestapi.model;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @Column
    Long reviewId;
    @Column
    Integer rating;

   // public Restaurant restaurant;
    @Column
    String reviewerName;
    @Column
    LocalDate dateCreated;
/*   @OneToMany(mappedBy ="reviews")
    public Restaurant restaurant;*/
   /* @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;*/

}
