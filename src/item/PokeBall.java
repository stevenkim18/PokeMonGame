/*
 * ���ϻ����ð�: 5�� 3�� 21�� 39��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * ���Ϻ� Ŭ����
 * 
 * <Ŭ���� ����>
 * - ������Ŭ������ ��� �޴´�.
 * - �߻����ϸ��� ���� �� ���ȴ�.
 * 
 * <����>
 * - ���ϸ�������Ȯ��: ���ϸ��� ���� Ȯ���� �����ϴ� ����
 * 
 * <�޼ҵ�>
 * - ���ϸ��̵�����: ���ϸ��� ������ ���´�
 * - ������: ���ϸ��� ������ �ʾƼ� ��������
*/

package item;

import java.util.Random;

import characters.MainCharacter;
import function.Music;
import function.OneLine;
import pokemon.PokeMon;
import thread.PokeBallWaitingThread;

public class PokeBall extends Item{

	//<����>
	double probability; // ���ϸ�������Ȯ��
	
	OneLine oneLine = new OneLine();
	
	//<������>
	public PokeBall(String name, int price) {
		super(name, price);
		//�����ڿ��� �������� ���� �ش�!
	}
	
	//<Getter,Setter>
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	//<�޼ҵ�>
	//���Ϻ��� ����ϴ�
	public void usePokeBall(MainCharacter ����, PokeMon pokemon) throws InterruptedException {
		
		Random random = new Random();
		int random_numder;
		
		Music throwSound = new Music("���Ϻ������¼Ҹ�.mp3", false);
		throwSound.start();
		
		PokeBallWaitingThread ballWaitingThread = new PokeBallWaitingThread();
		ballWaitingThread.start();
		ballWaitingThread.join();

		// ü���� 51~100�� --> Ȯ�� 1/4
		if (pokemon.getHp() > pokemon.getMax_hp() / 2 && pokemon.getHp() <= pokemon.getMax_hp()) {
			// 1~4 �� ������ ��!
			random_numder = random.nextInt(4) + 1;

			// 1/4 Ȯ���� ����
			if (random_numder == 1) {
				come(����, pokemon);
			}
			// 3/4 Ȯ���� �� ����
			else {
				crack();
			}

		}
		// ü���� 25~50�� --> Ȯ�� 1/2
		else if (pokemon.getHp() > pokemon.getMax_hp() / 4 && pokemon.getHp() <= pokemon.getMax_hp() / 2) {
			// 1~2 �� ������ ��!
			random_numder = random.nextInt(2) + 1;

			// 1/2 Ȯ���� ����
			if (random_numder == 1) {
				come(����, pokemon);
			}
			// 1/2 Ȯ���� �� ����
			else {
				crack();
			}

		}
		// ü���� 1~25�� --> Ȯ�� 1
		else if (pokemon.getHp() >= 1 && pokemon.getHp() <= pokemon.getMax_hp() / 4) {

			

			// 100�� Ȯ���� ����!
			come(����, pokemon);

		}

	}
	
	//���ϸ��̵�����
	public void come(MainCharacter ����, PokeMon pokemon) {
		����.getOwned_PokeMon().add(pokemon);
		
		Music caughtSound = new	Music("���ϸ��������Ҹ�.mp3", false);
		caughtSound.start();
		
		System.out.println(����.getName() + "�� " + pokemon.getName() + "�� ��ҽ��ϴ�!!");
		
		oneLine.pressEnter();
	}
	
	//������
	public void crack() {
		
		Music awaySound = new Music("���Ϻ����������¼Ҹ�.mp3", false);
		awaySound.start();
		
		System.out.println("���ϸ��� ���Ϻ��� ���� ���Խ��ϴ�!!");
		
		oneLine.pressEnter();
	}

}
