package Grandao.Repositories.MariaDB;
import Grandao.DTO.LibroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository {


    public interface LibroDAO extends JpaRepository<LibroDTO, String> {

    }
}
