package Grandao.Controladores;

import Grandao.DTO.Usuario;
import Grandao.Service.ServicioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    @Autowired
    ServicioGeneral servicioGeneral;

    @GetMapping
    public List<Usuario> listar(){
        return  servicioGeneral.obtenerUsuariosXml();
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Usuario usuario){
        servicioGeneral.guardarUsuarioXml(usuario);
    }

}
