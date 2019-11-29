/*
 * ���ϻ����ð�: 5�� 4�� 12�� 55��
 * �����ð�:
 * ��������:
 * 
 * <Ŭ���� �̸�>
 * NPC Ʈ���̳� Ŭ����
 * 
 * <Ŭ���� ����>
 * - NPCŬ������ ��� �޴� Ŭ������
 * - ���ΰ��� ����� �� �� �ִ� ��ü�� ����� Ŭ�����̴�
 * 
 * <����>
 * - �������ϸ� : Ʈ���̳ʰ� �����ϰ� �ִ� ���ϸ� ����Ʈ
 * - �������ɿ��� : ������ ���� ���� ���θ� ��Ÿ���� ����(Ʈ���̳ʴ� ���ΰ��� �ѹ� �� ���� ����)
 * 
 * <�޼ҵ�>
 * - ���������Ѵ� : ���ΰ��� ������ ��û�ϸ� Ʈ���̳ʰ� ���Ѵ�
 * - ���ϸ���������
 * - ���ϸ󿡰������Ѵ�
 * - �����ش� : ���ΰ��� ��Ʋ���� �̱�� Ʈ���̳ʰ� ���ΰ����� ���� �ش�
 * - �����P�´� : ���ΰ��� ��Ʋ���� ���� Ʈ���̳ʰ� ���ΰ����Լ� ���� ���Ҵ´�
*/

package characters;

import java.util.ArrayList;

import pokemon.PokeMon;

public class NPCTrainer extends NPC{
	
	//<����>
	ArrayList<PokeMon> owned_PokeMon; //�������ϸ�
	boolean battleAvailable; //�������ɿ���
	
	//<������>
	public NPCTrainer(String name, String map) {
		super(name, map);
		// ���ϸ� ����Ʈ �����
		this.owned_PokeMon = new ArrayList<PokeMon>();
		
		// ���� ���� ���δ� ó������ ����--> true
		this.battleAvailable = true;
	}
	
	//<Getter, Setter>
	public ArrayList<PokeMon> getOwned_PokeMon() {
		return owned_PokeMon;
	}

	public void setOwned_PokeMon(ArrayList<PokeMon> owned_PokeMon) {
		this.owned_PokeMon = owned_PokeMon;
	}

	public boolean isBattleAvailable() {
		return battleAvailable;
	}

	public void setBattleAvailable(boolean battleAvailable) {
		this.battleAvailable = battleAvailable;
	}
	
	//<�޼ҵ�>
	//���������Ѵ�
	public void acceptBattle() {
		
	}

	//���ϸ���������
	public void takeOutPokeMon() {

	}

	//���ϸ󿡰������ϴ�
	public void orderPokeMon() {

	}

	//�����ش�
	public void giveMoney(MainCharacter ����) {
		����.receiveMoney(1000);
	}
	
	//�������´�
	public void takeMoney() {
		
	}
	
}
