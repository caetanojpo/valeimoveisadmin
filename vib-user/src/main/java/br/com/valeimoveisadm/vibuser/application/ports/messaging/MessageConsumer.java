package br.com.valeimoveisadm.vibuser.application.ports.messaging;

public interface MessageConsumer {

    void consumeSucessEvent(String payload);
    void consumeFailEvent(String pauload);
}
