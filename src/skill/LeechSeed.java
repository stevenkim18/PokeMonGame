package skill;

import pokemon.PokeMon;

public class LeechSeed extends Skill{ //���Ѹ���

	public LeechSeed(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "���Ѹ���";
		this.type = "Ǯ";
		this.power_point = 10;
		this.max_power_point = 10;
		this.power = 0;
		this.accuracy = 100;
		
	}
	
	@Override
		public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
			super.beUsed(myPokemon, otherPokemon);
			
			// ������ ���� HP�� 1/5�� ����Ѵ�.
			int absorb_hp = otherPokemon.getMax_hp()/5;
			
			// ���� HP�� �ٰ�
			otherPokemon.reduceHp(absorb_hp);
			
			// �� ���ϸ� HP�� �þ��.
			myPokemon.recover(absorb_hp);
		}

}
