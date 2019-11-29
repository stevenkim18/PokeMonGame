package pokemon;

import skill.Bubble;
import skill.Tackle;
import skill.TailWhip;
import skill.WaterGun;
import skill.Withdraw;
import thread.ImageViewer;

public class Squirtle extends PokeMon{ //���α�

	//<������>
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
		this.type = "��";
		
		//�⺻ ��ų �߰�
		this.skill.add(0, new Tackle("���α�")); // �����ġ��
		this.skill.add(1, new TailWhip("���α�")); // ��������
		
		//���� ��ų �߰�
		//���� 7 ��ǰ
		this.learnable_skill.add(0, new Bubble("���α�"));
		//���� 10 ������ ����
		this.learnable_skill.add(1, new Withdraw("���α�"));		
		//���� 14 ������
		this.learnable_skill.add(2, new WaterGun("������"));
		
		//���� 7�̻����� ���� �ɶ�
		if(level >= 7) {
			// ��ǰ ���
			this.skill.add(this.learnable_skill.remove(0));
			
			if(level >= 10) {
				//������ ���� ���
				this.skill.add(this.learnable_skill.remove(0));
				
				if(level >= 14) {
					//���� ���� ����
					this.skill.remove(1);
					
					//������ ���
					this.skill.add(this.learnable_skill.remove(0));
					
				}
			}
		}
	}
	
	// ������ �����ִ�
	public void showPicture() throws InterruptedException {

		Thread imageViewer = new Thread(new ImageViewer("���α�", "���α�.jpg"));

		imageViewer.start();
		imageViewer.join();

	}
	
	

}
