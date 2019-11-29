package pokemon;

import skill.PosionSting;
import skill.StringShot;
import thread.ImageViewer;

public class Weedle extends PokeMon{ //������
	
	//<������>
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
		this.type = "Ǯ";
		
		//�⺻ ��ų �߰�
		this.skill.add(new PosionSting("������")); //��ħ
		this.skill.add(new StringShot("������")); //�ǻձ�
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

		Thread imageViewer = new Thread(new ImageViewer("������", "������.png"));

		imageViewer.start();
		imageViewer.join();

	}
	
}
