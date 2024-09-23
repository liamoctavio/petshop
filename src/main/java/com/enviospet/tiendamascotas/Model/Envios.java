package com.enviospet.tiendamascotas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.slf4j.LoggerFactory;

import jakarta.persistence.Column;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Table(name = "envios")
public class Envios {


    private static final Logger logger = LoggerFactory.getLogger(Envios.class);

    // Definir los atributos
    @Id // Indica que el atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor es autogenerado
    @Column(name = "id")
    private Long id;
    @Column(name = "destinatario")
    private String destinatario;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "peso")
    private double peso;
    @Column(name = "costo")
    private double costo;

    

    // Métodos getter y setter para cada atributo
    public Long getId() {
        logger.info("Estableciendo id: {}", id);
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinatario() {
        logger.info("Estableciendo destinatario: {}", destinatario);
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccion() {
        logger.info("Estableciendo direccion: {}", direccion);
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPeso() {
        logger.info("Estableciendo peso: {}", peso);
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        logger.info("Estableciendo costo: {}", costo);
        this.costo = costo;
    }
}
