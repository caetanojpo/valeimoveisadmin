package br.com.valeimoveisadm.vibuser.application.ports.messaging;

public interface MessageProducer {

    void sendEvent(String payload);
}
