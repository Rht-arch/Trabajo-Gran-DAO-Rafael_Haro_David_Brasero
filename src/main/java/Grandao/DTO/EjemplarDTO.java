package Grandao.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "ejemplar")
public class EjemplarDTO {

    @Id
    private int id;

    @Column(name = "isbn", nullable = false, length = 20)
    @NotBlank(message = "El ISBN no puede estar vacío")
    @Size(min = 10, max = 20, message = "El ISBN debe tener entre 10 y 20 caracteres")
    @Pattern(regexp = "^[0-9\\-]+$", message = "El ISBN solo puede contener números y guiones")
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    @NotNull(message = "El estado no puede ser nulo")
    private Estado estado;

    public enum Estado {
        Disponible,
        Prestado,
        Dañado
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EjemplarDTO() {}

    public EjemplarDTO(String isbn, Estado estado) {
        this.isbn = isbn;
        this.estado = estado;
    }
}
