package map;

import java.util.Random;
import java.util.Scanner;

import characters.MainCharacter;
import characters.NPCTrainer;
import function.Music;
import pokemon.Charmander;
import pokemon.PokeMon;
import pokemon.Squirtle;
import thread.AutoAttackThread;

public class Battlefield extends Map{

	//<변수>
	MainCharacter 지우;
	NPCTrainer trainer;
	PokeMon myPokemon;
	PokeMon otherPokemon;
	
	//<생성자>
	public Battlefield(String name) {
		super(name);
	}
	
	//<Getter, Setter>

	public MainCharacter get지우() {
		return 지우;
	}

	public void set지우(MainCharacter 지우) {
		this.지우 = 지우;
	}

	public NPCTrainer getTrainer() {
		return trainer;
	}

	public void setTrainer(NPCTrainer trainer) {
		this.trainer = trainer;
	}

	public PokeMon getMyPokemon() {
		return myPokemon;
	}

	public void setMyPokemon(PokeMon myPokemon) {
		this.myPokemon = myPokemon;
	}

	public PokeMon getOtherPokemon() {
		return otherPokemon;
	}

	public void setOtherPokemon(PokeMon otherPokemon) {
		this.otherPokemon = otherPokemon;
	}
	
	
	//<메소드>
	//전투장으로 들어오다
	public void comeToMap(PokeMon pokemon) {
		this.otherPokemon = pokemon;
	}

	public void comeToMap(MainCharacter 지우) throws InterruptedException {
		this.지우 = 지우;
		this.myPokemon = this.지우.takeOutPokeMon();
		myPokemon.showPicture();
		System.out.println(this.지우.getName() + ": 가랏!" + this.myPokemon.getName() + "!!!");
		Thread.sleep(1000);
	}
	
	public void comeToMap(NPCTrainer trainer) {
		this.trainer = trainer;
		this.otherPokemon = this.trainer.getOwned_PokeMon().get(0);
		System.out.println(this.trainer.getName() + ": 가랏! " + this.otherPokemon.getName() + "!!!");
	}
	
	
	
	//대결 포켓몬을 바꾸다
	public void changePokemon(PokeMon myPokemon) {
		this.myPokemon = myPokemon;
	}
	
	// 전투장을 나가다
	public void outOfMap() {
		this.지우 = null;
		this.myPokemon = null;
		this.trainer = null;
		this.otherPokemon = null;
	}
	
	
	//지우와 지우의 포켓몬이 나가다
	public void outOfMap(MainCharacter 지우) {
		this.지우 = null;
		this.myPokemon = null;
	}
	
	//상대 트레이너가 나가다
	public void outOfMap(NPCTrainer trainer) {
		this.trainer = null;
		this.otherPokemon = null;
	}
	
	//야생 포켓몬이 나가다
	public void outOfMap(PokeMon otherPokemon) {
		this.otherPokemon = null;
	}
	
	
	//싸운다
	public void fight() throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		// 내 포켓몬의 스킬을 보여준다.
		showBattleField();
		this.myPokemon.showSkills();
		System.out.println(this.myPokemon.getName() + "의 어떤 스킬을 사용하시겠습니까?");
		System.out.print("번호 입력 : ");
		String seleced_battle_num = scanner.next();
		Music buttonSound = new Music("버튼음.mp3", false);
		buttonSound.start();
		
		System.out.println();
		
		
		try {
			
			//1번에서 내 포켓몬이 소유하고 있는 최대 스킬수 까지만 입력
			if(Integer.parseInt(seleced_battle_num)>=1 && Integer.parseInt(seleced_battle_num) <= this.myPokemon.getSkill().size()) {

				// 포켓몬들끼리의 스피드를 비교한다
				// 나의 포켓몬의 스피드가 더 빠르면
				// 나의 포켓몬이 먼저 공격 후 상대 포켓몬이 공격
				if (this.myPokemon.getSpeed() >= this.otherPokemon.getSpeed()) {

					// 나의 포켓몬 공격
					showBattleField();
					this.myPokemon.useSkill(Integer.parseInt(seleced_battle_num), myPokemon, otherPokemon);
					
					System.out.println();

					
					// 상대 포켓몬이 보유하고 있는 스킬 갯수 중에서 랜덤 숫자를 선택하여 스킬 사용!
					// 포켓몬이 스킬을 3개 보유하고 있으면 1,2,3 중에 랜덤
					int otherPokemon_skillNum = random.nextInt(this.otherPokemon.getSkill().size()) + 1;
					
					Thread.sleep(1000);
					
					// 상대 포켓몬의 체력이 0보다 클때!
					if(this.otherPokemon.getHp() > 0) {
						showBattleField();
						// 상대 포켓몬 공격
						this.otherPokemon.useSkill(otherPokemon_skillNum, otherPokemon, myPokemon);
						System.out.println();
						Thread.sleep(1000);
					}	

				} 
				// 상대 포켓몬의 스피드가 빠른 경우
				else {
					// 상대 포켓몬이 보유하고 있는 스킬 갯수 중에서 랜덤 숫자를 선택하여 스킬 사용!
					int otherPokemon_skillNum = random.nextInt(this.otherPokemon.getSkill().size());
					
					System.out.println();

					// 상대 포켓몬 공격
					this.otherPokemon.useSkill(otherPokemon_skillNum, myPokemon, otherPokemon);

					// 나의 포켓몬 공격
					this.myPokemon.useSkill(Integer.parseInt(seleced_battle_num), otherPokemon, myPokemon);
					
					System.out.println();

				}

			}
			
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("숫자만 입력해주세요!");
			System.out.println();
		}
		
		
		
	}
	
	//메뉴를 보여주다
	@Override
	public void showMenu() {
		System.out.println("─────────────────────────────────────────────────── 전투장 메뉴 ─────────────────────────────────────────────────────────");
		System.out.println("\t\t[1]싸운다 \t\t[2]포켓몬 \t\t[3]아이템 가방 \t\t[0]도망간다");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("무엇을 하시겠습니까?");
		System.out.print("번호 입력 : ");
	}
	
	//전투장의 상태를 보여주다
	public void showBattleField() {
		System.out.println("\n\n");
		System.out.println("─────────────────────────────────────────────────────── 전투장 ─────────────────────────────────────────────────────────");
		System.out.println();
		if(trainer == null) {
			System.out.println("\t\t------<야생 포켓몬>------");
		}
		else {
			System.out.println("\t\t-<"+this.trainer.getName()+"의 포켓몬>-");
		}
		System.out.println(" \t\t 이름: " + this.otherPokemon.getName());
		System.out.println(" \t\t 레벨: " + this.otherPokemon.getLevel());
		System.out.println(" \t\t HP: "+ this.otherPokemon.getHp() + "/" + this.otherPokemon.getMax_hp());
		System.out.println("\t\t-----------------------");		
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t\t------<지우의 포켓몬>------");
		System.out.println("\t\t\t\t\t\t\t\t\t\t 이름: " + this.myPokemon.getName());
		System.out.println("\t\t\t\t\t\t\t\t\t\t 레벨: " + this.myPokemon.getLevel());
		System.out.println("\t\t\t\t\t\t\t\t\t\t HP: "+ this.myPokemon.getHp() + "/" + this.myPokemon.getMax_hp());
		System.out.println("\t\t\t\t\t\t\t\t\t\t------------------------");		
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}
	
//	public static void main(String[] args) {
//		
//		Battlefield battlefield = new Battlefield("전투장");
//		
//		battlefield.setMyPokemon(new Charmander("파이리", 8));
//		battlefield.setOtherPokemon(new Squirtle("꼬부기", 8));
//		
//		battlefield.showBattleField();
//		battlefield.showMenu();
//	
//	}
}
