package com.example.resturantreviewtestrestapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;
/*import javax.persistence.*;*/

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User_Info {
     /*   @GeneratedValue(strategy=GenerationType.AUTO)
        @NonNull
        private int id;*/
        @Id
        @NonNull
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long userId;

       private String username;

       private String password;

        private String name;

        private String role ;
    @JsonIdentityReference(alwaysAsId = true)
    @Column(name = "Reviews")
    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Override
    public String toString() {
        return "User_Info : {" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", reviews=" + reviews.get(0).getReviewId() +
                '}';
    }
}

