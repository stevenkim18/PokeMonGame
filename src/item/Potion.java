/*
 * 파일생성시각: 5월 3일 22시 01분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 포션 클래스
 * 
 * <클래스 설명>
 * - 포션클래스를 상속 받는다.
 * - 포켓몬의 체력을 회복시켜준다.
 * 
 * <변수>
 * - 
 * 
 * <메소드>
 * - 포켓몬의체력을회복시키다
*/

package item;

import pokemon.PokeMon;

public class Potion extends Item{
	
	//<변수>
	
	//<생성자>
	public Potion(String name, int price) {
		super(name, price);
	}
	
	//<Getter, Setter>

	//<메소드>
	//포켓몬의체력을회복시키다
	public void healPokeMon(PokeMon pokemon) {
		
		// 체력을 10 회복
		pokemon.recover(10);
		
		// 체력이 최대 체력을 넘었을 경우 최대체력으로 바꿈
		if(pokemon.getHp() > pokemon.getMax_hp()) {
			pokemon.setHp(pokemon.getMax_hp());
		}
		
		System.out.println(pokemon.getName() + "의 체력이 회복되었습니다!");
		
	}
}
