package map;

import characters.NPCTrainer;
import item.PokeBall;
import item.Potion;
import pokemon.Caterpie;
import pokemon.Kakuna;
import pokemon.Weedle;

public class ViridianForest extends Field{ //�̷Ͻ�

	public ViridianForest(String name) {
		super(name);
		
		//���� ���ϸ�
		this.appearingPokeMon.add(new Caterpie("ĳ����", 5));
		this.appearingPokeMon.add(new Kakuna("������", 5));
		this.appearingPokeMon.add(new Weedle("������", 5));
		this.appearingPokeMon.add(new Caterpie("ĳ����", 6));
		this.appearingPokeMon.add(new Kakuna("������", 6));
		this.appearingPokeMon.add(new Weedle("������", 6));
		
		//Ʈ���̳�
		this.fieldTrainer.add(0, new NPCTrainer("�������̼ҳ�¿�", "��Ͻ�"));
		this.fieldTrainer.add(1, new NPCTrainer("�������̼ҳ⼺��", "��Ͻ�"));
		this.fieldTrainer.add(2, new NPCTrainer("�������̼ҳ�¹�", "��Ͻ�"));
		
		//Ʈ���̳� ���ϸ� �߰�
		//�������̼ҳ�¿� ���ϸ� �߰�
		fieldTrainer.get(0).getOwned_PokeMon().add(new Caterpie("ĳ����", 7));
		fieldTrainer.get(0).getOwned_PokeMon().add(new Kakuna("������", 7));
		fieldTrainer.get(0).getOwned_PokeMon().add(new Weedle("������", 7));
		
		//�������̼ҳ⼺�� ���ϸ� �߰�
		fieldTrainer.get(1).getOwned_PokeMon().add(new Kakuna("������", 8));
		fieldTrainer.get(1).getOwned_PokeMon().add(new Caterpie("ĳ����", 8));
		fieldTrainer.get(1).getOwned_PokeMon().add(new Weedle("������", 8));
		
		//�������̼ҳ�¹� ���ϸ� �߰�
		fieldTrainer.get(2).getOwned_PokeMon().add(new Weedle("������", 9));
		fieldTrainer.get(2).getOwned_PokeMon().add(new Caterpie("ĳ����", 9));
		fieldTrainer.get(2).getOwned_PokeMon().add(new Kakuna("������", 9));
		
		
		//������
		for (int i = 0; i < 3; i++) {
			this.droppedItem.add(new PokeBall("���Ϻ�", 200));
			this.droppedItem.add(new Potion("ȸ����", 300));
		}
		
	}

	// �޴��� �����ִ�
	@Override
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�����������������������������������������������������<��Ͻ� �޴�>���������������������������������������������������������");
		System.out.println("������[1]�߻����ϸ�� ��ٸ��١������[2]Ʈ���̳ʿ� ��Ʋ�� �Ѵ١������[3]�������� �ݴ´١������[4]������ ���¸� ���١������[0]���� �̵��Ѵ١������");
		System.out.println("�����������������������������������������������������������������������������������������������������������������������");
		System.out.println();

	}
	
	//Ʈ���̳ʵ��� �����ִ�
	public void showTrainers() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("������������������������������������������������������������������������������������������������ ��Ͻ� Ʈ���̳ʵ� ������������������������������������������������������������������������������������������������������������");		for (int i = 0; i < this.fieldTrainer.size(); i++) {
			
			System.out.print(" ");
			
			//��ȣ
			System.out.print(" [" + (i+1) + "]");
			//�̸�
			System.out.print(this.fieldTrainer.get(i).getName());
			//���� ���� ����
			if(this.fieldTrainer.get(i).isBattleAvailable() == true) {
				System.out.print(" (���� ����)");
			}
			else {
				System.out.print(" (���� �Ұ���)");
			}
			//�������ϸ�
			System.out.print("/���ϸ�: " + this.fieldTrainer.get(i).getOwned_PokeMon().size() + "����");
			
			
		}
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
	}
	
	public void showOtherMap() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������������� �� �̵� ��������������������������������������������������������������������������������������������������������������������");
		System.out.print(" \t\t\t[1]���ʸ���");
		System.out.print(" \t\t\t��[2]��Ͻ���");
		System.out.print(" \t\t\t[3]ȸ����Ƽ");
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
	}
	
	public void showItems() {
		
		int pokeball_num = 0;
		int potion_num = 0;
		
		for (int i = 0; i < droppedItem.size(); i++) {
			
			if(droppedItem.get(i).getName() == "���Ϻ�") {
				pokeball_num++;
			}
			else if(droppedItem.get(i).getName() == "ȸ����") {
				potion_num++;
			}
			
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("���������������������������������������������������������������������������������������������� ��Ͻ��� ������ �����۵� ������������������������������������������������������������������������������������������������������");
		for (int i = 0; i < droppedItem.size(); i++) {
			System.out.print("               [" + (i+1) + "]" + droppedItem.get(i).getName());
		}
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	
	public static void main(String[] args) {
		
		ViridianForest forest = new ViridianForest("�̸�");
		forest.showTrainers();
		
	}
	
}








