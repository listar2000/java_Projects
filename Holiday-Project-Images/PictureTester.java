package classes;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test keepOnlyBlue */
	public static void testKeepOnlyBlue() {
		Picture beach = new Picture("src/images/beach.jpg");
		beach.explore();
		beach.keepOnlyBlue();
		beach.explore();
	}
	
	public static void testNegate() {
		Picture gorge = new Picture("src/images/gorge.jpg");
		gorge.explore();
		gorge.negate();
		gorge.explore();
	}
	
	public static void testGrayscale() {
		Picture gorge = new Picture("src/images/gorge.jpg");
		gorge.explore();
		gorge.grayscale();
		gorge.explore();
	}
	
	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("src/images/caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}
	
	public static void testMirrorHorizontal() 
	{
		Picture caterpillar = new Picture("src/images/caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorHorizontal();
		caterpillar.explore();
	}
	
	public static void testMirrorHorizontalBotToTop() 
	{
		Picture caterpillar = new Picture("src/images/caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorHorizontalBotToTop();
		caterpillar.explore();
	}
	
	public static void testMirrorVerticalRightToLeft() {
		Picture caterpillar = new Picture("src/images/caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVerticleRightToLeft();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("src/images/temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}
	
	public static void testMirrorGull() {
		Picture temple = new Picture("src/images/seagull.jpg");
		temple.explore();
		temple.mirrorGull();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("src/images/640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}
	
	public static void testMyCollage() {
		Picture canvas = new Picture("src/images/640x480.jpg");
		canvas.createMyCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("src/images/temple.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}
	
	public static void testMirrorArms() {
		Picture snowman = new Picture("src/images/snowman.jpg");
		snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		// testZeroBlue();
//		testMirrorVerticalRightToLeft();
//		testMirrorHorizontal();
//		testMirrorHorizontalBotToTop();
//		testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
//		 testNegate();
//		 testGrayscale();
		// testFixUnderwater();
//		 testMirrorVertical();
//		 testMirrorTemple();
		// testMirrorGull();
		// testMirrorDiagonal();
//		 testMyCollage();
		// testCopy();
		 testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
	}
}