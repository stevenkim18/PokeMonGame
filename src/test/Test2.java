/*
 * 파일생성시각: 5월 2일 18시 10분
 * 
 * <상황>
 * 오박사가 지우에게 포켓몬을 주는 상황
 * 
 * <설명>
 * 오박사는 처음 포켓몬 3마리를 가지고 있다.
 * 오박사가 가지고 있는 포켓몬은 파이리, 꼬부기, 이상해씨이다.
 * 오박사는 지우에게 포켓몬을 준다
 * 지우는 오박사에게 포켓몬을 받는다.
 * 오박사 객체 변수인 보유 포켓몬 리스트에서 지우가 고른 포켓몬을 리턴한다
 * 지우는 오박사가 리턴한 포켓몬을 받아서 지우 객체 변수인 보유 포켓몬 리스트에 포켓몬을 저장한다.
 * 
 */

package test;

import characters.Dr_OH;
import characters.MainCharacter;

public class Test2 {

	public static void main(String[] args) {
		
		Dr_OH 오박사 = new Dr_OH("오박사", "태초마을");
		MainCharacter 지우 = new MainCharacter("지우");
		
		//포켓몬 주기 전 오박사 보유포켓몬 상태
		for (int i = 0; i < 오박사.getOwned_PokeMon().size(); i++) {
			System.out.println(오박사.getOwned_PokeMon().get(i).getName());
		}
		
		System.out.println();
		
		//포켓몬 주기 전 지우 보유포켓몬 상태
		for (int i = 0; i < 지우.getOwned_PokeMon().size(); i++) {
			System.out.println(지우.getOwned_PokeMon().get(i).getName());
		}
		
		System.out.println();
		
		//1. 오박사는 지우에게 오박사가 보유하고 있는 0번 포켓몬을 준다. --> 오박사.givePokeMon(0);
		//2. 지우는 오박사에게 오박사가 보유하고 있는 0번 포켓몬을 받아서 --> 지우.getPokeMon 
		//3. 지우의 보유포켓몬 리스트 넣는다. --> 지우.owned_PokeMon.add(0, pokemon);
		지우.getPokeMon(오박사.givePokeMon(0));
		
		//포켓몬 준 후 오박사 보유포켓몬 상태
		for (int i = 0; i < 오박사.getOwned_PokeMon().size(); i++) {
			System.out.println(오박사.getOwned_PokeMon().get(i).getName());
		}
		
		System.out.println();
		
		//포켓몬 준 후 지우 보유포켓몬 상태
		for (int i = 0; i < 지우.getOwned_PokeMon().size(); i++) {
			System.out.println(지우.getOwned_PokeMon().get(i).getName());
		}
	}

}
