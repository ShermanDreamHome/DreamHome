package com.dreamHome.dreamHome.models;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 255)
    private String locationUrl;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Listing listing;

    public Photo() {}

    public Photo(Long id, String locationUrl, Listing listing) {
        this.id = id;
        this.locationUrl = locationUrl;
        this.listing = listing;
    }

    public Photo(String locationUrl, Listing listing) {
        this.locationUrl = locationUrl;
        this.listing = listing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", locationUrl='" + locationUrl + '\'' +
                ", listing=" + listing +
                '}';
    }
}
