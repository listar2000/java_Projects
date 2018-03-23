package javajava;

import java.util.Scanner;

public class diamondNumber 
{	
	/*
	 * ����չʾ���յ����
	 */
	public static void resultShow(int max) 
	{
		if (max > 99) {
			System.out.println("the number must be less than 100");
			return;
		}
		//���ٵ���
		for (int i = 0; i <= max; i++) {
			format(max, i);
		}
		//�Ӷൽ��
		for (int i = max-1; i >= 0; i--) {
			format(max, i);
		}
	}
	/*
	 * format�������ڸ�ʽ����������������������ǰ�ո��������ã�
	 */
	private static void format(int max, int number) {
		int gap = max-number;
		for (int i = 0; i < gap; i++) {
			System.out.print("   ");
		} 
		printNum(number);
	}
	/*
	 * ��������������ÿһ�е��������ݣ��� 4 3 2 1 0 1 2 3 4
	 */
	private static void printNum(int n) 
	{
		for (int i = n; i > 0; i--) {
			//������Ϊ2λ��ʱ���Ϊ1
			if (i > 9) System.out.print(i+" ");
			//1λ��ʱ���Ϊ2
			else System.out.print(i+"  ");
		}
		
		for (int i = 0; i <= n; i++) {
			//������Ϊ2λ��ʱ���Ϊ1
			if (i > 9) System.out.print(i+" ");
			//1λ��ʱ���Ϊ2
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

