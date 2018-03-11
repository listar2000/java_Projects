package FlyWeightDemo;

public class Building implements IBuilding {
	
	private String name;
	private String shape;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Building(String name) {
		this.name = name;
	}
	
	@Override
	public void use() {
		System.out.println("the building is a "+name+", its shape is "+shape+", and its age is "+ age);
	}

}
