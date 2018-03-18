package sortingProject;

import java.util.Scanner;

/**
 * @author listar2000
 * @project APCS Sorting Project
 */
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
		System.out.println("***输入4保存联系人名单到指定txt文档");
		System.out.println("***输入5查询联系人（姓名查询）");
		System.out.println("***输入6将联系人以名字顺序排序");
		System.out.println("***输入7将联系人以电话号码排序");
		System.out.println("***输入8退出系统（结束）");
		System.out.println("*************************************");
		
		while (true) 
		{
			int option = reader.nextInt();
			
			if (option == 8) { 
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
			case 4:
				saveFunction();
				break;
			case 5:
				searchFunction();
				break;
			case 6:
				nameSearchFunction();
			case 7:
				phoneSearchFunction();
			default:
				System.out.println("请输入有效的数字指令！");
				break;
			}
			System.out.println("***😄可以进行下一个操作了***");
		}
	}
	
	private void searchFunction() 
	{
		System.out.println("请输入查询人姓名");
		
		Person searchPerson = phoneBook.getPerson(reader.next());
		
		if (searchPerson == null) System.out.println("^^^查无此人^^^");
		else System.out.println(searchPerson);
	}

	private void saveFunction() {
		System.out.println("开始保存！！");
		System.out.println("注意IDE有可能遮挡了文件选择框，请最小化IDE");
		phoneBook.userCreateFile();
	}

	private void addFunction() 
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
	}
	
	private void deleteFunction() 
	{
		System.out.println("***欢迎使用功能2，请先输入想要删除的联系人的姓名***");
		String deleteName = reader.next();
		if (phoneBook.removePerson(deleteName)) { 
			System.out.println("删除成功！");
		}
		else {
			System.out.println("系统中查无此人");
		}
	}
	
	private void printFunction()
	{
		System.out.println("***以下为该联系人册输出的结果***");
		phoneBook.printBook();

		System.out.println();
	}
	
	private void nameSearchFunction() 
	{
		phoneBook.sortByName();
		System.out.println("***排序成功***");
		printFunction();
	}
	
	private void phoneSearchFunction() 
	{
		phoneBook.sortByNum();
		System.out.println("***排序成功***");
		printFunction();
	}
	
	public static void main(String[] args) {
		new PhoneBook_menuDriven().start();
	}
}
