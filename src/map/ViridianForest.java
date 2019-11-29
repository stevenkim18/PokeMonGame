package map;

import characters.NPCTrainer;
import item.PokeBall;
import item.Potion;
import pokemon.Caterpie;
import pokemon.Kakuna;
import pokemon.Weedle;

public class ViridianForest extends Field{ //싱록숲

	public ViridianForest(String name) {
		super(name);
		
		//출현 포켓몬
		this.appearingPokeMon.add(new Caterpie("캐터피", 5));
		this.appearingPokeMon.add(new Kakuna("딱충이", 5));
		this.appearingPokeMon.add(new Weedle("뿔충이", 5));
		this.appearingPokeMon.add(new Caterpie("캐터피", 6));
		this.appearingPokeMon.add(new Kakuna("딱충이", 6));
		this.appearingPokeMon.add(new Weedle("뿔충이", 6));
		
		//트레이너
		this.fieldTrainer.add(0, new NPCTrainer("벌레잡이소년승우", "상록숲"));
		this.fieldTrainer.add(1, new NPCTrainer("벌레잡이소년성훈", "상록숲"));
		this.fieldTrainer.add(2, new NPCTrainer("벌레잡이소년승민", "상록숲"));
		
		//트레이너 포켓몬 추가
		//벌레잡이소년승우 포켓몬 추가
		fieldTrainer.get(0).getOwned_PokeMon().add(new Caterpie("캐터피", 7));
		fieldTrainer.get(0).getOwned_PokeMon().add(new Kakuna("딱충이", 7));
		fieldTrainer.get(0).getOwned_PokeMon().add(new Weedle("뿔충이", 7));
		
		//벌레잡이소년성훈 포켓몬 추가
		fieldTrainer.get(1).getOwned_PokeMon().add(new Kakuna("딱충이", 8));
		fieldTrainer.get(1).getOwned_PokeMon().add(new Caterpie("캐터피", 8));
		fieldTrainer.get(1).getOwned_PokeMon().add(new Weedle("뿔충이", 8));
		
		//벌레잡이소년승민 포켓몬 추가
		fieldTrainer.get(2).getOwned_PokeMon().add(new Weedle("뿔충이", 9));
		fieldTrainer.get(2).getOwned_PokeMon().add(new Caterpie("캐터피", 9));
		fieldTrainer.get(2).getOwned_PokeMon().add(new Kakuna("딱충이", 9));
		
		
		//아이템
		for (int i = 0; i < 3; i++) {
			this.droppedItem.add(new PokeBall("포켓볼", 200));
			this.droppedItem.add(new Potion("회복약", 300));
		}
		
	}

	// 메뉴를 보여주다
	@Override
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<상록숲 메뉴>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■■■[1]야생포켓몬들 기다린다■■■■■■[2]트레이너와 배틀을 한다■■■■■■[3]아이템을 줍는다■■■■■■[4]지우의 상태를 본다■■■■■■[0]맵을 이동한다■■■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println();

	}
	
	//트레이너들을 보여주다
	public void showTrainers() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────── 상록숲 트레이너들 ──────────────────────────────────────────────────────");		for (int i = 0; i < this.fieldTrainer.size(); i++) {
			
			System.out.print(" ");
			
			//번호
			System.out.print(" [" + (i+1) + "]");
			//이름
			System.out.print(this.fieldTrainer.get(i).getName());
			//전투 가능 여부
			if(this.fieldTrainer.get(i).isBattleAvailable() == true) {
				System.out.print(" (전투 가능)");
			}
			else {
				System.out.print(" (전투 불가능)");
			}
			//보유포켓몬
			System.out.print("/포켓몬: " + this.fieldTrainer.get(i).getOwned_PokeMon().size() + "마리");
			
			
		}
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}
	
	public void showOtherMap() {

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────────── 맵 이동 ──────────────────────────────────────────────────────────");
		System.out.print(" \t\t\t[1]태초마을");
		System.out.print(" \t\t\t▶[2]상록숲◀");
		System.out.print(" \t\t\t[3]회색시티");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}
	
	public void showItems() {
		
		int pokeball_num = 0;
		int potion_num = 0;
		
		for (int i = 0; i < droppedItem.size(); i++) {
			
			if(droppedItem.get(i).getName() == "포켓볼") {
				pokeball_num++;
			}
			else if(droppedItem.get(i).getName() == "회복약") {
				potion_num++;
			}
			
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("─────────────────────────────────────────────── 상록숲에 떨어진 아이템들 ───────────────────────────────────────────────────");
		for (int i = 0; i < droppedItem.size(); i++) {
			System.out.print("               [" + (i+1) + "]" + droppedItem.get(i).getName());
		}
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}

	
	public static void main(String[] args) {
		
		ViridianForest forest = new ViridianForest("이름");
		forest.showTrainers();
		
	}
	
}








