package skill;

import pokemon.PokeMon;

public class LeechSeed extends Skill{ //씨뿌리기

	public LeechSeed(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "씨뿌리기";
		this.type = "풀";
		this.power_point = 10;
		this.max_power_point = 10;
		this.power = 0;
		this.accuracy = 100;
		
	}
	
	@Override
		public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
			super.beUsed(myPokemon, otherPokemon);
			
			// 상대방의 남은 HP중 1/5를 흡수한다.
			int absorb_hp = otherPokemon.getMax_hp()/5;
			
			// 상대방 HP는 줄고
			otherPokemon.reduceHp(absorb_hp);
			
			// 내 포켓몬 HP는 늘어난다.
			myPokemon.recover(absorb_hp);
		}

}
