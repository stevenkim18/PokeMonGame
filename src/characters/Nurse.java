/*
 * ���ϻ����ð�: 5�� 4�� 9�� 35��
 * 
 * �����ð�: 
 * <��������>
 * 
 * <Ŭ���� �̸�>
 * ��ȣ�� Ŭ����
 * 
 * <Ŭ���� ����>
 * - NPCŬ������ ��� �޴´�.
 * - ��� ��Ƽ ���� ��ȣ�簡 �Ѹ� �־�� �Ѵ�.
 * - ��ȣ��� ���ϸ��� ü�°� ���ϸ���� ��ų ��뷮�� ȸ�������ش�.
 * - ��ȣ�翡�� ���ϸ��� �ñ� �� �ִ�
 * 
 * <����>
 * - ���� ���ϸ�: ��ȣ�簡 �����ϰ� �ִ� ���ϸ��� �����ϴ� ����Ʈ(ó������ ����Ʈ�� ����ִ�)
 * 
 * <�޼ҵ�>
 * - ���ϸ��� ü���� ȸ����Ų��
 * - ���ϸ����ش�
 * - ���Ϻ����ش�
 * 
 * <�߰� ���� ����>
 * ��ȣ�翡�� ���ϸ��� �ñ�� ���ϸ��� ���� �ȴ�!
*/

package characters;

import java.util.ArrayList;

import pokemon.PokeMon;

public class Nurse extends NPC{

	//<����>
	ArrayList<PokeMon> owned_PokeMon; // �������ϸ�
	
	//<������>
	public Nurse(String name, String map) {
		super(name, map);
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		// ��� ����!
		this.dialogue.add(0, "������� ���� ���ϸ� ��ȣ�� �Դϴ�!");
		this.dialogue.add(1, "������ ���͵帱���?");
		
	}
	
	//<Getter, Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}
	
	//<�޼ҵ�>
	//���ϸ��� ü���� ȸ����Ų��
	public void healPokeMon(PokeMon pokemon) {
		//���ϸ��� ȸ���Ǵ�
		pokemon.recover();
		//��ų pp ȸ��
		for (int i = 0; i < pokemon.getSkill().size(); i++) {
			pokemon.getSkill().get(i).setPower_point(pokemon.getSkill().get(i).getMax_power_point());
		}
		System.out.println(pokemon.getName() + "�� ü�°� ��ų ���Ƚ���� ȸ���Ǿ����ϴ�!");
	}
	
	//���ϸ����޴´�
	public void receivePokeMon(PokeMon pokemon) {
		
		System.out.println("���찡 ��ȣ�翡�� " + pokemon.getName() + "�� �ð���ϴ�!");
		
		this.owned_PokeMon.add(pokemon);
	}
	
	//���ϸ����ش�
	public void givePokeMon() {

	}
	
	//��ȣ���� ���ϸ��� �����ִ�
	public void showPokeMons() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("���������������������������������������������������������������������������������������������������� �ðܵ� ���ϸ�� ������������������������������������������������������������������������������������������������������������");
		
		//���ϸ��� ���� ��
		if(owned_PokeMon.size() == 0) {
			System.out.println("\t\t\t\t\t   " + this.name + "�� ������ �ִ� ���ϸ��� �����ϴ�!");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		}
		// ���ϸ��� ���� ��
		else {
			
			// [1��] �̸�: ���̸�, ����: 6, ü��: 40
			for (int i = 0; i < owned_PokeMon.size(); i++) {
				
				System.out.print("  ");
				
				//��ȣ 
				System.out.print("[" + (i+1) + "]");
				
				//�̸�
				System.out.print("�̸�: " + owned_PokeMon.get(i).getName());
				
				//����
				System.out.print(" / ����: " + owned_PokeMon.get(i).getLevel());
				
				//ü��
				System.out.print(" / ü��: " + owned_PokeMon.get(i).getHp() + "/" + owned_PokeMon.get(i).getMax_hp());
				
				
				
			}
			System.out.println();
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

		}
		
	}
	
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("������������������������������������������������������������������������������������������������������ ��ȣ���� �޴� ��������������������������������������������������������������������������������������������������������������");
		System.out.println("\t\t[1]���ϸ� ȸ�� \t\t[2]���ϸ� �ñ�� \t\t[3]���ϸ� ã�� \t\t[0]�����");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");


	}
	
//	public static void main(String[] args) {
//		
//		Nurse nurse = new Nurse("��ȣ��", "ȸ����Ƽ");
//		
//		nurse.showMenu();
//		nurse.showPokeMons();
//	}
}
