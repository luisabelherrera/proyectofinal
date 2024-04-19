package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;

    private int codigo;
    private String nombre;
    private String apellido;



}
