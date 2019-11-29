/*
 * 파일생성시각: 5월 3일 21시 27분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 아이템가방 클래스
 * 
 * <클래스 설명>
 * - 주인공의 아이템들을 담는 클래스이다.
 * - 주인공의 맴버 변수로 들어간다.
 * 
 * <변수>
 * - 포켓볼
 * - 회복약
 * 
 * <메소드>
 * - 아이템을 집어넣는다
 * - 아이템을 꺼낸다
 * - 아이템가방의상태를 보여주다
*/

package item;

import java.util.ArrayList;

public class ItemBag {

	//<변수>
	ArrayList<PokeBall> pokeball; // 포켓볼
	ArrayList<Potion> potion; // 포션
	
	//<생성자>
	public ItemBag() {
		this.pokeball = new ArrayList<PokeBall>();
		this.potion = new ArrayList<Potion>();
	}
	
	//<Getter,Setter>
	public ArrayList<PokeBall> getPokeball() {
		return pokeball;
	}

	public void setPokeball(ArrayList<PokeBall> pokeball) {
		this.pokeball = pokeball;
	}

	public ArrayList<Potion> getPotion() {
		return potion;
	}

	public void setPotion(ArrayList<Potion> potion) {
		this.potion = potion;
	}
	
	//<메소드>
	//아이템을 집어 넣는다.
	public void putItem(Item item) {
		//매개변수로 받은 아이템이 포켓볼이면
		if(item instanceof PokeBall) {
			this.pokeball.add((PokeBall) item);
		}
		//매개변수로 받은 아이템이 포션이면
		else if(item instanceof Potion){
			this.potion.add((Potion) item);
		}
	}
	
	//아이템을 꺼낸다.
	public void takeOutItem() {
		
	}
	
	//아이템가방의 상태를 보여주다
	public void showStatus() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────── 지우의 아이템가방 ───────────────────────────────────────────────────────");
		System.out.print(" \t\t\t\t[1] 포켓볼: " + pokeball.size() + "개");
		System.out.println(" \t\t\t\t[2] 회복약: " + potion.size() + "개");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}
	
}
