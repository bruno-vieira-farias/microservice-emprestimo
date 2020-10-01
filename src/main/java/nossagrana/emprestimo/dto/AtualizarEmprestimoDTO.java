package nossagrana.emprestimo.dto;

import java.time.ZonedDateTime;

public class AtualizarEmprestimoDTO {
    private ZonedDateTime dataVencimento;
    private double montante;

    public AtualizarEmprestimoDTO(ZonedDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public AtualizarEmprestimoDTO(ZonedDateTime dataVencimento, double montante) {
        this.dataVencimento = dataVencimento;
        this.montante = montante;
    }

    public ZonedDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(ZonedDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }
}
