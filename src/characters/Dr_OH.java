/*
 * 파일생성시각: 5월 2일 12시 11분
 * 
 * 수정시각: 5월 4일 1시 6분
 * <수정내용>
 * 오박사가 지우에게 포켓볼을 준다
 * 보유포켓볼 리스트를 추가하고 
 * 포켓볼을 준다 메소드도 추가함
 * 
 * <클래스 이름>
 * 오박사 클래스
 * 
 * <클래스 설명>
 * - NPC클래스를 상속 받는다
 * - 오프닝에서 간단한 설명을 한다.
 * - 처음 3마리 포켓몬을 가지고 있다.
 * - 지우에게 3마리 포켓몬 중 한마리를 준다.
 * 
 * <변수>
 * - 보유 포켓몬: 오박사는 게임 시작시 파이리, 꼬부기, 이상해씨를 가지고 있다.
 * - 보유 포켓볼: 오박사가 5개의 포켓볼을 가지고 있고 포켓몬을 주고 난 후에 포켓볼을 준다
 * 
 * <메소드>
 * - 포켓몬을준다
 * - 포켓볼을준다
 * - 오박사의포켓몬들을보여주다
 *
*/
package characters;

import java.util.ArrayList;

import item.PokeBall;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.PokeMon;
import pokemon.Squirtle;

public class Dr_OH extends NPC{
	
	//<변수>
	ArrayList<PokeMon> owned_PokeMon; // 보유 포켓몬
	ArrayList<PokeBall> owned_PokeBall; // 보유 포켓볼
	
	//<생성자>
	public Dr_OH(String name, String map) {
		super(name, map);
		// 포켓몬 리스트 만들기
		owned_PokeMon = new ArrayList<PokeMon>();
		
		// 포켓볼 리스트 만들기
		owned_PokeBall = new ArrayList<PokeBall>();
		// 오프닝 대사 저장
		dialogue.add(0,"안녕! 포켓몬스터의 세계에 잘 왔다.");
		dialogue.add(1,"나는 포켓몬 박사로 존경받는 오박사란다!");
		dialogue.add(2,"그리고 이 세계에는 포켓몬이라고 불리는 생명체가 도처에 살고있다!");
		dialogue.add(3,"사람들은 이 포켓몬이라는 생명체를 애완동물로 기르거나 승부를 하지만…");
		dialogue.add(4,"나는 포켓몬을 전문적으로 연구하고 있지");
		dialogue.add(5,"자.. 그러면 이제 너에 대해 알려다오");
		dialogue.add(6,"너의 이름은 뭐지?");
		dialogue.add(7,"준비는 되었는가?");
		dialogue.add(8,"드디어 이제부터 너의 이야기가 시작되어진다");
		dialogue.add(9,"즐거운 것도 괴로운 것도 잔뜩 널 기다리고 있을 것이다!" );
		dialogue.add(10,"꿈과 모험과 포켓몬스터의 세계로 렛츠 고!!" );
		
		// 오박사 처음 지우에게 포켓몬을 줄때 하는 대사
		dialogue.add(11,"오!! 지우야 이제 너가 다 커서 모험을 떠나게 되었구나!");
		dialogue.add(12,"모험을 떠나는데 포켓몬이 없으면 안되겠지?");
		dialogue.add(13,"지금 내가 가지고 있는 포켓몬은 3마리 뿐인데 이 중에 한마리를 너한테 주마");
		dialogue.add(14,"자 이중에 한마리를 골라보렴!");
		
		// 오박사가 포켓몬을 주고 난 후의 대사!
		dialogue.add(15,"좋아 지우!! 앞으로 그 포켓몬을 이용해 최고의 트레이너가 되거라!");
		
		// 오박사 포켓볼을 주는 경우
		dialogue.add(16,"오! 지우야! 마침 잘 왔다 내가 줄게 있단다.");
		dialogue.add(17,"이 포켓볼을 가지고 야생 포켓몬을 잡을 수 있단다.");
		dialogue.add(18,"그럼.... 지우야! 건투를 빈다.");
		
		// 포켓몬 객체 생성 하여 리스트에 저장
		// 파이리
		owned_PokeMon.add(0, new Charmander("파이리", 5));
		// 꼬부기
		owned_PokeMon.add(1, new Squirtle("꼬부기", 5));
		// 이상해씨
		owned_PokeMon.add(2, new Bulbasaur("이상해씨" , 5));
		
		// 처음시작 할 때 오박사가 5개의 포켓볼을 가지고 있음
		for (int i = 0; i < 5; i++) {
			owned_PokeBall.add(new PokeBall("포켓볼", 200));
		}
	}
	
	//<Getter,Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}
	
	public ArrayList<PokeBall> getOwned_PokeBall() {
		return owned_PokeBall;
	}

	public void setOwned_PokeBall(ArrayList<PokeBall> owned_PokeBall) {
		this.owned_PokeBall = owned_PokeBall;
	}

	//<메소드>
	//포켓몬을주다
	public PokeMon givePokeMon(int num) {
		//오박사는 지우에 파이리를 주다.
		return owned_PokeMon.remove(num-1);
	}
	
	//포켓볼을주다
	public PokeBall givePokeBall() {
		//맨 첫번째 있는 포켓볼을 주다
		return owned_PokeBall.remove(0);
	}
	
	//오박사의 포켓볼을 보여주다
	public void showPokeMon() {
		System.out.println();
		System.out.println("------------------------------------------------ 오박사의 포켓몬 ---------------------------------------------------------");
		System.out.println();
		for (int i = 0; i < owned_PokeMon.size(); i++) {
			
			System.out.print("     ");
			//번호 
			System.out.print("[" + (i+1) + "번" + "]");
			
			//이름
			System.out.print("이름: " + owned_PokeMon.get(i).getName());
			
			//레벨
			System.out.print(" / 레벨: " + owned_PokeMon.get(i).getLevel());
			
			//속성
			System.out.print(" / 속성: " + owned_PokeMon.get(i).getType());
			
			
			
		}
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------------");

		System.out.println();
	}

	


	
}
