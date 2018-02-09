package classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////
			
	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setGreen(0);
				pixelObj.setRed(0);
			}
		}
	}
	
	public void negate() 
	{	
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) 
			{	
				pixelObj.setBlue(255-pixelObj.getBlue());
				pixelObj.setRed(255-pixelObj.getRed());
				pixelObj.setGreen(255-pixelObj.getGreen());
			}
		}
	}
	
	public void grayscale() 
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) 
			{	
				int grayDegree = (pixelObj.getBlue()+pixelObj.getRed()+pixelObj.getGreen())/3;
				pixelObj.setBlue(grayDegree);
				pixelObj.setRed(grayDegree);
				pixelObj.setGreen(grayDegree);
			}
		}
	}
	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	
	public void mirrorHorizontal() 
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel upPixel = null;
		Pixel downPixel = null;
		
		int height = pixels.length;
		for (int col = 0; col< pixels[0].length; col++) {
			for (int row=0; row < height/2; row++) {
				upPixel = pixels[row][col];
				downPixel = pixels[height-1-row][col];
				downPixel.setColor(upPixel.getColor());
			}
		}
	}
	
	public void mirrorHorizontalBotToTop() 
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel upPixel = null;
		Pixel downPixel = null;
		
		int height = pixels.length;
		for (int col = 0; col< pixels[0].length; col++) {
			for (int row=0; row < height/2; row++) {
				upPixel = pixels[row][col];
				downPixel = pixels[height-1-row][col];
				upPixel.setColor(downPixel.getColor());
			}
		}
	}
	
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	
	public void mirrorVerticleRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}
	
	public void mirrorArms() {
		
		final int UP_BORDER = 158;
		final int DOWN_BORDER = 198;
		final int LEFT_BORDER = 104;
		final int RIGHT_BORDER = 294;
		
		Pixel upPixel = null;
		Pixel downPixel = null;
		Pixel[][] pixels = this.getPixels2D();
	
		
		for (int col = LEFT_BORDER; col < RIGHT_BORDER; col++) {
			for (int row = UP_BORDER; row < DOWN_BORDER; row++) 
			{
				upPixel = pixels[row][col];
				downPixel = pixels[DOWN_BORDER - row + DOWN_BORDER][col];
				downPixel.setColor(upPixel.getColor());
			}
		}
	}
	
	public void mirrorGull() {
		
		final int UP_BORDER = 234;
		final int DOWN_BORDER = 321;
		final int LEFT_BORDER = 237;
		final int RIGHT_BORDER = 344;
		
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
	
		for (int row = UP_BORDER; row < DOWN_BORDER; row++) {
			for (int col = LEFT_BORDER; col < RIGHT_BORDER; col++) 
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][RIGHT_BORDER - col + RIGHT_BORDER];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	
	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		
		final int UP_BORDER = 27;
		final int DOWN_BORDER = 97;
		final int LEFT_BORDER = 13;
		final int RIGHT_BORDER = 276;
		
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		
		int count = 0;
		
		// loop through the rows
		for (int row = UP_BORDER; row < DOWN_BORDER; row++) {
			// loop from 13 to just before the mirror point
			for (int col = LEFT_BORDER; col < RIGHT_BORDER; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][RIGHT_BORDER - col + RIGHT_BORDER];
				rightPixel.setColor(leftPixel.getColor());
				count ++;
			}
		}
		System.out.println("The number of times that leftpixel is used is: "+count);
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) 
	{
		this.copy(fromPic, startRow, startCol, 0, fromPic.getWidth(), 0, fromPic.getHeight());
	}
	
	public void copy(Picture fromPic, int startRow, int startCol, int from_Left, int from_Right, int from_Up,
			int from_Down) 
	{
		
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		
		//对输入进行条件判断
		if (from_Left > from_Right || from_Right > fromPixels[0].length 
				|| from_Up > from_Down || from_Down > fromPixels.length) {
			System.out.println("输入的参数有问题");
			return;
		}
		
		for (int fromRow = from_Left, toRow = startRow; fromRow < from_Right
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = from_Up, toCol = startCol; fromCol < from_Down
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() 
	{
		Picture flower1 = new Picture("src/images/flower1.jpg");
		Picture flower2 = new Picture("src/images/flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("src/images/collage.jpg");
	}
	
	public void createMyCollage()
	{
		Picture seagull = new Picture("src/images/seagull.jpg");
		Picture flower = new Picture("src/images/flower1.jpg");
		Picture arms = new Picture("src/images/snowman.jpg");
		arms.negate();
		this.copy(flower, 0, 0);
		this.copy(seagull, 100, 0, 237, 344, 234, 321);
		this.copy(arms, 200, 0, 104, 294, 158, 198);
		this.mirrorVertical();
		this.write("src/images/myCollage.jpg");
		System.out.println("图片打印成功");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel downPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length-1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				downPixel = pixels[row+1][col];
				rightColor = rightPixel.getColor();
				
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else if (leftPixel.colorDistance(downPixel.getColor()) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("src/images/water.jpg");
		beach.explore();
		beach.grayscale();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
