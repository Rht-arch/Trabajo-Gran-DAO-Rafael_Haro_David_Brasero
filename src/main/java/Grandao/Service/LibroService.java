package Grandao.Service;



import Grandao.DTO.LibroDTO;
import Grandao.Repositories.MariaDB.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository.LibroDAO libroDAO;

    // Obtener libro por ISBN
    public LibroDTO getLibro(String isbn) {
        Optional<Libro> libro = libroDAO.findById(isbn);
        if (libro.isPresent()) {
            return new LibroDTO(libro.get().getIsbn(), libro.get().getTitulo(), libro.get().getAutor());
        } else {
            throw new RuntimeException("Libro no encontrado con ISBN: " + isbn);
        }
    }

    // Crear nuevo libro
    public LibroDTO createLibro(LibroDTO libroDTO) {
        Libro libro = new Libro(libroDTO.getIsbn(), libroDTO.getTitulo(), libroDTO.getAutor());
        libro = libroDAO.save(libro);
        return new LibroDTO(libro.getIsbn(), libro.getTitulo(), libro.getAutor());
    }

    // Actualizar libro existente
    public LibroDTO updateLibro(String isbn, LibroDTO libroDTO) {
        Optional<Libro> libroExistente = libroDAO.findById(isbn);
        if (libroExistente.isPresent()) {
            Libro libro = libroExistente.get();
            libro.setTitulo(libroDTO.getTitulo());
            libro.setAutor(libroDTO.getAutor());
            libro = libroDAO.save(libro);
            return new LibroDTO(libro.getIsbn(), libro.getTitulo(), libro.getAutor());
        } else {
            throw new RuntimeException("Libro no encontrado con ISBN: " + isbn);
        }
    }

    // Eliminar libro
    public void deleteLibro(String isbn) {
        if (libroDAO.existsById(isbn)) {
            libroDAO.deleteById(isbn);
        } else {
            throw new RuntimeException("Libro no encontrado con ISBN: " + isbn);
        }
    }
}

