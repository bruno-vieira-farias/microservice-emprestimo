package nossagrana.emprestimo.entity;

public class ItemFilaNotificacaoUsuario {
    private String destinatario;
    private String nome;

    public ItemFilaNotificacaoUsuario() {
    }

    public ItemFilaNotificacaoUsuario(String destinatario, String nome) {
        this.destinatario = destinatario;
        this.nome = nome;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
