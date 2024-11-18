package org.example.nasa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asteroid")
public class Asteroid {
    @Id
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

    @OneToMany(mappedBy = "asteroid", cascade = CascadeType.ALL)
    private List<Aproach> aprochments;

    public Asteroid(int id, String name, double magnitude, double diameter, boolean dangerous, List<Aproach> aprochments) {
        this.id = id;
        this.name = name;
        this.magnitude = magnitude;
        this.diameter = diameter;
        this.dangerous = dangerous;
        this.aprochments = aprochments;
    }

    public Asteroid(int id, String name, double magnitude, double diameter, boolean dangerous) {
        this.id = id;
        this.name = name;
        this.magnitude = magnitude;
        this.diameter = diameter;
        this.dangerous = dangerous;
    }

    public Asteroid() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public List<Aproach> getAprochments() {
        return aprochments;
    }

    public void setAprochments(List<Aproach> aprochments) {
        this.aprochments = aprochments;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "id=" + id +
                ", name=" + name +
                ", magnitude=" + magnitude +
                ", diameter=" + diameter +
                ", dangerous=" + dangerous +
                '}';
    }
}
