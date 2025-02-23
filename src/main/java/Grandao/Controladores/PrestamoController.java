package Grandao.Controladores;

import Grandao.DTO.Prestamo;
import Grandao.Service.ServicioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {
    @Autowired
    public ServicioGeneral servicioGeneral;

    @GetMapping
    public List<Prestamo> prestamos() {
        return servicioGeneral.obtenerPrestamos();
    }

    @PostMapping
    public void crearPrestamo(@RequestBody Prestamo prestamo) {
        servicioGeneral.guardarPrestamo(prestamo);

    }

    @PutMapping("/{id}")
    public void actualizarPrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        servicioGeneral.actualizarPrestamo(prestamo,id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable int id) {
        servicioGeneral.borrarPrestamo(id);
    }
}
