package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "estadio")
@Setter
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestadio;

    @Column(name="nombre",nullable = false,length = 40)
    private String nombre;

    @Column(name="provincia",nullable = false,length = 40)
    private String provincia;

    @Column(name="club",nullable = false,length = 40)
    private String club;

    public Estadio() {

    }
}
