package Grandao.DAO;



import Grandao.DTO.LibroDTO;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DAOFicherosTXT {


    private String filePath = "src/main/resources/Ficheros/FicheroLibros.txt";

    // Verifica si el archivo existe y lo crea si no
    private void ensureFileExists() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Obtener todos los libros
    public List<LibroDTO> getAllLibros() {
        List<LibroDTO> libros = new ArrayList<>();
        ensureFileExists(); // Asegurarse de que el archivo exista
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");  // Separar los datos por coma
                // Crear un objeto LibroDTO y asignar los valores leídos desde el archivo
                LibroDTO libro = new LibroDTO();
                libro.setIsbn(data[0]);  // Asignar ISBN
                libro.setTitulo(data[1]);  // Asignar título
                libro.setAutor(data[2]);  // Asignar autor
                libros.add(libro);  // Añadir el libro a la lista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libros;  // Retornar la lista de libros
    }

    // Guardar un nuevo libro
    public void saveLibro(LibroDTO libroDTO) {
        ensureFileExists(); // Asegurarse de que el archivo exista
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(libroDTO.getIsbn() + "," + libroDTO.getTitulo() + "," + libroDTO.getAutor());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
