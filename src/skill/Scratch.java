package skill;

import pokemon.PokeMon;

public class Scratch extends Skill{
	
	//<생성자>
	public Scratch(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "할퀴기";
		this.type = "노말";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 4;
		this.accuracy = 100;
	}
	
	//<메소드>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		//내 포켓몬의 공격력+스킬위력 - 상대포켓몬의 방어력
		int damage = myPokemon.getAttack() + this.power - otherPokemon.getDefense();
		
		otherPokemon.reduceHp(damage);
	}
	
	
}
