package thread;

import java.util.Scanner;

public class PrintOnebyone {
	
	//����
	Thread oneLine;
	
	
	//�޼ҵ�
	public void printSentence(String sentence) throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		
		oneLine = new Thread(new PrintOnebyoneThread(sentence));
		
		oneLine.start();
		oneLine.join();
		
		System.out.println();
		scanner.nextLine();
		
	}
}
