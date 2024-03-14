package br.com.valeimoveisadm.vibuser.adapter.outbound.cryptography;

import br.com.valeimoveisadm.vibuser.application.ports.cryptography.EncryptPassword;
import org.springframework.stereotype.Component;

@Component
public class Argon2Password implements EncryptPassword {
    @Override
    public String enconde(String password) {
        return null;
    }
}
