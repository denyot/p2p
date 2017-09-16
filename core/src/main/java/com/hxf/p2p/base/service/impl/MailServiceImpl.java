package com.hxf.p2p.base.service.impl;

import com.hxf.p2p.base.service.IMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements IMailService {
    @Value("${email.host}")
    private String host;
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;

    @Override
    public void sendMail(String target, String title, String content) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(587);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail,true,"UTF-8");//true用来打开multipart模式，添加
            helper.setTo(target);
            helper.setFrom(username);
            helper.setSubject(title);
            helper.setText(content,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mail);
    }
}

