package skill;

import pokemon.PokeMon;

public class Ember extends Skill{
	
	//<생성자>
	public Ember(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "불꽃세례";
		this.type = "불";
		this.power_point = 25;
		this.max_power_point = 25;
		this.power = 4;
		this.accuracy = 100;
	}
	
	//<메소드>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		//내 포켓몬 특수공격력  + 레벨 + 스킬위력 - 상대 포켓몬의 방어력
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();
		
		otherPokemon.reduceHp(damage);
		
	}

}
