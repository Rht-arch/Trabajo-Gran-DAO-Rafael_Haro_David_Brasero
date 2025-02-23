package Grandao.Service;

import Grandao.DAO.DAOFicherosTXT;
import Grandao.DTO.LibroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service {

    @Autowired
    private DAOFicherosTXT daoLibro;  // Aquí inyectamos el DAO correspondiente al manejo de archivos txt para libros

    // Obtener todos los libros
    public List<LibroDTO> getAllLibros() {
        return daoLibro.getAllLibros();
    }

    // Obtener un libro por su ISBN
    public LibroDTO getLibro(String isbn) {
        return daoLibro.getLibro(isbn);
    }

    // Añadir un nuevo libro
    public void addLibro(LibroDTO libroDTO) {
        daoLibro.saveLibro(libroDTO);
    }

    // Actualizar un libro existente
    public void updateLibro(LibroDTO libroDTO) {
        daoLibro.updateLibro(libroDTO);
    }

    // Eliminar un libro por ISBN
    public void deleteLibro(String isbn) {
        daoLibro.deleteLibro(isbn);
    }
}
