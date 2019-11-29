package skill;

import pokemon.PokeMon;

public class VineWhip extends Skill{ //����ä��

	public VineWhip(String equipped_Pokemon) {
		
		super(equipped_Pokemon);
		this.name = "����ä��";
		this.type = "Ǯ";
		this.power_point = 25;
		this.max_power_point = 25;
		this.power = 5;
		this.accuracy = 100;
		
	}
	
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		// TODO Auto-generated method stub
		super.beUsed(myPokemon, otherPokemon);
		
		// �� ���ϸ��� Ư�����ݷ� + ���� + ��ų ���� - ��� ���ϸ� Ư�� ����
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();

		otherPokemon.reduceHp(damage);
	}

}
