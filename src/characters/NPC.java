/*
 * ���ϻ����ð�: 5�� 2�� 11�� 59��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * NPC Ŭ����
 * 
 * <Ŭ���� ����>
 * - ���ӿ��� ���ΰ��� �ܼ��� ��ȭ�� �ϴ� npcĳ���͸� ����� Ŭ�����̴�
 * - ���� Ŭ������ ��� �޴´�.
 * 
 * <����>
 * - ������ : npcĳ���� ��Ÿ���� ���� �����ϴ� ����
 * 
 * <�޼ҵ�>
 * - 
*/

package characters;

public class NPC extends Person{

	//<����>
	String appearanceMap; // ������
	
	//<������>
	public NPC(String name, String map) {
		super(name);
		this.appearanceMap = map;
	}

	//<Getter, Setter>
	public String getAppearanceMap() {
		return appearanceMap;
	}

	public void setAppearanceMap(String appearanceMap) {
		this.appearanceMap = appearanceMap;
	}
	
	
	

}
