/*
 * ���ϻ����ð�: 5�� 3�� 21�� 27��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * �����۰��� Ŭ����
 * 
 * <Ŭ���� ����>
 * - ���ΰ��� �����۵��� ��� Ŭ�����̴�.
 * - ���ΰ��� �ɹ� ������ ����.
 * 
 * <����>
 * - ���Ϻ�
 * - ȸ����
 * 
 * <�޼ҵ�>
 * - �������� ����ִ´�
 * - �������� ������
 * - �����۰����ǻ��¸� �����ִ�
*/

package item;

import java.util.ArrayList;

public class ItemBag {

	//<����>
	ArrayList<PokeBall> pokeball; // ���Ϻ�
	ArrayList<Potion> potion; // ����
	
	//<������>
	public ItemBag() {
		this.pokeball = new ArrayList<PokeBall>();
		this.potion = new ArrayList<Potion>();
	}
	
	//<Getter,Setter>
	public ArrayList<PokeBall> getPokeball() {
		return pokeball;
	}

	public void setPokeball(ArrayList<PokeBall> pokeball) {
		this.pokeball = pokeball;
	}

	public ArrayList<Potion> getPotion() {
		return potion;
	}

	public void setPotion(ArrayList<Potion> potion) {
		this.potion = potion;
	}
	
	//<�޼ҵ�>
	//�������� ���� �ִ´�.
	public void putItem(Item item) {
		//�Ű������� ���� �������� ���Ϻ��̸�
		if(item instanceof PokeBall) {
			this.pokeball.add((PokeBall) item);
		}
		//�Ű������� ���� �������� �����̸�
		else if(item instanceof Potion){
			this.potion.add((Potion) item);
		}
	}
	
	//�������� ������.
	public void takeOutItem() {
		
	}
	
	//�����۰����� ���¸� �����ִ�
	public void showStatus() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("������������������������������������������������������������������������������������������������ ������ �����۰��� ��������������������������������������������������������������������������������������������������������������");
		System.out.print(" \t\t\t\t[1] ���Ϻ�: " + pokeball.size() + "��");
		System.out.println(" \t\t\t\t[2] ȸ����: " + potion.size() + "��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
}
