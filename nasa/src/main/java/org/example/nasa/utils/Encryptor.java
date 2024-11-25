package org.example.nasa.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryptor {
    public static String encrypt(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean verifyPassword(String password , String encryptedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password,encryptedPassword);
    }
}