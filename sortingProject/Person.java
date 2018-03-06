package sortingProject;

import java.util.ArrayList;

public class Person {
	
	private String name;
	private String phone;
	private String zipCode;
	
	public Person() {}
	
	public Person(String name, String phone, String zipCode) {
		
		this.name = name;
		this.phone = phone;
		this.zipCode = zipCode;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Person)) return false;
		
		else if (name == ((Person)obj).name && phone == ((Person)obj).phone 
				&& zipCode == ((Person)obj).zipCode) 
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "***Name: " + name + "  Phone Number: " + phone + "  Zip Code: "+ zipCode + " ***";
	}
	
	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
		Person p1 = new Person("a","123","321");
		Person p2 = new Person("a","12","321");
		list.add(p1);
		System.out.println(list.get(0));
		System.out.println(p1.equals(p2));
		list.get(0).setName("Oscar");
		System.out.println(list.get(0));
		
	}
}
