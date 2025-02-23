package Grandao.Repositories.MariaDB;

import Grandao.DTO.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
