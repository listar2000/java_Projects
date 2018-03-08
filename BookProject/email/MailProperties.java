package email;

import java.util.Properties;

public class MailProperties {
	
	private static String myEmailSMTPHost = "smtp.163.com";
//	private static String mySMTPPort = "25"; //if the SSL is closed
	private static String mySMTPPort = "25";
	private static String username = "listar2000@163.com";
	private static String password = "xxxxxx";
	
	public static Properties getProperties() 
	{
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocal", "SMTP");
		prop.setProperty("mail.smtp.host", myEmailSMTPHost);
		prop.setProperty("mail.smtp.auth", "true");
		
		prop.setProperty("mail.smtp.port", mySMTPPort);
//		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
//        prop.setProperty("mail.smtp.socketFactory.port", mySMTPPort);
		
		return prop;
	}
	
	public static String getEmail() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}

}
