package com.inghub.inghub.UtilityService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PassEncryptService {


    public String encryptPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        String encodedPassword = passwordEncoder.encode(password);

        return encodedPassword;
    }
}
