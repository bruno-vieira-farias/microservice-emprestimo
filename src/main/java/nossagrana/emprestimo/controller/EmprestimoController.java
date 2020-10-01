package nossagrana.emprestimo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nossagrana.emprestimo.dto.AtualizarEmprestimoDTO;
import nossagrana.emprestimo.dto.EmprestimoDTO;
import nossagrana.emprestimo.dto.SolicitarEmprestimoDTO;
import nossagrana.emprestimo.entity.Emprestimo;
import nossagrana.emprestimo.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @ApiOperation(value = "Busca os emprestimos por email.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Busca realizada com sucesso.")
    })
    @CrossOrigin
    @GetMapping
    public List<EmprestimoDTO> buscaPorEmail(@RequestParam String emailUsuario) {
        List<Emprestimo> emprestimos = this.service.findByEmail(emailUsuario);

        return emprestimos.stream()
                .map(EmprestimoDTO::new)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Solicita um novo empréstimo.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Emprestimo criado com sucesso.")
         })
    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmprestimoDTO solicitarEmprestimo(@RequestBody SolicitarEmprestimoDTO solicitarEmprestimoDTO) {
        Emprestimo emprestimo = service.create(solicitarEmprestimoDTO);
        return new EmprestimoDTO(emprestimo);
    }

    @ApiOperation(value = "Atualiza um empréstimo existente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Emprestimo atualizado com sucesso.")
    })
    @CrossOrigin
    @PutMapping("{id}")
    public EmprestimoDTO atualizarEmprestimo(@PathVariable String id, @RequestBody AtualizarEmprestimoDTO atualizarEmprestimoDTO) {
        Emprestimo emprestimo = service.update(id, atualizarEmprestimoDTO);
        return new EmprestimoDTO(emprestimo);
    }

    @ApiOperation(value = "Remove um empréstimo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Emprestimo removido com sucesso.")
    })
    @CrossOrigin
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
