package skill;

import pokemon.PokeMon;

public class PoisonPowder extends Skill{ //������

	public PoisonPowder(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "������";
		this.type = "��";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 0;
		this.accuracy = 80;
		
	}
	
	@Override
		public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {			// TODO Auto-generated method stub
			super.beUsed(myPokemon, otherPokemon);
			
			//��� ���ϸ��� ���� �ɸ���!
		}

}
