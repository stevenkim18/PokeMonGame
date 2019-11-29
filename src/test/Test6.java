package test;

import characters.MainCharacter;
import map.Battlefield;
import pokemon.Charmander;
import pokemon.Weedle;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {
		
		Battlefield 전투장 = new Battlefield("전투장");
		MainCharacter 지우 = new MainCharacter("지우");
		Weedle 뿔충이 = new Weedle("뿔충이", 5);
		
		지우.getOwned_PokeMon().add(new Charmander("파이리" , 5));
		전투장.comeToMap(지우);
		
		전투장.comeToMap(뿔충이);
		
		전투장.showBattleField();
		전투장.showMenu();
		
		뿔충이.showSkills();
	}
}
