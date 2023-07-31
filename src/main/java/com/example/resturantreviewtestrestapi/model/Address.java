package com.example.resturantreviewtestrestapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "address_id")
public class Address {
/*    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;*/
    @Id
    @NonNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long address_id;
    private String street;
    private String city;
    private String state;
    private String zip;

}
