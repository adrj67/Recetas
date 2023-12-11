
package com.app.recetas.controller;

import com.app.recetas.dto.Mensaje;
import com.app.recetas.dto.RecetaDto;
import com.app.recetas.entity.Receta;
import com.app.recetas.service.RecetaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/receta")
@CrossOrigin(origins = "http://localhost:4200")
public class RecetaController {
    
    @Autowired
    RecetaService recetaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Receta>> list(){
        List<Receta> list = recetaService.list();
        return new ResponseEntity<List<Receta>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Receta> getById(@PathVariable("id") int id){
        if(!recetaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Receta receta = recetaService.getOne(id).get();
        return new ResponseEntity(receta, HttpStatus.OK);
    }
   
     @GetMapping("/detailName/{nombre}")
    public ResponseEntity<Receta> getByNombre(@PathVariable("nombre") String nombre){
        if(!recetaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Receta receta = recetaService.getByNombre(nombre).get();
        return new ResponseEntity(receta, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RecetaDto recetaDto){
        if (StringUtils.isBlank(recetaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        // Agregado AUTOR
       if (recetaService.existsByNombreAndAutor(recetaDto.getNombre(), recetaDto.getAutor())) {
            return new ResponseEntity(new Mensaje("Esa receta de ese autor ya existe"), HttpStatus.BAD_REQUEST);}
        Receta receta = new Receta(recetaDto.getTipo(), recetaDto.getAutor(), recetaDto.getNombre(),  recetaDto.getIngredientes(), recetaDto.getProcedimiento());
        recetaService.save(receta);
        return new ResponseEntity(new Mensaje("Receta creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody RecetaDto recetaDto){
        if(!recetaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(recetaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (recetaService.existsByNombreAndAutorAndIdNot(recetaDto.getNombre(), recetaDto.getAutor(), id)) {
            return new ResponseEntity(new Mensaje("Ya existe una receta con ese nombre para este autor"), HttpStatus.BAD_REQUEST);
    }
       
        Receta receta = recetaService.getOne(id).get();
        receta.setTipo(recetaDto.getTipo());
        receta.setAutor(recetaDto.getAutor());
        receta.setNombre(recetaDto.getNombre());
        receta.setIngredientes(recetaDto.getIngredientes());
        receta.setProcedimiento(recetaDto.getProcedimiento());
        
        recetaService.save(receta);
        return new ResponseEntity(new Mensaje("Receta Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!recetaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.NOT_FOUND);
        recetaService.delete(id);
        return new ResponseEntity(new Mensaje("Receta eliminada"), HttpStatus.OK);
     }       
}