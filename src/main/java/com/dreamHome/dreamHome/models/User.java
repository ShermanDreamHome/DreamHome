package com.dreamHome.dreamHome.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", indexes = {
        @Index(name = "idx_user_location", columnList = "location")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 150)
    private String lastName;

    @Column(nullable = false, length = 175)
    private String email;

    @Column(nullable = false, length = 10)
    private Integer phone;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false)
    private String photoUrl;

    @Column(nullable = false, length = 55)
    private String password;

    @Column(nullable = false, length = 10)
    private Boolean isAdmin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="favorites",
            joinColumns={@JoinColumn(name="listing_id")},
            inverseJoinColumns={@JoinColumn(name="user_id")}
    )
    private List<Favorites> favorites;

    @ManyToOne
    private Location location;

    public User() {}

    public User(Long id, String firstName, String lastName, String email, Integer phone, String username, String photoUrl, String password, Boolean isAdmin, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.photoUrl = photoUrl;
        this.password = password;
        this.isAdmin = isAdmin;
        this.location = location;
    }

    public User(String firstName, String lastName, String email, Integer phone, String username, String photoUrl, String password, Boolean isAdmin, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.photoUrl = photoUrl;
        this.password = password;
        this.isAdmin = isAdmin;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", location=" + location +
                '}';
    }
}
