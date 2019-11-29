package thread;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ItemThread {
	
	//변수
	int second = 0;
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		
		@Override
		public void run() {

			second++;
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t"+second + "초");
			
			if(second == 5) {
				timer.cancel();
			}
			
		}
	};
	//Getter Setter
	public int getSecond() {
		return second;
	}


	public void setSecond(int second) {
		this.second = second;
	}
	
	
	//메소드
	public void start() {
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}


	
//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		ItemThread itemThread = new ItemThread();
//		
//		itemThread.start();
//		
//		int count = 0;
//		
//		do {
//			System.out.println("엔터 입력");
//			scanner.nextLine();
//			count++;
//			
//		} while (itemThread.second < 5);
//		
//		System.out.println("count = "+count);
//		
//		if(count> 50) {
//			System.out.println("성공");
//		}
//		else {
//			System.out.println("실패");
//		}
//		
//	}
}
