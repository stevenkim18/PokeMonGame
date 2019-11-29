/*
 * ���ϻ����ð�: 5�� 2�� 21�� 51��
 * 
 * �����ð�: 5�� 3�� 12�� 44��
 * *��������* 
 * ���� Ŭ�������� ���ʸ������� �����ϱ� ������� ���� Ŭ������ ���� �����
 * npc����Ʈ --> ���ڻ�, ������ ��ü ������ ����
 * 
 * 
 * <Ŭ���� �̸�>
 * ���� Ŭ����
 * 
 * <Ŭ���� ����>
 * - �� Ŭ������ ��ӹ޴´�.
 * - ���� Ŭ������ ȸ����Ƽ, ����Ƽ ��ü�� �����.
 * 
 * <����>
 * - ��ȣ��
 * - ��Ʈ����
 * - ����
 * 
 * <�޼ҵ�>
 * 
*/

package map;

import characters.GymTrainer;
import characters.MartOwner;
import characters.Nurse;
import pokemon.Geodude;
import pokemon.Onix;

public class City extends Map{
	
	//<����>
	Nurse nurse; //��ȣ��
	MartOwner mart_owner; // ��Ʈ����
	GymTrainer gym_trainer; // ����
	
	//<������>
	public City(String name) {
		super(name);
		
		// ��ȣ�� ��ü ����
		this.nurse = new Nurse("��ȣ��", name);
		
		// ��Ʈ���� ��ü ����
		this.mart_owner = new MartOwner("��Ʈ����", name);
		
		// ���� ��ü ����
		// ���߿� ���� ��ü�� ���� �Ҷ� "����"�� "�̽���"�� ���� ����
		this.gym_trainer = new GymTrainer("ȸ����Ƽ�������", name);
		
		// ���� ���ϸ� ��ü ����
		this.gym_trainer.getOwned_PokeMon().add(0, new Geodude("������", 13));
		this.gym_trainer.getOwned_PokeMon().add(1, new Onix("�ս���", 15));
		
		
	}

	
	//<Getter,Setter>
	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public MartOwner getMart_owner() {
		return mart_owner;
	}

	public void setMart_owner(MartOwner mart_owner) {
		this.mart_owner = mart_owner;
	}

	public GymTrainer getGym_trainer() {
		return gym_trainer;
	}

	public void setGym_trainer(GymTrainer gym_trainer) {
		this.gym_trainer = gym_trainer;
	}
	
	//<�޼ҵ�>
	@Override
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�����������������������������������������������������<ȸ����Ƽ �޴�>�������������������������������������������������������");
		System.out.println("�����[1]���ϸ� ��ȣ�翡�� ���� �Ǵ١�����[2]��Ʈ���ο��� ���� �Ǵ١�����[3]���忡�� ���� �Ǵ١�����[4]������ ���¸� ���١�����[0]���� �̵��Ѵ١����");
		System.out.println("�����������������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}
	
	public void showOtherMap() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������������� �� �̵� ��������������������������������������������������������������������������������������������������������������������");
		System.out.print(" \t\t\t[1]���ʸ���");
		System.out.print(" \t\t\t[2]��Ͻ�");
		System.out.print(" \t\t\t��[3]ȸ����Ƽ��");
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
//	public static void main(String[] args) {
//		
//		City city = new City("ȸ����Ƽ");
//		
//		city.showMenu();
//		
//	}
	
}
