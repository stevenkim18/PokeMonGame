package thread;

import java.util.Scanner;

public class PrintOnebyone {
	
	//변수
	Thread oneLine;
	
	
	//메소드
	public void printSentence(String sentence) throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		
		oneLine = new Thread(new PrintOnebyoneThread(sentence));
		
		oneLine.start();
		oneLine.join();
		
		System.out.println();
		scanner.nextLine();
		
	}
}
