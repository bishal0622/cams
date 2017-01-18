package com.clinic.config;

/**
 * Created by BiSAl MhRzn on 1/18/2017.
 */

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    public MailService() {
    }

    public void sendMail(String messageBody, String to, String subject){

        System.out.println("mail service");
        Properties props = new Properties();
        MailSSLSocketFactory sf= null;
        try {
            sf= new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.socketFactory",sf);

        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.ssl.trust","smtp.gmail.com");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","587");
        props.put("mail.smtp.socketFactory.class","javax,net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","587");


        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("futsal.devil1bi@gmail.com","cartoon2");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("futsal.devil1bi@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}