package Grandao.Repositories.Mongo;

import Grandao.DTO.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestamoMongoDAO extends MongoRepository<Prestamo, Integer> {

}
