package br.com.valeimoveisadm.vibrealestate.application.core.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String objectName, Long id) {
        super(objectName + " not found by ID: " + id);
    }
}
