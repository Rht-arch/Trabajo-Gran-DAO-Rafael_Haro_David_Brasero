package Grandao.Service;

import Grandao.DTO.LibroDTO;
import Grandao.DAO.DAOFicherosTXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service {

    @Autowired
    private DAOFicherosTXT libroDAO; // Inyectar el DAO de libros

    // Obtener todos los libros
    public List<LibroDTO> getAllLibros() {
        return libroDAO.getAllLibros(); // Obtiene todos los libros desde el archivo
    }

    // Obtener un libro por su ISBN
    public LibroDTO getLibro(String isbn) {
        return libroDAO.getLibro(isbn); // Obtiene el libro con el ISBN correspondiente
    }

    // Agregar un nuevo libro
    public void addLibro(LibroDTO libroDTO) {
        libroDAO.saveLibro(libroDTO); // Guarda un nuevo libro en el archivo
    }

    // Actualizar un libro existente
    public void updateLibro(LibroDTO libroDTO) {
        libroDAO.updateLibro(libroDTO); // Actualiza los datos del libro en el archivo
    }

    // Eliminar un libro por su ISBN
    public void deleteLibro(String isbn) {
        libroDAO.deleteLibro(isbn); // Elimina el libro con el ISBN dado del archivo
    }
}
