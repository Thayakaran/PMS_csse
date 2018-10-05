package com.group25.mailService;

import com.group25.entity.Login;
import com.group25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender jms;

    @Autowired
    public void MailSevice(JavaMailSender jms) {
        this.jms = jms;
    }

    // send mail about user registration
    public void sendMailAboutUserRegistration(User user) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(user.getEmail());
        sm.setFrom("matrix.pms.sliit@gmail.com");
        sm.setSubject("PMS Registration");
        sm.setText("You have been registered successfully in PMS \n" + "Your Role\n" + user.getRole()
                + '\n' + "Your Default Password is " + user.getPassword());

        jms.send(sm);
    }

    public void sendEmailWithNewPassword(String email, String newPassword) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(email);
        sm.setFrom("matrix.pms.sliit@gmail.com");
        sm.setSubject("Account Recovery Service");
        sm.setText("Thank you for using our service. You can use the password provided to access your account.\n" + "Your new password : " + newPassword);

        jms.send(sm);
    }
}
