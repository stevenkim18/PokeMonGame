package skill;

import pokemon.PokeMon;

public class Growl extends Skill{ //울음소리

	//<생성자>
	public Growl(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "울음소리";
		this.type = "노말";
		this.power_point = 40;
		this.max_power_point = 40;
		this.power = 0;
		this.accuracy = 100;
	}
	
	//<메소드>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		// 상대 포켓몬의 방어력을 1 감소시킴
		otherPokemon.setDefense(otherPokemon.getDefense()-1);
		
		System.out.println(otherPokemon.getName() + "의 방어력이 감소했습니다!");
		
	}

	
}
