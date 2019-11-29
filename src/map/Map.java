/*
 * ���ϻ����ð�: 5�� 2�� 20�� 56��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * �� Ŭ����
 * 
 * <Ŭ���� ����>
 * - ���ÿ� �ʵ��� ����Ŭ�����̴�.
 * - �� Ŭ������ ������ ��ü �ȿ��� ���ΰ��� Ȱ���Ѵ�.
 * 
 * <����>
 * - �̸� : ���� �̸��� �����Ѵ�.
 * - �����忩�� : ���ΰ��� �ʿ� ���� �ִ��� �������� ���θ� ��Ÿ����.
 * 
 * <�޼ҵ�>
 * - ������ ���´�: ���ΰ��� ������ ���´�.
 * - �ʿ��� ������: ���ΰ����� ������.
 * - ���� �޴��� �����ش�.
*/

package map;

import characters.MainCharacter;

public class Map {
	//<����>
	String name; // �̸�
	boolean mapEntryStatus; // �����忩��
	
	//<������>
	public Map(String name) {
		this.name = name;
	}
	
	//<Getter,Setter>
	//[start]

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMapEntryStatus() {
		return mapEntryStatus;
	}

	public void setMapEntryStatus(boolean mapEntryStatus) {
		this.mapEntryStatus = mapEntryStatus;
	}
	//[end]

	//<�޼ҵ�>
	//���찡 ������ ���´�
	public void comeToMap(MainCharacter ����) throws InterruptedException {
		
		this.mapEntryStatus = true;
		
		System.out.println();
		Thread.sleep(1000);
		System.out.println();
		System.out.println("���� ��ġ : " + this.name);
		System.out.println();
		Thread.sleep(1000);
		
	}
	
	//�ʿ��� ������
	public void outOfMap() {
		// �����忩�ΰ� false���� �ȴ�.
		this.mapEntryStatus = false;
	}
	
	//���� �޴��� �����ش�.
	public void showMenu() {
		
	}

}
