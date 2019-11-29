package test;

import java.util.Scanner;

public class Test9 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			String num = scanner.next();
			
			System.out.println(Integer.parseInt(num));
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력해주세요!");
		}
		
		
		
		
	}
	
}
