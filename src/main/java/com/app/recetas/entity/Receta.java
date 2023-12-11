
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
    @Column(name="ingredientes") 
    private String ingredientes;
    @Column(name="procedimiento") 
    private String procedimiento;

    public Receta() {
    }

    public Receta(String tipo, String autor, String nombre, String ingredientes, String procedimiento) {
        this.tipo = tipo;
        this.autor = autor;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.procedimiento = procedimiento;
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
    
}