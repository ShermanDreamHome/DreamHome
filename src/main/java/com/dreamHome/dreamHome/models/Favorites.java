package com.dreamHome.dreamHome.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
@AllArgsConstructor
@NoArgsConstructor
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;


    @ManyToOne
    @JoinColumn(name = "listing_id")
    @Getter
    @Setter
    private Listing listing;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;


    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                ", listing=" + listing +
                ", user=" + user +
                '}';
    }
}
