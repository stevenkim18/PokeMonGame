package function;

import java.util.Scanner;

public class OneLine {
	
	public void pressEnter() {
		
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		Music buttonSound = new Music("��ư��.mp3", false);
		buttonSound.start();
	}
	
}
