/*
 * 필드에서 아이템 리스트에 포켓볼과 회복약이 저장됨.
 * 
 * 필드에서 지우가 아이템을 주으면 지우의 가방의 포켓볼 리스트와 회복약 리스트로 옮겨감.
 * 
 * 그때 형변환을 하여야 함!! 
 * 
 * hashcode로 찍어 보니
 * 같은 객체인 것을 알 수 있음!
 */

package test;

import item.Item;
import item.PokeBall;

public class Test4 {
	
	public static void main(String[] args) {
		
		Item item = new PokeBall("포켓볼", 200);
		
		System.out.println(item.hashCode());
		
		PokeBall pokeBall = (PokeBall) item;
		
		System.out.println(pokeBall.hashCode());
	}
}
