package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExceptionResponse {

    private int code;
    private String status;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String correlationId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldExceptionResponse> fields;
}
