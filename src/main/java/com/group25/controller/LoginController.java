package com.group25.controller;


import com.group25.entity.Login;
import com.group25.mailService.MailService;
import com.group25.service.LoginService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    MailService mailservice;

    @RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("email") String email, @PathVariable("password") String password) throws Exception{

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

        Login login = loginService.getUserCredentials(email);

        if (login == null) {

            return new ResponseEntity<>("Invalid Credentials", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        } else if (passwordEncryptor.checkPassword(password, login.getPassword())){

            return new ResponseEntity<>(login, new HttpHeaders(), HttpStatus.OK);

        } else {

            return new ResponseEntity<>("Invalid Credentials", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @RequestMapping(value = "/forgot/{email}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> resetForgottenPassword(@PathVariable("email") String email){

        Login login = new Login();

        try {

            login = loginService.getUserCredentials(email);

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        if (email == "null") {

            return new ResponseEntity<>("Enter an email address", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        } else if (login == null) {

            return new ResponseEntity<>("Invalid email address", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        } else {

            String newPassword = randomString(4);

            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

            String newEncryptedPassword = passwordEncryptor.encryptPassword(newPassword);

            loginService.updatePassword(email, newEncryptedPassword);

            mailservice.sendEmailWithNewPassword(email, newPassword);

            return new ResponseEntity<>("We sent a new password to your email", new HttpHeaders(), HttpStatus.OK);

        }

    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}
