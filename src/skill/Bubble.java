package skill;

import pokemon.PokeMon;

public class Bubble extends Skill{ //��ǰ

	//<������>
	public Bubble(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "��ǰ";
		this.type = "��";
		this.power_point = 30;
		this.max_power_point = 30;
		this.power = 3;
		this.accuracy = 100;
	}
	
	//<�޼ҵ�>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		
		super.beUsed(myPokemon, otherPokemon);
		
		// �� ���ϸ��� Ư�����ݷ� + ���� + ��ų ���� - ��� ���ϸ� Ư�� ����
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();

		otherPokemon.reduceHp(damage);
	}
}
