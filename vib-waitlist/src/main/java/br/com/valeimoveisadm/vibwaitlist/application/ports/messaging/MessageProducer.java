package br.com.valeimoveisadm.vibrealestate.application.ports.messaging;

public interface MessageProducer {

    void sendEvent(String payload);
}
