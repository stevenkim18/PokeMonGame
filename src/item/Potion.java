/*
 * ���ϻ����ð�: 5�� 3�� 22�� 01��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * ���� Ŭ����
 * 
 * <Ŭ���� ����>
 * - ����Ŭ������ ��� �޴´�.
 * - ���ϸ��� ü���� ȸ�������ش�.
 * 
 * <����>
 * - 
 * 
 * <�޼ҵ�>
 * - ���ϸ���ü����ȸ����Ű��
*/

package item;

import pokemon.PokeMon;

public class Potion extends Item{
	
	//<����>
	
	//<������>
	public Potion(String name, int price) {
		super(name, price);
	}
	
	//<Getter, Setter>

	//<�޼ҵ�>
	//���ϸ���ü����ȸ����Ű��
	public void healPokeMon(PokeMon pokemon) {
		
		// ü���� 10 ȸ��
		pokemon.recover(10);
		
		// ü���� �ִ� ü���� �Ѿ��� ��� �ִ�ü������ �ٲ�
		if(pokemon.getHp() > pokemon.getMax_hp()) {
			pokemon.setHp(pokemon.getMax_hp());
		}
		
		System.out.println(pokemon.getName() + "�� ü���� ȸ���Ǿ����ϴ�!");
		
	}
}
