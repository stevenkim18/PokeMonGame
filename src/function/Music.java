package function;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import main.PokeMon_Game;

public class Music extends Thread{ //음악쓰레드
	
	//변수
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	//생성자
	public Music(String musicName, boolean isLoop) {
		
		try {
			this.isLoop = isLoop;
			file = new File(PokeMon_Game.class.getResource("../music/" + musicName).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
		} catch (Exception e) {
			
		}
		
	}
	
	//메소드
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
		
	}
	
	@Override
	public void run() {

		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				
			} while (isLoop);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
