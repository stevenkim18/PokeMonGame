package skill;

import pokemon.PokeMon;

public class StringShot extends Skill{

	//<생성자>
	public StringShot(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "실뿜기";
		this.type = "벌레";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 0;
		this.accuracy = 95;
	}

	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		//스피드 1 감소
		otherPokemon.setSpeed(otherPokemon.getSpeed()-1);
		
		System.out.println(otherPokemon.getName() + "의 스피드 감소했습니다!");
	}
	
}
