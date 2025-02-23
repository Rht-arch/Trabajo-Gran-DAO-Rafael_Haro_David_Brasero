package Grandao.DAO;



import Grandao.DTO.LibroDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DAOFicherosTXT {

    @Value("${libros.filepath}")  // Puedes configurar la ruta del archivo en el archivo application.properties
    private String filePath;

    public List<LibroDTO> getAllLibros() {
        List<LibroDTO> libros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                LibroDTO libro = new LibroDTO(data[0], data[1], data[2]);
                libros.add(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public LibroDTO getLibro(String isbn) {
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
    }

    public void saveLibro(LibroDTO libroDTO) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(libroDTO.getIsbn() + "," + libroDTO.getTitulo() + "," + libroDTO.getAutor());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateLibro(LibroDTO libroDTO) {
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
    }

    public void deleteLibro(String isbn) {
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
    }
}
