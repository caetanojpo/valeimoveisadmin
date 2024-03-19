package br.com.valeimoveisadm.vibuser.adapter.outbound.utils;

import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.EventResponse;
import br.com.valeimoveisadm.vibuser.application.ports.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonUtilImpl implements JsonUtils {

    private final ObjectMapper objectMapper;

    @Override
    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch(Exception exception){
            log.error("Object Mapper Error: ", exception.getMessage());
            return "";
        }
    }

    @Override
    public EventResponse toEvent(String json) {
       try{
           return objectMapper.readValue(json, EventResponse.class);
       } catch ( Exception exception){
           log.error("Object Mapper Error: ", exception.getMessage());
           return null;
       }
    }
}
