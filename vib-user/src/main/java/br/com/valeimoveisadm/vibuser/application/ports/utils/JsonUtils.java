package br.com.valeimoveisadm.vibuser.application.ports.utils;

import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.EventResponse;

public interface JsonUtils {

    public String toJson(Object object);

    public EventResponse toEvent(String json);
}
