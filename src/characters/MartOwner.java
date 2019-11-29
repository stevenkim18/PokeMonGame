/*
 * ���ϻ����ð�: 5�� 4�� 11�� 33��
 * 
 * �����ð�: 
 * <��������>
 * 
 * <Ŭ���� �̸�>
 * ��Ʈ���� Ŭ����
 * 
 * <Ŭ���� ����>
 * - NPCŬ������ ��� �޴´�.
 * - �������� ��� �� �� �ִ� �ɸ����̴�
 * 
 * <����>
 * -
 * 
 * <�޼ҵ�>
 * - �����������
 * - ���������Ǵ�
*/

package characters;

import java.util.ArrayList;

import item.PokeBall;
import item.Potion;

public class MartOwner extends NPC{

	//<����>
	ArrayList<PokeBall> owned_pokeball;
	ArrayList<Potion> owned_potion;
	
	//<������>
	public MartOwner(String name, String map) {
		super(name, map);
		
		this.owned_pokeball = new ArrayList<PokeBall>();
		this.owned_potion = new ArrayList<Potion>();
		
		//���Ϻ� ȸ���� 10���� �߰�!
		for (int i = 0; i < 10; i++) {
			
			owned_pokeball.add(new PokeBall("���Ϻ�", 200));
			owned_potion.add(new Potion("ȸ����", 300));
			
		}
		
	}
	
	//<Getter,Setter>
	public ArrayList<PokeBall> getOwned_pokeball() {
		return owned_pokeball;
	}

	public void setOwned_pokeball(ArrayList<PokeBall> owned_pokeball) {
		this.owned_pokeball = owned_pokeball;
	}

	public ArrayList<Potion> getOwned_potion() {
		return owned_potion;
	}

	public void setOwned_potion(ArrayList<Potion> owned_potion) {
		this.owned_potion = owned_potion;
	}
	
	//<�޼ҵ�>
	//�����������
	public void buyItem() {
		
	}

	//���������Ǵ�
	public void sellItem() {
		
	}
	
	public void showItems() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������������� �Ǹ� ǰ�� ������������������������������������������������������������������������������������������������������������������");
		System.out.print("\t\t\t[1] ��Ĺ�� /" + this.owned_pokeball.size() + "�� (����:200��)");
		System.out.println("\t\t\t[2] ȸ���� /" + this.owned_potion.size() + "�� (����:300��)");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public static void main(String[] args) {
		MartOwner martOwner = new MartOwner("�̸�", "�̸�");
		martOwner.showItems();
	}
	
}
