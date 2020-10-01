package nossagrana.emprestimo.support;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CloudAmqpConnection {
    private CachingConnectionFactory connectionFactory;
    private String hostname;
    private String username;
    private String password;

    public CloudAmqpConnection(
            @Value("${notificacao-usuario.cloudamqp.hostname}") String hostname,
            @Value("${notificacao-usuario.cloudamqp.username}") String username,
            @Value("${notificacao-usuario.cloudamqp.password}") String password
    ) {
        this.hostname = hostname;
        this.username = username;
        this.password = password;
    }

    public CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory(hostname);
            connectionFactory.setUsername(username);
            connectionFactory.setPassword(password);
            connectionFactory.setVirtualHost(username);

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}