package Grandao.DTO;


import jakarta.validation.constraints.*;  // Para las anotaciones de validación
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "libro")
public class LibroDTO {
    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    @NotBlank(message = "El ISBN no puede estar vacío")
    @Size(min = 10, max = 20, message = "El ISBN debe tener entre 10 y 20 caracteres")
    @Pattern(regexp = "^[0-9\\-]+$", message = "El ISBN solo puede contener números y guiones")
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 200)
    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 200, message = "El título no puede tener más de 200 caracteres")
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    @NotBlank(message = "El autor no puede estar vacío")
    @Size(max = 100, message = "El nombre del autor no puede tener más de 100 caracteres")
    private String autor;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
