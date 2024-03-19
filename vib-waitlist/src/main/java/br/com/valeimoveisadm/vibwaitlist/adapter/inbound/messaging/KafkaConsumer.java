package br.com.valeimoveisadm.vibrealestate.adapter.inbound.messaging;

import br.com.valeimoveisadm.vibrealestate.adapter.outbound.utils.JsonUtilImpl;
import br.com.valeimoveisadm.vibrealestate.application.ports.messaging.MessageConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer implements MessageConsumer {

    private final JsonUtilImpl jsonUtil;

    @KafkaListener(
            groupId = "",
            topics = ""
    )
    @Override
    public void consumeSucessEvent(String payload) {
        log.info("Receiving sucess event {} from user-sucess", payload);
        var event = jsonUtil.toEvent(payload);
        log.info(event.toString());
    }

    @KafkaListener(
            groupId = "",
            topics = ""
    )
    @Override
    public void consumeFailEvent(String payload) {
        log.info("Receiving rollback {} from user-fail", payload);
        var event = jsonUtil.toEvent(payload);
        log.info(event.toString());
    }


}
