/*
 * ���ϻ����ð�: 5�� 3�� 21�� 33��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * ������ Ŭ����
 * 
 * <Ŭ���� ����>
 * - �����۵��� ����Ŭ�����̴�
 * 
 * <����>
 * - �̸�: �������� �̸��� �����ϴ� ����
 * - ����: �������� ������ �����ϴ� ����
 * 
 * <�޼ҵ�>
 * - ���Ǵ�
*/

package item;

public class Item {
	
	//<����>
	String name; //�̸�
	int price; //����
	
	//<������>
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	//<Getter,Setter>
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//<�޼ҵ�>
	//���Ǵ�
	public void used() {
		System.out.println(this.name + "�� ����մϴ�!");
	}

}
