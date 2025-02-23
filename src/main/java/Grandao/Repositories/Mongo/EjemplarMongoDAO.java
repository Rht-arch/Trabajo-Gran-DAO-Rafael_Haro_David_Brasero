package Grandao.Repositories.Mongo;

import Grandao.DTO.EjemplarDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarMongoDAO extends MongoRepository<EjemplarDTO, String> {
    // Métodos adicionales según sea necesario
}
