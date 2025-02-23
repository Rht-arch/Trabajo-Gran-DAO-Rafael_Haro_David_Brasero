package Grandao.DTO;

import jakarta.persistence.*;

@Entity
@Table(name = "ejemplar")
public class EjemplarDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
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
