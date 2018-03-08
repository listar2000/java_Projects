package email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator{
	
	private String username = null;
	private String password = null;
	
	public MailAuthenticator(String username, String password) {
		this.password = password;
		this.username = username;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
