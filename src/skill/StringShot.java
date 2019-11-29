package skill;

import pokemon.PokeMon;

public class StringShot extends Skill{

	//<������>
	public StringShot(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "�ǻձ�";
		this.type = "����";
		this.power_point = 35;
		this.max_power_point = 35;
		this.power = 0;
		this.accuracy = 95;
	}

	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		//���ǵ� 1 ����
		otherPokemon.setSpeed(otherPokemon.getSpeed()-1);
		
		System.out.println(otherPokemon.getName() + "�� ���ǵ� �����߽��ϴ�!");
	}
	
}
