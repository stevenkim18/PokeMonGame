package pokemon;

import skill.Bubble;
import skill.Tackle;
import skill.TailWhip;
import skill.WaterGun;
import skill.Withdraw;
import thread.ImageViewer;

public class Squirtle extends PokeMon{ //꼬부기

	//<생성자>
	public Squirtle(String name, int level) {
		super(name);
		this.level = level;
		this.hp = 10 + 2 * level;
		this.max_hp = 10 + 2 * level;
		this.attack = 6 + level;
		this.defense = 6 + level;
		this.sp_attack = 8 + level;
		this.sp_defense = 7 + level;
		this.speed = 8 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 40;
		this.type = "물";
		
		//기본 스킬 추가
		this.skill.add(0, new Tackle("꼬부기")); // 몸통박치기
		this.skill.add(1, new TailWhip("꼬부기")); // 꼬리흔들기
		
		//보유 스킬 추가
		//레벨 7 거품
		this.learnable_skill.add(0, new Bubble("꼬부기"));
		//레벨 10 껍질에 숨기
		this.learnable_skill.add(1, new Withdraw("꼬부기"));		
		//레벨 14 물대포
		this.learnable_skill.add(2, new WaterGun("물대포"));
		
		//레벨 7이상으로 생성 될때
		if(level >= 7) {
			// 거품 배움
			this.skill.add(this.learnable_skill.remove(0));
			
			if(level >= 10) {
				//껍질에 숨기 배움
				this.skill.add(this.learnable_skill.remove(0));
				
				if(level >= 14) {
					//꼬리 흔들기 삭제
					this.skill.remove(1);
					
					//물대포 배움
					this.skill.add(this.learnable_skill.remove(0));
					
				}
			}
		}
	}
	
	// 사진을 보여주다
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("꼬부기", "꼬부기.jpg"));

		imageViewer.start();
		imageViewer.join();

	}
	
	

}
