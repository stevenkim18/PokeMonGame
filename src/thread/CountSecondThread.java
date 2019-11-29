package thread;

import java.util.Timer;
import java.util.TimerTask;

public class CountSecondThread extends Thread{
	
	//변수
	int second = 0;
	int max_second;
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		
		@Override
		public void run() {

			second++;
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t"+second + "초");
			
			if(second == max_second) {
				timer.cancel();
			}
			
		}
	};
	public CountSecondThread(int max_second) {
		this.max_second = max_second;
	}
	
	
	//Getter Setter
	public int getSecond() {
		return second;
	}


	public void setSecond(int second) {
		this.second = second;
	}
	
	
	//메소드
	public void start() {
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public static void main(String[] args) {
		
		CountSecondThread countSecondThread = new CountSecondThread(10);
		
		countSecondThread.start();
	}
	
}
