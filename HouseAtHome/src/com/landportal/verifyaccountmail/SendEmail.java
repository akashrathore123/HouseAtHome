package com.landportal.verifyaccountmail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;






import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;


class MyPasswordAuthenticator extends Authenticator
{
String user;
String pw;

public MyPasswordAuthenticator (String username, String password)
{
super();
this.user = username;
this.pw = password;
}
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(user, pw);
}
}

public class SendEmail {
private SendEmail(){
	
}       

	public static int sendEmail(String email,String id) throws MessagingException, UnsupportedEncodingException {
        ResourceBundle rb = ResourceBundle.getBundle("db");

		 String username= rb.getString("username");
         String password = rb.getString("password");
         Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.starttls.enable","true");
         

         Session session = null;
         if (username != null && password != null)
         {
              props.put("mail.smtp.auth", "true");
              session = Session.getInstance(props,
              new MyPasswordAuthenticator(username, password));
         }
         else
         {
              session = Session.getDefaultInstance(props, null);
         }

         MimeMessage message = new MimeMessage(session);
         try {
    	 String domain = rb.getString("domain");	 
        	 
        	 
          message.setFrom(new InternetAddress("akash.1210017@kiet.edu","House At Home"));
         
         InternetAddress[] address = InternetAddress.parse(email, false);
         message.setRecipients(Message.RecipientType.TO, address);
         message.setSubject("House At Home | Account Verification");
         message.setContent("click on the link below to activate your account<br>"
         		+ "<a href='"+domain+"confirmemail?profile="+id+"'>activate/account/token?SefrAd"+id+"%@df","text/html; charset=utf-8");
         //message.setSentDate());
         Transport.send(message);
         return 1;
         } catch (AddressException e) {
              
              e.printStackTrace();
         } catch (MessagingException e) {
              
              e.printStackTrace();
         }
         return 0;
		} 
		
	
		
	
}
