/*
 * 파일생성시각: 5월 2일 22시 01분
 * 
 * 수정시각: 5월 4일 1시 17분
 * <수정내용>
 * 엄마가 돈을 주고 맡길 수 있는 기능 추가
 * 보유금액 변수 추가
 * 돈을 받는다 메소드 추가
 * 
 * <클래스 이름>
 * 엄마 클래스
 * 
 * <클래스 설명>
 * - NPC클래스를 상속 받는다.
 * - 엄마 클래스로 만들어진 엄마 객체는 태초마을에만 있다.
 * 
 * <변수>
 * - 보유금액 : 엄마가 가지고 있는 돈을 저장하는 변수(처음에는 3000원을 가지고 있다)
 * 
 * <메소드>
 * - 돈을준다 : 주인공 지우에게 돈 3000원을 준다
 * - 돈을 받는디: 주인공 지우는 엄마한테 돈을 맡길 수 있다
 * - 포켓몬의체력을회복시킨다 : 지우가 가지고 있는 포켓몬의 체력을 회복시켜준다.
*/

package characters;

import pokemon.PokeMon;

public class Mom extends NPC{
	
	//<변수>
	int money; // 보유금액
	
	//<생성자>
	public Mom(String name, String map) {
		super(name, map);
		//엄마는 처움에 3000원을 가지고 있다.
		this.money = 3000;
		
		//엄마 대사 저장
		//지우가 포켓몬이 없을때 대사
		dialogue.add(0,"지우야 아직 포켓몬이 없구나. 오박사님에게 한 번 가보렴!");
		
		//지우가 포켓몬을 받고 엄마에게 처음 돈을 받으러 올때
		dialogue.add(1,"지우야! 모험을 떠날려면 돈이 필요하겠구나!");
		dialogue.add(2,"지우야! 몸 조심하고 나중에 포켓몬에게 회복이 필요하거나 돈을 맡기고 싶으면 엄마에게 오거라!");
		dialogue.add(3,"아들 사랑한다~~~");
		
		//지우가 엄마를 찾아 올때
		dialogue.add(4,"오! 지우야 무슨 도와줄 일이라도 있니?");
		
	}
	
	//<Getter,Setter>
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	//<메소드>
	//돈을주다
	public int giveMoney(int money) {
		//엄마의 잔액 > 입력받은 돈 
		if(this.money >= money) {
			this.money -= money;
			return money;
		}
		else {
			System.out.println("잔액이 부족합니다!");
			return 0;
		}
		
	}
	
	//돈을 받는다
	public void receiveMoney(int money) {
		this.money += money;
	}
	
	//포켓몬의체력을회복시킨다
	public void healPokeMon(PokeMon pokemon) {
		//포켓몬이 회복되다
		pokemon.recover();
		//스킬 pp 회복
		for (int i = 0; i < pokemon.getSkill().size(); i++) {
			pokemon.getSkill().get(i).setPower_point(pokemon.getSkill().get(i).getMax_power_point());
		}
		System.out.println(pokemon.getName() + "의 체력과 스킬 사용횟수가 회복되었습니다!");
	}
	
	public void showMomsMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("─────────────────────────────────────────────────── 엄마의 메뉴 ────────────────────────────────────────────────────────");
		System.out.println("                [1]포켓몬 회복                      [2]돈을 찾는다                      [3]돈을 맡긴다                      [0]그만대화하기");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

		
	}

}
