package thread;

import java.util.ArrayList;

import characters.MainCharacter;
import map.ViridianForest;
import pokemon.PokeMon;

public class RainThread extends Thread{
	
	//변수
	MainCharacter 지우;
	ViridianForest 상록숲;
	ArrayList<PokeMon> pokemons;
	
	//생성자
	public RainThread(MainCharacter	지우, ViridianForest 상록숲) {
		this.지우 = 지우;
		this.상록숲 = 상록숲;
		
		// 포켓몬 리스트 생성!!!
		this.pokemons = new ArrayList<PokeMon>();
		
		
		//포켓몬 리스트에 지우 포켓몬들 저장!
		for (int i = 0; i < this.지우.getOwned_PokeMon().size(); i++) {
			pokemons.add(this.지우.getOwned_PokeMon().get(i));
		}
		
		//포켓몬 리스트에 상록숲 포켓몬들 저장!
		for (int i = 0; i < this.상록숲.getAppearingPokeMon().size(); i++) {
			pokemons.add(this.상록숲.getAppearingPokeMon().get(i));
		}
		
	}
	
	//메소드
	@Override
	public void run() {
		
		System.out.println("비가 오고 있습니다!");
		System.out.println("비가 오면 불 속성 포켓몬은 싫어 하고 풀 속성 포켓몬은 좋아합니다!!");
		
		while(true) {
			
			try {
				
				Thread.sleep(1000);
				

				for (int i = 0; i < pokemons.size(); i++) {
					
					// 비가 오면 불 포켓몬의 공격력은 1씩 감소!
					if(pokemons.get(i).getType().equals("불")) {
						pokemons.get(i).setAttack(pokemons.get(i).getAttack()-1);
						pokemons.get(i).setSp_attack(pokemons.get(i).getSp_attack()-1);
						System.out.println(pokemons.get(i).getName() + "의 공격력이 감소합니다!");
					}
					// 비가 오면 풀 포켓몬의 공격력은 1씩 증가!
					else if(pokemons.get(i).getType().equals("풀")) {
						pokemons.get(i).setAttack(pokemons.get(i).getAttack()+1);
						pokemons.get(i).setSp_attack(pokemons.get(i).getSp_attack()+1);
						System.out.println(pokemons.get(i).getName() + "의 공격력이 증가합니다!");
					}
					
				}
			} catch (InterruptedException e) {
				
			}
			
			
		}
		
	}
	
	public void close() {
		this.지우 = null;
		this.상록숲 = null;
		this.pokemons.clear();
		this.interrupt();
	}

}
