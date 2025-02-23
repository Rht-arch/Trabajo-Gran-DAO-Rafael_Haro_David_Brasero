package Grandao.Controladores;



import Grandao.DTO.LibroDTO;
import Grandao.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Obtener libro por ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<LibroDTO> getLibro(@PathVariable String isbn) {
        LibroDTO libroDTO = libroService.getLibro(isbn);
        return ResponseEntity.ok(libroDTO);
    }

    // Crear nuevo libro
    @PostMapping
    public ResponseEntity<LibroDTO> createLibro(@RequestBody LibroDTO libroDTO) {
        LibroDTO createdLibro = libroService.createLibro(libroDTO);
        return ResponseEntity.status(201).body(createdLibro);
    }

    // Actualizar libro existente
    @PutMapping("/{isbn}")
    public ResponseEntity<LibroDTO> updateLibro(@PathVariable String isbn, @RequestBody LibroDTO libroDTO) {
        LibroDTO updatedLibro = libroService.updateLibro(isbn, libroDTO);
        return ResponseEntity.ok(updatedLibro);
    }

    // Eliminar libro
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteLibro(@PathVariable String isbn) {
        libroService.deleteLibro(isbn);
        return ResponseEntity.noContent().build();
    }
}

