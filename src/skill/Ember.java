package skill;

import pokemon.PokeMon;

public class Ember extends Skill{
	
	//<������>
	public Ember(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "�Ҳɼ���";
		this.type = "��";
		this.power_point = 25;
		this.max_power_point = 25;
		this.power = 4;
		this.accuracy = 100;
	}
	
	//<�޼ҵ�>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		//�� ���ϸ� Ư�����ݷ�  + ���� + ��ų���� - ��� ���ϸ��� ����
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();
		
		otherPokemon.reduceHp(damage);
		
	}

}
