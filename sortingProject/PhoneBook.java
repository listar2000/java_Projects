package sortingProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneBook {
	
	private ArrayList <Person> personList;
	
	public PhoneBook() {
		personList = new ArrayList<>();
	}
	
	public void addPerson(Person person) 
	{
		personList.add(person);
	}
	
	public boolean removePerson(Person person) {
		//empty check
		if (personList.size() == 0) return false;
		
		return personList.remove(person);
	}
	
	//TODO reconstruct this method changePerson() for better operation
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
		for (int j = 0; j < personList.size(); j++) {
			Person firstPerson = personList.get(j);
			for (int i = j+1; i < personList.size(); i++) {
				if (Integer.parseInt(firstPerson.getPhone()) - Integer.parseInt(personList.get(i).getPhone()) < 0)
			    {
					Person secondPerson = personList.get(i);
					int secondIndex = getPersonIndex(firstPerson.getName());
					personList.set(secondIndex, secondPerson);
					personList.set(i, firstPerson);
					firstPerson = secondPerson;
				}
			}
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
			System.out.println("the phonebook has been succesfully printed to file");
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
	
	public static void main(String[] args) {
		//example of writing phone book information to file.
		PhoneBook book = new PhoneBook();
		book.addPerson(new Person("kidam","123451","510630"));
		book.addPerson(new Person("bidam","123451","510630"));
		book.addPerson(new Person("aaa","123451","510630"));
		book.addPerson(new Person("ccc","123451","510630"));
		book.addPerson(new Person("absent","123451","510630"));
		book.sortByName();
		book.printBook();
//		book.writeToFile("C:/Users/asus/Desktop/printToFile.txt");
	}
}
