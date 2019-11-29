package skill;

import pokemon.PokeMon;

public class PoisonPowder extends Skill{ //독가루

	public PoisonPowder(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "독가루";
		this.type = "독";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 0;
		this.accuracy = 80;
		
	}
	
	@Override
		public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {			// TODO Auto-generated method stub
			super.beUsed(myPokemon, otherPokemon);
			
			//상대 포켓몬이 독에 걸린다!
		}

}
