package skill;

import pokemon.PokeMon;

public class RockThrow extends Skill{ //돌 떨구기
	 
	//<생성자>
	public RockThrow(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "돌떨구기";
		this.type = "바위";
		this.power_point = 15;
		this.max_power_point = 15;
		this.power = 6;
		this.accuracy = 90;
		
	} 
	
	@Override
		public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		
			super.beUsed(myPokemon, otherPokemon);
			
			// 내 포켓몬의 특수공격력 + 레벨 + 스킬 위력 - 상대 포켓몬 특수 방어력
			int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();

			otherPokemon.reduceHp(damage);
		}
}
