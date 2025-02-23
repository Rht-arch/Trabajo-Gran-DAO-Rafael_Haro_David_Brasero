package Grandao.Repositories.Mongo;

import Grandao.DTO.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioMongoDAO extends MongoRepository<Usuario,Integer> {

}
