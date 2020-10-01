package nossagrana.emprestimo.entity;

import nossagrana.emprestimo.dto.SolicitarEmprestimoDTO;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Emprestimo {
    @Id
    private String id;
    private double montante;
    private LocalDate dataVencimento;
    private LocalDate dataBase;
    private double taxaJuros;
    private String emailUsuario;
    private double taxaCET;

    public Emprestimo() {}

    public Emprestimo(double montante, LocalDate dataVencimento, LocalDate dataBase, double taxaJuros) {
        this.montante = montante;
        this.dataVencimento = dataVencimento;
        this.dataBase = dataBase;
        this.taxaJuros = taxaJuros;
    }

    public Emprestimo(SolicitarEmprestimoDTO solicitarEmprestimoDTO) {
        this.montante = solicitarEmprestimoDTO.getMontante();
        this.dataVencimento = solicitarEmprestimoDTO.getDataVencimento().toLocalDate();
        this.emailUsuario = solicitarEmprestimoDTO.getEmailUsuario();
        this.dataBase = LocalDate.now();
        this.taxaJuros = 0.40;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataBase() {
        return dataBase;
    }

    public void setDataBase(LocalDate dataBase) {
        this.dataBase = dataBase;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public double getTaxaCET() {
        return taxaCET;
    }

    public void setTaxaCET(double taxaCET) {
        this.taxaCET = taxaCET;
    }
}