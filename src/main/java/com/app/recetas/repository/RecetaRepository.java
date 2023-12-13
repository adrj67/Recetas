
package com.app.recetas.repository;

import com.app.recetas.entity.Receta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer>{
    
    Optional<Receta> findByNombre(String nombre);
    boolean existsByNombre (String nombre);
    
    Optional<Receta> findByTipo(String tipo);
    boolean existsByTipo (String tipo);

    // Agregado AUTOR
    public boolean existsByAutor(String autor); 
    // Autor y nombre
    public boolean existsByNombreAndAutor(String nombre, String autor);
    // autor y nombre pero otro ID
    public Optional<Receta> findByNombreAndAutorAndIdNot(String nombre, String autor, int id);
    
}
