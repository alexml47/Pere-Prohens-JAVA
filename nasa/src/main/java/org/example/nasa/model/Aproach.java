package org.example.nasa.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;


@Data
@Entity
@Table(name = "aproach")
public class Aproach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Setter
    @Column(name = "aproachDate")
    private LocalDate aproachDate;

    @Column(name = "velocity")
    private double velocity;

    @Column(name = "distance")
    private double distance;

    @Column(name = "orbitingBody")
    private String orbitingBody;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_asteroid")
    private Asteroid asteroid;



    public Aproach(LocalDate aproachDate, double velocity, double distance, String orbitingBody,Asteroid asteroid) {
        this.aproachDate = aproachDate;
        this.velocity = velocity;
        this.distance = distance;
        this.orbitingBody = orbitingBody;
        this.asteroid = asteroid;
    }

    public Aproach(int id, LocalDate aproachDate, double velocity, double distance, String orbitingBody) {
        this.id = id;
        this.aproachDate = aproachDate;
        this.velocity = velocity;
        this.distance = distance;
        this.orbitingBody = orbitingBody;
    }

    public Aproach() {}


    @Override
    public String toString() {
        return "Aproach{" +
                "aproachDate=" + aproachDate +
                ", velocity=" + velocity +
                ", distance=" + distance +
                ", orbitingBody='" + orbitingBody + '\'' +
                '}';
    }
}
