package cn.xzt.ask.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {


    public static void sendMail(String to, String title, String content) throws Exception {

        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.126.com");
        props.setProperty("mail.smtp.auth", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("zhoumj2019@126.com", "zmj427663");
            }
        };

        Session session = Session.getDefaultInstance(props, authenticator);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("zhoumj2019@126.com"));

        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        message.setSubject(title);

        message.setContent(content, "text/html;charset=UTF-8");

        Transport.send(message);

    }

    public static void main(String[] args) throws Exception {
        sendMail("304500212@qq.com", "第二次测试", "测试内容");
    }
}
