package pokemon;

import skill.StringShot;
import skill.Tackle;
import thread.ImageViewer;

public class Caterpie extends PokeMon{//캐터피

	//<생성자>
	public Caterpie(String name, int level) {
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
		
		//기본 스킬 장착
		this.skill.add(new Tackle("캐터피")); // 몸통박치기
		this.skill.add(new StringShot("캐터피")); // 실뿜기
		
		
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

		Thread imageViewer = new Thread(new ImageViewer("캐터피", "캐터피.png"));

		imageViewer.start();
		imageViewer.join();
	

	}

}
