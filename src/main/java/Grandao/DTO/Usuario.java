package Grandao.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.sql.Date;
import java.time.LocalDate;

@XmlRootElement(name = "usuario")
@XmlType(propOrder = {"id", "dni", "nombre", "email", "password", "tipo", "penalizacionHasta"})
public class Usuario {

    private int id;
    private String dni;
    private String nombre;
    private String email;
    private String password;
    private String tipo;
    private Date penalizacionHasta;

    public Usuario() {
        // Constructor vacío necesario para JAXB
    }

    public Usuario(int id, String dni, String nombre, String email, String password, String tipo, Date penalizacionHasta) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.penalizacionHasta = penalizacionHasta;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlElement
    public Date getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(Date penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", penalizacionHasta=" + penalizacionHasta +
                '}';
    }
}
