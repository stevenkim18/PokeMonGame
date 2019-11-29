package skill;

import pokemon.PokeMon;

public class RockThrow extends Skill{ //�� ������
	 
	//<������>
	public RockThrow(String equipped_Pokemon) {
		super(equipped_Pokemon);
		
		this.name = "��������";
		this.type = "����";
		this.power_point = 15;
		this.max_power_point = 15;
		this.power = 6;
		this.accuracy = 90;
		
	} 
	
	@Override
		public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		
			super.beUsed(myPokemon, otherPokemon);
			
			// �� ���ϸ��� Ư�����ݷ� + ���� + ��ų ���� - ��� ���ϸ� Ư�� ����
			int damage = myPokemon.getSp_attack() + myPokemon.getLevel() + this.power - otherPokemon.getSp_defense();

			otherPokemon.reduceHp(damage);
		}
}
