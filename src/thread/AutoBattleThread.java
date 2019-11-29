package thread;

import java.util.Random;

import characters.MainCharacter;
import map.Battlefield;
import pokemon.Charmander;
import pokemon.PokeMon;
import pokemon.Squirtle;

public class AutoBattleThread extends Thread{
	
	//변수
	MainCharacter 지우; 		//주인공
	PokeMon myPokemon; 		//주인공의 포켓몬
	PokeMon otherPokemon; 	//야생 포켓몬
	Battlefield battlefield;//전투장
	
	//생성자
	public AutoBattleThread(MainCharacter 지우, PokeMon otherPokemon, Battlefield battlefield) {
		this.지우 = 지우;
		this.myPokemon = 지우.getOwned_PokeMon().get(0);
		this.otherPokemon = otherPokemon;
		this.battlefield = battlefield;
		
	}
	
	//메소드
	@Override
	public void run() {
		
		Random random = new Random();
		
		try {
			this.battlefield.comeToMap(지우);
		} catch (InterruptedException e) {
			
		}
		this.battlefield.comeToMap(otherPokemon);
		
		
		
		try {
			Thread.sleep(1000);
			
			do {
				int myPokemon_skill_num = random.nextInt(myPokemon.getSkill().size())+1;
				int otherPokemon_skill_num = random.nextInt(otherPokemon.getSkill().size())+1;
				
				battlefield.showBattleField();
				
				Thread.sleep(1000);
				
				//내 포켓몬의 스피드가 빠를 때
				if(myPokemon.getSpeed() >= otherPokemon.getSpeed()) {
					
					this.myPokemon.useSkill(myPokemon_skill_num, myPokemon, otherPokemon);
					
					Thread.sleep(2000);
					
					//상대 포켓몬의 체력이 0이 아닐때!
					if(otherPokemon.getHp() > 0) {
						battlefield.showBattleField();
						Thread.sleep(1000);
						this.otherPokemon.useSkill(otherPokemon_skill_num, otherPokemon, myPokemon);
						Thread.sleep(1000);

					}
					
				}
				//상대 포켓몬의 스피드가 빠를때 
				else {
					
					this.otherPokemon.useSkill(otherPokemon_skill_num, otherPokemon, myPokemon);
					
					Thread.sleep(1000);
					
					battlefield.showBattleField();
					Thread.sleep(1000);
					this.myPokemon.useSkill(myPokemon_skill_num, myPokemon, otherPokemon);
					Thread.sleep(1000);

				}
				
				if(otherPokemon.getHp() == 0) {
					battlefield.showBattleField();
					break;
				}
				
			} while (true);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		this.interrupt();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MainCharacter 지우 = new MainCharacter("지우");
		지우.getOwned_PokeMon().add(new Charmander("파이리", 10));
		
		PokeMon otherPokemon = new Squirtle("꼬부기", 6);
		
		Battlefield 전투장 = new Battlefield("전투장");
		
		AutoBattleThread autoBattleThread = new AutoBattleThread(지우, otherPokemon, 전투장);
		
		autoBattleThread.start();
		autoBattleThread.join();
		autoBattleThread.close();
		
		
	}
	

}



