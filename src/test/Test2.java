/*
 * ���ϻ����ð�: 5�� 2�� 18�� 10��
 * 
 * <��Ȳ>
 * ���ڻ簡 ���쿡�� ���ϸ��� �ִ� ��Ȳ
 * 
 * <����>
 * ���ڻ�� ó�� ���ϸ� 3������ ������ �ִ�.
 * ���ڻ簡 ������ �ִ� ���ϸ��� ���̸�, ���α�, �̻��ؾ��̴�.
 * ���ڻ�� ���쿡�� ���ϸ��� �ش�
 * ����� ���ڻ翡�� ���ϸ��� �޴´�.
 * ���ڻ� ��ü ������ ���� ���ϸ� ����Ʈ���� ���찡 �� ���ϸ��� �����Ѵ�
 * ����� ���ڻ簡 ������ ���ϸ��� �޾Ƽ� ���� ��ü ������ ���� ���ϸ� ����Ʈ�� ���ϸ��� �����Ѵ�.
 * 
 */

package test;

import characters.Dr_OH;
import characters.MainCharacter;

public class Test2 {

	public static void main(String[] args) {
		
		Dr_OH ���ڻ� = new Dr_OH("���ڻ�", "���ʸ���");
		MainCharacter ���� = new MainCharacter("����");
		
		//���ϸ� �ֱ� �� ���ڻ� �������ϸ� ����
		for (int i = 0; i < ���ڻ�.getOwned_PokeMon().size(); i++) {
			System.out.println(���ڻ�.getOwned_PokeMon().get(i).getName());
		}
		
		System.out.println();
		
		//���ϸ� �ֱ� �� ���� �������ϸ� ����
		for (int i = 0; i < ����.getOwned_PokeMon().size(); i++) {
			System.out.println(����.getOwned_PokeMon().get(i).getName());
		}
		
		System.out.println();
		
		//1. ���ڻ�� ���쿡�� ���ڻ簡 �����ϰ� �ִ� 0�� ���ϸ��� �ش�. --> ���ڻ�.givePokeMon(0);
		//2. ����� ���ڻ翡�� ���ڻ簡 �����ϰ� �ִ� 0�� ���ϸ��� �޾Ƽ� --> ����.getPokeMon 
		//3. ������ �������ϸ� ����Ʈ �ִ´�. --> ����.owned_PokeMon.add(0, pokemon);
		����.getPokeMon(���ڻ�.givePokeMon(0));
		
		//���ϸ� �� �� ���ڻ� �������ϸ� ����
		for (int i = 0; i < ���ڻ�.getOwned_PokeMon().size(); i++) {
			System.out.println(���ڻ�.getOwned_PokeMon().get(i).getName());
		}
		
		System.out.println();
		
		//���ϸ� �� �� ���� �������ϸ� ����
		for (int i = 0; i < ����.getOwned_PokeMon().size(); i++) {
			System.out.println(����.getOwned_PokeMon().get(i).getName());
		}
	}

}
