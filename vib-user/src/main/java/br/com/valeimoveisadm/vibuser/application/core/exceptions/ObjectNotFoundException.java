package br.com.valeimoveisadm.vibuser.application.core.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String objectName, Long id) {
        super(objectName + " not found by ID: " + id);
    }
    public ObjectNotFoundException(String objectName, String email) {
        super(objectName + " not found by Email: " + email);
    }
}
