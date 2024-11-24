package org.example.nasa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column
    String name;

    @Column
    String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public User(String name, String password, Rol rol) {
        this.name = name;
        this.password = password;
        this.rol = rol;
    }

    public User() {}

    public User(int id, String password, String name, Rol rol) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.rol = rol;
    }
}
