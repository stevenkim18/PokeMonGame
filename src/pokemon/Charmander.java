package pokemon;

import skill.Ember;
import skill.Flamethrower;
import skill.Growl;
import skill.MetalClaw;
import skill.Scratch;
import thread.ImageViewer;

public class Charmander extends PokeMon{ //���̸�

	//<������>
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
		this.type = "��";
	
		// �⺻ ��ų �߰�
		this.skill.add(0, new Scratch("�ľƸ�")); //������
		this.skill.add(1, new Growl("���̸�"));   //�����Ҹ�
		
		// ���� ��ų �߰�
		// ���� 7 �Ҳ� ����
		this.learnable_skill.add(0, new Ember("���̸�"));
		// ���� 10 ��Żũ�ο�
		this.learnable_skill.add(1, new MetalClaw("���̸�"));
		// ���� 15 ȭ�� ���
		this.learnable_skill.add(2, new Flamethrower("���̸�"));
		
		// ���� 7�̻����� ���� ��
		if(level >=7) {
			// �Ҳ� ���� ���
			this.skill.add(this.learnable_skill.remove(0));
			
			if(level >= 10) {
				// ��Żũ�ο� ���
				this.skill.add(this.learnable_skill.remove(0));
				
				if(level >=15) {
					// �����Ҹ� ����
					this.skill.remove(1);
					
					// ȭ���� ���
					this.skill.add(this.learnable_skill.remove(0));	
					
				}
			}
		}
		
		
	}
	
	// ������
	@Override
	public void levelUp(int level) {
		// ������ �°� �ɷ�ġ�� �ö󰣴�!
		this.level = level;
		this.hp = 10 + 2 * level;
		this.max_hp = 10 + 2 * level;
		this.attack = 7 + level;
		this.defense = 6 + level;
		this.sp_attack = 8 + level;
		this.sp_defense = 7 + level;
		this.speed = 8 + level;
		this.max_exp = (level * (level - 1) * 5) / 2;
		
		//��ų�� ����.
		// ���� 7 �Ҳ� ����
		if(level == 7) {
			learnSkill("�Ҳɼ���");
		}
		// ���� 10 ��Żũ�ο�
		if(level == 10) {
			learnSkill("��Żũ�ο�");
		}
		// ���� 15 ȭ�� ���
		if(level == 15) {
			learnSkill("ȭ�����");
		}
	}
	
	// ��ų�� ����
	@Override
	public void learnSkill(String skill_name) {
		
		System.out.println(this.name + "�� " + this.learnable_skill.get(0).getName() + "�� ������ϴ�!");
		
		this.skill.add(this.learnable_skill.remove(0));
		
	}
	
	//������ �����ִ�
	public void showPicture() throws InterruptedException {
		
		Thread imageViewer = new Thread(new ImageViewer("���̸�", "���̸�.gif"));
		
		imageViewer.start();
		imageViewer.join();
		
	}
	

}
