package nossagrana.emprestimo.dto;

import nossagrana.emprestimo.entity.Emprestimo;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EmprestimoDTO {
    private double montante;
    private ZonedDateTime dataVencimento;
    private ZonedDateTime dataBase;
    private double taxaJuros;
    private double taxaCET;

    public EmprestimoDTO(double montante, ZonedDateTime dataVencimento, ZonedDateTime dataBase, double taxaJuros, double taxaCET) {
        this.montante = montante;
        this.dataVencimento = dataVencimento;
        this.dataBase = dataBase;
        this.taxaJuros = taxaJuros;
        this.taxaCET = taxaCET;
    }

    public EmprestimoDTO(Emprestimo entity) {
        this.dataBase = entity.getDataBase().atStartOfDay(ZoneId.systemDefault());
        this.dataVencimento = entity.getDataVencimento().atStartOfDay(ZoneId.systemDefault());
        this.montante = entity.getMontante();
        this.taxaCET = entity.getTaxaCET();
        this.taxaJuros = entity.getTaxaJuros();
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public ZonedDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(ZonedDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public ZonedDateTime getDataBase() {
        return dataBase;
    }

    public void setDataBase(ZonedDateTime dataBase) {
        this.dataBase = dataBase;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaCET() {
        return taxaCET;
    }

    public void setTaxaCET(double taxaCET) {
        this.taxaCET = taxaCET;
    }
}
