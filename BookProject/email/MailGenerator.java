package email;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailGenerator {
	
	private String mailContent;
	private String mailTitle;
	private String receiver;
	private File file;
	private Properties prop;
	
	public MailGenerator(String receiver, String mailContent, String mailTitle, File file) {
		
		this.mailContent = mailContent;
		this.mailTitle = mailTitle;
		this.receiver = receiver;
		this.file = file;
		
	}
	
	public void send() throws Exception 
	{
		prop = MailProperties.getProperties();
		
		Authenticator authenticator = new MailAuthenticator(MailProperties.getEmail(), MailProperties.getPassword());
		
		Session session = Session.getDefaultInstance(prop, authenticator);
		session.setDebug(true);
		
		Message message = creatMessage(session);
		
		Transport.send(message);
//		Transport transport = session.getTransport();
//		
//		transport.connect(MailProperties.getEmail(), MailProperties.getPassword());
//		transport.sendMessage(message, message.getAllRecipients());
//		transport.close();
	}
	
	public Message creatMessage(Session session) throws Exception 
	{
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(MailProperties.getEmail(), "BestBook.net", "UTF-8"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver, "customer", "UTF-8"));
		message.setSubject(mailTitle);
		
		Multipart multipart = new MimeMultipart();
		
		BodyPart textBody = new MimeBodyPart();
		textBody.setContent(mailContent, "text/html; charset=utf-8");
		multipart.addBodyPart(textBody);
		
		if (!file.exists()) {
			textBody.setContent("无法显示附件", "text/html; charset=utf-8");
		}
		
		else {
			BodyPart fileBody = new MimeBodyPart();
			FileDataSource dataSource = new FileDataSource(file);
			fileBody.setDataHandler(new DataHandler(dataSource));
			multipart.addBodyPart(fileBody);
		}
		
		message.setContent(multipart);
		message.saveChanges();
		
		return message;
	}
	
}
