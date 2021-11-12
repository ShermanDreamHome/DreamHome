package com.dreamHome.dreamHome.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String firstName;

    @Column(nullable = false, length = 150)
    @Getter
    @Setter
    private String lastName;

    @Column(nullable = false, length = 175)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false, length = 10)
    @Getter
    @Setter
    private Integer phone;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String username;

    @Column(nullable = false, length = 255)
    @Getter
    @Setter
    private String photoUrl;

    @Column(nullable = false, length = 255)
    @Getter
    @Setter
    private String password;

    @Column(nullable = false, length = 10)
    @Getter
    @Setter
    private Boolean isAdmin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="favorites",
            joinColumns={@JoinColumn(name="listing_id")},
            inverseJoinColumns={@JoinColumn(name="user_id")}
    )
    @Getter
    @Setter
    private List<Favorites> favorites;

    @OneToOne
    @Getter
    @Setter
    private Location location;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @Getter
    @Setter
    private List<Listing> listing;



    public User(User copy){

        id = copy.id;
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        phone = copy.phone;
        password = copy.password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", username='" + username + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", favorites=" + favorites +
                ", location=" + location +
                '}';
    }


}
