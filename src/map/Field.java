/*
 * 파일생성시각: 5월 4일 13시 27분
 * 
 * 수정시각: 
 * <수정내용>
 * 
 * <클래스 이름>
 * 필드 클래스
 * 
 * <클래스 설명>
 * - 멥 클래스를 상속받는다.
 * - 필드 클래스는 주인공이 트레이너와 배틀을 하고 야생 포켓몬이 나오는 맵이다
 * - 필드로 상록숲과 달맞이 산 객체를 만든다
 * 
 * <변수>
 * - 출현몬스터
 * - 필드트레이너
 * - 떨어져있는아이템
 * 
 * <메소드>
 * 포켓몬이 나타나다
*/

package map;

import java.util.ArrayList;

import characters.NPCTrainer;
import item.Item;
import pokemon.PokeMon;

public class Field extends Map{

	//<변수>
	ArrayList<PokeMon> appearingPokeMon; //출현몬스터
	ArrayList<NPCTrainer> fieldTrainer; //필드 트레이너
	ArrayList<Item> droppedItem; //떨어져있는아이템
	
	//<생성자>
	public Field(String name) {
		super(name);
		
		// 출현몬스터 리스트 생성
		this.appearingPokeMon = new ArrayList<PokeMon>();
		
		// 필드 트레이너 리스트 생성
		this.fieldTrainer = new ArrayList<NPCTrainer>();
		
		// 떨어져있는 아이템 리스트 생성
		this.droppedItem = new ArrayList<Item>();
		
		// 필드 마다 출현 몬스터와 필드 트레이너 떨어져 있는 아이템들이 달라서
		// 필드 클래스의 하위 클래스로 상록숲이랑 달맞이 산을 만들어야 할 수도....
	}

	//<Getter, Setter>
	public ArrayList<PokeMon> getAppearingPokeMon() {
		return appearingPokeMon;
	}

	public void setAppearingPokeMon(ArrayList<PokeMon> appearingPokeMon) {
		this.appearingPokeMon = appearingPokeMon;
	}

	public ArrayList<NPCTrainer> getFieldTrainer() {
		return fieldTrainer;
	}

	public void setFieldTrainer(ArrayList<NPCTrainer> fieldTrainer) {
		this.fieldTrainer = fieldTrainer;
	}

	public ArrayList<Item> getDroppedItem() {
		return droppedItem;
	}

	public void setDroppedItem(ArrayList<Item> droppedItem) {
		this.droppedItem = droppedItem;
	}
	
	//<메소드>
	//포켓몬이나타나다
	public void appear() {
		
	}
	
}
