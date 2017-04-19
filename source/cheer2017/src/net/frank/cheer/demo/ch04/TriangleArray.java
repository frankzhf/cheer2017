package net.frank.cheer.demo.ch04;

import java.util.Scanner;

public class TriangleArray {
	
	public static void main(String[] args) {
		
		System.out.print("Enter a number:");
		Scanner scanner = new Scanner(System.in);
		
		final int input = scanner.nextInt();
		int[][] data = new int[input + 1][];
		for (int i = 0; i <= input; i++) {
			data[i] = new int[i + 1];
		}

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				
				int value = 1;
				for (int k = 1; k <= j; k++)
					value = value * (i - k + 1) / k;

				data[i][j] = value;
			}
		}
		int space = input * 2;
		for (int[] row : data) {
			StringBuilder sb = new StringBuilder(space);
			for (int i = 0; i < space; i++) {
				sb.append(" ");
			}
			space -= 2;
			System.out.print(sb.toString());
			for (int odd : row)
				System.out.printf("%4d", odd);
			System.out.println();
		}
		scanner.close();
	}
}
