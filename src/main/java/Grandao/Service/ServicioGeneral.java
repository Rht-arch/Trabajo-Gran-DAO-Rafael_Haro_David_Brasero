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
    @Autowired
    private EjemplarRepository ejemplar;

    public ServicioGeneral() {
        this.daoUsuarios = new DAOFicherosXML();
    }

    // Obtener todos los libros
    public List<LibroDTO> getAllLibros() {
        return daoLibro.getAllLibros();
    }


    public void addLibro(LibroDTO libroDTO) {
        if (!validarLibro(libroDTO)) {
            throw new IllegalArgumentException("El libro tiene datos inválidos.");
        }
        daoLibro.saveLibro(libroDTO);
    }

    // Método de validación antes de guardar un libro
    private boolean validarLibro(LibroDTO libro) {
        if (libro.getIsbn() == null || !libro.getIsbn().matches("^[0-9\\-]+$") || libro.getIsbn().length() < 10 || libro.getIsbn().length() > 20) {
            return false;
        }
        if (libro.getTitulo() == null || libro.getTitulo().isEmpty() || libro.getTitulo().length() > 200) {
            return false;
        }
        if (libro.getAutor() == null || libro.getAutor().isEmpty() || libro.getAutor().length() > 100) {
            return false;
        }
        return true;
    }


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
    public Prestamo actualizarPrestamo(Prestamo pr, int id) {
        pr.setId(id);
        return prestamo.save(pr);

    }

    public void borrarPrestamo(int id) {
        prestamo.deleteById(id);
    }
    // Métodos para ejemplares (MariaDB)

    // Obtener todos los ejemplares
    public List<EjemplarDTO> getAllEjemplares() {
        return ejemplar.findAll();  // Usamos la instancia ejemplarRepository
    }

    // Obtener un ejemplar por ISBN
    public EjemplarDTO getEjemplarByIsbn(String isbn) {
        return EjemplarRepository.findByIsbn(isbn);  // Usamos la instancia ejemplarRepository
    }

    // Añadir un nuevo ejemplar
    public void addEjemplar(EjemplarDTO ejemplarDTO) {
        ejemplar.save(ejemplarDTO);  // Usamos la instancia ejemplarRepository
    }

    //Modificar un ejemplar por id
    public void updateEjemplar(Integer id, EjemplarDTO ejemplarDTO) {
        // Lógica para actualizar el ejemplar en la base de datos
        EjemplarDTO ejemplarExistente = ejemplar.findById(id).orElseThrow(() -> new RuntimeException("Ejemplar no encontrado"));
        ejemplarExistente.setIsbn(ejemplarDTO.getIsbn());
        ejemplarExistente.setEstado(ejemplarDTO.getEstado());
        ejemplar.save(ejemplarExistente);
    }


    // Eliminar un ejemplar por ID
    public void deleteEjemplar(Integer id) {
        ejemplar.deleteById(id);  // Usamos la instancia ejemplarRepository
    }


}

