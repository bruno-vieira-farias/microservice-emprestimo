package nossagrana.emprestimo.dto;

import java.time.ZonedDateTime;

public class SolicitarEmprestimoDTO {
    private double montante;
    private ZonedDateTime dataVencimento;
    private String emailUsuario;

    public SolicitarEmprestimoDTO(double montante, ZonedDateTime dataVencimento, String emailUsuario) {
        this.montante = montante;
        this.dataVencimento = dataVencimento;
        this.emailUsuario = emailUsuario;
    }

    public SolicitarEmprestimoDTO() {
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

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

}
