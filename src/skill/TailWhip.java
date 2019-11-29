package skill;

import pokemon.PokeMon;

public class TailWhip extends Skill{ //���� ����

	public TailWhip(String equipped_Pokemon) {
		super(equipped_Pokemon);
		this.name = "��������";
		this.type = "�븻";
		this.power_point = 30;
		this.max_power_point = 30;
		this.power = 0;
		this.accuracy = 100;
	}
	
	//<�޼ҵ�>
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		
		super.beUsed(myPokemon, otherPokemon);
		
		//��� ���ϸ��� ������ 1 ���ҽ�Ų
		otherPokemon.setDefense(otherPokemon.getDefense()-1);
		
		System.out.println(otherPokemon.getName() + "�� ������ �����߽��ϴ�!");

	}

}
