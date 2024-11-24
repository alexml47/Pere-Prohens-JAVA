package org.example.nasa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column
    String rol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<User> users;

    public Rol(int id, String rol) {
        this.id = id;
        this.rol = rol;
    }
}
