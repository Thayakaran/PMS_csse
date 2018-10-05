package com.group25.mailService;

import com.group25.entity.User;
import com.group25.entity.SiteManager;
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

    // Sent mail to when manager approve order
    public void sendApprovemail(SiteManager sitemanager) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(sitemanager.getPersonMail());
        sm.setFrom("matrix.pms.sliit@gmail.com");
        sm.setSubject("Place an order");
        sm.setText(sitemanager.getInfor() + "\n" + "Order ID :" + sitemanager.getId()
                + '\n' + "Before : " + sitemanager.getRequiredate());

        jms.send(sm);
    }

}
