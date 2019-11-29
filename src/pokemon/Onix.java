package pokemon;

import skill.Harden;
import skill.RockThrow;
import skill.Tackle;
import thread.ImageViewer;

public class Onix extends PokeMon{ //·Õ½ºÅæ

	//»ý¼ºÀÚ
	public Onix(String name, int level) {
		super(name);
		
		this.level = level;
		this.hp = 11 + 2 * level;
		this.max_hp = 11 + 2 * level;
		this.attack = 8 + level;
		this.defense = 8 + level;
		this.sp_attack = 8 + level;
		this.sp_defense = 8 + level;
		this.speed = 8 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 15*level;
		this.type = "¹ÙÀ§";
		
		// ½ºÅ³ Ãß°¡!
		this.skill.add(0, new Tackle("·Õ½ºÅæ")); // ¸öÅë¹ÚÄ¡±â
		this.skill.add(1, new Harden("·Õ½ºÅæ")); // ´Ü´ÜÇØÁö±â
		this.skill.add(2, new RockThrow("·Õ½ºÅæ")); // µ¹¶³±¸±â
				
	}
	
	// »çÁøÀ» º¸¿©ÁÖ´Ù
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("·Õ½ºÅæ", "·Õ½ºÅæ.jpg"));

		imageViewer.start();
		imageViewer.join();

	}


}
