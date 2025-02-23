package Grandao.Service;

import Grandao.DAO.DAOFicherosTXT;

import Grandao.DTO.LibroDTO;
import Grandao.DTO.EjemplarDTO;  // DTO para Ejemplar
import Grandao.Repositories.MariaDB.EjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioGeneral {

    @Autowired
    private DAOFicherosTXT daoLibro;  // DAO para libros en archivo de texto

    @Autowired
    private EjemplarRepository daoEjemplar;  // DAO para Ejemplares en MariaDB (JPA)

    // Obtener todos los libros
    public List<LibroDTO> getAllLibros() {
        return daoLibro.getAllLibros();
    }

    /* Obtener un libro por su ISBN
    public LibroDTO getLibro(String isbn) {
        return daoLibro.getLibro(isbn);
    }*/

    // Añadir un nuevo libro
    public void addLibro(LibroDTO libroDTO) {
        daoLibro.saveLibro(libroDTO);
    }

    /* Actualizar un libro existente
    public void updateLibro(LibroDTO libroDTO) {
        daoLibro.updateLibro(libroDTO);
    }

    // Eliminar un libro por ISBN
    public void deleteLibro(String isbn) {
        daoLibro.deleteLibro(isbn);
    }*/

    // ==============================================
    // Operaciones para Ejemplares (MariaDB)
    // ==============================================

    // Obtener todos los ejemplares
    public List<EjemplarDTO> getAllEjemplares() {
        return daoEjemplar.findAll();  // Utiliza el método findAll() de JPARepository
    }

    // Obtener un ejemplar por ID
    public EjemplarDTO getEjemplarById(int id) {
        return daoEjemplar.findById(id).orElse(null);  // Devuelve null si no lo encuentra
    }

    // Añadir un nuevo ejemplar
    public void addEjemplar(EjemplarDTO ejemplarDTO) {
        daoEjemplar.save(ejemplarDTO);  // Guarda el ejemplar en la base de datos
    }

    // Actualizar un ejemplar existente
    public void updateEjemplar(EjemplarDTO ejemplarDTO) {
        daoEjemplar.save(ejemplarDTO);  // El método save también sirve para actualizar
    }

    // Eliminar un ejemplar por ID
    public void deleteEjemplar(int id) {
        daoEjemplar.deleteById(id);  // Elimina el ejemplar por su ID
    }
}
