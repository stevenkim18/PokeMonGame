package skill;

import pokemon.PokeMon;

public class MetalClaw extends Skill{

	public MetalClaw(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "메탈크로우";
		this.type = "노말";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 5;
		this.accuracy = 95;
	}
	
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);

		int damage = myPokemon.getAttack() + this.power - otherPokemon.getDefense();

		otherPokemon.reduceHp(damage);
	}

}
