
package com.app.recetas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="receta")
public class Receta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") 
    private int id;
    @Column(name="tipo") 
    private String tipo;
    @Column(name="autor") 
    private String autor;
    @Column(name="nombre") 
    private String nombre;
    @Column(name="rendimiento") 
    private String rendimiento;
    @Column(name="ingredientes") 
    private String ingredientes;
    @Column(name="procedimiento") 
    private String procedimiento;
    @Column(name="consejo") 
    private String consejo;

    public Receta() {
    }

    public Receta(
            String tipo, String autor, String nombre, String rendimiento, 
            String ingredientes, String procedimiento, String consejo
    ) {
        this.tipo = tipo;
        this.autor = autor;
        this.nombre = nombre;
        this.rendimiento = rendimiento;
        this.ingredientes = ingredientes;
        this.procedimiento = procedimiento;
        this.consejo = consejo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

   
}