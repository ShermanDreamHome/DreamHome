package com.dreamHome.dreamHome.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private Integer price;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer squareFt;

    @ManyToOne
    private Location location;

    @Column(nullable = false, length = 200)
    private Long owner_id;

    @Column(nullable = false, length = 200)
    private Long realtor_api_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listing")
    private List<Photo> photos;

    public Listing() {}


    public Listing(Long id, Integer price, String title, String description, Integer squareFt, Location location, Long owner_id, Long realtor_api_id, List<Photo> photos) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.description = description;
        this.squareFt = squareFt;
        this.location = location;
        this.owner_id = owner_id;
        this.realtor_api_id = realtor_api_id;
        this.photos = photos;
    }

    public Listing(Integer price, String title, String description, Integer squareFt, Location location, Long owner_id, Long realtor_api_id, List<Photo> photos) {
        this.price = price;
        this.title = title;
        this.description = description;
        this.squareFt = squareFt;
        this.location = location;
        this.owner_id = owner_id;
        this.realtor_api_id = realtor_api_id;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSquareFt() {
        return squareFt;
    }

    public void setSquareFt(Integer squareFt) {
        this.squareFt = squareFt;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getRealtor_api_id() {
        return realtor_api_id;
    }

    public void setRealtor_api_id(Long realtor_api_id) {
        this.realtor_api_id = realtor_api_id;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", squareFt=" + squareFt +
                ", location=" + location +
                ", owner_id=" + owner_id +
                ", realtor_api_id=" + realtor_api_id +
                ", photos=" + photos +
                '}';
    }
}
