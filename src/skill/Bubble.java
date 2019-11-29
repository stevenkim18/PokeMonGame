package skill;

import pokemon.PokeMon;

public class Bubble extends Skill{ //거품

	//<생성자>
	public Bubble(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "거품";
		this.type = "물";
		this.power_point = 30;
		this.max_power_point = 30;
		this.power = 3;
		this.accuracy = 100;
	}
	
	//<메소드>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		
		super.beUsed(myPokemon, otherPokemon);
		
		// 내 포켓몬의 특수공격력 + 레벨 + 스킬 위력 - 상대 포켓몬 특수 방어력
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();

		otherPokemon.reduceHp(damage);
	}
}
