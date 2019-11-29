package test;

import java.util.Scanner;

public class Test7 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자 입력:");
		int n = scanner.nextInt();
		
		int S = (n*(n-1)*5)/2;
		System.out.println(S);
		
		
	}
}	
