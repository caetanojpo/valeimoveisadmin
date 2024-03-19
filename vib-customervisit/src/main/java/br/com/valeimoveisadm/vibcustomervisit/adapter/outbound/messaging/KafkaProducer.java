package br.com.valeimoveisadm.vibrealestate.adapter.outbound.messaging;

import br.com.valeimoveisadm.vibrealestate.application.ports.messaging.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer implements MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.teste}")
    private String testeTopic;

    @Override
    public void sendEvent(String payload) {
        try {
            log.info("Sending Event to topic {} with data {}", testeTopic, payload);
            kafkaTemplate.send(testeTopic, payload);
        } catch (Exception exception) {
            log.error("Error trying to send data to topic {} with data {}", testeTopic, payload);
        }

    }
}
