package FlyWeightDemo;

import java.util.HashMap;
import java.util.Map;

public class BuildingFactory {
	
	private static Map<String, Building> buildingMap = new HashMap<>();
	
	public static Building getBuilding(String name) {
		
		Building building = buildingMap.get(name);
				
		if (building == null) {
			building = new Building(name);
			buildingMap.put(name, building);
		}
		
		return building;
	}
	
	public static int getSize() {
		return buildingMap.size();
	}
}	
