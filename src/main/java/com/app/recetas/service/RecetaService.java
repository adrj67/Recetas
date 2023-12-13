
package com.app.recetas.service;

import com.app.recetas.entity.Receta;
import com.app.recetas.repository.RecetaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecetaService {
    
    @Autowired
    RecetaRepository recetaRepository;
    
    public List<Receta> list(){
        return recetaRepository.findAll();
    }
    
    public Optional <Receta> getOne(int id){
        return recetaRepository.findById(id);
    }
    
    public Optional<Receta> getByNombre(String nombre){
        return recetaRepository.findByNombre(nombre);
    }
    
    public Optional<Receta> getByTipo(String tipo){
        return recetaRepository.findByTipo(tipo);
    }
    
    public void save(Receta receta){
        recetaRepository.save(receta);
    }
    
    public void delete(int id){
        recetaRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
        return recetaRepository.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return recetaRepository.existsByNombre(nombre);
    }

    // Agregado AUTOR
    public boolean existsByAutor(String autor) { 
        return recetaRepository.existsByAutor(autor);
    }
    
    public boolean existsByNombreAndAutor(String nombre, String autor) {
        return recetaRepository.existsByNombreAndAutor(nombre, autor);
    }

    public boolean existsByNombreAndAutorAndIdNot(String nombre, String autor, int id) {
        Optional<Receta> existingReceta = recetaRepository.findByNombreAndAutorAndIdNot(nombre, autor, id);
        // Devuelve true si existe una receta, false si no existe
        return existingReceta.isPresent();
    }
}