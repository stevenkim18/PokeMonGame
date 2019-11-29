/*
 * 파일생성시각: 5월 3일 21시 39분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 포켓볼 클래스
 * 
 * <클래스 설명>
 * - 아이템클래스를 상속 받는다.
 * - 야생포켓몬을 잡을 때 사용된다.
 * 
 * <변수>
 * - 포켓몬이잡힐확률: 포켓몬이 잡힐 확률을 저장하는 변수
 * 
 * <메소드>
 * - 포켓몬이들어오다: 포켓몬이 잡혀서 들어온다
 * - 꺠진다: 포켓몬이 잡히지 않아서 없어진다
*/

package item;

import java.util.Random;

import characters.MainCharacter;
import function.Music;
import function.OneLine;
import pokemon.PokeMon;
import thread.PokeBallWaitingThread;

public class PokeBall extends Item{

	//<변수>
	double probability; // 포켓몬이잡힐확률
	
	OneLine oneLine = new OneLine();
	
	//<생성자>
	public PokeBall(String name, int price) {
		super(name, price);
		//생성자에서 랜덤으로 값을 준다!
	}
	
	//<Getter,Setter>
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	//<메소드>
	//포켓볼을 사용하다
	public void usePokeBall(MainCharacter 지우, PokeMon pokemon) throws InterruptedException {
		
		Random random = new Random();
		int random_numder;
		
		Music throwSound = new Music("포켓볼던지는소리.mp3", false);
		throwSound.start();
		
		PokeBallWaitingThread ballWaitingThread = new PokeBallWaitingThread();
		ballWaitingThread.start();
		ballWaitingThread.join();

		// 체력이 51~100퍼 --> 확률 1/4
		if (pokemon.getHp() > pokemon.getMax_hp() / 2 && pokemon.getHp() <= pokemon.getMax_hp()) {
			// 1~4 중 임의의 수!
			random_numder = random.nextInt(4) + 1;

			// 1/4 확률로 잡힘
			if (random_numder == 1) {
				come(지우, pokemon);
			}
			// 3/4 확률로 안 잡힘
			else {
				crack();
			}

		}
		// 체력이 25~50퍼 --> 확률 1/2
		else if (pokemon.getHp() > pokemon.getMax_hp() / 4 && pokemon.getHp() <= pokemon.getMax_hp() / 2) {
			// 1~2 중 임의의 수!
			random_numder = random.nextInt(2) + 1;

			// 1/2 확률로 잡힘
			if (random_numder == 1) {
				come(지우, pokemon);
			}
			// 1/2 확률로 안 잡힘
			else {
				crack();
			}

		}
		// 체력이 1~25퍼 --> 확률 1
		else if (pokemon.getHp() >= 1 && pokemon.getHp() <= pokemon.getMax_hp() / 4) {

			

			// 100퍼 확률로 잡힘!
			come(지우, pokemon);

		}

	}
	
	//포켓몬이들어오다
	public void come(MainCharacter 지우, PokeMon pokemon) {
		지우.getOwned_PokeMon().add(pokemon);
		
		Music caughtSound = new	Music("포켓몬이잡힌소리.mp3", false);
		caughtSound.start();
		
		System.out.println(지우.getName() + "가 " + pokemon.getName() + "를 잡았습니다!!");
		
		oneLine.pressEnter();
	}
	
	//꺠진다
	public void crack() {
		
		Music awaySound = new Music("포켓볼에서나오는소리.mp3", false);
		awaySound.start();
		
		System.out.println("포켓몬이 포켓볼을 깨고 나왔습니다!!");
		
		oneLine.pressEnter();
	}

}
