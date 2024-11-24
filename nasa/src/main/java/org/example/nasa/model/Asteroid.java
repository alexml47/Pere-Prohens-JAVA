package org.example.nasa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "asteroid")
public class Asteroid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "magnitude")
    private double magnitude;

    @Column(name = "diameter")
    private double diameter;

    @Column(name = "dangerous")
    private boolean dangerous;

    @Column(name = "nasaAsteroid")
    private boolean nasaAsteroid;

    @OneToMany(mappedBy = "asteroid", cascade = CascadeType.ALL)
    private List<Aproach> aprochments;

    public Asteroid(String name, double magnitude, double diameter, boolean dangerous, boolean nasaAsteroid) {
        this.name = name;
        this.magnitude = magnitude;
        this.diameter = diameter;
        this.dangerous = dangerous;
        this.nasaAsteroid = nasaAsteroid;
    }

    public Asteroid(int id,String name, double magnitude, double diameter, boolean dangerous, boolean nasaAsteroid) {
        this.id = id;
        this.name = name;
        this.magnitude = magnitude;
        this.diameter = diameter;
        this.dangerous = dangerous;
        this.nasaAsteroid = nasaAsteroid;
    }

    public Asteroid() {

    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "id=" + id +
                ", name=" + name +
                ", magnitude=" + magnitude +
                ", diameter=" + diameter +
                ", dangerous=" + dangerous +
                ", nasa asteroid=" + nasaAsteroid +
                '}';
    }
}
