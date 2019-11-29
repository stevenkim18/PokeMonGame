package skill;

import pokemon.PokeMon;

public class Growl extends Skill{ //�����Ҹ�

	//<������>
	public Growl(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "�����Ҹ�";
		this.type = "�븻";
		this.power_point = 40;
		this.max_power_point = 40;
		this.power = 0;
		this.accuracy = 100;
	}
	
	//<�޼ҵ�>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		super.beUsed(myPokemon, otherPokemon);
		
		// ��� ���ϸ��� ������ 1 ���ҽ�Ŵ
		otherPokemon.setDefense(otherPokemon.getDefense()-1);
		
		System.out.println(otherPokemon.getName() + "�� ������ �����߽��ϴ�!");
		
	}

	
}
