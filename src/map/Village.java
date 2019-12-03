/*
 * ���ϻ����ð�: 5�� 4�� 12�� 13��
 * �����ð�:
 * <��������>
 * 
 * <Ŭ���� �̸�>
 * ���� Ŭ����
 * 
 * <Ŭ���� ����>
 * - ���� ��� �޴� Ŭ�����̴�
 * - ���ΰ��� ó�� ������ �ϴ� �����̴�
 * 
 * <����>
 * - ���ڻ�
 * - ����
 * 
 * <�޼ҵ�>
 * - ���� �޴��� �����ش�
*/

package map;

import characters.Dr_OH;
import characters.MainCharacter;
import characters.Mom;

public class Village extends Map{
	
	//<����>
	Dr_OH dr_oh; //���ڻ�
	Mom mom; //����
	
	//<������>
	public Village(String name) {
		super(name);
		//���ڻ�� ������ �� ������ ����.
		
		//������ ���ʸ����� ó�� ���� ����
		this.mom = new Mom("�������", "���ʸ���");
	}
	
	//<Getter, Setter>
	public Dr_OH getDr_oh() {
		return dr_oh;
	}

	public void setDr_oh(Dr_OH dr_oh) {
		this.dr_oh = dr_oh;
	}

	public Mom getMom() {
		return mom;
	}

	public void setMon(Mom mom) {
		this.mom = mom;
	}
	
	//<�޼ҵ�>
	//�޴��� �����ִ�
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("����������������������������������������������������<���ʸ��� �޴�>��������������������������������������������������������");
		System.out.println("����������[1]���ڻ翡�� ���� �Ǵ١�����������[2]�������� ���� �Ǵ١�����������[3]������ ������ ���١�����������[0]���� �̵��Ѵ�.�����������");
		System.out.println("�����������������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}
	
	//������ ������ ���� �����ִ�!
	public void showAccount(MainCharacter ����) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("������������������������������������������������������������������������������������������������������ ���� �ܾ� ������������������������������������������������������������������������������������������������������������������");
		System.out.println("       \t     \t\t ������ ���� �ݾ�: " + ����.getMoney() + "��                                 ������ ���� �ݾ�: " + this.getMom().getMoney() + "��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

	}
	
	public void showOtherMap() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������������� �� �̵� ��������������������������������������������������������������������������������������������������������������������");
		System.out.print(" \t\t\t��[1]���ʸ�����");
		System.out.print(" \t\t\t[2]��Ͻ�");
		System.out.print(" \t\t\t[3]ȸ����Ƽ");
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");


	}
	
	public static void main(String[] args) {
		
		Village village = new Village("���ʸ���");
		village.showOtherMap();
	}
	
	
}