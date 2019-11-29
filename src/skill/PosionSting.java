package skill;

import pokemon.PokeMon;

public class PosionSting extends Skill{

	//<생성자>
	public PosionSting(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "독침";
		this.type = "독";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 2;
		this.accuracy = 100;
		
	}
	
	//<메소드>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();
		
		otherPokemon.reduceHp(damage);
	}
}
