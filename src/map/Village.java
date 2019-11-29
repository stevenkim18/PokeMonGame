/*
 * 파일생성시각: 5월 4일 12시 13분
 * 수정시각:
 * <수정내용>
 * 
 * <클래스 이름>
 * 마을 클래스
 * 
 * <클래스 설명>
 * - 맵을 상속 받는 클래스이다
 * - 주인공이 처음 시작을 하는 마을이다
 * 
 * <변수>
 * - 오박사
 * - 엄마
 * 
 * <메소드>
 * - 맵의 메뉴를 보여준다
*/

package map;

import characters.Dr_OH;
import characters.MainCharacter;
import characters.Mom;

public class Village extends Map{
	
	//<변수>
	Dr_OH dr_oh; //오박사
	Mom mom; //엄마
	
	//<생성자>
	public Village(String name) {
		super(name);
		//오박사는 오프닝 후 맵으로 들어옴.
		
		//엄마는 태초마을에 처음 부터 있음
		this.mom = new Mom("지우엄마", "태초마을");
	}
	
	//<Getter, Setter>
	public Dr_OH getDr_oh() {
		return dr_oh;
	}

	public void setDr_oh(Dr_OH dr_oh) {
		this.dr_oh = dr_oh;
	}

	public Mom getMom() {
		return mom;
	}

	public void setMon(Mom mom) {
		this.mom = mom;
	}
	
	//<메소드>
	//메뉴를 보여주다
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<태초마을 메뉴>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■[1]오박사에게 말을 건다■■■■■■■■■■■[2]엄마에게 말을 건다■■■■■■■■■■■[3]지우의 정보를 본다■■■■■■■■■■■[0]맵을 이동한다.■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println();
	}
	
	//엄마와 지우의 돈을 보여주다!
	public void showAccount(MainCharacter 지우) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("─────────────────────────────────────────────────── 현재 잔액 ─────────────────────────────────────────────────────────");
		System.out.println("       \t     \t\t 지우의 보유 금액: " + 지우.getMoney() + "원                                 엄마의 보유 금액: " + this.getMom().getMoney() + "원");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

	}
	
	public void showOtherMap() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────────── 맵 이동 ──────────────────────────────────────────────────────────");
		System.out.print(" \t\t\t▶[1]태초마을◀");
		System.out.print(" \t\t\t[2]상록숲");
		System.out.print(" \t\t\t[3]회색시티");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");


	}
	
	public static void main(String[] args) {
		
		Village village = new Village("태초마을");
		village.showOtherMap();
	}
	
	
}
