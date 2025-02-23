package Grandao.Service;

import Grandao.DAO.DAOFicherosTXT;
import Grandao.DAO.DAOFicherosXML;
import Grandao.DTO.EjemplarDTO;
import Grandao.DTO.LibroDTO;
import Grandao.DTO.Prestamo;
import Grandao.DTO.Usuario;
import Grandao.Repositories.MariaDB.EjemplarRepository;
import Grandao.Repositories.Mongo.PrestamoMongoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioGeneral {

    @Autowired
    private DAOFicherosTXT daoLibro;  // Aquí inyectamos el DAO correspondiente al manejo de archivos txt para libros

    private DAOFicherosXML daoUsuarios;

    @Autowired
    private PrestamoMongoDAO prestamo;

    public ServicioGeneral() {
        this.daoUsuarios = new DAOFicherosXML();
    }

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

    /* Eliminar un libro por ISBN
    public void deleteLibro(String isbn) {
        daoLibro.deleteLibro(isbn);
    }*/

    //Ficheros XML

    //Guardar Usuarios con xml
    public List<Usuario> obtenerUsuariosXml() {
        return daoUsuarios.obtenerUsuarios();
    }

    // Guardar un usuario en XML
    public void guardarUsuarioXml(Usuario usuario) {
        daoUsuarios.guardarUsuario(usuario);
    }

    //MongoDB

    public List<Prestamo> obtenerPrestamos() {
        return prestamo.findAll();
    }

    public Prestamo guardarPrestamo(Prestamo pr) {
        return prestamo.save(pr);
    }

    public void borrarPrestamo(int id) {
        prestamo.deleteById(id);
    }
    // Métodos para ejemplares (MariaDB)

    // Obtener todos los ejemplares
    public List<EjemplarDTO> getAllEjemplares() {
        return ejemplarRepository.findAll();  // Usamos la instancia ejemplarRepository
    }

    // Obtener un ejemplar por ISBN
    public EjemplarDTO getEjemplarByIsbn(String isbn) {
        return ejemplarRepository.findByIsbn(isbn);  // Usamos la instancia ejemplarRepository
    }

    // Añadir un nuevo ejemplar
    public void addEjemplar(EjemplarDTO ejemplarDTO) {
        ejemplarRepository.save(ejemplarDTO);  // Usamos la instancia ejemplarRepository
    }

    // Eliminar un ejemplar por ID
    public void deleteEjemplar(Integer id) {
        ejemplarRepository.deleteById(id);  // Usamos la instancia ejemplarRepository
    }
}

