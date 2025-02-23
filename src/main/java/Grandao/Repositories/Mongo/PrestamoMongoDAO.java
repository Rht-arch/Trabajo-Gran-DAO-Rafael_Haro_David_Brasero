package Grandao.Repositories.Mongo;


import Grandao.DTO.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoMongoDAO extends MongoRepository<Prestamo,Integer> {
    public List<Prestamo> findById(int id);
    public List<Prestamo> findByIdLibro(int idLibro);
    public List<Prestamo> findByIdUsuario(int idUsuario);

}

