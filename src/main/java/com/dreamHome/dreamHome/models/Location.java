package com.dreamHome.dreamHome.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 200)
    @Getter
    @Setter
    private String address1;

    @Column(nullable = false, length = 200)
    @Getter
    @Setter
    private String address2;

    @Column(nullable = false, length = 200)
    @Getter
    @Setter
    private String city;

    @Column(nullable = false, length = 200)
    @Getter
    @Setter
    private String state;

    @Column(nullable = false, length = 20)
    @Getter
    @Setter
    private Integer zip;


    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
