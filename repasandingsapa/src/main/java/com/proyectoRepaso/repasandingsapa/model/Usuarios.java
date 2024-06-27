package com.proyectoRepaso.repasandingsapa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false,updatable = false)
    private Integer idUsuario;

    @Column(name = "nombre_usuario",nullable = false,updatable = false)
    private String nombreUsuario;

    @Column(name = "correo_usuario",nullable = false,updatable = false)
    private String correoUsuario;
}
