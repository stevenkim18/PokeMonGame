package thread;

import java.util.Random;

import function.Music;

public class PokeBallWaitingThread extends Thread{

	@Override
	public void run() {
		Random random = new Random();
		
		int random_num = random.nextInt(3) + 3;
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		for (int i = 0; i < random_num; i++) {
			
			Music movingSound = new Music("���Ϻ������̴¼Ҹ�.mp3", false);
			movingSound.start();
			
			System.out.println("���Ϻ��� �����̴� ��...");
			System.out.println();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			
		}
	}
}
