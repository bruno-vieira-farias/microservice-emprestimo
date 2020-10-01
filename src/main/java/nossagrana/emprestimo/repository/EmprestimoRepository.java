package nossagrana.emprestimo.repository;

import nossagrana.emprestimo.entity.Emprestimo;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@Document
public interface EmprestimoRepository extends MongoRepository<Emprestimo, String> {
    List<Emprestimo> findAll();
    @Query("{ 'emailUsuario' : { $regex : ?0 } }")
    List<Emprestimo> findAllByEmail(String email);
}
