
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

public class email2 {    
	
	static String d_email = "pparthenhs@gmail.com";//to email mas 
	static String d_password = ".....";// o kwdikos mas 
	static String d_host = "smtp.gmail.com";// o host
	static String d_port = "465";// to port
	static String m_to = "maria_stavrinou_@hotmail.com";//to email pou phgenei
	static String m_subject = "To email einai etoimo ";
	static String m_text = "Hey, this is a test email.";
    
	static private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
    
    public static void main(String[] args){
    
        Properties props = new Properties();//ena hashtable
        
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        
        props.setProperty("mail.user", d_email);
        props.setProperty("mail.password", d_password);
        
        try {
        	
           Authenticator auth = new SMTPAuthenticator();
           Session session = Session.getInstance(props,auth); 
            
              
            MimeMessage msg = new MimeMessage(session);
            
            msg.setText(m_text);
            
            msg.setSubject(m_subject);
            
            msg.setFrom(new InternetAddress(d_email));
            
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            
            Transport.send(msg);
            
            
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
   

}