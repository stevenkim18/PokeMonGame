/*
 * �ʵ忡�� ������ ����Ʈ�� ���Ϻ��� ȸ������ �����.
 * 
 * �ʵ忡�� ���찡 �������� ������ ������ ������ ���Ϻ� ����Ʈ�� ȸ���� ����Ʈ�� �Űܰ�.
 * 
 * �׶� ����ȯ�� �Ͽ��� ��!! 
 * 
 * hashcode�� ��� ����
 * ���� ��ü�� ���� �� �� ����!
 */

package test;

import item.Item;
import item.PokeBall;

public class Test4 {
	
	public static void main(String[] args) {
		
		Item item = new PokeBall("���Ϻ�", 200);
		
		System.out.println(item.hashCode());
		
		PokeBall pokeBall = (PokeBall) item;
		
		System.out.println(pokeBall.hashCode());
	}
}
