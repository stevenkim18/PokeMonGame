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

	//<����>
	MainCharacter ����;
	NPCTrainer trainer;
	PokeMon myPokemon;
	PokeMon otherPokemon;
	
	//<������>
	public Battlefield(String name) {
		super(name);
	}
	
	//<Getter, Setter>

	public MainCharacter get����() {
		return ����;
	}

	public void set����(MainCharacter ����) {
		this.���� = ����;
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
	
	
	//<�޼ҵ�>
	//���������� ������
	public void comeToMap(PokeMon pokemon) {
		this.otherPokemon = pokemon;
	}

	public void comeToMap(MainCharacter ����) throws InterruptedException {
		this.���� = ����;
		this.myPokemon = this.����.takeOutPokeMon();
		myPokemon.showPicture();
		System.out.println(this.����.getName() + ": ����!" + this.myPokemon.getName() + "!!!");
		Thread.sleep(1000);
	}
	
	public void comeToMap(NPCTrainer trainer) {
		this.trainer = trainer;
		this.otherPokemon = this.trainer.getOwned_PokeMon().get(0);
		System.out.println(this.trainer.getName() + ": ����! " + this.otherPokemon.getName() + "!!!");
	}
	
	
	
	//��� ���ϸ��� �ٲٴ�
	public void changePokemon(PokeMon myPokemon) {
		this.myPokemon = myPokemon;
	}
	
	// �������� ������
	public void outOfMap() {
		this.���� = null;
		this.myPokemon = null;
		this.trainer = null;
		this.otherPokemon = null;
	}
	
	
	//����� ������ ���ϸ��� ������
	public void outOfMap(MainCharacter ����) {
		this.���� = null;
		this.myPokemon = null;
	}
	
	//��� Ʈ���̳ʰ� ������
	public void outOfMap(NPCTrainer trainer) {
		this.trainer = null;
		this.otherPokemon = null;
	}
	
	//�߻� ���ϸ��� ������
	public void outOfMap(PokeMon otherPokemon) {
		this.otherPokemon = null;
	}
	
	
	//�ο��
	public void fight() throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		// �� ���ϸ��� ��ų�� �����ش�.
		showBattleField();
		this.myPokemon.showSkills();
		System.out.println(this.myPokemon.getName() + "�� � ��ų�� ����Ͻðڽ��ϱ�?");
		System.out.print("��ȣ �Է� : ");
		String seleced_battle_num = scanner.next();
		Music buttonSound = new Music("��ư��.mp3", false);
		buttonSound.start();
		
		System.out.println();
		
		
		try {
			
			//1������ �� ���ϸ��� �����ϰ� �ִ� �ִ� ��ų�� ������ �Է�
			if(Integer.parseInt(seleced_battle_num)>=1 && Integer.parseInt(seleced_battle_num) <= this.myPokemon.getSkill().size()) {

				// ���ϸ�鳢���� ���ǵ带 ���Ѵ�
				// ���� ���ϸ��� ���ǵ尡 �� ������
				// ���� ���ϸ��� ���� ���� �� ��� ���ϸ��� ����
				if (this.myPokemon.getSpeed() >= this.otherPokemon.getSpeed()) {

					// ���� ���ϸ� ����
					showBattleField();
					this.myPokemon.useSkill(Integer.parseInt(seleced_battle_num), myPokemon, otherPokemon);
					
					System.out.println();

					
					// ��� ���ϸ��� �����ϰ� �ִ� ��ų ���� �߿��� ���� ���ڸ� �����Ͽ� ��ų ���!
					// ���ϸ��� ��ų�� 3�� �����ϰ� ������ 1,2,3 �߿� ����
					int otherPokemon_skillNum = random.nextInt(this.otherPokemon.getSkill().size()) + 1;
					
					Thread.sleep(1000);
					
					// ��� ���ϸ��� ü���� 0���� Ŭ��!
					if(this.otherPokemon.getHp() > 0) {
						showBattleField();
						// ��� ���ϸ� ����
						this.otherPokemon.useSkill(otherPokemon_skillNum, otherPokemon, myPokemon);
						System.out.println();
						Thread.sleep(1000);
					}	

				} 
				// ��� ���ϸ��� ���ǵ尡 ���� ���
				else {
					// ��� ���ϸ��� �����ϰ� �ִ� ��ų ���� �߿��� ���� ���ڸ� �����Ͽ� ��ų ���!
					int otherPokemon_skillNum = random.nextInt(this.otherPokemon.getSkill().size());
					
					System.out.println();

					// ��� ���ϸ� ����
					this.otherPokemon.useSkill(otherPokemon_skillNum, myPokemon, otherPokemon);

					// ���� ���ϸ� ����
					this.myPokemon.useSkill(Integer.parseInt(seleced_battle_num), otherPokemon, myPokemon);
					
					System.out.println();

				}

			}
			
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("���ڸ� �Է����ּ���!");
			System.out.println();
		}
		
		
		
	}
	
	//�޴��� �����ִ�
	@Override
	public void showMenu() {
		System.out.println("������������������������������������������������������������������������������������������������������ ������ �޴� ������������������������������������������������������������������������������������������������������������������");
		System.out.println("\t\t[1]�ο�� \t\t[2]���ϸ� \t\t[3]������ ���� \t\t[0]��������");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("������ �Ͻðڽ��ϱ�?");
		System.out.print("��ȣ �Է� : ");
	}
	
	//�������� ���¸� �����ִ�
	public void showBattleField() {
		System.out.println("\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������������������� ������ ������������������������������������������������������������������������������������������������������������������");
		System.out.println();
		if(trainer == null) {
			System.out.println("\t\t------<�߻� ���ϸ�>------");
		}
		else {
			System.out.println("\t\t-<"+this.trainer.getName()+"�� ���ϸ�>-");
		}
		System.out.println(" \t\t �̸�: " + this.otherPokemon.getName());
		System.out.println(" \t\t ����: " + this.otherPokemon.getLevel());
		System.out.println(" \t\t HP: "+ this.otherPokemon.getHp() + "/" + this.otherPokemon.getMax_hp());
		System.out.println("\t\t-----------------------");		
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t\t\t\t------<������ ���ϸ�>------");
		System.out.println("\t\t\t\t\t\t\t\t\t\t �̸�: " + this.myPokemon.getName());
		System.out.println("\t\t\t\t\t\t\t\t\t\t ����: " + this.myPokemon.getLevel());
		System.out.println("\t\t\t\t\t\t\t\t\t\t HP: "+ this.myPokemon.getHp() + "/" + this.myPokemon.getMax_hp());
		System.out.println("\t\t\t\t\t\t\t\t\t\t------------------------");		
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
//	public static void main(String[] args) {
//		
//		Battlefield battlefield = new Battlefield("������");
//		
//		battlefield.setMyPokemon(new Charmander("���̸�", 8));
//		battlefield.setOtherPokemon(new Squirtle("���α�", 8));
//		
//		battlefield.showBattleField();
//		battlefield.showMenu();
//	
//	}
}
