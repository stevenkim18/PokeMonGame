/*
 * ���ϻ����ð�: 5�� 2�� 11�� 30��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * ��� Ŭ����
 * 
 * <Ŭ���� ����>
 * - �ɸ��͵��� �ֻ��� Ŭ�����̴�
 * 
 * <����>
 * - �̸� : ĳ������ �̸��� �����Ѵ�.
 * - ��� : ĳ������ ������ �����Ѵ�.
 * 
 * <�޼ҵ�>
 * - ��縦���Ѵ� : ��� ������ ����� ��縦 ���Ѵ�.
*/

package characters;

import java.util.ArrayList;

public class Person {
	
	//<����>
	String name; // �̸�
	ArrayList<String> dialogue = new ArrayList<String>(); // ���
	
	//<������>
	public Person(String name) {
		this.name = name;
	}
	
	//<Getter,Setter>
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getDialogue() {
		return dialogue;
	}

	public void setDialogue(ArrayList<String> dialogue) {
		this.dialogue = dialogue;
	}
	
	
	//<�޼ҵ�>
	//��縦���Ѵ�
	public void sayDialogue(int dialogueNum) {
		System.out.println(name + ": " + dialogue.get(dialogueNum)); // ��) ���ڻ�: �ȳ�!
	}
	
	

	

}
