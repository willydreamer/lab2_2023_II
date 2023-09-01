package com.example.lab2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "jugador")
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idjugador;

    @Column(name="nombre",nullable = false,length = 40)
    private String nombre;

    @Column(name="edad",nullable = false)
    private Integer edad;

    @Column(name="club",nullable = false,length = 200)
    private String club;

    @Column(name="posicion",nullable = false,length = 200)
    private String posicion;

    @Column(name="sn_idSeleccion")
    private Integer seleccion;
    public Jugador() {

    }
}
