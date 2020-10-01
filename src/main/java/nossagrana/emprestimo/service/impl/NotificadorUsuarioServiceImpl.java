package nossagrana.emprestimo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nossagrana.emprestimo.entity.ItemFilaNotificacaoUsuario;
import nossagrana.emprestimo.service.NotificadorUsuarioService;
import nossagrana.emprestimo.support.CloudAmqpConnection;
import nossagrana.emprestimo.support.ConsultaUsuarioService;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificadorUsuarioServiceImpl implements NotificadorUsuarioService {
    private String queueName;
    private String exchange;
    private RabbitTemplate template;
    private ConsultaUsuarioService consultaUsuarioService;

    public NotificadorUsuarioServiceImpl(
            CloudAmqpConnection cloudAmqpConnection,
            @Value("${notificacao-usuario.cloudamqp.queue-name}") String queueName,
            @Value("${notificacao-usuario.cloudamqp.exchange}") String exchange,
            ConsultaUsuarioService consultaUsuarioService
    ) {
        this.template = new RabbitTemplate(cloudAmqpConnection.getConnection());
        this.queueName = queueName;
        this.exchange = exchange;
        this.consultaUsuarioService = consultaUsuarioService;
        criaFilaCasoNecessario(queueName, exchange,cloudAmqpConnection);
    }

    @Override
    public void notificaUsuarioCriacaoEmprestimo(String email) {
        String nomeUsuario = consultaUsuarioService.consultaNomeUsuario(email);

        if (nomeUsuario == null){
            return;
        }

        ItemFilaNotificacaoUsuario itemFilaNotificacaoUsuario = new ItemFilaNotificacaoUsuario(email, nomeUsuario);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String itemAsJson = objectMapper.writeValueAsString(itemFilaNotificacaoUsuario);
            template.convertAndSend(exchange, queueName, itemAsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void criaFilaCasoNecessario(String queueName, String exchange, CloudAmqpConnection cloudAmqpConnection) {
        RabbitAdmin admin = new RabbitAdmin(cloudAmqpConnection.getConnection());
        Queue queueEmail = new Queue(queueName);
        admin.declareQueue(queueEmail);

        DirectExchange exchangeEmail = new DirectExchange(exchange);

        admin.declareExchange(exchangeEmail);
        admin.declareBinding(BindingBuilder.bind(queueEmail).to(exchangeEmail).with(queueName));
    }
}