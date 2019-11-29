/*
 * 파일생성시각: 5월 4일 12시 55분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * NPC 트레이너 클래스
 * 
 * <클래스 설명>
 * - NPC클래스를 상속 받는 클래스다
 * - 주인공과 대결을 할 수 있는 객체를 만드는 클래스이다
 * 
 * <변수>
 * - 보유포켓몬 : 트레이너가 보유하고 있는 포켓몬 리스트
 * - 전투가능여부 : 전투가 가능 한지 여부를 나타내는 변수(트레이너는 주인공과 한번 만 전투 가능)
 * 
 * <메소드>
 * - 전투에응한다 : 주인공이 전투를 신청하면 트레이너가 응한다
 * - 포켓몬을꺼낸다
 * - 포켓몬에게지시한다
 * - 돈을준다 : 주인공이 배틀에서 이기면 트레이너가 주인공에게 돈을 준다
 * - 돈을뻇는다 : 주인공이 배틀에서 지면 트레이너가 주인공에게서 돈을 뺏았는다
*/

package characters;

import java.util.ArrayList;

import pokemon.PokeMon;

public class NPCTrainer extends NPC{
	
	//<변수>
	ArrayList<PokeMon> owned_PokeMon; //보유포켓몬
	boolean battleAvailable; //전투가능여부
	
	//<생성자>
	public NPCTrainer(String name, String map) {
		super(name, map);
		// 포켓몬 리스트 만들기
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		// 전투 가능 여부는 처음에는 가능--> true
		this.battleAvailable = true;
	}
	
	//<Getter, Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}

	public boolean isBattleAvailable() {
		return battleAvailable;
	}

	public void setBattleAvailable(boolean battleAvailable) {
		this.battleAvailable = battleAvailable;
	}
	
	//<메소드>
	//전투에응한다
	public void acceptBattle() {
		
	}

	//포켓몬을꺼낸다
	public void takeOutPokeMon() {

	}

	//포켓몬에게지시하다
	public void orderPokeMon() {

	}

	//돈을준다
	public void giveMoney(MainCharacter 지우) {
		지우.receiveMoney(1000);
	}
	
	//돈을뺏는다
	public void takeMoney() {
		
	}
	
}
