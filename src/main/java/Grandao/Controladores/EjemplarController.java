package Grandao.Controladores;

import Grandao.DTO.EjemplarDTO;
import Grandao.Service.ServicioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarController {

    @Autowired
    private ServicioGeneral servicioGeneral;

    // Obtener todos los ejemplares
    @GetMapping
    public List<EjemplarDTO> getAllEjemplares() {
        return servicioGeneral.getAllEjemplares();
    }

    // Obtener un ejemplar por ISBN
    @GetMapping("/{isbn}")
    public EjemplarDTO getEjemplarByIsbn(@PathVariable String isbn) {
        return servicioGeneral.getEjemplarByIsbn(isbn);
    }

    // Añadir un nuevo ejemplar
    @PostMapping
    public void addEjemplar(@RequestBody EjemplarDTO ejemplarDTO) {
        servicioGeneral.addEjemplar(ejemplarDTO);
    }

    // Eliminar un ejemplar por ID
    @DeleteMapping("/{id}")
    public void deleteEjemplar(@PathVariable Integer id) {
        servicioGeneral.deleteEjemplar(id);
    }
}
