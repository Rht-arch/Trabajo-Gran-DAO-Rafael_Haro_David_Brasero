package Grandao.Repositories.Mongo;


import Grandao.DTO.LibroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroMongoDAO extends JpaRepository<LibroDTO, String> {
    // Métodos adicionales si es necesario (por ejemplo, buscar por autor)
}
