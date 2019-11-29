/*
 * 파일생성시각: 5월 2일 11시 59분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * NPC 클래스
 * 
 * <클래스 설명>
 * - 게임에서 주인공과 단순히 대화만 하는 npc캐릭터를 만드는 클래스이다
 * - 유닛 클래스를 상속 받는다.
 * 
 * <변수>
 * - 출현맵 : npc캐릭터 나타나는 맵을 저장하는 변수
 * 
 * <메소드>
 * - 
*/

package characters;

public class NPC extends Person{

	//<변수>
	String appearanceMap; // 출현맵
	
	//<생성자>
	public NPC(String name, String map) {
		super(name);
		this.appearanceMap = map;
	}

	//<Getter, Setter>
	public String getAppearanceMap() {
		return appearanceMap;
	}

	public void setAppearanceMap(String appearanceMap) {
		this.appearanceMap = appearanceMap;
	}
	
	
	

}
