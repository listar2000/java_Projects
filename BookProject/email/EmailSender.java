package email;

import java.io.File;

public class EmailSender {
	
	private String bookName;
	private File bookFile;
	private String toEmailAddress;
	
	public EmailSender(File bookFile, String toEmailAddress) 
	{
		this.bookName = bookFile.getName();
		this.bookFile = bookFile;
		this.toEmailAddress = toEmailAddress;
	}
	
	public String getEmailContent() {
		return "��л�������鼮: "+ bookName +", ��ӭ�´ι��٣�";
	}
	
	public String getEmailTitle() {
		return "���������鼮�� " + bookName;
	}
	
	public boolean sendEmail() throws Exception {
		MailGenerator generator = new MailGenerator(toEmailAddress, getEmailContent(), getEmailTitle(), bookFile);
		generator.send();
		return true;
	}

	public String getBookName() {
		return bookName;
	}
	
	public static void main(String[] args) throws Exception {
		File newfile = new File("C:\\Users\\liyx\\Desktop\\EBooks\\test.txt");
		EmailSender sender = new EmailSender(newfile, "1342100816@qq.com");
		sender.sendEmail();
		System.out.println("�������");
	}
}
