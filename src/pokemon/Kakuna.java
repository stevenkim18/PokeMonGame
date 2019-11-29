package pokemon;

import skill.Harden;
import thread.ImageViewer;

public class Kakuna extends PokeMon{ // 딱충이

	//<생성자>
	public Kakuna(String name, int level) {
		super(name);
		this.level = level;
		this.hp = 11 + 2 * level;
		this.max_hp = 11 + 2 * level;
		this.attack = 5 + level;
		this.defense = 6 + level;
		this.sp_attack = 5 + level;
		this.sp_defense = 6 + level;
		this.speed = 5 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 12 * level;
		this.type = "풀";
		
		//기본스킬
		this.skill.add(0,new Harden("딱충이")); //딱딱해지기
		
	}

	
	@Override
	public void levelUp(int level) {
		this.level = level;
		this.hp = 11 + 2 * level;
		this.max_hp = 11 + 2 * level;
		this.attack = 5 + level;
		this.defense = 6 + level;
		this.sp_attack = 5 + level;
		this.sp_defense = 6 + level;
		this.speed = 5 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 12 * level;
		this.type = "벌레";
	}
	
	// 사진을 보여주다
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("딱충이", "딱충이.png"));

		imageViewer.start();
		imageViewer.join();

	}

}
