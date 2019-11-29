package skill;

import pokemon.PokeMon;

public class Withdraw extends Skill{

	public Withdraw(String equipped_Pokemon) { //������ ����
		super(equipped_Pokemon);
		this.name = "������ ����";
		this.type = "��";
		this.power_point = 40;
		this.max_power_point = 40;
		this.power = 0;
		this.accuracy = 100;
	}
	
	@Override
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		
		super.beUsed(myPokemon, otherPokemon);
		
		myPokemon.setDefense(myPokemon.getDefense()+1);
		myPokemon.setSp_defense(myPokemon.getSp_defense()+1);
		
		System.out.println(myPokemon.getName() + "�� ������ �����߽��ϴ�!");
	}
}
