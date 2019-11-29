package skill;

import pokemon.PokeMon;

public class Harden extends Skill{

	//<생성자>
	public Harden(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "단단해지기";
		this.type = "노말";
		this.power_point = 30;
		this.max_power_point = 30;
		this.power = 0;
		this.accuracy = 100;
	}
	
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		myPokemon.setDefense(myPokemon.getDefense()+1);
		
		System.out.println(myPokemon.getName() + "의 방어력이 올라갔습니다!");
	}

}
