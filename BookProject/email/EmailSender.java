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
		return "感谢您购买书籍: "+ bookName +", 欢迎下次光临！";
	}
	
	public String getEmailTitle() {
		return "请查收你的书籍： " + bookName;
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
		System.out.println("发送完成");
	}
}
