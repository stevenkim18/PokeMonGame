package pokemon;

import skill.PosionSting;
import skill.StringShot;
import thread.ImageViewer;

public class Weedle extends PokeMon{ //뿔충이
	
	//<생성자>
	public Weedle(String name, int level) {
		super(name);
		this.level = level;
		this.hp = 9 + 2 * level;
		this.max_hp = 9 + 2 * level;
		this.attack = 5 + level;
		this.defense = 5 + level;
		this.sp_attack = 5 + level;
		this.sp_defense = 5 + level;
		this.speed = 5 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 10 * level;
		this.type = "풀";
		
		//기본 스킬 추가
		this.skill.add(new PosionSting("뿔충이")); //독침
		this.skill.add(new StringShot("뿔충이")); //실뿜기
	}
	
	@Override
	public void levelUp(int level) {
		this.level = level;
		this.hp = 9 + 2 * level;
		this.max_hp = 9 + 2 * level;
		this.attack = 5 + level;
		this.defense = 5 + level;
		this.sp_attack = 5 + level;
		this.sp_defense = 5 + level;
		this.speed = 5 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 10 * level;
		this.type = "벌레";
	}

	// 사진을 보여주다
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("뿔충이", "뿔충이.png"));

		imageViewer.start();
		imageViewer.join();

	}
	
}
