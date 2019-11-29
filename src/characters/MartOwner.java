/*
 * 파일생성시각: 5월 4일 11시 33분
 * 
 * 수정시각: 
 * <수정내용>
 * 
 * <클래스 이름>
 * 마트주인 클래스
 * 
 * <클래스 설명>
 * - NPC클래스를 상속 받는다.
 * - 아이템을 사고 팔 수 있는 케릭터이다
 * 
 * <변수>
 * -
 * 
 * <메소드>
 * - 아이템을산다
 * - 아이템을판다
*/

package characters;

import java.util.ArrayList;

import item.PokeBall;
import item.Potion;

public class MartOwner extends NPC{

	//<변수>
	ArrayList<PokeBall> owned_pokeball;
	ArrayList<Potion> owned_potion;
	
	//<생성자>
	public MartOwner(String name, String map) {
		super(name, map);
		
		this.owned_pokeball = new ArrayList<PokeBall>();
		this.owned_potion = new ArrayList<Potion>();
		
		//포켓볼 회복약 10개씩 추가!
		for (int i = 0; i < 10; i++) {
			
			owned_pokeball.add(new PokeBall("포켓볼", 200));
			owned_potion.add(new Potion("회복약", 300));
			
		}
		
	}
	
	//<Getter,Setter>
	public ArrayList<PokeBall> getOwned_pokeball() {
		return owned_pokeball;
	}

	public void setOwned_pokeball(ArrayList<PokeBall> owned_pokeball) {
		this.owned_pokeball = owned_pokeball;
	}

	public ArrayList<Potion> getOwned_potion() {
		return owned_potion;
	}

	public void setOwned_potion(ArrayList<Potion> owned_potion) {
		this.owned_potion = owned_potion;
	}
	
	//<메소드>
	//아이템을산다
	public void buyItem() {
		
	}

	//아이템을판다
	public void sellItem() {
		
	}
	
	public void showItems() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────────── 판매 품목 ─────────────────────────────────────────────────────────");
		System.out.print("\t\t\t[1] 포캣볼 /" + this.owned_pokeball.size() + "개 (가격:200원)");
		System.out.println("\t\t\t[2] 회복약 /" + this.owned_potion.size() + "개 (가격:300원)");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}

	public static void main(String[] args) {
		MartOwner martOwner = new MartOwner("이름", "이름");
		martOwner.showItems();
	}
	
}
