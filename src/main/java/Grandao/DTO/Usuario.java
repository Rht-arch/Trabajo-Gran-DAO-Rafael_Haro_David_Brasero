package Grandao.DTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@XmlRootElement(name="usuarios")
public class Usuario{
    private List<Usuarios> usuariosList;

    @XmlElement(name="usuario"){
        public List<Usuarios> getUsu
    }
}