/*
 * �� �̵� �ϴ� �� ����!!
 */

package test;

import java.util.ArrayList;

import map.City;
import map.Field;
import map.Map;
import map.Village;

public class Test5 {

	public static void main(String[] args) {
		
		ArrayList<Map> �� = new ArrayList<Map>();
		
		��.add(0, new Village("���ʸ���"));
		��.add(1, new Field("��Ͻ�"));
		��.add(2, new City("ȸ����Ƽ"));
		��.add(3, new Field("�޸��̻�"));
		��.add(4, new City("����Ƽ"));
		
		System.out.println(��);
		
		Village ���ʸ���;
		Field ��Ͻ�;
		City ȸ����Ƽ;
		Field �޸��̻�;
		City ����Ƽ;
		
		
		
	}
	
	
}
