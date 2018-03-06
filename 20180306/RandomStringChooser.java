import java.util.ArrayList;
import java.util.Random;

public class RandomStringChooser {
	
	private ArrayList <String> list;
	private Random random = new Random();
	
	public RandomStringChooser(String [] strings) {
		
		list = new ArrayList<>();
		
		for (String string: strings)
			list.add(string);
		
	}
	
	public String getNext() {
		
		if (list.size() == 0) return "NONE";
		
		return list.remove(random.nextInt(list.size()));
		
	}
	
//	public static void main(String[] args) {
//		
//		String [] words = {"i","fuck","your","mother"};
//		RandomStringChooser chooser = new RandomStringChooser(words);
//		
//		for (int k = 0; k < 6; k++) {  
//			System.out.print(chooser.getNext()+" ");
//		}
//		
//	}
}
