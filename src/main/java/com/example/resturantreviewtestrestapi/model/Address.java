package com.example.resturantreviewtestrestapi.model;

import lombok.*;
import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class Address {
    @Id
    @NonNull
    public Long id;
    public String street;
    public String city;
    public String state;
    public String zip;
 /*   @OneToOne(mappedBy = "address" )
    private Restaurant restaurant;*/
}
