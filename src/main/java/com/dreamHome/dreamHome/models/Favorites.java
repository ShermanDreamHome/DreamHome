package com.dreamHome.dreamHome.models;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "listing")
    private Listing listing;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Favorites() {}

    public Favorites(Long id, Listing listing, User user) {
        this.id = id;
        this.listing = listing;
        this.user = user;
    }

    public Favorites(Listing listing, User user) {
        this.listing = listing;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                ", listing=" + listing +
                ", user=" + user +
                '}';
    }
}
