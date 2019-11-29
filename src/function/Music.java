package function;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import main.PokeMon_Game;

public class Music extends Thread{ //���Ǿ�����
	
	//����
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	//������
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
	
	//�޼ҵ�
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
