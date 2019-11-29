package skill;

import pokemon.PokeMon;

public class Tackle extends Skill{

	//<������>
	public Tackle(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "�����ġ��";
		this.type = "�븻";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 3;
		this.accuracy = 95;
	}

	//<�޼ҵ�>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		//�� ���ϸ��� ���ݷ�+��ų���� - ������ϸ��� ����
		int damage = myPokemon.getAttack() + this.power - otherPokemon.getDefense();
				
		otherPokemon.reduceHp(damage);
	}
	
	
}
