package Grandao.DAO;



import Grandao.DTO.LibroDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DAOFicherosTXT {

    @Value("${libros.filepath}")
    private String filePath;

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
                String[] data = line.split(",");
                LibroDTO libro = new LibroDTO();
                libros.add(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libros;
    }

    /* Obtener un libro por su ISBN
    public LibroDTO getLibro(String isbn) {
        ensureFileExists(); // Asegurarse de que el archivo exista
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(isbn)) {
                    return new LibroDTO(data[0], data[1], data[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

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

    /* Actualizar un libro
    public void updateLibro(LibroDTO libroDTO) {
        ensureFileExists(); // Asegurarse de que el archivo exista
        List<LibroDTO> libros = getAllLibros();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (LibroDTO libro : libros) {
                if (libro.getIsbn().equals(libroDTO.getIsbn())) {
                    writer.write(libroDTO.getIsbn() + "," + libroDTO.getTitulo() + "," + libroDTO.getAutor());
                } else {
                    writer.write(libro.getIsbn() + "," + libro.getTitulo() + "," + libro.getAutor());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /* Eliminar un libro
    public void deleteLibro(String isbn) {
        ensureFileExists(); // Asegurarse de que el archivo exista
        List<LibroDTO> libros = getAllLibros();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (LibroDTO libro : libros) {
                if (!libro.getIsbn().equals(isbn)) {
                    writer.write(libro.getIsbn() + "," + libro.getTitulo() + "," + libro.getAutor());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
