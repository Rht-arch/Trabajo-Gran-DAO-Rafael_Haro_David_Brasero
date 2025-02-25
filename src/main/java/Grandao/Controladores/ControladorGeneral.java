package Grandao.Controladores;

import Grandao.DTO.Prestamo;
import Grandao.DTO.Usuario;
import Grandao.Service.ServicioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
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
}
