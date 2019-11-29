package thread;

import function.Music;

public class RecoverPokemonThread extends Thread{
	
	Music recoverMusic = new Music("포켓몬회복.mp3", false);
	
	@Override
	public void run() {
		
		recoverMusic.start();
		
		for (int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(1100);
			} catch (InterruptedException e) {
				
			}
			System.out.println("회복중...");
			System.out.println();
			
		}
		
		recoverMusic.close();
		
	}
	public static void main(String[] args) {
		
		
		Thread thread = new RecoverPokemonThread();
		thread.start();
	}
	
}


