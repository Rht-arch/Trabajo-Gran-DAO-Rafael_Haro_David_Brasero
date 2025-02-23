package Grandao.Controladores;

import Grandao.DTO.EjemplarDTO;
import Grandao.Service.ServicioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    @Autowired
    private ServicioGeneral ejemplarService;

    // Obtener todos los ejemplares
    @GetMapping
    public List<EjemplarDTO> getAllEjemplares() {
        return ejemplarService.getAllEjemplares();
    }

    // Obtener un ejemplar por ID
    @GetMapping("/{id}")
    public ResponseEntity<EjemplarDTO> getEjemplar(@PathVariable int id) {
        EjemplarDTO ejemplar = ejemplarService.getEjemplar(id);
        if (ejemplar != null) {
            return ResponseEntity.ok(ejemplar);
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener un ejemplar por ISBN
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<EjemplarDTO> getEjemplarByIsbn(@PathVariable String isbn) {
        EjemplarDTO ejemplar = ejemplarService.getEjemplarByIsbn(isbn);
        if (ejemplar != null) {
            return ResponseEntity.ok(ejemplar);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo ejemplar
    @PostMapping
    public ResponseEntity<EjemplarDTO> addEjemplar(@RequestBody EjemplarDTO ejemplarDTO) {
        ejemplarService.addEjemplar(ejemplarDTO);
        return ResponseEntity.status(201).body(ejemplarDTO);
    }

    // Actualizar un ejemplar existente
    @PutMapping("/{id}")
    public ResponseEntity<EjemplarDTO> updateEjemplar(@PathVariable int id, @RequestBody EjemplarDTO ejemplarDTO) {
        ejemplarDTO.setId(id);
        ejemplarService.updateEjemplar(ejemplarDTO);
        return ResponseEntity.ok(ejemplarDTO);
    }

    // Eliminar un ejemplar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjemplar(@PathVariable int id) {
        ejemplarService.deleteEjemplar(id);
        return ResponseEntity.noContent().build();
    }
}
