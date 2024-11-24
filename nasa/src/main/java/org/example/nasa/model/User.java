package org.example.nasa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column
    String name;

    @Column
    String password;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public User(String name, String password, Rol rol) {
        this.name = name;
        this.password = password;
        this.rol = rol;
    }

    public User() {}
}
