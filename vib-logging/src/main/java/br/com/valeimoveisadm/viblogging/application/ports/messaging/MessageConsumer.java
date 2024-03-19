package br.com.valeimoveisadm.vibrealestate.application.ports.messaging;

public interface MessageConsumer {

    void consumeSucessEvent(String payload);
    void consumeFailEvent(String pauload);
}
