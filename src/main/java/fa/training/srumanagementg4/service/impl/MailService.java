package fa.training.srumanagementg4.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailLogin(String toEmail, String name, String password) {
        String sendContent = "<html><h2>Hello: <span style='color: red'>" + name + ",</span></h2>" +
                "    <h2>Your login email is: <span style='color: red'>" + toEmail + "</span></h2>" +
                "    <h2>Your login password is: <span style='color: red'>" + password + "</span></h2>" +
                "    <br>" +
                "    <h2>If you forgot your login password, please contact HR department of the company to get it again!</h2>" +
                "    <br>" +
                "    <br>" +
                "    <br>" +
                "    <h2>Sincerely thank you!</h2></html>";
        sendEmail(toEmail, sendContent);

    }

    public void sendEmail(String toEmail, String sendContent) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, StandardCharsets.UTF_8.name());
            message.setTo(toEmail);
            message.setSubject("SRUM - SECURITY");
            message.setText(sendContent, true);
            javaMailSender.send(mimeMessage);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
