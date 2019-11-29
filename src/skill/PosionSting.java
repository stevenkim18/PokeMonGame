package skill;

import pokemon.PokeMon;

public class PosionSting extends Skill{

	//<������>
	public PosionSting(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "��ħ";
		this.type = "��";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 2;
		this.accuracy = 100;
		
	}
	
	//<�޼ҵ�>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();
		
		otherPokemon.reduceHp(damage);
	}
}
