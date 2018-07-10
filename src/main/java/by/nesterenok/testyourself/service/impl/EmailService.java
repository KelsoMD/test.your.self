package by.nesterenok.testyourself.service.impl;

import by.nesterenok.testyourself.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService{

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setFrom("testyourself.application@mail.ru");
            message.setText(text);
            emailSender.send(message);
    }
    public void sendAcceptMessage(String to, Question question){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(String.format("Question %s accepted.", question.getId()));
        message.setFrom("testyourself.application@mail.ru");
        message.setText(String.format("Your question %s (%s) accepted by moderators, from now it can be used in your tests!",
                question.getId(), question.getText()));
        emailSender.send(message);
    }
    public void sendDeniMessage(String to, Question question){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(String.format("Question %s denied.", question.getId()));
        message.setFrom("testyourself.application@mail.ru");
        message.setText(String.format("Your question %s (%s) denied by moderators. The reason is not implemented yet " +
                        "=)",
                question.getId(), question.getText()));
        emailSender.send(message);
    }
}
