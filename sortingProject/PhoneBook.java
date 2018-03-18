package sortingProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.google.zxing.Writer;

/**
 * @author listar2000
 * @project APCS Sorting Project
 */
public class PhoneBook {
	
	private ArrayList <Person> personList;
	private BufferedWriter writer;
	
	/**
	 *@constructor <b>构造器中才初始化数组并且会自动读取上一次保存的文档</b>
	 */
	public PhoneBook() {
		personList = new ArrayList<>();
		autoLoadBeforeStart();
	}
	
	/**
	 * @param <b>想要加入的Person对象，在菜单中由用户输入的数据构造</b>
	 * @return 无
	 */
	public void addPerson(Person person) 
	{
		personList.add(person);
	}
	
	/**
	 * 
	 * @param 想要删除的人的用户名
	 * @return 当列表联系人数量为0或者查无此人时为false，否则成功删除且返回true
	 */
	public boolean removePerson(String name) {
		//empty check
		if (personList.size() == 0) return false;
		
		for (Person p: personList) {
			if (p.getName().equals(name)) {
				personList.remove(p);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @depreciated 暂时没有用处
	 * @param 以前的名字
	 * @param 新的名字
	 * @param 新的手机号
	 * @param 新的地址
	 */
	public void changePerson(String oldName, String newName, String newPhone, String newZip) 
	{
		int personIndex = getPersonIndex(oldName);
		
		if (personIndex == -1) return;
		
		personList.get(personIndex).setName(newName);
		personList.get(personIndex).setPhone(newPhone);
		personList.get(personIndex).setZipCode(newZip);
	}
	
	/**
	 * 核心排序算法，使用冒泡排序法
	 */
	public void sortByName() 
	{		
		for (int j = 0; j < personList.size()-1; j++) {
			int miniIndex = j;
			for (int k = j+1; k < personList.size(); k++) {
				if (personList.get(miniIndex).getName().compareTo(personList.get(k).getName()) > 0) {
					miniIndex = k;
				}
			}
			Person swap = personList.get(j);
			personList.set(j, personList.get(miniIndex));
			personList.set(miniIndex, swap);
		}
	}
	
	/**
	 * 可选择选择排序或者是插入排序，核心算法
	 */
	public void sortByNum()
	{
		//selection sorting
//		for (int j = 0; j < personList.size()-1; j++) {
//			int miniIndex = j;
//			for (int k = j+1; k < personList.size(); k++) {
//
//				if (Integer.parseInt(personList.get(miniIndex).getPhone()) 
//						- Integer.parseInt(personList.get(k).getPhone()) > 0) {
//					miniIndex = k;
//				}
//			}
//			Person swap = personList.get(j);
//			personList.set(j, personList.get(miniIndex));
//			personList.set(miniIndex, swap);
//		}
		//insertion sorting
		for (int j = 1; j < personList.size(); j++) 
		{
			int possibleIndex = j;
			Person swap = personList.get(possibleIndex);
			while (possibleIndex > 0 && swap.getName()
					.compareTo(personList.get(possibleIndex-1).getName()) > 0) {
				personList.set(possibleIndex, personList.get(possibleIndex-1));
				possibleIndex--;
			}
			personList.set(possibleIndex, swap);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @return 找到的人，若不匹配返回null
	 */
	public Person getPerson(String name) 
	{	
		int personIndex = getPersonIndex(name);
		
		if (personIndex == -1) return null;
		
		return personList.get(personIndex);
		
	}
	
	/**
	 * 
	 * @param name
	 * @return 找到的人，若不匹配返回null
	 */
	private int getPersonIndex(String name) 
	{	
		int index = 0;
		while (personList.get(index).getName() != name && index < personList.size()) {
			index ++;
		}
		//if cannot find this person, return -1
		if (index == personList.size()) return -1;
		return index;
	}
	
	/**
	 * 定义console中用户的输出格式
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Person p : personList) builder.append(p.toString()+"\r\n");
		return builder.toString();
	}
	
	/**
	 * 测试方法
	 */
	public void printBook() {
		System.out.println(this);
	}
	
	/**
	 * 提供一个用户自定义存储路径的方式
	 */
	public void userCreateFile() {
		JFileChooser chooser = new JFileChooser();
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getAbsolutePath();
			if (!path.endsWith(".txt")) System.out.println("***选择文件形式必须为txt***");
			else writeToFile(path);
		}
	}
	
	/**
	 * 存储用户数据到一个指定文件夹
	 * @param filePath
	 */
	public void writeToFile(String filePath) {
		
		File file = new File(filePath);
		BufferedWriter writer = null;
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(toString());
			writer.flush();
			System.out.println("the phonebook has been succesfully printed to "+filePath);
		} catch (IOException e1) {
				e1.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 在程序开始运行时导入数据
	 */
	public void autoLoadBeforeStart() 
	{
		File autoFile = new File("/projectProperties.txt");
		String personInfo = null;
		if (!autoFile.exists()) {
			System.out.println("无法找到上次结束程序保存的数据");
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(autoFile));
			while ((personInfo = reader.readLine()) != null) {
				String [] info = personInfo.split("#");
				//The following line is for test.
				//System.out.println(info[0]);
				personList.add(new Person(info[0], info[1], info[2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在程序结束后保存数据
	 */
	public void autoSaveBeforeExit() {
		
		File autoFile = new File("/projectProperties.txt");
		try {
			if (!autoFile.exists()) autoFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(autoFile));
			StringBuilder builder = new StringBuilder();
			for (Person person: personList) {
				builder.append(person.getName()+"#"+person.getPhone()+"#"+person.getZipCode());
				builder.append("\n");
			}
			//The following line is for test only;
			//System.out.println(builder.toString());
			writer.write(builder.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}     
	
	public static void main(String[] args) {
		//example of writing phone book information to file.
//		PhoneBook book = new PhoneBook();
//		book.addPerson(new Person("kidam","123450","510630"));
//		book.addPerson(new Person("bidam","123451","510630"));
//		book.addPerson(new Person("aaa","123452","510630"));
//		book.addPerson(new Person("ccc","123453","510630"));
//		book.addPerson(new Person("ab","123454","510630"));
//		book.sortByName();
//		book.printBook();
//		book.sortByNum();
//		book.printBook();
//		book.autoSaveBeforeExit();
//		book.userCreateFile();
//		book.writeToFile("C:/Users/asus/Desktop/printToFile.txt");
	}
}
