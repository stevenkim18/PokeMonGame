package thread;

import java.util.Random;

public class WaitingPokemonThread extends Thread{

	@Override
	public void run() {
		Random random = new Random();
		
		int random_num = random.nextInt(3) + 3;
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		for (int i = 0; i < random_num; i++) {
			
			System.out.println("야생 포켓몬을 기다리는 중...");
			System.out.println();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Thread thread = new WaitingPokemonThread();
		thread.start();
		
	}
	
}


