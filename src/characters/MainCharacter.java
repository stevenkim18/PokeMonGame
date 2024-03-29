/*
 * だ橾儅撩衛陝: 5錯 2橾 17衛 14碟
 * 
 * 熱薑衛陝: 5錯 3橾 21衛 22碟
 * <熱薑頂辨>
 * 贗楚蝶 棻檜橫斜極擊 熱薑л.
 * 輿檣奢 雖辦朝 餌塋 贗楚蝶蒂 鼻樓	嫡擠.
 * 
 * <贗楚蝶 檜葷>
 * 輿檣奢(雖辦) 贗楚蝶
 * 
 * <贗楚蝶 撲貲>
 * - 餌塋 贗楚蝶蒂 鼻樓 嫡朝棻.
 * - 餌辨濠陛 啪歜 寰縑憮 褻濛й 熱 氈朝 輿檣奢 議葛攪檜棻.
 * 
 * <滲熱>
 * - 爾嶸 ん鰍跨: 輿檣奢檜 陛雖堅 氈朝 ん鰍跨菟擊 盪濰ж朝 葬蝶お
 * - 嬴檜蠱陛寞: 輿檣奢檜 菟堅 氈朝 嬴檜蠱陛寞擊 盪濰ж朝 霤褻滲熱
 * - 察雖偃熱 : 輿檣奢檜 陛雖堅 氈朝 察雖曖 偃熱蒂 盪濰ж朝 滲熱
 * - 爾嶸旎擋 : 輿檣奢檜 模雖ж堅 氈朝 絲擊 盪濰ж朝 滲熱
 * 
 * <詭模萄>
 * - 棻艇お溯檜傘縑啪 瞪癱蒂 褐羶и棻
 * - ん鰍跨擊 疏魚棻
 * - ん鰍跨縑啪 雖衛и棻
 * - 嬴檜蠱擊 餌辨и棻
 * - 嬴檜蠱擊 骯棻
 * - 嬴檜蠱擊 っ棻
 * - 嬴檜蠱擊 鄹朝棻
 * - ん鰍跨擊 濩朝棻
 * - ん鰍跨擊 嫡朝棻
 * - 絲擊 遽棻
 * - 絲擊 嫡朝棻
 * - 雖辦曖 鼻鷓蒂 爾罹輿棻
 * - 雖辦曖 ん鰍跨菟擊 爾罹輿棻
 * - 雖辦曖 嬴檜蠱陛寞擊 爾罹輿棻
 * - 雖辦曖 鼻鷓詭景蒂 爾罹輿棻
 * - ん鰍獐擊 嫡朝棻
 * 
*/

package characters;

import java.util.ArrayList;
import java.util.Scanner;

import function.Music;
import function.OneLine;
import item.Item;
import item.ItemBag;
import pokemon.PokeMon;

public class MainCharacter extends Person{
	
	//<滲熱>
	ArrayList<PokeMon> owned_PokeMon; //爾嶸 ん鰍跨
	ItemBag itembag; //嬴檜蠱 陛寞
	int badge; //察雖偃熱
	int money; //爾嶸旎擋
	
	
	//<儅撩濠>
	public MainCharacter(String name) {
		super(name);
		
		//爾嶸ん鰍跨 葬蝶お 虜菟晦
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		//嬴檜蠱 陛寞 虜菟晦
		this.itembag = new ItemBag();
		
		//察雖偃熱 0偃煎 蟾晦�� ж晦
		this.badge = 0;
		
		//爾嶸旎擋 0偃煎 蟾晦�� ж晦
		this.money = 0;
	}
	
	//<Getter, Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}
	
	public ItemBag getItembag() {
		return itembag;
	}

	public void setItembag(ItemBag itembag) {
		this.itembag = itembag;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	//<詭模萄>
	//棻艇お溯檜傘縑啪瞪癱蒂褐羶и棻
	public void applyBattle() {
		
	}
	
	//ん鰍跨擊疏魚棻
	public PokeMon takeOutPokeMon() {
		
		System.out.println(this.name + "陛 " + this.owned_PokeMon.get(0).getName() + "蒂 疏麻蝗棲棻!");
		
		return this.owned_PokeMon.get(0);
	}
	
	//ん鰍跨縑啪雖衛ж棻
	public void orderPokeMon() {
		
	}
	
	//嬴檜蠱擊 餌辨и棻
	public void useItem() {
		
	}
	
	//嬴檜蠱擊 骯棻
	public void buyItem() {
		
	}
	
	//嬴檜蠱擊 っ棻
	public void sellItem() {
		
	}
	
	//嬴檜蠱擊 鄹朝棻
	public void pickUpItem() {
		
	}
	
	//ん鰍跨擊 濩朝棻
	public void catchPokemon() {
		
	}
	
	//ん鰍跨擊 嫡朝棻
	public void getPokeMon(PokeMon pokemon) {
		this.owned_PokeMon.add(0, pokemon);
	}
	
	//絲擊遽棻
	public int giveMoney(int money) {
		//釭曖 濤擋 >= 殮溘 嫡擎 旎擋;
		if(this.money >= money) {
			this.money -= money;
			return money; 	
		}
		else {
			System.out.println();
			System.out.println("雖辦曖 濤擋檜 睡褶м棲棻!");
			System.out.println();
			return 0;
		}
		
	}
	
	//絲擊嫡朝棻
	public void receiveMoney(int money) {
		this.money += money;
		System.out.println(this.name + "陛 " + money + "錳擊 嫡懊蝗棲棻!!");
	}
	
	//雖辦曖 鼻鷓蒂 爾罹輿棻
	public void showInformation() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 雖辦曖 晦獄薑爾 式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println(" \t\t\t\t 爾嶸旎擋: " + this.money + "錳 \t\t\t\t" + "爾嶸察雖偃熱: " + this.badge + "偃");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	//雖辦曖 ん鰍跨菟擊 爾罹輿棻
	public void showPokeMons() {
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 雖辦曖 ん鰍跨菟 式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		
		//ん鰍跨檜 橈擊 陽
		if(owned_PokeMon.size() == 0) {
			System.out.println("\t\t\t\t\t\t" + this.name + "陛 陛雖堅 氈朝 ん鰍跨檜 橈蝗棲棻!");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		}
		// ん鰍跨檜 氈擊 陽
		else {
			
			// [1廓] 檜葷: だ檜葬, 溯漣: 6, 羹溘: 40
			for (int i = 0; i < owned_PokeMon.size(); i++) {
				
				System.out.print("  ");
				
				//廓�� 
				System.out.print("[" + (i+1) + "]");
				
				//檜葷
				System.out.print("檜葷: " + owned_PokeMon.get(i).getName());
				
				//溯漣
				System.out.print(" / 溯漣: " + owned_PokeMon.get(i).getLevel());
				
				//羹溘
				System.out.print(" / 羹溘: " + owned_PokeMon.get(i).getHp() + "/" + owned_PokeMon.get(i).getMax_hp());
				
				
				
			}
			System.out.println();
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			
		}
		
	}
	
	//雖辦曖 ん鰍跨蒂 撮睡餌о擊 爾罹輿棻
	public void showPokemonDetail() {
		
		while(true) {
			showPokeMons();
			System.out.println("賃 廓 ん鰍跨曖 鼻撮薑爾蒂 爾衛啊蝗棲梱? \t\t\t\t\t\t\t\t\t   (菴煎陛晦 : 0廓 殮溘)");
			System.out.print("廓�� 殮溘: ");
			
			Scanner scanner = new Scanner(System.in);
			String pokemon_num = scanner.next();
			Music buttonSound = new Music("幗が擠.mp3", false);
			buttonSound.start();
			
			// ん鰍跨 摹鷗 璋濠陛 1睡攪 雖辦陛 陛雖堅 氈朝 璋濠梱雖 殮溘嫡朝 唳辦
			if(Integer.parseInt(pokemon_num) >=1 && Integer.parseInt(pokemon_num) <= this.owned_PokeMon.size()) {
				this.owned_PokeMon.get(Integer.parseInt(pokemon_num)-1).showPokemonStat();
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t   (菴煎陛晦 : 0廓 殮溘)");
				
				scanner.next();
				Music buttonSound1 = new Music("幗が擠.mp3", false);
				buttonSound1.start();
			}
			else if (pokemon_num.equals("0")){
				break;
			}
			else {
				System.out.println();
				System.out.println("棻衛殮溘п輿撮蹂!");
				OneLine oneLine = new OneLine();
				oneLine.pressEnter();
			}
			
		}
	}
	
	//雖辦曖 嬴檜蠱陛寞擊 爾罹輿棻
	public void showItemBag() {
		this.itembag.showStatus();
	}
	
	//雖辦曖 鼻鷓詭景蒂 爾罹輿棻
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 雖辦曖 薑爾 式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("                  [1]晦獄薑爾                         [2]ん鰍跨菟                         [3]嬴檜蠱陛寞                          [0]菴煎陛晦");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	//嬴檜蠱擊 嫡朝棻
	public void receiveItem(Item item) {
		//雖辦曖 嬴檜蠱 陛寞縑 厥朝棻.
		this.itembag.putItem(item);
	}
	

}
