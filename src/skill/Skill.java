package skill;

import pokemon.PokeMon;

public class Skill {
	//<변수>
	String name; 			//스킬이름
	String type; 			//속성
	int power_point; 		//스킬사용횟수
	int max_power_point; 	//최대스킬사용횟수
	int power;				//위력
	int accuracy;			//명중률
	String equipped_Pokemon;//장착된 포켓몬
	
	//<생성자>
	public Skill(String equipped_Pokemon) {
		//스킬을 장착 할때 장착된 포켓몬만 생성자로 입력받음!
		this.equipped_Pokemon = equipped_Pokemon;
	}
	
	//<Getter, Setter>

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower_point() {
		return power_point;
	}

	public void setPower_point(int power_point) {
		this.power_point = power_point;
	}

	public int getMax_power_point() {
		return max_power_point;
	}

	public void setMax_power_point(int max_power_point) {
		this.max_power_point = max_power_point;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getEquipped_Pokemon() {
		return equipped_Pokemon;
	}

	public void setEquipped_Pokemon(String equipped_Pokemon) {
		this.equipped_Pokemon = equipped_Pokemon;
	}
	
	//<메소드>
	//스킬이사용되다
	public void beUsed(PokeMon myPokemon, PokeMon otherPokemon) {
		//스킬 사용횟수 1 감소
		this.power_point -= 1;
		
		//노말공격
		//myPokemon의 공격력+레벨+스킬의 위력에서
		//otherPokemon의 방어력을 뺀 값을 만큼 
		//otherPokemon의 체력을 감소시킨다.
		
	}
	

	//스킬이장착되다
	public void beEquipped() {
		
	}
	
	//스킬이삭제되다
	public void beRemoved() {
		
	}
	
	
	
}
