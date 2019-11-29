package thread;

import java.util.Random;

import characters.MainCharacter;
import map.Battlefield;
import pokemon.Charmander;
import pokemon.PokeMon;
import pokemon.Squirtle;

public class AutoBattleThread extends Thread{
	
	//����
	MainCharacter ����; 		//���ΰ�
	PokeMon myPokemon; 		//���ΰ��� ���ϸ�
	PokeMon otherPokemon; 	//�߻� ���ϸ�
	Battlefield battlefield;//������
	
	//������
	public AutoBattleThread(MainCharacter ����, PokeMon otherPokemon, Battlefield battlefield) {
		this.���� = ����;
		this.myPokemon = ����.getOwned_PokeMon().get(0);
		this.otherPokemon = otherPokemon;
		this.battlefield = battlefield;
		
	}
	
	//�޼ҵ�
	@Override
	public void run() {
		
		Random random = new Random();
		
		try {
			this.battlefield.comeToMap(����);
		} catch (InterruptedException e) {
			
		}
		this.battlefield.comeToMap(otherPokemon);
		
		
		
		try {
			Thread.sleep(1000);
			
			do {
				int myPokemon_skill_num = random.nextInt(myPokemon.getSkill().size())+1;
				int otherPokemon_skill_num = random.nextInt(otherPokemon.getSkill().size())+1;
				
				battlefield.showBattleField();
				
				Thread.sleep(1000);
				
				//�� ���ϸ��� ���ǵ尡 ���� ��
				if(myPokemon.getSpeed() >= otherPokemon.getSpeed()) {
					
					this.myPokemon.useSkill(myPokemon_skill_num, myPokemon, otherPokemon);
					
					Thread.sleep(2000);
					
					//��� ���ϸ��� ü���� 0�� �ƴҶ�!
					if(otherPokemon.getHp() > 0) {
						battlefield.showBattleField();
						Thread.sleep(1000);
						this.otherPokemon.useSkill(otherPokemon_skill_num, otherPokemon, myPokemon);
						Thread.sleep(1000);

					}
					
				}
				//��� ���ϸ��� ���ǵ尡 ������ 
				else {
					
					this.otherPokemon.useSkill(otherPokemon_skill_num, otherPokemon, myPokemon);
					
					Thread.sleep(1000);
					
					battlefield.showBattleField();
					Thread.sleep(1000);
					this.myPokemon.useSkill(myPokemon_skill_num, myPokemon, otherPokemon);
					Thread.sleep(1000);

				}
				
				if(otherPokemon.getHp() == 0) {
					battlefield.showBattleField();
					break;
				}
				
			} while (true);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		this.interrupt();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MainCharacter ���� = new MainCharacter("����");
		����.getOwned_PokeMon().add(new Charmander("���̸�", 10));
		
		PokeMon otherPokemon = new Squirtle("���α�", 6);
		
		Battlefield ������ = new Battlefield("������");
		
		AutoBattleThread autoBattleThread = new AutoBattleThread(����, otherPokemon, ������);
		
		autoBattleThread.start();
		autoBattleThread.join();
		autoBattleThread.close();
		
		
	}
	

}



