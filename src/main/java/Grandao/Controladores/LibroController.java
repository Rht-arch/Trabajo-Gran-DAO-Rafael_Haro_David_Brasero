package Grandao.Controladores;

import Grandao.DTO.LibroDTO;
import Grandao.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros") // Ruta base para los libros
public class LibroController {

    @Autowired
    private Service service; // Inyección de la clase Service

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAllLibros() {
        List<LibroDTO> libros = service.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // Obtener un libro por su ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<LibroDTO> getLibro(@PathVariable String isbn) {
        LibroDTO libro = service.getLibro(isbn);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el libro
        }
    }

    // Crear un nuevo libro
    @PostMapping
    public ResponseEntity<Void> addLibro(@RequestBody LibroDTO libroDTO) {
        service.addLibro(libroDTO);
        return new ResponseEntity<>(HttpStatus.CREATED); // Retorna 201 si el libro fue creado con éxito
    }

    // Actualizar un libro existente
    @PutMapping("/{isbn}")
    public ResponseEntity<Void> updateLibro(@PathVariable String isbn, @RequestBody LibroDTO libroDTO) {
        // Verifica si el libro existe
        if (service.getLibro(isbn) != null) {
            libroDTO.setIsbn(isbn); // Aseguramos que el ISBN en el DTO sea el correcto
            service.updateLibro(libroDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 si la actualización fue exitosa
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no existe el libro
        }
    }

    // Eliminar un libro por su ISBN
    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteLibro(@PathVariable String isbn) {
        if (service.getLibro(isbn) != null) {
            service.deleteLibro(isbn);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 si la eliminación fue exitosa
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el libro
        }
    }
}
