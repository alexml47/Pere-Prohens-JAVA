package org.example.nasa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column
    String name;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<User> users;
}