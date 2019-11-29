/*
 * ÆÄÀÏ»ý¼º½Ã°¢: 5¿ù 2ÀÏ 17½Ã 14ºÐ
 * 
 * ¼öÁ¤½Ã°¢: 5¿ù 3ÀÏ 21½Ã 22ºÐ
 * <¼öÁ¤³»¿ë>
 * Å¬·¡½º ´ÙÀÌ¾î±×·¥À» ¼öÁ¤ÇÔ.
 * ÁÖÀÎ°ø Áö¿ì´Â »ç¶÷ Å¬·¡½º¸¦ »ó¼Ó	¹ÞÀ½.
 * 
 * <Å¬·¡½º ÀÌ¸§>
 * ÁÖÀÎ°ø(Áö¿ì) Å¬·¡½º
 * 
 * <Å¬·¡½º ¼³¸í>
 * - »ç¶÷ Å¬·¡½º¸¦ »ó¼Ó ¹Þ´Â´Ù.
 * - »ç¿ëÀÚ°¡ °ÔÀÓ ¾È¿¡¼­ Á¶ÀÛÇÒ ¼ö ÀÖ´Â ÁÖÀÎ°ø Ä³¸¯ÅÍÀÌ´Ù.
 * 
 * <º¯¼ö>
 * - º¸À¯ Æ÷ÄÏ¸ó: ÁÖÀÎ°øÀÌ °¡Áö°í ÀÖ´Â Æ÷ÄÏ¸óµéÀ» ÀúÀåÇÏ´Â ¸®½ºÆ®
 * - ¾ÆÀÌÅÛ°¡¹æ: ÁÖÀÎ°øÀÌ µé°í ÀÖ´Â ¾ÆÀÌÅÛ°¡¹æÀ» ÀúÀåÇÏ´Â ÂüÁ¶º¯¼ö
 * - ¹îÁö°³¼ö : ÁÖÀÎ°øÀÌ °¡Áö°í ÀÖ´Â ¹îÁöÀÇ °³¼ö¸¦ ÀúÀåÇÏ´Â º¯¼ö
 * - º¸À¯±Ý¾× : ÁÖÀÎ°øÀÌ ¼ÒÁöÇÏ°í ÀÖ´Â µ·À» ÀúÀåÇÏ´Â º¯¼ö
 * 
 * <¸Þ¼Òµå>
 * - ´Ù¸¥Æ®·¹ÀÌ³Ê¿¡°Ô ÀüÅõ¸¦ ½ÅÃ»ÇÑ´Ù
 * - Æ÷ÄÏ¸óÀ» ²¨³½´Ù
 * - Æ÷ÄÏ¸ó¿¡°Ô Áö½ÃÇÑ´Ù
 * - ¾ÆÀÌÅÛÀ» »ç¿ëÇÑ´Ù
 * - ¾ÆÀÌÅÛÀ» »ê´Ù
 * - ¾ÆÀÌÅÛÀ» ÆÇ´Ù
 * - ¾ÆÀÌÅÛÀ» ÁÝ´Â´Ù
 * - Æ÷ÄÏ¸óÀ» Àâ´Â´Ù
 * - Æ÷ÄÏ¸óÀ» ¹Þ´Â´Ù
 * - µ·À» ÁØ´Ù
 * - µ·À» ¹Þ´Â´Ù
 * - Áö¿ìÀÇ »óÅÂ¸¦ º¸¿©ÁÖ´Ù
 * - Áö¿ìÀÇ Æ÷ÄÏ¸óµéÀ» º¸¿©ÁÖ´Ù
 * - Áö¿ìÀÇ ¾ÆÀÌÅÛ°¡¹æÀ» º¸¿©ÁÖ´Ù
 * - Áö¿ìÀÇ »óÅÂ¸Þ´º¸¦ º¸¿©ÁÖ´Ù
 * - Æ÷ÄÏº¼À» ¹Þ´Â´Ù
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
	
	//<º¯¼ö>
	ArrayList<PokeMon> owned_PokeMon; //º¸À¯ Æ÷ÄÏ¸ó
	ItemBag itembag; //¾ÆÀÌÅÛ °¡¹æ
	int badge; //¹îÁö°³¼ö
	int money; //º¸À¯±Ý¾×
	
	
	//<»ý¼ºÀÚ>
	public MainCharacter(String name) {
		super(name);
		
		//º¸À¯Æ÷ÄÏ¸ó ¸®½ºÆ® ¸¸µé±â
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		//¾ÆÀÌÅÛ °¡¹æ ¸¸µé±â
		this.itembag = new ItemBag();
		
		//¹îÁö°³¼ö 0°³·Î ÃÊ±âÈ­ ÇÏ±â
		this.badge = 0;
		
		//º¸À¯±Ý¾× 0°³·Î ÃÊ±âÈ­ ÇÏ±â
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
	
	//<¸Þ¼Òµå>
	//´Ù¸¥Æ®·¹ÀÌ³Ê¿¡°ÔÀüÅõ¸¦½ÅÃ»ÇÑ´Ù
	public void applyBattle() {
		
	}
	
	//Æ÷ÄÏ¸óÀ»²¨³½´Ù
	public PokeMon takeOutPokeMon() {
		
		System.out.println(this.name + "°¡ " + this.owned_PokeMon.get(0).getName() + "¸¦ ²¨³Â½À´Ï´Ù!");
		
		return this.owned_PokeMon.get(0);
	}
	
	//Æ÷ÄÏ¸ó¿¡°ÔÁö½ÃÇÏ´Ù
	public void orderPokeMon() {
		
	}
	
	//¾ÆÀÌÅÛÀ» »ç¿ëÇÑ´Ù
	public void useItem() {
		
	}
	
	//¾ÆÀÌÅÛÀ» »ê´Ù
	public void buyItem() {
		
	}
	
	//¾ÆÀÌÅÛÀ» ÆÇ´Ù
	public void sellItem() {
		
	}
	
	//¾ÆÀÌÅÛÀ» ÁÝ´Â´Ù
	public void pickUpItem() {
		
	}
	
	//Æ÷ÄÏ¸óÀ» Àâ´Â´Ù
	public void catchPokemon() {
		
	}
	
	//Æ÷ÄÏ¸óÀ» ¹Þ´Â´Ù
	public void getPokeMon(PokeMon pokemon) {
		this.owned_PokeMon.add(0, pokemon);
	}
	
	//µ·À»ÁØ´Ù
	public int giveMoney(int money) {
		//³ªÀÇ ÀÜ¾× >= ÀÔ·Â ¹ÞÀº ±Ý¾×;
		if(this.money >= money) {
			this.money -= money;
			return money; 	
		}
		else {
			System.out.println();
			System.out.println("Áö¿ìÀÇ ÀÜ¾×ÀÌ ºÎÁ·ÇÕ´Ï´Ù!");
			System.out.println();
			return 0;
		}
		
	}
	
	//µ·À»¹Þ´Â´Ù
	public void receiveMoney(int money) {
		this.money += money;
		System.out.println(this.name + "°¡ " + money + "¿øÀ» ¹Þ¾Ò½À´Ï´Ù!!");
	}
	
	//Áö¿ìÀÇ »óÅÂ¸¦ º¸¿©ÁÖ´Ù
	public void showInformation() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡ Áö¿ìÀÇ ±âº»Á¤º¸ ¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println(" \t\t\t\t º¸À¯±Ý¾×: " + this.money + "¿ø \t\t\t\t" + "º¸À¯¹îÁö°³¼ö: " + this.badge + "°³");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	//Áö¿ìÀÇ Æ÷ÄÏ¸óµéÀ» º¸¿©ÁÖ´Ù
	public void showPokeMons() {
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡ Áö¿ìÀÇ Æ÷ÄÏ¸óµé ¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		
		//Æ÷ÄÏ¸óÀÌ ¾øÀ» ¶§
		if(owned_PokeMon.size() == 0) {
			System.out.println("\t\t\t\t\t\t" + this.name + "°¡ °¡Áö°í ÀÖ´Â Æ÷ÄÏ¸óÀÌ ¾ø½À´Ï´Ù!");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		}
		// Æ÷ÄÏ¸óÀÌ ÀÖÀ» ¶§
		else {
			
			// [1¹ø] ÀÌ¸§: ÆÄÀÌ¸®, ·¹º§: 6, Ã¼·Â: 40
			for (int i = 0; i < owned_PokeMon.size(); i++) {
				
				System.out.print("  ");
				
				//¹øÈ£ 
				System.out.print("[" + (i+1) + "]");
				
				//ÀÌ¸§
				System.out.print("ÀÌ¸§: " + owned_PokeMon.get(i).getName());
				
				//·¹º§
				System.out.print(" / ·¹º§: " + owned_PokeMon.get(i).getLevel());
				
				//Ã¼·Â
				System.out.print(" / Ã¼·Â: " + owned_PokeMon.get(i).getHp() + "/" + owned_PokeMon.get(i).getMax_hp());
				
				
				
			}
			System.out.println();
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			
		}
		
	}
	
	//Áö¿ìÀÇ Æ÷ÄÏ¸ó¸¦ ¼¼ºÎ»çÇ×À» º¸¿©ÁÖ´Ù
	public void showPokemonDetail() {
		
		while(true) {
			showPokeMons();
			System.out.println("¸î ¹ø Æ÷ÄÏ¸óÀÇ »ó¼¼Á¤º¸¸¦ º¸½Ã°Ú½À´Ï±î? \t\t\t\t\t\t\t\t\t   (µÚ·Î°¡±â : 0¹ø ÀÔ·Â)");
			System.out.print("¹øÈ£ ÀÔ·Â: ");
			
			Scanner scanner = new Scanner(System.in);
			String pokemon_num = scanner.next();
			Music buttonSound = new Music("¹öÆ°À½.mp3", false);
			buttonSound.start();
			
			// Æ÷ÄÏ¸ó ¼±ÅÃ ¼ýÀÚ°¡ 1ºÎÅÍ Áö¿ì°¡ °¡Áö°í ÀÖ´Â ¼ýÀÚ±îÁö ÀÔ·Â¹Þ´Â °æ¿ì
			if(Integer.parseInt(pokemon_num) >=1 && Integer.parseInt(pokemon_num) <= this.owned_PokeMon.size()) {
				this.owned_PokeMon.get(Integer.parseInt(pokemon_num)-1).showPokemonStat();
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t   (µÚ·Î°¡±â : 0¹ø ÀÔ·Â)");
				
				scanner.next();
				Music buttonSound1 = new Music("¹öÆ°À½.mp3", false);
				buttonSound1.start();
			}
			else if (pokemon_num.equals("0")){
				break;
			}
			else {
				System.out.println();
				System.out.println("´Ù½ÃÀÔ·ÂÇØÁÖ¼¼¿ä!");
				OneLine oneLine = new OneLine();
				oneLine.pressEnter();
			}
			
		}
	}
	
	//Áö¿ìÀÇ ¾ÆÀÌÅÛ°¡¹æÀ» º¸¿©ÁÖ´Ù
	public void showItemBag() {
		this.itembag.showStatus();
	}
	
	//Áö¿ìÀÇ »óÅÂ¸Þ´º¸¦ º¸¿©ÁÖ´Ù
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡ Áö¿ìÀÇ Á¤º¸ ¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("                  [1]±âº»Á¤º¸                         [2]Æ÷ÄÏ¸óµé                         [3]¾ÆÀÌÅÛ°¡¹æ                          [0]µÚ·Î°¡±â");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	//¾ÆÀÌÅÛÀ» ¹Þ´Â´Ù
	public void receiveItem(Item item) {
		//Áö¿ìÀÇ ¾ÆÀÌÅÛ °¡¹æ¿¡ ³Ö´Â´Ù.
		this.itembag.putItem(item);
	}
	

}
