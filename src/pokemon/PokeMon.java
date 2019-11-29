/*
 * ���ϻ����ð�: 5�� 2�� 15�� 20��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * ���ϸ� Ŭ����
 * 
 * <Ŭ���� ����>
 * - ��� ���ϸ���� �θ�Ŭ�����̴�.
 * 
 * <����>
 * - �̸�: ���ϸ��� �̸��� �����ϴ� ����
 * - ����: ���ϸ��� ������ �����ϴ� ����
 * - ü��: ���ϸ��� ü���� �����ϴ� ����
 * - ���ݷ� : ���ϸ��� ���ݷ��� �����ϴ� ����
 * - ���� : ���ϸ��� ������ �����ϴ� ����
 * - ���ǵ� : ���ϸ��� ���ǵ带 �����ϴ� ����(������ �� ���ϸ��� ���ǵ带 ���ؼ� ���� ���ϸ��� ���� ����)
 * - ����ġ : ���ϸ��� ���� ����ġ�� �����ϴ� ����
 * - �ִ����ġ : ���ϸ��� �ִ� ����ġ�� �����ϴ� ����(���� ���� �ִ� ����ġ�� Ŀ��)
 * - (��ų�������� : ��ų�� �����ϰ� �ִ� ���ڸ� �����ϴ� ����)
 * - �Ӽ� : ���ϸ��� Ÿ���� �����ϴ� ����(��, ��, ����, ��, �븻 ���)
 * - 
 * 
 * <�޼ҵ�>
 * - ���ϸ��� ��ų�� ����Ѵ�
 * - ���ϸ��� ü���� �����Ѵ�
 * - ��ų�� ����
 * - ȸ���ȴ�
 * - �����ϴ�
 * - ��ȭ�ϴ�
 * - ������ �ö󰡴�
 * - ����ġ�� �ö󰡴�
*/

package pokemon;

import java.util.ArrayList;

import skill.Skill;

public class PokeMon {
	
	//<����>
	String name;   //�̸�
	int level;     //����
	int hp;        //ü��
	int max_hp;    //�ִ�ü��
	int attack;    //���ݷ�
	int defense;   //����
	int sp_attack; //Ư�����ݷ�
	int sp_defense;//Ư������
	int speed;     //���ǵ�
	int exp;       //����ġ
	int max_exp;   //�ִ� ����ġ
	int drop_exp;  //�ִ� ����ġ
	String type;   //�Ӽ�
	ArrayList<Skill> skill; // ������ ��ų
	ArrayList<Skill> learnable_skill; // ��� �� �ִ� ��ų
	
	//<������>
	public PokeMon(String name) {
//			int level, int hp, int attack, int defense, int sp_attack, int sp_defense, int speed, String type) {
		this.name = name;
//		this.level = level;
//		this.hp = hp;
//		this.max_hp  = hp; // ó�� ���ϸ��� ���� �Ҷ��� ü�� ���� �ִ� ü���� ���� ����
//		this.attack = attack;
//		this.defense = defense;
//		this.sp_attack = sp_attack;
//		this.sp_defense = sp_defense;
//		this.speed = speed;
//		this.type = type;
		this.skill = new ArrayList<Skill>();
		
		this.learnable_skill = new ArrayList<Skill>();
	}

	//<Getter, Setter>
	//[start]
	public String getName() {
		return name;
	}

	public int getMax_hp() {
		return max_hp;
	}

	public void setMax_hp(int max_hp) {
		this.max_hp = max_hp;
	}

	public int getSp_attack() {
		return sp_attack;
	}

	public void setSp_attack(int sp_attack) {
		this.sp_attack = sp_attack;
	}

	public int getSp_defense() {
		return sp_defense;
	}

	public void setSp_defense(int sp_defense) {
		this.sp_defense = sp_defense;
	}

	public int getDrop_exp() {
		return drop_exp;
	}

	public void setDrop_exp(int drop_exp) {
		this.drop_exp = drop_exp;
	}

	public ArrayList<Skill> getSkill() {
		return skill;
	}

	public void setSkill(ArrayList<Skill> skill) {
		this.skill = skill;
	}

	public ArrayList<Skill> getLearnable_skill() {
		return learnable_skill;
	}

	public void setLearnable_skill(ArrayList<Skill> learnable_skill) {
		this.learnable_skill = learnable_skill;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMax_exp() {
		return max_exp;
	}

	public void setMax_exp(int max_exp) {
		this.max_exp = max_exp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	//[end]
	
	//<�޼ҵ�>
	//���ϸ��� ��ų�� ����Ѵ�
	public void useSkill(int skill_num, PokeMon myPokemon, PokeMon otherPokemon) {
		
		System.out.println(this.name + "�� " + this.skill.get(skill_num-1).getName() + "�� ����մϴ�!");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
		
		// ��ų����Ʈ�� 0���� �����ϱ� ������ �Ű������� -1�� ��.
		this.skill.get(skill_num -1).beUsed(myPokemon, otherPokemon);
	}
	
	//���ϸ��� ü���� �����Ѵ�
	public void reduceHp(int damage) {
		
		//�������� ���̳ʽ��� ��� �������� 1�� �ٲ�
		if (damage < 0) {
			damage = 1;
		}
		
		System.out.println(this.name + "�� ü���� " + damage + " �����߽��ϴ�!");
		
		this.hp -= damage;
		
		//ü���� ���̳ʽ��� �Ǵ� ���� 0���� �ٲ۴�
		if(hp <= 0) {
			this.hp = 0;
		}
	}
	
	//��ų�� ����
	public void learnSkill(String skill_name) {
		
	}
	
	//ȸ���ȴ�
	public void recover() {
		// ü���� �ִ� ü�±��� �ö󰣴�.
		this.hp = max_hp;
	}
	//������ ��ŭ ȸ���Ѵ�
	public void recover(int hp) {
		// ü���� �ִ� ü�±��� �ö󰣴�.
		this.hp += hp;
		
		if(this.hp > this.max_exp) {
			this.hp = this.max_exp;
		}
	}
	
	//�����ϴ�
	public void faint() {
		System.out.println(this.name + "�� �����Ͽ����ϴ�!");
	}
	
	//���ϸ��� ��ų�� �����ش�
	public void showSkills() {
		System.out.println("���������������������������������������������������������������������������������������������������� "+this.name+"�� ��ų ��������������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < this.skill.size(); i++) {
			System.out.print("     [" + (i+1) + "]" + 
								this.skill.get(i).getName() + 
								"(" + this.skill.get(i).getPower_point() + "/" + this.skill.get(i).getMax_power_point() + ")" +
								" �Ӽ�: " + this.skill.get(i).getType());
		}
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	//���ϸ� ����ġ�� �ö󰡴�
	public void increaseExp(int exp) {
				
		this.exp += exp;
		
		System.out.println(this.name + "�� ����ġ�� " + exp + " �����Ͽ����ϴ�!");
		
		//����ġ�� �ִ� ����ġ ���� ū ���
		if(this.exp >= this.max_exp) {
			
			//���� ����ġ���� �ִ����ġ�� �A���� ���� ����ġ�� ����
			this.exp = this.exp - this.max_exp;
			
			//������ �ö󰣴�
			this.level += 1;
			
			System.out.println(this.name + "�� ������ "+ this.level+ "�� �ö����ϴ�!");
			
			//������ �°� �ɷ�ġ�� �ö󰣴�
			levelUp(this.level);
			
		}
	}
	
	//���ϸ��� ������ �ö󰡴�
	public void levelUp(int level) {
		
	}
	
	//���ϸ��� ���¸� �����ش�
	public void showPokemonStat() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("������������������������������������������������������������������������������������������������ "+this.name+"�� ������ "+" ������������������������������������������������������������������������������������������������������������");
		System.out.print("   \t\t\t\t�̸�: " + this.name + " / ����: " + this.level + " / �Ӽ�: " + this.type);
		System.out.println(" / ü��: " + this.hp + "/" + this.max_hp + " / ����ġ: " + this.exp + "/" + this.max_exp);
		System.out.println("---------------------------------------------------- <�ɷ�ġ> ---------------------------------------------------------");
		System.out.println("\t\t\t       ���ݷ�: " + this.attack + " / Ư�����ݷ�: " + this.sp_attack + 
							" / ���� : " + this.defense + " / Ư������ : " + this.sp_defense + 
							" / ���ǵ�: " + this.speed);
		System.out.println("----------------------------------------------------- <��ų> ---------------------------------------------------------");
		for (int i = 0; i < this.skill.size(); i++) {
			System.out.print("   [" + (i + 1) + "] " + this.skill.get(i).getName() + "(" + this.skill.get(i).getPower_point() + "/"
							+ this.skill.get(i).getMax_power_point() + ")" + "/�Ӽ�: " + this.skill.get(i).getType());
			
		}
		System.out.println();
		for (int i = 0; i < this.skill.size(); i++) {
			System.out.print("       ");
			System.out.print("����: " + this.skill.get(i).getPower() + " / ���߷�: " + this.skill.get(i).getAccuracy());
			System.out.print("    ");
			
		}
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
	}
	
	//���ϸ��� ������ �����ش�!
	public void showPicture() throws InterruptedException {
		
	}
	
	
}
