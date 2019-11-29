package pokemon;

import skill.Ember;
import skill.Flamethrower;
import skill.Growl;
import skill.MetalClaw;
import skill.Scratch;
import thread.ImageViewer;

public class Charmander extends PokeMon{ //파이리

	//<생성자>
	public Charmander(String name, int level) {
		super(name);
		this.level = level;
		this.hp = 10 + 2 * level;
		this.max_hp = 10 + 2 * level;
		this.attack = 7 + level;
		this.defense = 6 + level;
		this.sp_attack = 8 + level;
		this.sp_defense = 7 + level;
		this.speed = 8 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 40;
		this.type = "불";
	
		// 기본 스킬 추가
		this.skill.add(0, new Scratch("파아리")); //할퀴기
		this.skill.add(1, new Growl("파이리"));   //울음소리
		
		// 보유 스킬 추가
		// 레벨 7 불꽃 세례
		this.learnable_skill.add(0, new Ember("파이리"));
		// 레벨 10 메탈크로우
		this.learnable_skill.add(1, new MetalClaw("파이리"));
		// 레벨 15 화염 방사
		this.learnable_skill.add(2, new Flamethrower("파이리"));
		
		// 레벨 7이상으로 생길 때
		if(level >=7) {
			// 불꽃 세례 배움
			this.skill.add(this.learnable_skill.remove(0));
			
			if(level >= 10) {
				// 메탈크로우 배움
				this.skill.add(this.learnable_skill.remove(0));
				
				if(level >=15) {
					// 울음소리 지움
					this.skill.remove(1);
					
					// 화명방사 배움
					this.skill.add(this.learnable_skill.remove(0));	
					
				}
			}
		}
		
		
	}
	
	// 레벨업
	@Override
	public void levelUp(int level) {
		// 레벨에 맞게 능력치가 올라간다!
		this.level = level;
		this.hp = 10 + 2 * level;
		this.max_hp = 10 + 2 * level;
		this.attack = 7 + level;
		this.defense = 6 + level;
		this.sp_attack = 8 + level;
		this.sp_defense = 7 + level;
		this.speed = 8 + level;
		this.max_exp = (level * (level - 1) * 5) / 2;
		
		//스킬을 배운다.
		// 레벨 7 불꽃 세례
		if(level == 7) {
			learnSkill("불꽃세례");
		}
		// 레벨 10 메탈크로우
		if(level == 10) {
			learnSkill("메탈크로우");
		}
		// 레벨 15 화염 방사
		if(level == 15) {
			learnSkill("화염방사");
		}
	}
	
	// 스킬을 배운다
	@Override
	public void learnSkill(String skill_name) {
		
		System.out.println(this.name + "가 " + this.learnable_skill.get(0).getName() + "를 배웠습니다!");
		
		this.skill.add(this.learnable_skill.remove(0));
		
	}
	
	//사진을 보여주다
	public void showPicture() throws InterruptedException {
		
		Thread imageViewer = new Thread(new ImageViewer("파이리", "파이리.gif"));
		
		imageViewer.start();
		imageViewer.join();
		
	}
	

}
