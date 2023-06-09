package com.example.resturantreviewtestrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.NonNull;
/*import javax.persistence.*;*/
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class User {

        @Id
        @NonNull
      //  @GeneratedValue(strategy = GenerationType.AUTO)
        Long userId;


        @Column
        String username;

        String password;

        @Column
        String name;

       /* @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "fk_userReview", referencedColumnName = "userId")
        List<Review> reviews;*/

        final String role = "USER";



  /*      @Override
        public String toString() {
            return "User [userId=" + userId + ", username=" + username + ", name=" + name
                    + ", reviewCount=" + reviewCount + "]";
        }*/

    }

