/*
 * 파일생성시각: 5월 4일 9시 35분
 * 
 * 수정시각: 
 * <수정내용>
 * 
 * <클래스 이름>
 * 간호사 클래스
 * 
 * <클래스 설명>
 * - NPC클래스를 상속 받는다.
 * - 모든 시티 마다 간호사가 한명씩 있어야 한다.
 * - 간호사는 포켓몬의 체력과 포켓몬들의 스킬 사용량을 회복시켜준다.
 * - 간호사에게 포켓몬을 맡길 수 있다
 * 
 * <변수>
 * - 보유 포켓몬: 간호사가 보유하고 있는 포켓몬을 저장하는 리스트(처음에는 리스트가 비어있다)
 * 
 * <메소드>
 * - 포켓몬의 체력을 회복시킨다
 * - 포켓몬을준다
 * - 포켓볼을준다
 * 
 * <추가 구현 사항>
 * 간호사에게 포켓몬을 맡기면 포켓몬이 육성 된다!
*/

package characters;

import java.util.ArrayList;

import pokemon.PokeMon;

public class Nurse extends NPC{

	//<변수>
	ArrayList<PokeMon> owned_PokeMon; // 보유포켓몬
	
	//<생성자>
	public Nurse(String name, String map) {
		super(name, map);
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		// 대사 생성!
		this.dialogue.add(0, "어서오세요 저는 포켓몬 간호사 입니다!");
		this.dialogue.add(1, "무엇을 도와드릴까요?");
		
	}
	
	//<Getter, Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}
	
	//<메소드>
	//포켓몬의 체력을 회복시킨다
	public void healPokeMon(PokeMon pokemon) {
		//포켓몬이 회복되다
		pokemon.recover();
		//스킬 pp 회복
		for (int i = 0; i < pokemon.getSkill().size(); i++) {
			pokemon.getSkill().get(i).setPower_point(pokemon.getSkill().get(i).getMax_power_point());
		}
		System.out.println(pokemon.getName() + "의 체력과 스킬 사용횟수가 회복되었습니다!");
	}
	
	//포켓몬을받는다
	public void receivePokeMon(PokeMon pokemon) {
		
		System.out.println("지우가 간호사에게 " + pokemon.getName() + "를 맡겼습니다!");
		
		this.owned_PokeMon.add(pokemon);
	}
	
	//포켓몬을준다
	public void givePokeMon() {

	}
	
	//간호사의 포켓몬을 보여주다
	public void showPokeMons() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("────────────────────────────────────────────────── 맡겨둔 포켓몬들 ──────────────────────────────────────────────────────");
		
		//포켓몬이 없을 때
		if(owned_PokeMon.size() == 0) {
			System.out.println("\t\t\t\t\t   " + this.name + "가 가지고 있는 포켓몬이 없습니다!");
			System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		}
		// 포켓몬이 있을 때
		else {
			
			// [1번] 이름: 파이리, 레벨: 6, 체력: 40
			for (int i = 0; i < owned_PokeMon.size(); i++) {
				
				System.out.print("  ");
				
				//번호 
				System.out.print("[" + (i+1) + "]");
				
				//이름
				System.out.print("이름: " + owned_PokeMon.get(i).getName());
				
				//레벨
				System.out.print(" / 레벨: " + owned_PokeMon.get(i).getLevel());
				
				//체력
				System.out.print(" / 체력: " + owned_PokeMon.get(i).getHp() + "/" + owned_PokeMon.get(i).getMax_hp());
				
				
				
			}
			System.out.println();
			System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

		}
		
	}
	
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("─────────────────────────────────────────────────── 간호사의 메뉴 ───────────────────────────────────────────────────────");
		System.out.println("\t\t[1]포켓몬 회복 \t\t[2]포켓몬 맡기기 \t\t[3]포켓몬 찾기 \t\t[0]나기기");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");


	}
	
//	public static void main(String[] args) {
//		
//		Nurse nurse = new Nurse("간호사", "회색시티");
//		
//		nurse.showMenu();
//		nurse.showPokeMons();
//	}
}
