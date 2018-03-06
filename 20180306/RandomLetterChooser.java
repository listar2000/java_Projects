public class RandomLetterChooser extends RandomStringChooser{

	public RandomLetterChooser(String[] strings) {
		super(strings);
	}
	
	public RandomLetterChooser(String str) {
		
		super(getSingleLetters(str));
		
	}
	
	public static String [] getSingleLetters(String string) {
		
		String [] letters = new String [string.length()];
		//the most efficient way of assigning characters to String list
		for (int i = 0; i < string.length(); i++) {
			letters[i] = String.valueOf(string.charAt(i));
		}
		
		return letters;
	}
	
//	public static void main(String[] args) {
//		
//		RandomStringChooser letter = new RandomLetterChooser("specific");
//		for (int k = 0; k < 10; k++) {
//			System.out.print(letter.getNext());
//		}
//		
//	}
}
