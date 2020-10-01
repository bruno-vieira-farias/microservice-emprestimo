package nossagrana.emprestimo.support;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsultaUsuarioService {
    private String host;
    private String port;

    public ConsultaUsuarioService(@Value("${microservico-usuario.host}") String host, @Value("${microservico-usuario.port}") String port) {
        this.host = host;
        this.port = port;
    }

    public String consultaNomeUsuario(String email) {
        HttpResponse<String> response = Unirest.get("http://" + host + ":" + port + "/usuarios/{email}")
                .routeParam("email", email)
                .asString();

        if (response.getStatus() != 200) {
            return null;
        }

        return response.getBody();
    }

}