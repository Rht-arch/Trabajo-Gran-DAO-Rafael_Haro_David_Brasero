package Grandao.Controladores;

import Grandao.DTO.EjemplarDTO;
import Grandao.DTO.LibroDTO;
import Grandao.DTO.Prestamo;
import Grandao.DTO.Usuario;
import Grandao.Service.ServicioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class ControladorGeneral {

    @Autowired
    public ServicioGeneral servicioGeneral;

    /*
    Metodos de prestamos con MongoDB
     */
    //READ prestamos
    @GetMapping("/prestamos")
    public List<Prestamo> prestamos() {
        return servicioGeneral.obtenerPrestamos();
    }

    //INSERT prestamos
    @PostMapping("/prestamos")
    public void crearPrestamo(@RequestBody Prestamo prestamo) {
        servicioGeneral.guardarPrestamo(prestamo);

    }
    //UPDATE prestamos
    @PutMapping("/prestamos/{id}")
    public void actualizarPrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        servicioGeneral.actualizarPrestamo(prestamo,id);
    }
    //DELETE prestamos
    @DeleteMapping("/prestamos/{id}")
    public void eliminarPrestamo(@PathVariable int id) {
        servicioGeneral.borrarPrestamo(id);
    }

    /*
    Metodos de usuarios con XML
     */
    //READ usuarios
    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        return  servicioGeneral.obtenerUsuariosXml();
    }

    //INSERT usuarios
    @PostMapping("/usuarios")
    public void insertar(@RequestBody Usuario usuario){
        servicioGeneral.guardarUsuarioXml(usuario);
    }

    /*
    Metodos de libros con ficheros TXT
     */
    // Obtener todos los libros
    @GetMapping("/libros")
    public ResponseEntity<List<LibroDTO>> getAllLibros() {
        List<LibroDTO> libros = servicioGeneral.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
    // Crear un nuevo libro
    @PostMapping("/libros")
    public ResponseEntity<Void> addLibro(@RequestBody LibroDTO libroDTO) {
        servicioGeneral.addLibro(libroDTO);
        return new ResponseEntity<>(HttpStatus.CREATED); // Retorna 201 si el libro fue creado con éxito
    }

    /*
    Metodos de ejemplar con Spring
     */
    // Obtener todos los ejemplares
    @GetMapping("/ejemplares")
    public List<EjemplarDTO> getAllEjemplares() {
        return servicioGeneral.getAllEjemplares();
    }

    // Obtener un ejemplar por ISBN
    @GetMapping("ejemplares/{id}")
    public EjemplarDTO getEjemplarById(@PathVariable int id) {
        return servicioGeneral.getEjemplarById(id);
    }

    // Añadir un nuevo ejemplar
    @PostMapping("/ejemplares")
    public void addEjemplar(@RequestBody EjemplarDTO ejemplarDTO) {
        servicioGeneral.addEjemplar(ejemplarDTO);
    }
    // Actualizar un ejemplar por ID
    @PutMapping("ejemplares/{id}")
    public void updateEjemplar(@PathVariable Integer id, @RequestBody EjemplarDTO ejemplarDTO) {
        servicioGeneral.updateEjemplar(id, ejemplarDTO);
    }
    // Eliminar un ejemplar por ID
    @DeleteMapping("ejemplares/{id}")
    public void deleteEjemplar(@PathVariable Integer id) {
        servicioGeneral.deleteEjemplar(id);
    }
}
