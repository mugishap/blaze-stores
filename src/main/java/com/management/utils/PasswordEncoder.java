package com.management.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import jakarta.enterprise.context.RequestScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
public class PasswordEncoder {

    @ConfigProperty(name = "com.management.password.secret")  private String secret;
    @ConfigProperty(name = "com.management.password.iterations")  private Integer iteration;
    @ConfigProperty(name = "com.management.password.keylength")  private Integer keyLength;
    
    public String encode(CharSequence cs) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secret.getBytes(), iteration, keyLength))
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }
}