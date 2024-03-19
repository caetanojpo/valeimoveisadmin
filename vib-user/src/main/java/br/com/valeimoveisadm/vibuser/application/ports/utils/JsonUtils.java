package br.com.valeimoveisadm.vibuser.application.ports.utils;

import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.EventResponse;

public interface JsonUtils {

    String toJson(Object object);

    EventResponse toEvent(String json);
}
