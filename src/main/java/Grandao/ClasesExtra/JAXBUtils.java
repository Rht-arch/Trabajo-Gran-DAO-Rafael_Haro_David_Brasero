package Grandao.ClasesExtra;

import Grandao.DTO.Usuario;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JAXBUtils {
    public static void convertirAXml(Usuario usuario,String ruta) {
        try{
            JAXBContext context = JAXBContext.newInstance(Usuario.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(usuario,new File(ruta));
        }catch(JAXBException e){
            e.printStackTrace();
        }
    }
    public static Usuario convertirDesdeXML(String ruta){
        try{
            JAXBContext context = JAXBContext.newInstance(Usuario.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Usuario) unmarshaller.unmarshal(new File(ruta));
        }catch(JAXBException e){
            e.printStackTrace();
        }
        return null;

    }
    public static List<Usuario> leerTodos(String carpeta){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        File folder = new File(carpeta);
        for(File file : folder.listFiles()){
            if(file.isFile() && file.getName().endsWith(".xml")){
                usuarios.add(convertirDesdeXML(file.getPath()));
            }
        }
        return usuarios;
    }
}
