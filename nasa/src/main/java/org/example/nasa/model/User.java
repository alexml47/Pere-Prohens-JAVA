package org.example.nasa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column
    String userName;

    @Column
    String password;
}
