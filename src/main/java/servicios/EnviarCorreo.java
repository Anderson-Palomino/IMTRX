package servicios;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.dto.UsuarioDTO;

public class EnviarCorreo {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public boolean enviarEmail(UsuarioDTO usuario) {
        boolean test = false;

        String toEmail = usuario.getCorreo();
        String fromEmail = "andersonpalominosandoval@gmail.com";
        String password = "fumc rtis ojdp onkz"; // Cambia esto por la contraseña de aplicación generada

        try {
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            mess.setSubject("Verificacion de correo de usuario");
            mess.setText("Regristramiento exitoso. Por favor, verifique su correo usando este código " + usuario.getCode());

            Transport.send(mess);
            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
}


