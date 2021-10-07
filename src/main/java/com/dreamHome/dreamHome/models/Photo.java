package com.dreamHome.dreamHome.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;


    @Column(nullable = false, length = 255)
    @Getter
    @Setter
    private String locationUrl;

    @ManyToOne
    @JoinColumn(name = "listing_id")
    @Getter
    @Setter
    private Listing listing;


    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", locationUrl='" + locationUrl + '\'' +
                ", listing=" + listing +
                '}';
    }
}
