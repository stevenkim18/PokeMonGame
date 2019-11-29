package thread;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageViewer extends JFrame implements Runnable{
	
	Image img = null;
	
	public ImageViewer(String pokemon_name, String file_name) {
		
		try {
			
			File image = new File("C:\\Users\\ksw01\\Desktop\\pokemon\\" + file_name);
			img = ImageIO.read(image);
			
		} catch (IOException e) {
			
			System.out.println("이미지 파일이 없습니다!");
		}
		
		init();
		
		setTitle(pokemon_name);
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		
	}
	
	public void init() {
		
		JLabel label = new JLabel(new ImageIcon(img));
		
		add(label);
		
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dispose();
		
	}
	
}
