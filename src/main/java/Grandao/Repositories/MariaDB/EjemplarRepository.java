package Grandao.Repositories.MariaDB;



import Grandao.DTO.EjemplarDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepository extends JpaRepository<EjemplarDTO, Integer> {

    static EjemplarDTO findByIsbn(String isbn) {
        return null;
    }
}
