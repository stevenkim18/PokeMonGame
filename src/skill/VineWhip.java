package skill;

import pokemon.PokeMon;

public class VineWhip extends Skill{ //덩굴채찍

	public VineWhip(String equipped_Pokemon) {
		
		super(equipped_Pokemon);
		this.name = "덩굴채찍";
		this.type = "풀";
		this.power_point = 25;
		this.max_power_point = 25;
		this.power = 5;
		this.accuracy = 100;
		
	}
	
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		// TODO Auto-generated method stub
		super.beUsed(myPokemon, otherPokemon);
		
		// 내 포켓몬의 특수공격력 + 레벨 + 스킬 위력 - 상대 포켓몬 특수 방어력
		int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();

		otherPokemon.reduceHp(damage);
	}

}
