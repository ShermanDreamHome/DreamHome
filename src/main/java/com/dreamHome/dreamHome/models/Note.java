package com.dreamHome.dreamHome.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 200)
    @Getter
    @Setter
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Getter
    @Setter
    private String description;

    @ManyToOne
    @Getter
    @Setter
    private User user;

    @ManyToOne
    @Getter
    @Setter
    private Listing listing;


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", listing=" + listing +
                '}';
    }
}
