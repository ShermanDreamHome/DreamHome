package com.dreamHome.dreamHome.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "listing")
@AllArgsConstructor
@NoArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private Integer price;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Getter
    @Setter
    private String description;

    @Column(nullable = false)
    @Getter
    @Setter
    private Integer squareFt;

    @OneToOne
    @Getter
    @Setter
    private Location location;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Getter
    @Setter
    private User owner;

    @Column(nullable = true, length = 200)
    @Getter
    @Setter
    private Long realtor_api_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listing")
    @Getter
    @Setter
    private List<Photo> photos;



    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", squareFt=" + squareFt +
                ", location=" + location +
                ", owner_id=" + owner +
                ", realtor_api_id=" + realtor_api_id +
                ", photos=" + photos +
                '}';
    }
}
