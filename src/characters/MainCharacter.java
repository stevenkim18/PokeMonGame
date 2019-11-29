/*
 * ���ϻ����ð�: 5�� 2�� 17�� 14��
 * 
 * �����ð�: 5�� 3�� 21�� 22��
 * <��������>
 * Ŭ���� ���̾�׷��� ������.
 * ���ΰ� ����� ��� Ŭ������ ���	����.
 * 
 * <Ŭ���� �̸�>
 * ���ΰ�(����) Ŭ����
 * 
 * <Ŭ���� ����>
 * - ��� Ŭ������ ��� �޴´�.
 * - ����ڰ� ���� �ȿ��� ������ �� �ִ� ���ΰ� ĳ�����̴�.
 * 
 * <����>
 * - ���� ���ϸ�: ���ΰ��� ������ �ִ� ���ϸ���� �����ϴ� ����Ʈ
 * - �����۰���: ���ΰ��� ��� �ִ� �����۰����� �����ϴ� ��������
 * - �������� : ���ΰ��� ������ �ִ� ������ ������ �����ϴ� ����
 * - �����ݾ� : ���ΰ��� �����ϰ� �ִ� ���� �����ϴ� ����
 * 
 * <�޼ҵ�>
 * - �ٸ�Ʈ���̳ʿ��� ������ ��û�Ѵ�
 * - ���ϸ��� ������
 * - ���ϸ󿡰� �����Ѵ�
 * - �������� ����Ѵ�
 * - �������� ���
 * - �������� �Ǵ�
 * - �������� �ݴ´�
 * - ���ϸ��� ��´�
 * - ���ϸ��� �޴´�
 * - ���� �ش�
 * - ���� �޴´�
 * - ������ ���¸� �����ִ�
 * - ������ ���ϸ���� �����ִ�
 * - ������ �����۰����� �����ִ�
 * - ������ ���¸޴��� �����ִ�
 * - ���Ϻ��� �޴´�
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
	
	//<����>
	ArrayList<PokeMon> owned_PokeMon; //���� ���ϸ�
	ItemBag itembag; //������ ����
	int badge; //��������
	int money; //�����ݾ�
	
	
	//<������>
	public MainCharacter(String name) {
		super(name);
		
		//�������ϸ� ����Ʈ �����
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		//������ ���� �����
		this.itembag = new ItemBag();
		
		//�������� 0���� �ʱ�ȭ �ϱ�
		this.badge = 0;
		
		//�����ݾ� 0���� �ʱ�ȭ �ϱ�
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
	
	//<�޼ҵ�>
	//�ٸ�Ʈ���̳ʿ�����������û�Ѵ�
	public void applyBattle() {
		
	}
	
	//���ϸ���������
	public PokeMon takeOutPokeMon() {
		
		System.out.println(this.name + "�� " + this.owned_PokeMon.get(0).getName() + "�� ���½��ϴ�!");
		
		return this.owned_PokeMon.get(0);
	}
	
	//���ϸ󿡰������ϴ�
	public void orderPokeMon() {
		
	}
	
	//�������� ����Ѵ�
	public void useItem() {
		
	}
	
	//�������� ���
	public void buyItem() {
		
	}
	
	//�������� �Ǵ�
	public void sellItem() {
		
	}
	
	//�������� �ݴ´�
	public void pickUpItem() {
		
	}
	
	//���ϸ��� ��´�
	public void catchPokemon() {
		
	}
	
	//���ϸ��� �޴´�
	public void getPokeMon(PokeMon pokemon) {
		this.owned_PokeMon.add(0, pokemon);
	}
	
	//�����ش�
	public int giveMoney(int money) {
		//���� �ܾ� >= �Է� ���� �ݾ�;
		if(this.money >= money) {
			this.money -= money;
			return money; 	
		}
		else {
			System.out.println();
			System.out.println("������ �ܾ��� �����մϴ�!");
			System.out.println();
			return 0;
		}
		
	}
	
	//�����޴´�
	public void receiveMoney(int money) {
		this.money += money;
		System.out.println(this.name + "�� " + money + "���� �޾ҽ��ϴ�!!");
	}
	
	//������ ���¸� �����ִ�
	public void showInformation() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������� ������ �⺻���� ��������������������������������������������������������������������������������������������������������������");
		System.out.println(" \t\t\t\t �����ݾ�: " + this.money + "�� \t\t\t\t" + "������������: " + this.badge + "��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	//������ ���ϸ���� �����ִ�
	public void showPokeMons() {
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("�������������������������������������������������������������������������������������������������� ������ ���ϸ�� ��������������������������������������������������������������������������������������������������������������");
		
		//���ϸ��� ���� ��
		if(owned_PokeMon.size() == 0) {
			System.out.println("\t\t\t\t\t\t" + this.name + "�� ������ �ִ� ���ϸ��� �����ϴ�!");
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		}
		// ���ϸ��� ���� ��
		else {
			
			// [1��] �̸�: ���̸�, ����: 6, ü��: 40
			for (int i = 0; i < owned_PokeMon.size(); i++) {
				
				System.out.print("  ");
				
				//��ȣ 
				System.out.print("[" + (i+1) + "]");
				
				//�̸�
				System.out.print("�̸�: " + owned_PokeMon.get(i).getName());
				
				//����
				System.out.print(" / ����: " + owned_PokeMon.get(i).getLevel());
				
				//ü��
				System.out.print(" / ü��: " + owned_PokeMon.get(i).getHp() + "/" + owned_PokeMon.get(i).getMax_hp());
				
				
				
			}
			System.out.println();
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			
		}
		
	}
	
	//������ ���ϸ� ���λ����� �����ִ�
	public void showPokemonDetail() {
		
		while(true) {
			showPokeMons();
			System.out.println("�� �� ���ϸ��� �������� ���ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
			System.out.print("��ȣ �Է�: ");
			
			Scanner scanner = new Scanner(System.in);
			String pokemon_num = scanner.next();
			Music buttonSound = new Music("��ư��.mp3", false);
			buttonSound.start();
			
			// ���ϸ� ���� ���ڰ� 1���� ���찡 ������ �ִ� ���ڱ��� �Է¹޴� ���
			if(Integer.parseInt(pokemon_num) >=1 && Integer.parseInt(pokemon_num) <= this.owned_PokeMon.size()) {
				this.owned_PokeMon.get(Integer.parseInt(pokemon_num)-1).showPokemonStat();
				System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
				
				scanner.next();
				Music buttonSound1 = new Music("��ư��.mp3", false);
				buttonSound1.start();
			}
			else if (pokemon_num.equals("0")){
				break;
			}
			else {
				System.out.println();
				System.out.println("�ٽ��Է����ּ���!");
				OneLine oneLine = new OneLine();
				oneLine.pressEnter();
			}
			
		}
	}
	
	//������ �����۰����� �����ִ�
	public void showItemBag() {
		this.itembag.showStatus();
	}
	
	//������ ���¸޴��� �����ִ�
	public void showMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("������������������������������������������������������������������������������������������������������ ������ ���� ������������������������������������������������������������������������������������������������������������������");
		System.out.println("                  [1]�⺻����                         [2]���ϸ��                         [3]�����۰���                          [0]�ڷΰ���");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}
	
	//�������� �޴´�
	public void receiveItem(Item item) {
		//������ ������ ���濡 �ִ´�.
		this.itembag.putItem(item);
	}
	

}
