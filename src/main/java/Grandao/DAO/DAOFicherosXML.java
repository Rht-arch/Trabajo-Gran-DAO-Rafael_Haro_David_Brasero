package Grandao.DAO;

import Grandao.ClasesExtra.Wrapper;
import Grandao.DTO.Usuario;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DAOFicherosXML {

    private static final String directorios= "src/main/resources/Ficheros/usuarios.xml";

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            File file = new File(directorios);
            if (file.exists()) {
                JAXBContext context = JAXBContext.newInstance(Wrapper.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Wrapper wrapper = (Wrapper) unmarshaller.unmarshal(file);
                usuarios = wrapper.getUsuarios();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // Guardar un usuario en XML
    public void guardarUsuario(Usuario usuario) {
        List<Usuario> usuarios = obtenerUsuarios();
        usuarios.add(usuario);
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper wrapper = new Wrapper();
            wrapper.setUsuarios(usuarios);
            marshaller.marshal(wrapper, new File(directorios));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
