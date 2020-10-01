package nossagrana.emprestimo.service;

import nossagrana.emprestimo.dto.AtualizarEmprestimoDTO;
import nossagrana.emprestimo.dto.SolicitarEmprestimoDTO;
import nossagrana.emprestimo.entity.Emprestimo;

import java.util.List;

public interface EmprestimoService {
    List<Emprestimo> getAll();

    Emprestimo create(SolicitarEmprestimoDTO solicitarEmprestimoDTO);

    Emprestimo findById(String id);

    List<Emprestimo> findByEmail(String email);

    Emprestimo update(String id, AtualizarEmprestimoDTO atualizarEmprestimoDTO);

    void delete(String id);
}
