/*
 * 파일생성시각: 5월 2일 21시 51분
 * 
 * 수정시각: 5월 3일 12시 44분
 * *수정내용* 
 * 도시 클래스에서 태초마을까지 구현하기 어려워서 마을 클래스를 따로 만들고
 * npc리스트 --> 오박사, 엄마의 객체 변수를 만듬
 * 
 * 
 * <클래스 이름>
 * 도시 클래스
 * 
 * <클래스 설명>
 * - 멥 클래스를 상속받는다.
 * - 도시 클래스로 회색시티, 블루시티 객체를 만든다.
 * 
 * <변수>
 * - 간호사
 * - 마트주인
 * - 관장
 * 
 * <메소드>
 * 
*/

package map;

import characters.GymTrainer;
import characters.MartOwner;
import characters.Nurse;
import pokemon.Geodude;
import pokemon.Onix;

public class City extends Map{
	
	//<변수>
	Nurse nurse; //간호사
	MartOwner mart_owner; // 마트주인
	GymTrainer gym_trainer; // 관장
	
	//<생성자>
	public City(String name) {
		super(name);
		
		// 간호사 객체 생성
		this.nurse = new Nurse("간호사", name);
		
		// 마트주인 객체 생성
		this.mart_owner = new MartOwner("마트주인", name);
		
		// 관장 객체 생성
		// 나중에 관장 객체를 생성 할때 "웅이"나 "이슬이"로 따로 생성
		this.gym_trainer = new GymTrainer("회색시티관장웅이", name);
		
		// 관장 포켓몬 객체 생성
		this.gym_trainer.getOwned_PokeMon().add(0, new Geodude("꼬마돌", 13));
		this.gym_trainer.getOwned_PokeMon().add(1, new Onix("롱스톤", 15));
		
		
	}

	
	//<Getter,Setter>
	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public MartOwner getMart_owner() {
		return mart_owner;
	}

	public void setMart_owner(MartOwner mart_owner) {
		this.mart_owner = mart_owner;
	}

	public GymTrainer getGym_trainer() {
		return gym_trainer;
	}

	public void setGym_trainer(GymTrainer gym_trainer) {
		this.gym_trainer = gym_trainer;
	}
	
	//<메소드>
	@Override
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<회색시티 메뉴>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■[1]포켓몬 간호사에게 말을 건다■■■■■[2]마트주인에게 말을 건다■■■■■[3]관장에게 말을 건다■■■■■[4]지우의 상태를 본다■■■■■[0]맵을 이동한다■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println();
	}
	
	public void showOtherMap() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────────── 맵 이동 ──────────────────────────────────────────────────────────");
		System.out.print(" \t\t\t[1]태초마을");
		System.out.print(" \t\t\t[2]상록숲");
		System.out.print(" \t\t\t▶[3]회색시티◀");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}
	
//	public static void main(String[] args) {
//		
//		City city = new City("회색시티");
//		
//		city.showMenu();
//		
//	}
	
}
