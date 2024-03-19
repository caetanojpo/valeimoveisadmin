package br.com.valeimoveisadm.vibrealestate.application.ports.utils;


import br.com.valeimoveisadm.vibrealestate.adapter.inbound.rest.dto.response.EventResponse;

public interface JsonUtils {

    String toJson(Object object);

    EventResponse toEvent(String json);
}
