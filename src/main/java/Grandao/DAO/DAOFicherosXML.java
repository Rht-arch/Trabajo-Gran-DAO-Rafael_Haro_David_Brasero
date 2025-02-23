package Grandao.DAO;

import Grandao.ClasesExtra.JAXBUtils;
import Grandao.DTO.Usuario;

import java.util.List;

public class DAOFicherosXML {

    private static final String directorios= "src/main/resources/Ficheros";

    public void guardar(Usuario usuario){
        String ruta = directorios + usuario.getNombre() + ".xml";
        JAXBUtils.convertirAXml(usuario, ruta);
    }

    public List<Usuario> listar(){
        return JAXBUtils.leerTodos(directorios);
    }
}
