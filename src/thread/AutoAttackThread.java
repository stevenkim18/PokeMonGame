package thread;

import java.util.Random;

import map.Battlefield;
import pokemon.PokeMon;

public class AutoAttackThread extends Thread{
	
	//변수
	PokeMon myPokemon;
	PokeMon otherPokemon;
	Battlefield battlefield;
	boolean flag;
	
	//생성자
	public AutoAttackThread(Battlefield battlefield, PokeMon myPokemon, PokeMon otherPokemon) {
		this.battlefield = battlefield;
		this.myPokemon = myPokemon;
		this.otherPokemon = otherPokemon;
		this.flag = true;
	}
	
	//메소드
	@Override
	public void run() {
		
		Random random = new Random();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
		}
		
		while(flag) {
			try {
				int otherPokemon_skillNum = random.nextInt(this.otherPokemon.getSkill().size()) + 1;
				
				Thread.sleep(3000);
				this.battlefield.showBattleField();
				// 상대 포켓몬 공격
				this.otherPokemon.useSkill(otherPokemon_skillNum, otherPokemon, myPokemon);
				Thread.sleep(1000);
				this.battlefield.showBattleField();
				this.battlefield.showMenu();
				
			} catch (InterruptedException e) {
				
			}
		}
	
	}
	
	public void close() {
		this.flag = false;
		this.interrupt();
	}
	
}
