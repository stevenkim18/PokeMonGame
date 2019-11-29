package thread;

import java.util.ArrayList;

import characters.MainCharacter;
import map.ViridianForest;
import pokemon.PokeMon;

public class RainThread extends Thread{
	
	//����
	MainCharacter ����;
	ViridianForest ��Ͻ�;
	ArrayList<PokeMon> pokemons;
	
	//������
	public RainThread(MainCharacter	����, ViridianForest ��Ͻ�) {
		this.���� = ����;
		this.��Ͻ� = ��Ͻ�;
		
		// ���ϸ� ����Ʈ ����!!!
		this.pokemons = new ArrayList<PokeMon>();
		
		
		//���ϸ� ����Ʈ�� ���� ���ϸ�� ����!
		for (int i = 0; i < this.����.getOwned_PokeMon().size(); i++) {
			pokemons.add(this.����.getOwned_PokeMon().get(i));
		}
		
		//���ϸ� ����Ʈ�� ��Ͻ� ���ϸ�� ����!
		for (int i = 0; i < this.��Ͻ�.getAppearingPokeMon().size(); i++) {
			pokemons.add(this.��Ͻ�.getAppearingPokeMon().get(i));
		}
		
	}
	
	//�޼ҵ�
	@Override
	public void run() {
		
		System.out.println("�� ���� �ֽ��ϴ�!");
		System.out.println("�� ���� �� �Ӽ� ���ϸ��� �Ⱦ� �ϰ� Ǯ �Ӽ� ���ϸ��� �����մϴ�!!");
		
		while(true) {
			
			try {
				
				Thread.sleep(1000);
				

				for (int i = 0; i < pokemons.size(); i++) {
					
					// �� ���� �� ���ϸ��� ���ݷ��� 1�� ����!
					if(pokemons.get(i).getType().equals("��")) {
						pokemons.get(i).setAttack(pokemons.get(i).getAttack()-1);
						pokemons.get(i).setSp_attack(pokemons.get(i).getSp_attack()-1);
						System.out.println(pokemons.get(i).getName() + "�� ���ݷ��� �����մϴ�!");
					}
					// �� ���� Ǯ ���ϸ��� ���ݷ��� 1�� ����!
					else if(pokemons.get(i).getType().equals("Ǯ")) {
						pokemons.get(i).setAttack(pokemons.get(i).getAttack()+1);
						pokemons.get(i).setSp_attack(pokemons.get(i).getSp_attack()+1);
						System.out.println(pokemons.get(i).getName() + "�� ���ݷ��� �����մϴ�!");
					}
					
				}
			} catch (InterruptedException e) {
				
			}
			
			
		}
		
	}
	
	public void close() {
		this.���� = null;
		this.��Ͻ� = null;
		this.pokemons.clear();
		this.interrupt();
	}

}
