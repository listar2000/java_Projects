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

public class PhoneBook {
	
	private ArrayList <Person> personList;
	private BufferedWriter writer;
	
	
	
	public PhoneBook() {
		personList = new ArrayList<>();
		autoLoadBeforeStart();
	}
	
	public void addPerson(Person person) 
	{
		personList.add(person);
	}
	
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
	
	public void changePerson(String oldName, String newName, String newPhone, String newZip) 
	{
		int personIndex = getPersonIndex(oldName);
		
		if (personIndex == -1) return;
		
		personList.get(personIndex).setName(newName);
		personList.get(personIndex).setPhone(newPhone);
		personList.get(personIndex).setZipCode(newZip);
	}
	
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
	
	public Person getPerson(String name) 
	{	
		int personIndex = getPersonIndex(name);
		
		if (personIndex == -1) return null;
		
		return personList.get(personIndex);
		
	}
	
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Person p : personList) builder.append(p.toString()+"\r\n");
		return builder.toString();
	}
	
	public void printBook() {
		System.out.println(this);
	}
	
	public void userCreateFile() {
		JFileChooser chooser = new JFileChooser();
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getAbsolutePath();
			if (!path.endsWith(".txt")) System.out.println("***选择文件形式必须为txt***");
			else writeToFile(path);
		}
	}
	
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
	
	public void autoLoadBeforeStart() 
	{
		File autoFile = new File("E:/save.txt");
		String personInfo = null;
		if (!autoFile.exists()) {
			System.out.println("无法找到上次结束程序保存的数据");
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(autoFile));
			while ((personInfo = reader.readLine()) != null) {
				String [] info = personInfo.split("#");
				System.out.println(info[0]);
				personList.add(new Person(info[0], info[1], info[2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void autoSaveBeforeExit() {
		
		File autoFile = new File("E:/save.txt");
		try {
			if (!autoFile.exists()) autoFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(autoFile));
			StringBuilder builder = new StringBuilder();
			for (Person person: personList) {
				builder.append(person.getName()+"#"+person.getPhone()+"#"+person.getZipCode());
				builder.append("\n");
			}
			System.out.println(builder.toString());
			writer.write(builder.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
