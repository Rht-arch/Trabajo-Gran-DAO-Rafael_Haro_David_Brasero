package Grandao.Repositories.MariaDB;

import Grandao.DTO.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

}
