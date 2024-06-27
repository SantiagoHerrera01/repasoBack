package com.proyectoRepaso.repasandingsapa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false, updatable = false)
    private Integer idReserva;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "direccion_inicio")
    private String direccionInicial;

    @Column(name = "direccion_final")
    private String direccionFinal;
}
