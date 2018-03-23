package javajava;

import java.util.Scanner;

public class diamondNumber 
{	
	/*
	 * 用于展示最终的输出
	 */
	public static void resultShow(int max) 
	{
		if (max > 99) {
			System.out.println("the number must be less than 100");
			return;
		}
		//从少到多
		for (int i = 0; i <= max; i++) {
			format(max, i);
		}
		//从多到少
		for (int i = max-1; i >= 0; i--) {
			format(max, i);
		}
	}
	/*
	 * format方法用于格式化输出（方法内完成了数字前空格数的设置）
	 */
	private static void format(int max, int number) {
		int gap = max-number;
		for (int i = 0; i < gap; i++) {
			System.out.print("   ");
		} 
		printNum(number);
	}
	/*
	 * 这个方法用于输出每一行的数字内容，如 4 3 2 1 0 1 2 3 4
	 */
	private static void printNum(int n) 
	{
		for (int i = n; i > 0; i--) {
			//当数字为2位数时间隔为1
			if (i > 9) System.out.print(i+" ");
			//1位数时间隔为2
			else System.out.print(i+"  ");
		}
		
		for (int i = 0; i <= n; i++) {
			//当数字为2位数时间隔为1
			if (i > 9) System.out.print(i+" ");
			//1位数时间隔为2
			else System.out.print(i+"  ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number between 1 and 99");
		int max = Integer.parseInt(reader.next());
		resultShow(max);
		reader.close();
	}
}

