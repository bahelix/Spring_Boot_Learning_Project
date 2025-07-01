package com.bahelix.spring_boot_microservice_2_compra.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "compra")
@Data
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "inmueble_id", nullable = false)
  private Long inmuebleId;

  @Column(name = "titulo", nullable = false)
  private String titulo;

  @Column(name = "precio", nullable = false)
  private Double precio;

  @Column(name = "fecha_compra", nullable = false)
  private LocalDateTime fechaCompra;

}
