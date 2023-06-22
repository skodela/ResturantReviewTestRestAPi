package com.example.resturantreviewtestrestapi.model;

import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class Address {
    @Id
    public Long id;
    public String street;
    public String city;
    public String state;
    public String zip;
 /*   @OneToOne(mappedBy = "address" )
    private Restaurant restaurant;*/
}
