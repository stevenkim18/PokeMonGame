package pokemon;

import skill.Harden;
import skill.RockThrow;
import skill.Tackle;
import thread.ImageViewer;

public class Onix extends PokeMon{ //�ս���

	//������
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
		this.type = "����";
		
		// ��ų �߰�!
		this.skill.add(0, new Tackle("�ս���")); // �����ġ��
		this.skill.add(1, new Harden("�ս���")); // �ܴ�������
		this.skill.add(2, new RockThrow("�ս���")); // ��������
				
	}
	
	// ������ �����ִ�
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("�ս���", "�ս���.jpg"));

		imageViewer.start();
		imageViewer.join();

	}


}
