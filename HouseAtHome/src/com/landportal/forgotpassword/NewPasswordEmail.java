package com.landportal.forgotpassword;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.landportal.verifyaccountmail.SendEmail;
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
public class NewPasswordEmail {
private NewPasswordEmail(){
	
}       

	public static int sendEmail(String email,String id) throws MessagingException, UnsupportedEncodingException {
		 
		ResourceBundle  rb = ResourceBundle.getBundle("db");
		
		
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
         message.setSubject("House At Home | Change Password Request");
         message.setContent("click on the link below to reset your account password<br>"
         		+ "<a href='"+domain+"newpassword?token="+id+"'>activate/account/token?SefrAdAsdgSd45DL89hjbu%^764G787gHg%@df","text/html; charset=utf-8");
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
