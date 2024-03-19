package br.com.valeimoveisadm.vibuser.adapter.inbound.rest.controller.handler;


import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.ExceptionResponse;
import br.com.valeimoveisadm.vibuser.adapter.inbound.rest.dto.response.FieldExceptionResponse;
import br.com.valeimoveisadm.vibuser.application.core.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {ObjectNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(ObjectNotFoundException ex) {
        var httpStatus = HttpStatus.NOT_FOUND;
        var response = handleExceptionResponse(httpStatus, ex.getLocalizedMessage());

        log.error("Not found: {}", ex.getLocalizedMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        var response = handleExceptionResponse(httpStatus, "Erro inesperado do sistema");

        log.error("Internal Server Error: {}", ex.getLocalizedMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }


    private List<FieldExceptionResponse> getFieldsExceptionResponse(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> FieldExceptionResponse.builder()
                        .message(error.getDefaultMessage())
                        .field(error.getField())
                        .parameter(error.getRejectedValue())
                        .build())
                .toList();
    }

    private ExceptionResponse handleExceptionResponse(HttpStatus httpStatus, String message) {
        return ExceptionResponse.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .correlationId(getCorrelationId())
                .build();
    }

    private String getCorrelationId() {
        return MDC.get("correlationId");
    }
}