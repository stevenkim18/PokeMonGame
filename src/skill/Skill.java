package skill;

import pokemon.PokeMon;

public class Skill {
	//<����>
	String name; 			//��ų�̸�
	String type; 			//�Ӽ�
	int power_point; 		//��ų���Ƚ��
	int max_power_point; 	//�ִ뽺ų���Ƚ��
	int power;				//����
	int accuracy;			//���߷�
	String equipped_Pokemon;//������ ���ϸ�
	
	//<������>
	public Skill(String equipped_Pokemon) {
		//��ų�� ���� �Ҷ� ������ ���ϸ� �����ڷ� �Է¹���!
		this.equipped_Pokemon = equipped_Pokemon;
	}
	
	//<Getter, Setter>

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower_point() {
		return power_point;
	}

	public void setPower_point(int power_point) {
		this.power_point = power_point;
	}

	public int getMax_power_point() {
		return max_power_point;
	}

	public void setMax_power_point(int max_power_point) {
		this.max_power_point = max_power_point;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getEquipped_Pokemon() {
		return equipped_Pokemon;
	}

	public void setEquipped_Pokemon(String equipped_Pokemon) {
		this.equipped_Pokemon = equipped_Pokemon;
	}
	
	//<�޼ҵ�>
	//��ų�̻��Ǵ�
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		//��ų ���Ƚ�� 1 ����
		this.power_point -= 1;
		
		//�븻����
		//myPokemon�� ���ݷ�+����+��ų�� ���¿���
		//otherPokemon�� ������ �� ���� ��ŭ 
		//otherPokemon�� ü���� ���ҽ�Ų��.
		
	}
	

	//��ų�������Ǵ�
	public void beEquipped() {
		
	}
	
	//��ų�̻����Ǵ�
	public void beRemoved() {
		
	}
	
	
	
}
