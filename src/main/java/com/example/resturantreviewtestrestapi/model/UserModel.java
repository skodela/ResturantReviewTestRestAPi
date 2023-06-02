package com.example.resturantreviewtestrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

        @Id
      //  @GeneratedValue(strategy = GenerationType.AUTO)
        Long userId;


        @Column(unique = true)
        String username;

        String password;

        @Column(columnDefinition = "varchar(255) default 'Anonymous'")
        String name;

        @Column(columnDefinition = "integer default 0")
        int reviewCount;

        final String role = "USER";



        @Override
        public String toString() {
            return "User [userId=" + userId + ", username=" + username + ", name=" + name
                    + ", reviewCount=" + reviewCount + "]";
        }

    }

