package FlyWeightDemo;

public class BuildingTest {

	public static void main(String[] args) 
	{
		for (int i = 0; i < 5; i++) {
			Building bd = BuildingFactory.getBuilding("ThinkPHP");
			bd.setAge(i);
			bd.setShape("rectangal");
			bd.use();
			System.out.println(BuildingFactory.getSize());
		}
	}

}
