package test;

import characters.MainCharacter;
import map.Battlefield;
import pokemon.Charmander;
import pokemon.Weedle;

public class Test6 {
	public static void main(String[] args) throws InterruptedException {
		
		Battlefield ������ = new Battlefield("������");
		MainCharacter ���� = new MainCharacter("����");
		Weedle ������ = new Weedle("������", 5);
		
		����.getOwned_PokeMon().add(new Charmander("���̸�" , 5));
		������.comeToMap(����);
		
		������.comeToMap(������);
		
		������.showBattleField();
		������.showMenu();
		
		������.showSkills();
	}
}
