
package com.app.recetas.dto;

import jakarta.validation.constraints.NotBlank;



public class RecetaDto {
    
    private String tipo;
    private String autor;
    @NotBlank
    private String nombre;
    private String ingredientes;
    private String procedimiento;
    
    public RecetaDto() {
    }

    public RecetaDto(String tipo, String autor, String nombre, String ingredientes, String procedimiento) {
        this.tipo = tipo;
        this.autor = autor;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.procedimiento = procedimiento;
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