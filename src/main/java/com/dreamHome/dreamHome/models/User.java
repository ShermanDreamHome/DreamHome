package com.dreamHome.dreamHome.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
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

    @OneToOne
    private Location location;

    public User() {}

    public User(Long id, String firstName, String lastName, String email, Integer phone, String username, String photoUrl, String password, Boolean isAdmin, List<Favorites> favorites, Location location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.photoUrl = photoUrl;
        this.password = password;
        this.isAdmin = isAdmin;
        this.favorites = favorites;
        this.location = location;
    }

    public User(String firstName, String lastName, String email, Integer phone, String username, String photoUrl, String password, Boolean isAdmin, List<Favorites> favorites, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.photoUrl = photoUrl;
        this.password = password;
        this.isAdmin = isAdmin;
        this.favorites = favorites;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    public List<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorites> favorites) {
        this.favorites = favorites;
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
