package pokemon;

import skill.Growl;
import skill.LeechSeed;
import skill.PoisonPowder;
import skill.Tackle;
import skill.VineWhip;
import thread.ImageViewer;

public class Bulbasaur extends PokeMon{ //�̻��ؾ�

	public Bulbasaur(String name, int level) {
		super(name);
		this.level = level;
		this.hp = 10 + 2 * level;
		this.max_hp = 10 + 2 * level;
		this.attack = 7 + level;
		this.defense = 7 + level;
		this.sp_attack = 7 + level;
		this.sp_defense = 7 + level;
		this.speed = 8 + level;
		this.exp = 0;
		this.max_exp = (level * (level-1) *5)/2;
		this.drop_exp = 40;
		this.type = "Ǯ";
		
		// �⺻ ��ų �߰�!
		this.skill.add(0, new Tackle("�̻��ؾ�")); //�����ġ��
		this.skill.add(1, new Growl("�̻��ؾ�")); //�����Ҹ�

		// ���� ��ų �߰�
		// ���� 7 �Ҳ� ����
		this.learnable_skill.add(0, new LeechSeed("�̻��ؾ�")); //���Ѹ���
		// ���� 10 ��Żũ�ο�
		this.learnable_skill.add(1, new VineWhip("�̻��ؾ�")); //����ä��
		// ���� 15 ȭ�� ���
		this.learnable_skill.add(2, new PoisonPowder("�̻��ؾ�")); //������

		// ���� 7�̻����� ���� ��
		if (level >= 7) {
			// �Ҳ� ���� ���
			this.skill.add(this.learnable_skill.remove(0));

			if (level >= 10) {
				// ��Żũ�ο� ���
				this.skill.add(this.learnable_skill.remove(0));

				if (level >= 15) {
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
		this.defense = 7 + level;
		this.sp_attack = 7 + level;
		this.sp_defense = 7 + level;
		this.speed = 8 + level;
		this.max_exp = (level * (level - 1) * 5) / 2;

		// ��ų�� ����.
		// ���� 7 �Ҳ� ����
		if (level == 7) {
			learnSkill("���Ѹ���");
		}
		// ���� 10 ��Żũ�ο�
		if (level == 10) {
			learnSkill("����ä��");
		}
		// ���� 15 ȭ�� ���
		if (level == 15) {
			learnSkill("������");
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

		Thread imageViewer = new Thread(new ImageViewer("�̻��ؾ�", "�̻��ؾ�.png"));

		imageViewer.start();
		imageViewer.join();

	}

}
