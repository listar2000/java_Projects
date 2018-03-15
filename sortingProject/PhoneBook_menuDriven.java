package sortingProject;

import java.util.Scanner;

public class PhoneBook_menuDriven {
	private PhoneBook phoneBook;
	private Scanner reader;
	
	public PhoneBook_menuDriven() {
		phoneBook = new PhoneBook();
		reader = new Scanner(System.in);
	}
	
	public void start() 
	{
		System.out.println("***欢迎进入menu_driven的联系人册界面***");
		System.out.println("***输入1进入添加联系人界面");
		System.out.println("***输入2进入删除联系人界面");
		System.out.println("***输入3显示所有的联系人");
		System.out.println("***输入4推出系统（结束）");
		System.out.println("***输入5保存联系人名单到指定txt文档");
		
		while (true) 
		{
			int option = reader.nextInt();
			
			if (option == 4) { 
				phoneBook.autoSaveBeforeExit();
				System.exit(0);
			}
			
			switch (option) {
			case 1:
				addFunction();
				break;
			case 2:
				deleteFunction();
				break;
			case 3:
				printFunction();
				break;
			case 5:
				saveFunction();
				break;
			default:
				System.out.println("请输入有效的数字指令！");
				break;
			}
		}
	}
	
	public void saveFunction() {
		System.out.println("开始保存！！");
		System.out.println("注意IDE有可能遮挡了文件选择框，请最小化IDE");
		phoneBook.userCreateFile();
		System.out.println("O(∩_∩)O 完成！可以输入下一个指令了");
	}

	public void addFunction() 
	{
		System.out.println("***欢迎使用功能1，请先输入添加联系人的姓名***");
		String newName = reader.next();
		
		System.out.println("***下面请输入该联系人的手机号码***");
		String newPhone = reader.next();
		
		try {
			Integer.parseInt(newPhone);
		}
		catch(Exception e) {
			System.out.println("###手机号必须为数字，请重新输入全部数据###");
			this.addFunction();
			return;
		}
		
		System.out.println("***下面请输入该联系人的地址编码***");
		String newZip = reader.next();
		
		phoneBook.addPerson(new Person(newName, newPhone, newZip));
		
		System.out.println("O(∩_∩)O 完成！可以输入下一个指令了");
	}
	
	public void deleteFunction() 
	{
		System.out.println("***欢迎使用功能2，请先输入想要删除的联系人的姓名***");
		String deleteName = reader.next();
		if (phoneBook.removePerson(deleteName)) { 
			System.out.println("删除成功！");
		}
		else {
			System.out.println("系统中查无此人");
		}
		System.out.println("O(∩_∩)O 完成！可以输入下一个指令了");
	}
	
	public void printFunction()
	{
		System.out.println("***欢迎使用功能3，以下为该联系人册输出的结果***");
		phoneBook.printBook();
		
		System.out.println();
		System.out.println("O(∩_∩)O 完成！可以输入下一个指令了");
	}
	
	public static void main(String[] args) {
		new PhoneBook_menuDriven().start();
	}
}
