/*
 * 맵 이동 하는 것 구현!!
 */

package test;

import java.util.ArrayList;

import map.City;
import map.Field;
import map.Map;
import map.Village;

public class Test5 {

	public static void main(String[] args) {
		
		ArrayList<Map> 맵 = new ArrayList<Map>();
		
		맵.add(0, new Village("태초마을"));
		맵.add(1, new Field("상록숲"));
		맵.add(2, new City("회색시티"));
		맵.add(3, new Field("달맞이산"));
		맵.add(4, new City("블루시티"));
		
		System.out.println(맵);
		
		Village 태초마을;
		Field 상록숲;
		City 회색시티;
		Field 달맞이산;
		City 블루시티;
		
		
		
	}
	
	
}
