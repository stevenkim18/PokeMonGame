/*
 * 파일생성시각: 5월 2일 15시 20분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 포켓몬 클래스
 * 
 * <클래스 설명>
 * - 모든 포켓몬들의 부모클래스이다.
 * 
 * <변수>
 * - 이름: 포켓몬의 이름을 저장하는 변수
 * - 레벨: 포켓몬의 레벨을 저장하는 변수
 * - 체력: 포켓몬의 체력을 저장하는 변수
 * - 공격력 : 포켓몬의 공격력을 저장하는 변수
 * - 방어력 : 포켓몬의 방어력을 저장하는 변수
 * - 스피드 : 포켓몬의 스피드를 저장하는 변수(전투시 두 포켓몬의 스피드를 비교해서 빠른 포켓몬이 먼저 공격)
 * - 경험치 : 포켓몬의 현재 경험치를 저장하는 변수
 * - 최대경험치 : 포켓몬의 최대 경험치를 저장하는 변수(레벨 별로 최대 경험치가 커짐)
 * - (스킬보유개수 : 스킬을 보유하고 있는 숫자를 저장하는 변수)
 * - 속성 : 포켓몬의 타입을 저장하는 변수(불, 물, 전기, 땅, 노말 등등)
 * - 
 * 
 * <메소드>
 * - 포켓몬의 스킬을 사용한다
 * - 포켓몬의 체력이 감소한다
 * - 스킬을 배운다
 * - 회복된다
 * - 기절하다
 * - 진화하다
 * - 레벨이 올라가다
 * - 경험치가 올라가다
*/

package pokemon;

import java.util.ArrayList;

import skill.Skill;

public class PokeMon {
	
	//<변수>
	String name;   //이름
	int level;     //레벨
	int hp;        //체력
	int max_hp;    //최대체력
	int attack;    //공격력
	int defense;   //방어력
	int sp_attack; //특수공격력
	int sp_defense;//특수방어력
	int speed;     //스피드
	int exp;       //경험치
	int max_exp;   //최대 경험치
	int drop_exp;  //주는 경험치
	String type;   //속성
	ArrayList<Skill> skill; // 장착된 스킬
	ArrayList<Skill> learnable_skill; // 배울 수 있는 스킬
	
	//<생성자>
	public PokeMon(String name) {
//			int level, int hp, int attack, int defense, int sp_attack, int sp_defense, int speed, String type) {
		this.name = name;
//		this.level = level;
//		this.hp = hp;
//		this.max_hp  = hp; // 처음 포켓몬을 생성 할때는 체력 값과 최대 체력이 값이 같다
//		this.attack = attack;
//		this.defense = defense;
//		this.sp_attack = sp_attack;
//		this.sp_defense = sp_defense;
//		this.speed = speed;
//		this.type = type;
		this.skill = new ArrayList<Skill>();
		
		this.learnable_skill = new ArrayList<Skill>();
	}

	//<Getter, Setter>
	//[start]
	public String getName() {
		return name;
	}

	public int getMax_hp() {
		return max_hp;
	}

	public void setMax_hp(int max_hp) {
		this.max_hp = max_hp;
	}

	public int getSp_attack() {
		return sp_attack;
	}

	public void setSp_attack(int sp_attack) {
		this.sp_attack = sp_attack;
	}

	public int getSp_defense() {
		return sp_defense;
	}

	public void setSp_defense(int sp_defense) {
		this.sp_defense = sp_defense;
	}

	public int getDrop_exp() {
		return drop_exp;
	}

	public void setDrop_exp(int drop_exp) {
		this.drop_exp = drop_exp;
	}

	public ArrayList<Skill> getSkill() {
		return skill;
	}

	public void setSkill(ArrayList<Skill> skill) {
		this.skill = skill;
	}

	public ArrayList<Skill> getLearnable_skill() {
		return learnable_skill;
	}

	public void setLearnable_skill(ArrayList<Skill> learnable_skill) {
		this.learnable_skill = learnable_skill;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getMax_exp() {
		return max_exp;
	}

	public void setMax_exp(int max_exp) {
		this.max_exp = max_exp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	//[end]
	
	//<메소드>
	//포켓몬의 스킬을 사용한다
	public void useSkill(int skill_num, PokeMon myPokemon, PokeMon otherPokemon) {
		
		System.out.println(this.name + "가 " + this.skill.get(skill_num-1).getName() + "를 사용합니다!");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
		
		// 스킬리스트는 0부터 시작하기 때문에 매개변수에 -1을 함.
		this.skill.get(skill_num -1).beUsed(myPokemon, otherPokemon);
	}
	
	//포켓몬의 체력이 감소한다
	public void reduceHp(int damage) {
		
		//데미지가 마이너스일 경우 데미지를 1로 바꿈
		if (damage < 0) {
			damage = 1;
		}
		
		System.out.println(this.name + "의 체력이 " + damage + " 감소했습니다!");
		
		this.hp -= damage;
		
		//체력이 마이너스가 되는 경우는 0으로 바꾼다
		if(hp <= 0) {
			this.hp = 0;
		}
	}
	
	//스킬을 배운다
	public void learnSkill(String skill_name) {
		
	}
	
	//회복된다
	public void recover() {
		// 체력이 최대 체력까지 올라간다.
		this.hp = max_hp;
	}
	//일정량 만큼 회복한다
	public void recover(int hp) {
		// 체력이 최대 체력까지 올라간다.
		this.hp += hp;
		
		if(this.hp > this.max_exp) {
			this.hp = this.max_exp;
		}
	}
	
	//기절하다
	public void faint() {
		System.out.println(this.name + "가 기절하였습니다!");
	}
	
	//포켓몬의 스킬을 보여준다
	public void showSkills() {
		System.out.println("────────────────────────────────────────────────── "+this.name+"의 스킬 ───────────────────────────────────────────────────────");
		for (int i = 0; i < this.skill.size(); i++) {
			System.out.print("     [" + (i+1) + "]" + 
								this.skill.get(i).getName() + 
								"(" + this.skill.get(i).getPower_point() + "/" + this.skill.get(i).getMax_power_point() + ")" +
								" 속성: " + this.skill.get(i).getType());
		}
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
	}
	
	//포켓몬 경험치가 올라가다
	public void increaseExp(int exp) {
				
		this.exp += exp;
		
		System.out.println(this.name + "의 경험치가 " + exp + " 증가하였습니다!");
		
		//경험치가 최대 경험치 보다 큰 경우
		if(this.exp >= this.max_exp) {
			
			//현재 경험치에서 최대경험치를 뺸값을 현재 경험치의 저장
			this.exp = this.exp - this.max_exp;
			
			//레벨이 올라간다
			this.level += 1;
			
			System.out.println(this.name + "의 레벨이 "+ this.level+ "로 올랐습니다!");
			
			//레벨에 맞게 능력치가 올라간다
			levelUp(this.level);
			
		}
	}
	
	//포켓몬의 레벨이 올라가다
	public void levelUp(int level) {
		
	}
	
	//포켓몬의 상태를 보여준다
	public void showPokemonStat() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("──────────────────────────────────────────────── "+this.name+"의 상세정보 "+" ──────────────────────────────────────────────────────");
		System.out.print("   \t\t\t\t이름: " + this.name + " / 레벨: " + this.level + " / 속성: " + this.type);
		System.out.println(" / 체력: " + this.hp + "/" + this.max_hp + " / 경험치: " + this.exp + "/" + this.max_exp);
		System.out.println("---------------------------------------------------- <능력치> ---------------------------------------------------------");
		System.out.println("\t\t\t       공격력: " + this.attack + " / 특수공격력: " + this.sp_attack + 
							" / 방어력 : " + this.defense + " / 특수방어력 : " + this.sp_defense + 
							" / 스피드: " + this.speed);
		System.out.println("----------------------------------------------------- <스킬> ---------------------------------------------------------");
		for (int i = 0; i < this.skill.size(); i++) {
			System.out.print("   [" + (i + 1) + "] " + this.skill.get(i).getName() + "(" + this.skill.get(i).getPower_point() + "/"
							+ this.skill.get(i).getMax_power_point() + ")" + "/속성: " + this.skill.get(i).getType());
			
		}
		System.out.println();
		for (int i = 0; i < this.skill.size(); i++) {
			System.out.print("       ");
			System.out.print("위력: " + this.skill.get(i).getPower() + " / 명중률: " + this.skill.get(i).getAccuracy());
			System.out.print("    ");
			
		}
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}
	
	//포켓몬의 사진을 보여준다!
	public void showPicture() throws InterruptedException {
		
	}
	
	
}
