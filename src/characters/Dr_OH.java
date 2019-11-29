/*
 * ���ϻ����ð�: 5�� 2�� 12�� 11��
 * 
 * �����ð�: 5�� 4�� 1�� 6��
 * <��������>
 * ���ڻ簡 ���쿡�� ���Ϻ��� �ش�
 * �������Ϻ� ����Ʈ�� �߰��ϰ� 
 * ���Ϻ��� �ش� �޼ҵ嵵 �߰���
 * 
 * <Ŭ���� �̸�>
 * ���ڻ� Ŭ����
 * 
 * <Ŭ���� ����>
 * - NPCŬ������ ��� �޴´�
 * - �����׿��� ������ ������ �Ѵ�.
 * - ó�� 3���� ���ϸ��� ������ �ִ�.
 * - ���쿡�� 3���� ���ϸ� �� �Ѹ����� �ش�.
 * 
 * <����>
 * - ���� ���ϸ�: ���ڻ�� ���� ���۽� ���̸�, ���α�, �̻��ؾ��� ������ �ִ�.
 * - ���� ���Ϻ�: ���ڻ簡 5���� ���Ϻ��� ������ �ְ� ���ϸ��� �ְ� �� �Ŀ� ���Ϻ��� �ش�
 * 
 * <�޼ҵ�>
 * - ���ϸ����ش�
 * - ���Ϻ����ش�
 * - ���ڻ������ϸ���������ִ�
 *
*/
package characters;

import java.util.ArrayList;

import item.PokeBall;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.PokeMon;
import pokemon.Squirtle;

public class Dr_OH extends NPC{
	
	//<����>
	ArrayList<PokeMon> owned_PokeMon; // ���� ���ϸ�
	ArrayList<PokeBall> owned_PokeBall; // ���� ���Ϻ�
	
	//<������>
	public Dr_OH(String name, String map) {
		super(name, map);
		// ���ϸ� ����Ʈ �����
		owned_PokeMon = new ArrayList<PokeMon>();
		
		// ���Ϻ� ����Ʈ �����
		owned_PokeBall = new ArrayList<PokeBall>();
		// ������ ��� ����
		dialogue.add(0,"�ȳ�! ���ϸ����� ���迡 �� �Դ�.");
		dialogue.add(1,"���� ���ϸ� �ڻ�� ����޴� ���ڻ����!");
		dialogue.add(2,"�׸��� �� ���迡�� ���ϸ��̶�� �Ҹ��� ����ü�� ��ó�� ����ִ�!");
		dialogue.add(3,"������� �� ���ϸ��̶�� ����ü�� �ֿϵ����� �⸣�ų� �ºθ� ��������");
		dialogue.add(4,"���� ���ϸ��� ���������� �����ϰ� ����");
		dialogue.add(5,"��.. �׷��� ���� �ʿ� ���� �˷��ٿ�");
		dialogue.add(6,"���� �̸��� ����?");
		dialogue.add(7,"�غ�� �Ǿ��°�?");
		dialogue.add(8,"���� �������� ���� �̾߱Ⱑ ���۵Ǿ�����");
		dialogue.add(9,"��ſ� �͵� ���ο� �͵� �ܶ� �� ��ٸ��� ���� ���̴�!" );
		dialogue.add(10,"�ް� ����� ���ϸ����� ����� ���� ��!!" );
		
		// ���ڻ� ó�� ���쿡�� ���ϸ��� �ٶ� �ϴ� ���
		dialogue.add(11,"��!! ����� ���� �ʰ� �� Ŀ�� ������ ������ �Ǿ�����!");
		dialogue.add(12,"������ �����µ� ���ϸ��� ������ �ȵǰ���?");
		dialogue.add(13,"���� ���� ������ �ִ� ���ϸ��� 3���� ���ε� �� �߿� �Ѹ����� ������ �ָ�");
		dialogue.add(14,"�� ���߿� �Ѹ����� ��󺸷�!");
		
		// ���ڻ簡 ���ϸ��� �ְ� �� ���� ���!
		dialogue.add(15,"���� ����!! ������ �� ���ϸ��� �̿��� �ְ��� Ʈ���̳ʰ� �ǰŶ�!");
		
		// ���ڻ� ���Ϻ��� �ִ� ���
		dialogue.add(16,"��! �����! ��ħ �� �Դ� ���� �ٰ� �ִܴ�.");
		dialogue.add(17,"�� ���Ϻ��� ������ �߻� ���ϸ��� ���� �� �ִܴ�.");
		dialogue.add(18,"�׷�.... �����! ������ ���.");
		
		// ���ϸ� ��ü ���� �Ͽ� ����Ʈ�� ����
		// ���̸�
		owned_PokeMon.add(0, new Charmander("���̸�", 5));
		// ���α�
		owned_PokeMon.add(1, new Squirtle("���α�", 5));
		// �̻��ؾ�
		owned_PokeMon.add(2, new Bulbasaur("�̻��ؾ�" , 5));
		
		// ó������ �� �� ���ڻ簡 5���� ���Ϻ��� ������ ����
		for (int i = 0; i < 5; i++) {
			owned_PokeBall.add(new PokeBall("���Ϻ�", 200));
		}
	}
	
	//<Getter,Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}
	
	public ArrayList<PokeBall> getOwned_PokeBall() {
		return owned_PokeBall;
	}

	public void setOwned_PokeBall(ArrayList<PokeBall> owned_PokeBall) {
		this.owned_PokeBall = owned_PokeBall;
	}

	//<�޼ҵ�>
	//���ϸ����ִ�
	public PokeMon givePokeMon(int num) {
		//���ڻ�� ���쿡 ���̸��� �ִ�.
		return owned_PokeMon.remove(num-1);
	}
	
	//���Ϻ����ִ�
	public PokeBall givePokeBall() {
		//�� ù��° �ִ� ���Ϻ��� �ִ�
		return owned_PokeBall.remove(0);
	}
	
	//���ڻ��� ���Ϻ��� �����ִ�
	public void showPokeMon() {
		System.out.println();
		System.out.println("------------------------------------------------ ���ڻ��� ���ϸ� ---------------------------------------------------------");
		System.out.println();
		for (int i = 0; i < owned_PokeMon.size(); i++) {
			
			System.out.print("     ");
			//��ȣ 
			System.out.print("[" + (i+1) + "��" + "]");
			
			//�̸�
			System.out.print("�̸�: " + owned_PokeMon.get(i).getName());
			
			//����
			System.out.print(" / ����: " + owned_PokeMon.get(i).getLevel());
			
			//�Ӽ�
			System.out.print(" / �Ӽ�: " + owned_PokeMon.get(i).getType());
			
			
			
		}
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------------");

		System.out.println();
	}

	


	
}
