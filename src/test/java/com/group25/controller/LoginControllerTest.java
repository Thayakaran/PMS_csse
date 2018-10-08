package com.group25.controller;

import com.group25.entity.Login;
import com.group25.service.LoginService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testEmailServiceUserRole() {

        String email = "nsankeeth@gmail.com";

        Login login = loginService.getUserCredentials(email);

        String actualOut = login.getRole();
        String expectedOut = "Account Staff";

        assertEquals(expectedOut, actualOut);

    }

    @Test
    public void testEmailCredentials() {

        String email = "n.sankeeth@gmail.com";

        String password = "n.sankeeth@gmail.com@pms";

        Login login = loginService.getUserCredentials(email);

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

        Boolean actualOut = passwordEncryptor.checkPassword(password, login.getPassword());
        Boolean expectedOut = true;

        assertTrue(actualOut == expectedOut);
    }

}
