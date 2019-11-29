/*
 * ���ϻ����ð�: 5�� 4�� 13�� 27��
 * 
 * �����ð�: 
 * <��������>
 * 
 * <Ŭ���� �̸�>
 * �ʵ� Ŭ����
 * 
 * <Ŭ���� ����>
 * - �� Ŭ������ ��ӹ޴´�.
 * - �ʵ� Ŭ������ ���ΰ��� Ʈ���̳ʿ� ��Ʋ�� �ϰ� �߻� ���ϸ��� ������ ���̴�
 * - �ʵ�� ��Ͻ��� �޸��� �� ��ü�� �����
 * 
 * <����>
 * - ��������
 * - �ʵ�Ʈ���̳�
 * - �������ִ¾�����
 * 
 * <�޼ҵ�>
 * ���ϸ��� ��Ÿ����
*/

package map;

import java.util.ArrayList;

import characters.NPCTrainer;
import item.Item;
import pokemon.PokeMon;

public class Field extends Map{

	//<����>
	ArrayList<PokeMon> appearingPokeMon; //��������
	ArrayList<NPCTrainer> fieldTrainer; //�ʵ� Ʈ���̳�
	ArrayList<Item> droppedItem; //�������ִ¾�����
	
	//<������>
	public Field(String name) {
		super(name);
		
		// �������� ����Ʈ ����
		this.appearingPokeMon = new ArrayList<PokeMon>();
		
		// �ʵ� Ʈ���̳� ����Ʈ ����
		this.fieldTrainer = new ArrayList<NPCTrainer>();
		
		// �������ִ� ������ ����Ʈ ����
		this.droppedItem = new ArrayList<Item>();
		
		// �ʵ� ���� ���� ���Ϳ� �ʵ� Ʈ���̳� ������ �ִ� �����۵��� �޶�
		// �ʵ� Ŭ������ ���� Ŭ������ ��Ͻ��̶� �޸��� ���� ������ �� ����....
	}

	//<Getter, Setter>
	public ArrayList<PokeMon> getAppearingPokeMon() {
		return appearingPokeMon;
	}

	public void setAppearingPokeMon(ArrayList<PokeMon> appearingPokeMon) {
		this.appearingPokeMon = appearingPokeMon;
	}

	public ArrayList<NPCTrainer> getFieldTrainer() {
		return fieldTrainer;
	}

	public void setFieldTrainer(ArrayList<NPCTrainer> fieldTrainer) {
		this.fieldTrainer = fieldTrainer;
	}

	public ArrayList<Item> getDroppedItem() {
		return droppedItem;
	}

	public void setDroppedItem(ArrayList<Item> droppedItem) {
		this.droppedItem = droppedItem;
	}
	
	//<�޼ҵ�>
	//���ϸ��̳�Ÿ����
	public void appear() {
		
	}
	
}
