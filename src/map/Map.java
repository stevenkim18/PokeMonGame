/*
 * 파일생성시각: 5월 2일 20시 56분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 맵 클래스
 * 
 * <클래스 설명>
 * - 도시와 필드의 상위클래스이다.
 * - 맵 클래스로 생성된 객체 안에서 주인공이 활동한다.
 * 
 * <변수>
 * - 이름 : 맵의 이름을 저장한다.
 * - 맵입장여부 : 주인공이 맵에 들어와 있는지 없는지의 여부를 나타낸다.
 * 
 * <메소드>
 * - 맵으로 들어온다: 주인공인 맵으로 들어온다.
 * - 맵에서 나간다: 주인공에서 나간다.
 * - 맵의 메뉴를 보여준다.
*/

package map;

import characters.MainCharacter;

public class Map {
	//<변수>
	String name; // 이름
	boolean mapEntryStatus; // 맵입장여부
	
	//<생성자>
	public Map(String name) {
		this.name = name;
	}
	
	//<Getter,Setter>
	//[start]

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMapEntryStatus() {
		return mapEntryStatus;
	}

	public void setMapEntryStatus(boolean mapEntryStatus) {
		this.mapEntryStatus = mapEntryStatus;
	}
	//[end]

	//<메소드>
	//지우가 맵으로 들어온다
	public void comeToMap(MainCharacter 지우) throws InterruptedException {
		
		this.mapEntryStatus = true;
		
		System.out.println();
		Thread.sleep(1000);
		System.out.println();
		System.out.println("현재 위치 : " + this.name);
		System.out.println();
		Thread.sleep(1000);
		
	}
	
	//맵에서 나간다
	public void outOfMap() {
		// 멥입장여부가 false값이 된다.
		this.mapEntryStatus = false;
	}
	
	//맵의 메뉴를 보여준다.
	public void showMenu() {
		
	}

}
