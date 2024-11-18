package org.example.nasa.model;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
@Table(name = "aproach")
public class Aproach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "aproach_date")
    private LocalDate aproachDate;

    @Column(name = "velocity")
    private double velocity;

    @Column(name = "distance")
    private double distance;

    @Column(name = "orbiting_body")
    private String orbitingBody;

    @ManyToOne
    @JoinColumn(name = "id_asteroid")
    private Asteroid asteroid;



    public Aproach(LocalDate aproachDate, double velocity, double distance, String orbitingBody,Asteroid asteroid) {
        this.aproachDate = aproachDate;
        this.velocity = velocity;
        this.distance = distance;
        this.orbitingBody = orbitingBody;
        this.asteroid = asteroid;
    }

    public Aproach() {}

    public LocalDate getAproachDate() {
        return aproachDate;
    }

    public void setAproachDate(LocalDate aproachDate) {
        this.aproachDate = aproachDate;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    @Override
    public String toString() {
        return "Aproach{" +
                "aproachDate=" + aproachDate +
                ", velocity=" + velocity +
                ", distance=" + distance +
                ", orbitingBody='" + orbitingBody + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
