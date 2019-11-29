/*
 * ���ʽ��۽ð�: 5�� 2�� 11�� ����!
 * ���� �ð� : 
 * ���� ���� :
 * 
 * <������ ���� �ó�����>
 * 1.���ΰ��� ���찡 ���ڻ翡�� ���ϸ� �Ѹ����� ����.
 * 2.�߻����ϸ�� ���ϸ� Ʈ���̳ʿ� �ο��� ���ϸ��� Ű��.
 * 3.ü������ ���ϸ� ����� �ο��� ���� 2���� ������ ���� ��!
 * 
 * <���� ���ϸ�>
 * 1.���̸� 2.�̻��ؾ� 3.���α�
 * 
 * <��>
 * 1.���ʸ��� (Map1_Pallet_Town)
 * 2.��Ͻ� (Map2_Viridian_Forest)
 * 3.ȸ����Ƽ (Map3_Pewter_City)
 * 4.�޸��� �� (Map4_Mt_Moon)
 * 5.����Ƽ (Map5_Cerulean City)
 * 
 */

package main;

import java.util.Random;
import java.util.Scanner;

import characters.Dr_OH;
import characters.MainCharacter;
import function.OneLine;
import item.PokeBall;
import item.Potion;
import map.Battlefield;
import map.City;
import map.Field;
import map.Village;
import map.ViridianForest;
import pokemon.Charmander;
import test.Logo;
import thread.LoadingThread;
import thread.PrintOnebyone;

public class PokeMon_Game2 {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		//���� ����
		String selected_menu_num; // �Է� ���� ����
		String second_selected_menu_num; // �Է� ���� ������ 2���� ��� ���� ���� ����! 
		OneLine oneLine = new OneLine(); // ������ ��� ���͸� �Է¹ޱ� ���� ��ü
		PrintOnebyone print = new PrintOnebyone();
		
		// ���ڻ� ��ü ����
		Dr_OH ���ڻ� = new Dr_OH("���ڻ�", "���ʸ���");

		// ���� ��ü ����
		MainCharacter ���� = new MainCharacter("����");
		
		// �� ��ü ����
		Village ���ʸ��� = new Village("���ʸ���");
		ViridianForest ��Ͻ� = new ViridianForest("��Ͻ�");
		City ȸ����Ƽ = new City("ȸ����Ƽ");
		
		Battlefield ������ = new Battlefield("������");

		Logo �ΰ� = new Logo();
		�ΰ�.showLogo();
		
		oneLine.pressEnter();
		
		Thread loadingThread = new LoadingThread();
		loadingThread.start();
		loadingThread.join();
		//loadingThread.interrupted();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //25
		
		oneLine.pressEnter();
		
		// <���ڻ� ������>
		// [start] 
		// ���ڻ� ������ ��縦 ��
		// ���ʴ�� ��簡 ����
		// Enter�� ������ ���� ���� �Ѿ
		for (int i = 0; i < 11; i++) {
			System.out.print("                                                                       ");
			print.printSentence(���ڻ�.getDialogue().get(i));
			
			//"���� �̸��� ����?" ���� �̸��� ������� ��
			if(i == 6) {
				System.out.print("�̸� �Է� : ");
				String name = "����"; // scanner.next();
				����.setName(name);
				System.out.println(����.getName()+"!!");
				
			}
		}
		
		//[end]
		
		//loadingThread.start();
		//loadingThread.join();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //25
		
		oneLine.pressEnter();
		
		//���ʸ����� ���� ����
		���ʸ���.comeToMap(����);
		
		//���ʸ����� ���ڻ簡 ����
		���ʸ���.setDr_oh(���ڻ�);
		
		//���ʸ���
		while(true) {
			
			���ʸ���.showMenu();
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.print("��ȣ �Է�: ");
			selected_menu_num = scanner.next();
			
			//1. ���ڻ翡�� ���� �Ǵ�
			if(selected_menu_num.equals("1")) {
				
				// ���찡 ���ϸ��� ������ ���� ������
				if(����.getOwned_PokeMon().size() == 0) {

					// ó�� ���ڻ翡�� ���� �� ���ڻ簡 ���쿡�� ���ϸ��� �ִ� ��Ȳ
					oneLine.pressEnter();					
					���ڻ�.sayDialogue(11);
					oneLine.pressEnter();					
					���ڻ�.sayDialogue(12);
					oneLine.pressEnter();					
					���ڻ�.sayDialogue(13);
					oneLine.pressEnter();					
					���ڻ�.sayDialogue(14);
					oneLine.pressEnter();					
					
					//���찡 ���ϸ� ����
					while(true) {
						���ڻ�.showPokeMon();
						System.out.println("�� �� ���ϸ��� �����ðڽ��ϱ�?");
						System.out.print("��ȣ �Է� : ");
						selected_menu_num = scanner.next();
						
						//1~3�� �Է� ���� ��
						if(selected_menu_num.equals("1") || selected_menu_num.equals("2") || selected_menu_num.equals("3")) {
							
							System.out.println(���ڻ�.getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1).getName() + "�� �����ϼ̽��ϴ�!");
							oneLine.pressEnter();					
							
							System.out.println();
							System.out.println("������ �����ðڽ��ϱ�?");
							System.out.println("1.�� 2.�ƴϿ�");
							System.out.print("��ȣ �Է� : ");
							second_selected_menu_num = scanner.next();
							System.out.println();
							
							//1.��
							if(second_selected_menu_num.equals("1")) {
								
								//���ڻ� ���ϸ� ����Ʈ�� �ִ� ���õ� ���ϸ���
								//������ ���ϸ� ����Ʈ�� �̵��Ѵ�
								����.getPokeMon(���ڻ�.givePokeMon(Integer.parseInt(selected_menu_num)));
								
								oneLine.pressEnter();					
								System.out.println("����� ���ڻ翡�Է� ���� " + ����.getOwned_PokeMon().get(0).getName() + "�� �޾Ҵ�!!");
								oneLine.pressEnter();					
								
								���ڻ�.sayDialogue(15);
								oneLine.pressEnter();					
								
								break;
								
							}
							//2.�ƴϿ�
							else {
								
							}
							
						}
						//�߸� �Է����� ��
						else {
							
							oneLine.pressEnter();					
							System.out.println("�߸� �Է��ϼ̽��ϴ�!");
							System.out.println("1~3���� �Է����ּ���!!");
							oneLine.pressEnter();					
							
						}
						
					}
					
				}
				//���찡 ���ϸ��� ������ ���� ��
				else {
					
					//���ڻ� ���Ϻ��� ������ ���� ��
					if(���ڻ�.getOwned_PokeBall().size() != 0) {
						//���찡 ���ϸ��� �ް� �ٽ� ���ڻ翡�� ���ϸ� ���Ϻ��� �ش�!
						scanner.nextLine();
						���ڻ�.sayDialogue(16);
						scanner.nextLine();
						
						//���찡 ���ڻ翡�Է� ���� ���Ϻ� 5���� �޴´�.
						for (int i = 0; i < 5; i++) {
							����.receiveItem(���ڻ�.givePokeBall());
						}
						
						System.out.println("���ڻ翡�� ���Ϻ� 5���� �޾ҽ��ϴ�!");
						scanner.nextLine();
						
						���ڻ�.sayDialogue(17);
						scanner.nextLine();
						
						���ڻ�.sayDialogue(18);
						scanner.nextLine();
					}
					//���ڻ� ���쿡�� ���Ϻ��� �ְ� �Ѱ� ���� ��
					else if(���ڻ�.getOwned_PokeBall().size() == 0){
						
						scanner.nextLine();
						���ڻ�.sayDialogue(18);
						scanner.nextLine();
						
					}
					
				}
				
			}
			//2. �������� ���� �Ǵ�
			else if (selected_menu_num.equals("2")) {
				
				//���찡 ���ϸ��� ���� ��
				if(����.getOwned_PokeMon().size() == 0) {
					oneLine.pressEnter();
					���ʸ���.getMom().sayDialogue(0);
					oneLine.pressEnter();
				}
				//���찡 ���ϸ��� ���� ��
				else if(����.getOwned_PokeMon().size() >=1) {
					
					//ó�� ������ ���� �ٶ�(���� ���� 3000�� ���� ��)
					if(���ʸ���.getMom().getMoney() == 3000) {
						oneLine.pressEnter();
						
						���ʸ���.getMom().sayDialogue(1);
						
						//������ ���쿡�� 3000���� �ش�
						����.receiveMoney(���ʸ���.getMom().giveMoney(3000));
						
						oneLine.pressEnter();
						System.out.println("���찡 �������Էκ��� 3000���� �޾ҽ��ϴ�!");
						
						oneLine.pressEnter();
						���ʸ���.getMom().sayDialogue(2);
						
						oneLine.pressEnter();
						���ʸ���.getMom().sayDialogue(3);
						
						oneLine.pressEnter();
						
					}
					//������ ���� �ְ� ���� 
					//������ �⺻ ����� �Ҷ�(���ϸ� ȸ��, ���� ����� ���)
					else {
						oneLine.pressEnter();
						���ʸ���.getMom().sayDialogue(4);
						
						while(true) {
							
							oneLine.pressEnter();
							System.out.println("������ �Ͻðڽ��ϱ�?");
							System.out.println("1.���ϸ� ȸ�� 2.���� ã�´� 3.���� �ñ�� 0.�׸���ȭ�ϱ�");
							System.out.print("��ȣ�Է�: ");
							selected_menu_num = scanner.next();
							
							//1.���ϸ� ȸ��
							if (selected_menu_num.equals("1")) {
								System.out.println("������ ���ϸ���� �������� �ñ��!");
								
								oneLine.pressEnter();
								
								for (int i = 0; i < ����.getOwned_PokeMon().size(); i++) {
									���ʸ���.getMom().healPokeMon(����.getOwned_PokeMon().get(i));
								}
							
								
							}
							//2.���� ã�´�
							else if(selected_menu_num.equals("2")) {
								
								while(true) {
									System.out.println("ã�� �� �ִ� �� : " + ���ʸ���.getMom().getMoney() + "��");
									System.out.println("�󸶸� ã���ðڽ��ϱ�?");
									System.out.print("�ݾ� �Է� (�ڷΰ��� 0�Է�): ");
									String money = scanner.next();
									
									//0 �Է� �� �ڷΰ���
									if(money.equals("0")) {
										break;
									}
									//�ݾ� �Է½�
									else {
										// �Է��� �ݾ� ��ŭ ���쿡�� ���� �ش�
										����.receiveMoney(���ʸ���.getMom().giveMoney(Integer.parseInt(money)));
									}
									
								}
								
							}
							//3.���� �ñ��
							else if(selected_menu_num.equals("3")) {
								
								while(true) {
									System.out.println("������ ���� �ܾ� : " + ����.getMoney() + "��");
									System.out.println("�󸶸� �ñ�ðڽ��ϱ�?");
									System.out.print("�ݾ� �Է� (�ڷΰ��� 0�Է�): ");
									String money = scanner.next();
									
									//0 �Է� �� �ڷΰ���
									if(money.equals("0")) {
										break;
									}
									//�ݾ� �Է½�
									else {
										// �Է��� �ݾ� ��ŭ ���찡 �������� ���� �ñ��
										���ʸ���.getMom().receiveMoney(����.giveMoney(Integer.parseInt(money)));
									}
								}
								
								
							}
							//0.�׸� ��ȭ�ϱ�
							else if(selected_menu_num.equals("0")) {
								break;
							}
							//�߸� �Է� ���� ��
							else {

								oneLine.pressEnter();					
								System.out.println("�߸� �Է��ϼ̽��ϴ�!");
								oneLine.pressEnter();					
								
							}
						}
						
						
					}
					
					
					
				}
				
				
			}
			//3. ������ ���¸� ����
			else if (selected_menu_num.equals("3")) {
				
				while(true) {
					
					����.showMenu();
					System.out.println("������ ���ðڽ��ϱ�?");
					System.out.print("��ȣ �Է�: ");
					selected_menu_num = scanner.next();
					
					//1. ������ �⺻����
					if(selected_menu_num.equals("1")) {
						����.showInformation();
						System.out.print("������(�ƹ�Ű���Է�)");
						scanner.next();
					}
					
					//2. ������ ���ϸ��
					else if (selected_menu_num.equals("2")) {
						����.showPokeMons();
						����.showPokemonDetail();
						System.out.print("������(�ƹ�Ű���Է�)");
						scanner.next();
					}
					
					//3. ������ �����۰���
					else if (selected_menu_num.equals("3")) {
						����.showItemBag();
						System.out.print("������(�ƹ�Ű���Է�)");
						scanner.next();
					}
					
					//0. �ڷΰ���
					else if (selected_menu_num.equals("0")) {
						break;
					}
					
				}
				
			}
			//0. ���� �̵��Ѵ�.
			else if (selected_menu_num.equals("0")) {
				oneLine.pressEnter();				
				//���찡 ���ϸ��� �Ѹ����� ������ ���� ���� ����
				//���ʸ��� ��� �� ����.
				if(����.getOwned_PokeMon().size() == 0) {
					System.out.println("���쿡�Դ� ���ϸ��� �����ϴ�!!");
					System.out.println("���ڻ翡�� ���� ���ϸ��� ���� �� �ֽ��ϴ�!");
				}
				else {
					���ʸ���.outOfMap();
					break;
				}
				oneLine.pressEnter();
				
			}
			//�߸� �Է� ���� ��
			else {
				System.out.println();
				System.out.println("�ٽ� �Է����ּ���!");
				System.out.println();
			}
			
		} // ó�� �޴��� ���ư�!
		
		
		//��Ͻ�
		����.getOwned_PokeMon().add(new Charmander("���̸�" , 11));
		����.getOwned_PokeMon().add(new Charmander("���α�" , 14));
		����.getItembag().getPokeball().add(new PokeBall("���Ϻ�", 200));
		����.getItembag().getPokeball().add(new PokeBall("���Ϻ�", 200));
		����.getItembag().getPokeball().add(new PokeBall("���Ϻ�", 200));
		����.getItembag().getPokeball().add(new PokeBall("���Ϻ�", 200));
		����.getItembag().getPotion().add(new Potion("ȸ����", 300));
		
		
		while(true) {
			
			��Ͻ�.comeToMap(����);
			
			��Ͻ�.showMenu();
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.print("��ȣ �Է�: ");
			selected_menu_num = scanner.next();
			
			//1. �߻����ϸ��� ��ٸ���
			if(selected_menu_num.equals("1")) {
				
				System.out.println();
				System.out.println("��ٸ��� ��....");
				System.out.println();
				
				oneLine.pressEnter();
				// ��Ͻ� �ȿ� �ִ� ���͵��� ���ڸ� ������ ����
				int pokemon_num = ��Ͻ�.getAppearingPokeMon().size();
				// ���� ���ڸ� �޾Ƽ� ������ ����
				int randam_num = random.nextInt(pokemon_num);
				
				System.out.println(��Ͻ�.getAppearingPokeMon().get(randam_num).getName() + "�� ��Ÿ�����ϴ�!!!");
				
				������.comeToMap(����);
				������.comeToMap(��Ͻ�.getAppearingPokeMon().get(randam_num));
				
				while(true) {
					������.showBattleField();
					������.showMenu();
					
					selected_menu_num = scanner.next();
					
					//1. �ο��
					if(selected_menu_num.equals("1")) {
						
						������.fight();
						
					}
					//2. ���ϸ�
					else if(selected_menu_num.equals("2")) {
						
						while(true) {
							//������ ���ϸ� ����Ʈ�� �����ش�
							������.get����().showPokeMons();
							
							System.out.println("�� �� ���ϸ����� �ٲٽðڽ��ϱ�? (������: 0��)");
							System.out.print("��ȣ �Է�: ");
							selected_menu_num = scanner.next();
							
							//���찡 ������ �ִ� ���ϸ� ���� ���� ���ڸ� �Է� ���� ��
							if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num) <= ������.get����().getOwned_PokeMon().size()) {
								System.out.print("��� �� " + ������.getMyPokemon().getName() + "!! ");
								������.changePokemon(������.get����().getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1));
								
								System.out.println("���� " + ������.getMyPokemon().getName() + "!! ");
								break;
							}
							// 0�� �Է½�
							else if(selected_menu_num.equals("0")) {
								break;
							}
							else {
								System.out.println("�ٽ� �Է����ּ���!!");
							}
							
							
							
						}
						
						
					}
					// 3. ������ ����
					else if (selected_menu_num.equals("3")) {
						������.get����().showItemBag();
						System.out.println("� �������� ����Ͻðڽ��ϱ�?");
						System.out.print("��ȣ �Է�: ");
						selected_menu_num = scanner.next();
						
						// ���Ϻ� ���
						if(selected_menu_num.equals("1")) {
							
							//���찡 ���Ϻ��� ���� ��!
							if(������.get����().getItembag().getPokeball().size() != 0) {
								//���� ���ϸ��� ������ �� ���ϸ� ���� ���ڸ� ����
								int priorPokemonNum = ������.get����().getOwned_PokeMon().size();
								
								// ���찡 ���Ϻ��� �����
								������.get����().getItembag().getPokeball().remove(0).usePokeBall(������.get����(), ������.getOtherPokemon());
								
								// ���ϸ��� ����� ��� ���� ��������� ����
								if(������.get����().getOwned_PokeMon().size() == priorPokemonNum + 1) {
									break;
								}
								System.out.println();
							}
							else if(������.get����().getItembag().getPokeball().size() == 0) {
								
								System.out.println("���Ϻ��� �����ϴ�!");
								
							}
							
							
						}
						// ȸ���� ���
						else if (selected_menu_num.equals("2")) {
							
							//���찡 ȸ������ ���� ��!
							if(������.get����().getItembag().getPotion().size() != 0) {
								
								������.get����().getItembag().getPotion().remove(0).healPokeMon(������.get����().getOwned_PokeMon().get(0));
								
								
							}
							else if(������.get����().getItembag().getPotion().size() == 0) {
								
								System.out.println("ȸ������ �����ϴ�!!");
								
							}
							
							
						}
						
					}
					// 0. ��������
					else if (selected_menu_num.equals("0")) {
						System.out.println();
						System.out.println("���찡 ������ ���ϴ�!");
						System.out.println();
						break;
					}
					// �߸� �Է�������
					else {
						System.out.println();
						System.out.println("�ٽ� �Է����ּ���!");
						System.out.println();
					}
					
					// �����ϸ��� ü���� 0�϶�
					if(������.getMyPokemon().getHp() == 0) {
						System.out.println(������.getMyPokemon().getName() + "�� �����߽��ϴ�!");
						
						break;
					}
					// �߻����ϸ��� ü���� 0�϶�
					else if(������.getOtherPokemon().getHp() == 0) {
						
						System.out.println(������.getOtherPokemon().getName() + "�� �����߽��ϴ�!");
						
						System.out.println();
						
						//����ġ�� �ش�
						������.getMyPokemon().increaseExp(������.getOtherPokemon().getDrop_exp());
						
						//�������� ������
						������.outOfMap();
						
						break;
						
					}
					
				}
				
			}
			//2. Ʈ���̳ʿ� ��Ʋ�� �Ѵ�.
			else if(selected_menu_num.equals("2")) {
				
				int count = 0;
				gotoField:
				while(true) {
					
					��Ͻ�.showTrainers();
					
					System.out.println("��� Ʈ���̳ʿ� ����� �Ͻðڽ��ϱ�? (�ڷΰ���: 0��)");
					System.out.print("��ȣ �Է�: ");
					selected_menu_num = scanner.next();
					
					//1~3�� �Է½�!
					if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num)<= ��Ͻ�.getFieldTrainer().size()) {
						
						//Ʈ���̳ʰ� ������ ���� �� ��
						if(��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num)-1).isBattleAvailable() == true) {
							
							// ������ ����
							������.comeToMap(����);
							������.comeToMap(��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1));
							
							// ���� ����
							while(true) {
								������.showBattleField();
								������.showMenu();
								
								selected_menu_num = scanner.next();
								
								//1. �ο��
								if(selected_menu_num.equals("1")) {
									
									������.fight();
									
								}
								//2. ���ϸ�
								else if(selected_menu_num.equals("2")) {
									
									while(true) {
										//������ ���ϸ� ����Ʈ�� �����ش�
										������.get����().showPokeMons();
										
										System.out.println("�� �� ���ϸ����� �ٲٽðڽ��ϱ�? (������: 0��)");
										System.out.print("��ȣ �Է�: ");
										selected_menu_num = scanner.next();
										
										//���찡 ������ �ִ� ���ϸ� ���� ���� ���ڸ� �Է� ���� ��
										if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num) <= ������.get����().getOwned_PokeMon().size()) {
											System.out.print("��� �� " + ������.getMyPokemon().getName() + "!! ");
											������.changePokemon(������.get����().getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1));
											
											System.out.println("���� " + ������.getMyPokemon().getName() + "!! ");
											break;
										}
										// 0�� �Է½�
										else if(selected_menu_num.equals("0")) {
											break;
										}
										else {
											System.out.println("�ٽ� �Է����ּ���!!");
										}
										
										
										
									}
									
									
								}
								// 3. ������ ����
								else if (selected_menu_num.equals("3")) {
									������.get����().showItemBag();
									System.out.println("� �������� ����Ͻðڽ��ϱ�?");
									System.out.print("��ȣ �Է�: ");
									selected_menu_num = scanner.next();
									
									// ���Ϻ� ���
									if(selected_menu_num.equals("1")) {
									
										System.out.println("������ �ִ� ���ϸ��� ���� �� �����ϴ�!");
										
										
									}
									// ȸ���� ���
									else if (selected_menu_num.equals("2")) {
										
										//���찡 ȸ������ ���� ��!
										if(������.get����().getItembag().getPotion().size() != 0) {
											
											������.get����().getItembag().getPotion().remove(0).healPokeMon(������.get����().getOwned_PokeMon().get(0));
											
										}
										else if(������.get����().getItembag().getPotion().size() == 0) {
											
											System.out.println("ȸ������ �����ϴ�!!");
											
										}
										
										
									}
									
								}
								// 0. ��������
								else if (selected_menu_num.equals("0")) {
									System.out.println();
									System.out.println("���찡 ������ ���ϴ�!");
									System.out.println();
									break;
								}
								// �߸� �Է�������
								else {
									System.out.println();
									System.out.println("�ٽ� �Է����ּ���!");
									System.out.println();
								}
								
								// �����ϸ��� ü���� 0�϶�
								if(������.getMyPokemon().getHp() == 0) {
									System.out.println(������.getMyPokemon().getName() + "�� �����߽��ϴ�!");
									
									break;
								}
								// �߻����ϸ��� ü���� 0�϶�
								else if(������.getOtherPokemon().getHp() == 0) {
									
									
									System.out.println(������.getOtherPokemon().getName() + "�� �����߽��ϴ�!");
									
									System.out.println();
									
									//����ġ�� �ش�(Ʈ���̳ʿ� �ο�� �߰� ����ġ ȹ��)
									������.getMyPokemon().increaseExp(������.getOtherPokemon().getDrop_exp() + 20);
									
									// Ʈ���̳ʰ� ���ϸ��� ���� ���� ��
									if(count+1 < ������.getTrainer().getOwned_PokeMon().size()) {
										// ��� Ʈ���̳� ù��° ���ϸ� ����
										if (������.getTrainer().getOwned_PokeMon().get(count).getHp() == 0) {

											// ���� ���ϸ��� ����
											������.outOfMap(������.getTrainer().getOwned_PokeMon().get(count));
											
											count++;
											
											// �ٸ� ���ϸ��� ���������� ����
											������.comeToMap(������.getTrainer().getOwned_PokeMon().get(count));

										}
									}
									//Ʈ���̳ʰ� ���ϸ��� ���� ��
									else {

										System.out.println();
										System.out.println(������.getOtherPokemon().getName() + "���� �ºο��� �̰�� !");
										System.out.println();
										
										//Ʈ���̳ʰ� ���쿡�� ���� �ش�!
										System.out.println();
										������.getTrainer().giveMoney(������.get����());
										System.out.println();
										
										//Ʈ���̳ʰ� ���� �Ұ� ���·� �ٲ۴�
										������.getTrainer().setBattleAvailable(false);
										
										//�������� ������
										������.outOfMap();
										
										//��Ͻ� �޴��� �ٽ� ������
										break gotoField;
										
									}
									
								}
								
							}
						
						}
						//Ʈ���̳ʰ� ������ �Ұ��� �� ��
						else {
							
							System.out.println(��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1).getName() + "�ʹ� �ο� �� �����ϴ�!");
							
						}
						
						
					}
					//0�� �ڷΰ���
					else if(selected_menu_num.equals("0")) {
						break;
					}
					//�߸� �Է½�!
					else {
						System.out.println();
						System.out.println("�ٽ��Է����ּ���!");
						System.out.println();
					}
					
				}
				
			}
			// 3. �������� �ݴ´�.
			else if (selected_menu_num.equals("3")) {

			}
			// 4. ������ ���¸� ����
			else if (selected_menu_num.equals("4")) {
				
				while(true) {
					
					����.showMenu();
					System.out.println("������ ���ðڽ��ϱ�?");
					System.out.print("��ȣ �Է�: ");
					selected_menu_num = scanner.next();
					
					//1. ������ �⺻����
					if(selected_menu_num.equals("1")) {
						����.showInformation();
						System.out.print("������(�ƹ�Ű���Է�)");
						scanner.next();
					}
					
					//2. ������ ���ϸ��
					else if (selected_menu_num.equals("2")) {
						����.showPokeMons();
						����.showPokemonDetail();
						System.out.print("������(�ƹ�Ű���Է�)");
						scanner.next();
					}
					
					//3. ������ �����۰���
					else if (selected_menu_num.equals("3")) {
						����.showItemBag();
						System.out.print("������(�ƹ�Ű���Է�)");
						scanner.next();
					}
					
					//0. �ڷΰ���
					else if (selected_menu_num.equals("0")) {
						break;
					}
					
				}

			}
			// 0. ���� �̵��Ѵ�.
			else if (selected_menu_num.equals("0")) {

			}
			//�߸� ������ ��
			else {
				System.out.println();
				System.out.println("�ٽ� �Է����ּ���!");
				System.out.println();
			}
		}
	}

}
