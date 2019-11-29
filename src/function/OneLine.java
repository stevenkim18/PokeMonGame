package function;

import java.util.Scanner;

public class OneLine {
	
	public void pressEnter() {
		
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		Music buttonSound = new Music("¹öÆ°À½.mp3", false);
		buttonSound.start();
	}
	
}
