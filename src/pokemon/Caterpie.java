package pokemon;

import skill.StringShot;
import skill.Tackle;
import thread.ImageViewer;

public class Caterpie extends PokeMon{//ĳ����

	//<������>
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
		this.type = "Ǯ";
		
		//�⺻ ��ų ����
		this.skill.add(new Tackle("ĳ����")); // �����ġ��
		this.skill.add(new StringShot("ĳ����")); // �ǻձ�
		
		
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
		this.type = "����";
	}
	
	// ������ �����ִ�
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("ĳ����", "ĳ����.png"));

		imageViewer.start();
		imageViewer.join();
	

	}

}
