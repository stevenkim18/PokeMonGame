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

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import characters.Dr_OH;
import characters.MainCharacter;
import function.Ending;
import function.Music;
import function.OneLine;
import map.Battlefield;
import map.City;
import map.Village;
import map.ViridianForest;
import pokemon.Charmander;
import thread.AutoAttackThread;
import thread.AutoBattleThread;
import thread.CountSecondThread;
import thread.ItemThread;
import thread.LoadingThread;
import thread.LogoThread;
import thread.PrintOnebyoneThread;
import thread.RainThread;
import thread.RecoverPokemonThread;
import thread.WaitingPokemonThread;

public class PokeMon_Game {

	public static void main(String[] args) throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// ���� ����
		String selected_menu_num; // �Է� ���� ����
		String second_selected_menu_num; // �Է� ���� ������ 2���� ��� ���� ���� ����!
		OneLine oneLine = new OneLine(); // ������ ��� ���͸� �Է¹ޱ� ���� ��ü

		// ���ڻ� ��ü ����
		Dr_OH ���ڻ� = new Dr_OH("���ڻ�", "���ʸ���");

		// ���� ��ü ����
		MainCharacter ���� = new MainCharacter("����");
		
		// ������� ��ü ����
		Music introMusic = new Music("������.mp3", true);
		Music Dr_ohMusic = new Music("���ڻ�.mp3", true);
	
		// �� ��ü ����
		Village ���ʸ��� = new Village("���ʸ���");
		ViridianForest ��Ͻ� = new ViridianForest("��Ͻ�");
		City ȸ����Ƽ = new City("ȸ����Ƽ");

		Battlefield ������ = new Battlefield("������");
		
		//������ ���� ����
		introMusic.start();
		
		//�ΰ� ������ ����
		LogoThread logoThread = new LogoThread();
		logoThread.start();
		logoThread.join();
		
		oneLine.pressEnter();
		
		// ���� ����!
		

		//������ ���� ����
		introMusic.close();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		LoadingThread loadingThread = new LoadingThread();
		loadingThread.start();
		loadingThread.join();

		//���ڻ� ���� ����
		Dr_ohMusic.start();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		// <���ڻ� ������>
		// [start]
		// ���ڻ� ������ ��縦 ��
		// ���ʴ�� ��簡 ����
		// Enter�� ������ ���� ���� �Ѿ
		for (int i = 0; i < 11; i++) {
		
			Thread onebyoneThread = new Thread(new PrintOnebyoneThread(���ڻ�.getDialogue().get(i)));
			onebyoneThread.start();
			
			// "���� �̸��� ����?" ���� �̸��� ������� ��
			if (i == 7) {
				System.out.println("\n\n");
				String name = "����"; // scanner.next();
				����.setName(name);
				System.out.println(����.getName() + "!!");
				System.out.println("\n\n");
			}
			System.out.println();
			oneLine.pressEnter();
		}

		// [end]
		
		//���ڻ� ���� ����
		Dr_ohMusic.close();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("���ʸ����� �̵��մϴ�....");
		System.out.println();

		LoadingThread loadingThread1 = new LoadingThread();
		loadingThread1.start();
		loadingThread1.join();

		// ���ʸ����� ���ڻ簡 ����
		���ʸ���.setDr_oh(���ڻ�);
		
		String map_num = "1";
		
		Opening:
		while (true) {
			
			
			// ���ʸ���
			if(map_num.equals("1")) {
				
				//���ʸ��� ����
				Music villageMusic = new Music("���ʸ���.mp3", true);
				villageMusic.start();
				
				// ���ʸ����� ���� ����
				���ʸ���.comeToMap(����);
				
				while (true) {

					���ʸ���.showMenu();
					System.out.println("������ �Ͻðڽ��ϱ�?");
					System.out.print("��ȣ �Է�: ");
					selected_menu_num = scanner.next();
					Music buttonSound = new Music("��ư��.mp3", false);
					buttonSound.start();

					// 1. ���ڻ翡�� ���� �Ǵ�
					if (selected_menu_num.equals("1")) {

						// ���찡 ���ϸ��� ������ ���� ������
						if (����.getOwned_PokeMon().size() == 0) {
							
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							
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

							// ���찡 ���ϸ� ����
							while (true) {
								���ڻ�.showPokeMon();
								System.out.println("�� �� ���ϸ��� �����ðڽ��ϱ�?");
								System.out.print("��ȣ �Է� : ");
								selected_menu_num = scanner.next();
								Music buttonSound1 = new Music("��ư��.mp3", false);
								buttonSound1.start();

								// 1~3�� �Է� ���� ��
								if (selected_menu_num.equals("1") || selected_menu_num.equals("2")
										|| selected_menu_num.equals("3")) {

									System.out.println(
											���ڻ�.getOwned_PokeMon().get(Integer.parseInt(selected_menu_num) - 1).getName()
													+ "�� �����ϼ̽��ϴ�!");
									
									���ڻ�.getOwned_PokeMon().get(Integer.parseInt(selected_menu_num) - 1).showPicture();
									

									System.out.println();
									System.out.println("������ �����ðڽ��ϱ�?");
									System.out.println("1.�� 2.�ƴϿ�");
									System.out.print("��ȣ �Է� : ");
									second_selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();
									System.out.println();

									// 1.��
									if (second_selected_menu_num.equals("1")) {

										// ���ڻ� ���ϸ� ����Ʈ�� �ִ� ���õ� ���ϸ���
										// ������ ���ϸ� ����Ʈ�� �̵��Ѵ�
										����.getPokeMon(���ڻ�.givePokeMon(Integer.parseInt(selected_menu_num)));

										oneLine.pressEnter();
										
										Thread.sleep(1000);
										
										System.out.println(
												"����� ���ڻ翡�Է� ���� " + ����.getOwned_PokeMon().get(0).getName() + "�� �޾Ҵ�!!");
										oneLine.pressEnter();

										���ڻ�.sayDialogue(15);
										oneLine.pressEnter();

										break;

									}
									// 2.�ƴϿ�
									else {

									}

								}
								// �߸� �Է����� ��
								else {
									System.out.println();
									System.out.println("�߸� �Է��ϼ̽��ϴ�!");
									System.out.println("1~3���� �Է����ּ���!!");
									oneLine.pressEnter();
								}

							}

						}
						// ���찡 ���ϸ��� ������ ���� ��
						else {

							// ���ڻ� ���Ϻ��� ������ ���� ��
							if (���ڻ�.getOwned_PokeBall().size() != 0) {
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								// ���찡 ���ϸ��� �ް� �ٽ� ���ڻ翡�� ���ϸ� ���Ϻ��� �ش�!
								oneLine.pressEnter();
								���ڻ�.sayDialogue(16);
								oneLine.pressEnter();

								// ���찡 ���ڻ翡�Է� ���� ���Ϻ� 5���� �޴´�.
								for (int i = 0; i < 5; i++) {
									����.receiveItem(���ڻ�.givePokeBall());
								}
								
								Thread.sleep(1000);
								
								System.out.println("���ڻ翡�� ���Ϻ� 5���� �޾ҽ��ϴ�!");
								oneLine.pressEnter();

								���ڻ�.sayDialogue(17);
								oneLine.pressEnter();

								���ڻ�.sayDialogue(18);
								oneLine.pressEnter();
							}
							// ���ڻ� ���쿡�� ���Ϻ��� �ְ� �Ѱ� ���� ��
							else if (���ڻ�.getOwned_PokeBall().size() == 0) {

								scanner.nextLine();
								���ڻ�.sayDialogue(18);
								scanner.nextLine();

							}

						}

					}
					// 2. �������� ���� �Ǵ�
					else if (selected_menu_num.equals("2")) {
						
						System.out.println();
						
						// ���찡 ���ϸ��� ���� ��
						if (����.getOwned_PokeMon().size() == 0) {
							���ʸ���.getMom().sayDialogue(0);
							oneLine.pressEnter();
						}
						// ���찡 ���ϸ��� ���� ��
						else if (����.getOwned_PokeMon().size() >= 1) {

							// ó�� ������ ���� �ٶ�(���� ���� 3000�� ���� ��)
							if (���ʸ���.getMom().getMoney() == 3000) {
								
								���ʸ���.getMom().sayDialogue(1);
								
								oneLine.pressEnter();
								
								Thread.sleep(1000);
								// ������ ���쿡�� 3000���� �ش�
								����.receiveMoney(���ʸ���.getMom().giveMoney(3000));

								oneLine.pressEnter();
								���ʸ���.getMom().sayDialogue(2);

								oneLine.pressEnter();
								���ʸ���.getMom().sayDialogue(3);

								oneLine.pressEnter();

							}
							// ������ ���� �ְ� ����
							// ������ �⺻ ����� �Ҷ�(���ϸ� ȸ��, ���� ����� ���)
							else {
								oneLine.pressEnter();
								���ʸ���.getMom().sayDialogue(4);
								oneLine.pressEnter();
								
								while (true) {
									
									���ʸ���.getMom().showMomsMenu();
									System.out.println("������ �Ͻðڽ��ϱ�?");
									System.out.print("��ȣ�Է�: ");
									selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();
									

									// 1.���ϸ� ȸ��
									if (selected_menu_num.equals("1")) {
										System.out.println();
										System.out.println("������ ���ϸ���� �������� �ñ��!");
										System.out.println();
										
										oneLine.pressEnter();
										
										RecoverPokemonThread recoverPokemonThread = new RecoverPokemonThread();
										recoverPokemonThread.start();
										recoverPokemonThread.join();
										
										for (int i = 0; i < ����.getOwned_PokeMon().size(); i++) {
											���ʸ���.getMom().healPokeMon(����.getOwned_PokeMon().get(i));
										}
										
										oneLine.pressEnter();

									}
									// 2.���� ã�´�
									else if (selected_menu_num.equals("2")) {

										while (true) {
											
											try {
												���ʸ���.showAccount(����);
												System.out.println("�󸶸� ã���ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t    (�ڷΰ��� : 0�� �Է�)");
												System.out.print("�ݾ� �Է�: ");
												String money = scanner.next();
												Music buttonSound3 = new Music("��ư��.mp3", false);
												buttonSound3.start();

												// 0 �Է� �� �ڷΰ���
												if (money.equals("0")) {
													break;
												}
												// �ݾ� �Է½�
												else if(Integer.parseInt(money) >= 0 && Integer.parseInt(money) <= ���ʸ���.getMom().getMoney()){
													System.out.println();
													// �Է��� �ݾ� ��ŭ ���쿡�� ���� �ش�
													����.setMoney(����.getMoney() + ���ʸ���.getMom().giveMoney(Integer.parseInt(money)));
													
													System.out.println();
													System.out.println("���찡 " + money + "���� ã�ҽ��ϴ�!");
													oneLine.pressEnter();
													
												}
												else {
													System.out.println();
													System.out.println("�ݾ��� �ʰ��Ͽ����ϴ�!");
													oneLine.pressEnter();

												}
												
											} catch (NumberFormatException e) {
												System.out.println();
												System.out.println("���ڸ� �Է��� �ּ���!");
												oneLine.pressEnter();

											}
											
										}

									}
									// 3.���� �ñ��
									else if (selected_menu_num.equals("3")) {

										while (true) {
											try {
												���ʸ���.showAccount(����);
												System.out.println("�󸶸� �ñ�ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t    (�ڷΰ��� : 0�� �Է�)");
												System.out.print("�ݾ� �Է�: ");
												String money = scanner.next();
												Music buttonSound3 = new Music("��ư��.mp3", false);
												buttonSound3.start();

												// 0 �Է� �� �ڷΰ���
												if (money.equals("0")) {
													break;
												}
												// �ݾ� �Է½�
												else if(Integer.parseInt(money) >= 0 && Integer.parseInt(money) <= ����.getMoney()) {
													// �Է��� �ݾ� ��ŭ ���찡 �������� ���� �ñ��
													���ʸ���.getMom().receiveMoney(����.giveMoney(Integer.parseInt(money)));
													System.out.println();
													System.out.println(����.getName() +"�� �������� " + money + "���� �ð���ϴ�!");
													oneLine.pressEnter();
												}
												else {
													System.out.println();
													System.out.println("�ݾ��� �ʰ��Ͽ����ϴ�!");
													
													oneLine.pressEnter();
												}
												
											} catch (NumberFormatException e) {
												System.out.println();
												System.out.println("���ڸ� �Է��� �ּ���!");
		
												oneLine.pressEnter();
											}
											
											
										}

									}
									// 0.�׸� ��ȭ�ϱ�
									else if (selected_menu_num.equals("0")) {
										break;
									}
									// �߸� �Է� ���� ��
									else {
										System.out.println();
										System.out.println("�ٽ� �Է����ּ���!");
										oneLine.pressEnter();
									}
								}

							}

						}

					}
					// 3. ������ ���¸� ����
					else if (selected_menu_num.equals("3")) {

						while (true) {

							����.showMenu();
							System.out.println("������ ���ðڽ��ϱ�?");
							System.out.print("��ȣ �Է�: ");
							selected_menu_num = scanner.next();
							Music buttonSound3 = new Music("��ư��.mp3", false);
							buttonSound3.start();

							// 1. ������ �⺻����
							if (selected_menu_num.equals("1")) {
								����.showInformation();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
								scanner.next();
								Music buttonSound4 = new Music("��ư��.mp3", false);
								buttonSound4.start();
							}

							// 2. ������ ���ϸ��
							else if (selected_menu_num.equals("2")) {
								����.showPokeMons();
								����.showPokemonDetail();
//								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
//								scanner.next();
							}

							// 3. ������ �����۰���
							else if (selected_menu_num.equals("3")) {
								����.showItemBag();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
								scanner.next();
								Music buttonSound4 = new Music("��ư��.mp3", false);
								buttonSound4.start();
							}

							// 0. �ڷΰ���
							else if (selected_menu_num.equals("0")) {
								break;
							}
							//�߸� �Է½�
							else {
								System.out.println();
								System.out.println("�ٽ� �Է����ּ���!");
								oneLine.pressEnter();
							}

						}

					}
					// 0. ���� �̵��Ѵ�.
					else if (selected_menu_num.equals("0")) {
						
						// ���찡 ���ϸ��� �Ѹ����� ������ ���� ���� ����
						// ���ʸ��� ��� �� ����.
						if (����.getOwned_PokeMon().size() == 0) {
							System.out.println();
							System.out.println("���쿡�Դ� ���ϸ��� �����ϴ�!!");
							System.out.println("���ڻ翡�� ���� ���ϸ��� ���� �� �ֽ��ϴ�!");
							oneLine.pressEnter();
						} else {
							
							���ʸ���.showOtherMap();
							System.out.println("���� ���ðڽ��ϱ�?");
							System.out.print("��ȣ�̵�: ");
							map_num = scanner.next();
							Music buttonSound4 = new Music("��ư��.mp3", false);
							buttonSound4.start();
							
							if(map_num.equals("2")) {
								
								���ʸ���.outOfMap();
								
								//���ʸ��� ���� ����
								villageMusic.close();
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								System.out.println();
								System.out.println("��Ͻ����� �̵��մϴ�....");
								System.out.println();
								LoadingThread loadingThread2 = new LoadingThread();
								loadingThread2.start();
								loadingThread2.join();

								break;
							}
							else if (map_num.equals("3")) {
								System.out.println();
								System.out.println("��Ͻ��� ������ �� �� �ֽ��ϴ�!");
								oneLine.pressEnter();
							}
							else {
								System.out.println();
								System.out.println("�ٽ� �Է����ּ���!");
								oneLine.pressEnter();
							}
							
						}

					}
					else if(selected_menu_num.equals("�����ڸ��")) {
						System.out.println("������ ��尡 ����˴ϴ�!");
						System.out.println();
						����.getOwned_PokeMon().remove(0);
						����.getOwned_PokeMon().add(new Charmander("���̸�", 15));
						System.out.println(����.getOwned_PokeMon().get(0).getName() + "�� ������ 15�� �Ǿ����ϴ�!");
						oneLine.pressEnter();
					}
					// �߸� �Է� ���� ��
					else {
						System.out.println();
						System.out.println("�ٽ� �Է����ּ���!");
						oneLine.pressEnter();
					}

				}
				
			}
			
			// ��Ͻ�
			else if(map_num.equals("2")) {
				
				//�� ���� ����!! true�̸� ���� �Ű� false�̸� �ȿ�!
				//boolean random_weather = random.nextBoolean();
				
				gotoForest:
				do {
					// ��Ͻ� ���� ����
					Music forestMusic = new Music("��Ͻ�.mp3", true);
					forestMusic.start();
					
					// ��Ҹ� ��ü ����
					//Music rainSound = new Music("��Ҹ�.mp3", true);
					
					// true�̸� ����� �Ҹ� ƴ
					//if(random_weather) {
					//	rainSound.start();
					//}
					
					��Ͻ�.comeToMap(����);

//					RainThread rainThread = new RainThread(����, ��Ͻ�);
//					rainThread.start();
					while(true) {
						��Ͻ�.showMenu();
						//if(random_weather) {
						//	System.out.println("�� ���� ���Դϴ�!!");
						//}
						System.out.println("������ �Ͻðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t  (�ڵ����� : 11��)");
						System.out.print("��ȣ �Է�: ");
						selected_menu_num = scanner.next();
						Music buttonSound4 = new Music("��ư��.mp3", false);
						buttonSound4.start();

						// 1. �߻����ϸ��� ��ٸ���
						if (selected_menu_num.equals("1")) {

//							rainThread.close();
							
							Thread waitingPokemonThread = new WaitingPokemonThread();
							waitingPokemonThread.start();
							waitingPokemonThread.join();

							// ��Ͻ� ���� ����
							forestMusic.close();
							
							// �߻����ϸ� �Ⱦ� ����
							Music wildMusic = new Music("�߻����ϸ�.mp3", true);
							wildMusic.start();

							Thread.sleep(1000);

							// ��Ͻ� �ȿ� �ִ� ���͵��� ���ڸ� ������ ����
							int pokemon_num = ��Ͻ�.getAppearingPokeMon().size();
							// ���� ���ڸ� �޾Ƽ� ������ ����
							int randam_num = random.nextInt(pokemon_num);

							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

							System.out.println(��Ͻ�.getAppearingPokeMon().get(randam_num).getName() + "�� ��Ÿ�����ϴ�!!!");
							��Ͻ�.getAppearingPokeMon().get(randam_num).showPicture();
							
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							
							������.comeToMap(����);
							������.comeToMap(��Ͻ�.getAppearingPokeMon().get(randam_num));
							
							//��� ���ϸ� �ڵ� ����!
							AutoAttackThread attackThread = new AutoAttackThread(������, ������.getMyPokemon(), ������.getOtherPokemon());
							attackThread.start();

							while (true) {
								������.showBattleField();
								������.showMenu();
								
								selected_menu_num = scanner.next();
								Music buttonSound5 = new Music("��ư��.mp3", false);
								buttonSound5.start();
								
								attackThread.close();
								
								
								// 1. �ο��
								if (selected_menu_num.equals("1")) {

									������.fight();

								}
								// 2. ���ϸ�
								else if (selected_menu_num.equals("2")) {

									while (true) {
										// ������ ���ϸ� ����Ʈ�� �����ش�
										������.get����().showPokeMons();

										System.out.println("�� �� ���ϸ����� �ٲٽðڽ��ϱ�? (������: 0��)");
										System.out.print("��ȣ �Է�: ");
										selected_menu_num = scanner.next();
										Music buttonSound6 = new Music("��ư��.mp3", false);
										buttonSound6.start();
										
										// ���찡 ������ �ִ� ���ϸ� ���� ���� ���ڸ� �Է� ���� ��
										if (Integer.parseInt(selected_menu_num) >= 1 && Integer
												.parseInt(selected_menu_num) <= ������.get����().getOwned_PokeMon().size()) {
											
											//�����忡 �ִ� ���ϸ�� �ٲٷ��� �ϴ� ���ϸ��� �̸��� �ٸ� ��
											if(������.getMyPokemon().getName() != ������.get����().getOwned_PokeMon()
													.get(Integer.parseInt(selected_menu_num) - 1).getName()) {
												
												
												System.out.print("��� �� " + ������.getMyPokemon().getName() + "!! ");

												Thread.sleep(1000);

												������.changePokemon(������.get����().getOwned_PokeMon()
														.get(Integer.parseInt(selected_menu_num) - 1));

												System.out.println("���� " + ������.getMyPokemon().getName() + "!! ");

												������.getMyPokemon().showPicture();

												break;
											}
											else {
												System.out.println();
												System.out.println(������.getMyPokemon().getName() + "�� �̹� �������Դϴ�!!");
												oneLine.pressEnter();
											}

											
										}
										// 0�� �Է½�
										else if (selected_menu_num.equals("0")) {
											break;
										} else {
											System.out.println();
											System.out.println("�ٽ� �Է����ּ���!!");
											oneLine.pressEnter();
										}

									}

								}
								// 3. ������ ����
								else if (selected_menu_num.equals("3")) {
									������.get����().showItemBag();
									System.out.println("� �������� ����Ͻðڽ��ϱ�?");
									System.out.print("��ȣ �Է�: ");
									selected_menu_num = scanner.next();
									Music buttonSound7 = new Music("��ư��.mp3", false);
									buttonSound7.start();

									// ���Ϻ� ���
									if (selected_menu_num.equals("1")) {

										// ���찡 ���Ϻ��� ���� ��!
										if (������.get����().getItembag().getPokeball().size() != 0) {
											// ���� ���ϸ��� ������ �� ���ϸ� ���� ���ڸ� ����
											int priorPokemonNum = ������.get����().getOwned_PokeMon().size();

											// ���찡 ���Ϻ��� �����
											������.get����().getItembag().getPokeball().remove(0).usePokeBall(������.get����(),
													������.getOtherPokemon());

											// ���ϸ��� ����� ��� ���� ��������� ����
											if (������.get����().getOwned_PokeMon().size() == priorPokemonNum + 1) {
												
												��Ͻ�.getAppearingPokeMon().remove(randam_num);
												
												wildMusic.close();
												
												break gotoForest;
											}
											System.out.println();
										} else if (������.get����().getItembag().getPokeball().size() == 0) {
											System.out.println();
											System.out.println("���Ϻ��� �����ϴ�!");
											oneLine.pressEnter();
										}

									}
									// ȸ���� ���
									else if (selected_menu_num.equals("2")) {

										// ���찡 ȸ������ ���� ��!
										if (������.get����().getItembag().getPotion().size() != 0) {

											//���� �Դ¼Ҹ�!
											Music potionSound = new Music("����.mp3", false);
											potionSound.start();
											
											������.get����().getItembag().getPotion().remove(0)
													.healPokeMon(������.get����().getOwned_PokeMon().get(0));

										} else if (������.get����().getItembag().getPotion().size() == 0) {
											System.out.println();
											System.out.println("ȸ������ �����ϴ�!!");
											oneLine.pressEnter();
										}

									}

								}
								// 0. ��������
								else if (selected_menu_num.equals("0")) {
									System.out.println();
									System.out.println("���찡 ������ ���ϴ�!");
									oneLine.pressEnter();
									// �߻� ���ϸ� ���� ����
									wildMusic.close();

									// ��Ͻ� ���� Ʋ�� ���ؼ� do-while������ ��!
									break gotoForest;
								}
								// �߸� �Է�������
								else {
									System.out.println();
									System.out.println("�ٽ� �Է����ּ���!");
									oneLine.pressEnter();
								}

								// �����ϸ��� ü���� 0�϶�
								if (������.getMyPokemon().getHp() == 0) {
									System.out.println(������.getMyPokemon().getName() + "�� �����߽��ϴ�!");

									break;
								}
								// �߻����ϸ��� ü���� 0�϶�
								else if (������.getOtherPokemon().getHp() == 0) {
									
									// �߻� ���ϸ� ���� ����
									wildMusic.close();
									
									// �߻� ���ϸ� �¸� ���ǽ���
									Music wildVictoy = new Music("�߻����ϸ�¸�.mp3", false);
									wildVictoy.start();

									������.showBattleField();
									System.out.println(������.getOtherPokemon().getName() + "�� �����߽��ϴ�!");

									oneLine.pressEnter();

									System.out.println();

									// ����ġ�� �ش�
									������.getMyPokemon().increaseExp(������.getOtherPokemon().getDrop_exp());

									Thread.sleep(1000);

									// ������ ���� ���� �Ǽ� �ٽ� ����Ʈ�� �����!
									������.getOtherPokemon().levelUp(������.getOtherPokemon().getLevel());

									// �������� ������
									������.outOfMap();

									System.out.println();
									System.out.println("��Ͻ����� �̵��Ͻ÷��� �ƹ�Ű�� �Է����ּ���!");

									oneLine.pressEnter();
									
									// �߻� ���ϸ� �¸� ���� ����
									wildVictoy.close();
									
									// ��Ͻ� ���� Ʋ�� ���ؼ� do-while������ ��!
									break gotoForest;

								}

							}

						}
						// 2. Ʈ���̳ʿ� ��Ʋ�� �Ѵ�.
						else if (selected_menu_num.equals("2")) {
							
							//�ο� Ʈ���̳� ���ڸ� ��� ����
							//Ʈ���̳ʸ� �̱�� count�� 1����!
							int count = 0;
							
							while (true) {

								��Ͻ�.showTrainers();

								System.out.println("��� Ʈ���̳ʿ� ����� �Ͻðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t(�ڷΰ���: 0��)");
								System.out.print("��ȣ �Է�: ");
								selected_menu_num = scanner.next();
								Music buttonSound5 = new Music("��ư��.mp3", false);
								buttonSound5.start();

								// 1~3�� �Է½�!
								if (Integer.parseInt(selected_menu_num) >= 1
										&& Integer.parseInt(selected_menu_num) <= ��Ͻ�.getFieldTrainer().size()) {

									// Ʈ���̳ʰ� ������ ���� �� ��
									if (��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1)
											.isBattleAvailable() == true) {

										// ��Ͻ� ���� ����
										forestMusic.close();

										// Ʈ���̳� ���� ����
										Music trainerMusic = new Music("Ʈ���̳�.mp3", true);
										trainerMusic.start();
										
										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										
										// ������ ����
										������.comeToMap(����);
										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										������.comeToMap(��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1));
										
										// ��� Ʈ���̳� ���ϸ� ���� ������!
										��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1).getOwned_PokeMon().get(0).showPicture();

										//��� ���ϸ� �ڵ� ����!
										AutoAttackThread attackThread = new AutoAttackThread(������, ������.getMyPokemon(), ������.getOtherPokemon());
										attackThread.start();
										
										// ���� ����
										while (true) {

											������.showBattleField();
											������.showMenu();

											selected_menu_num = scanner.next();
											Music buttonSound6 = new Music("��ư��.mp3", false);
											buttonSound6.start();
											
											attackThread.close();

											// 1. �ο��
											if (selected_menu_num.equals("1")) {

												������.fight();

											}
											// 2. ���ϸ�
											else if (selected_menu_num.equals("2")) {

												while (true) {
													// ������ ���ϸ� ����Ʈ�� �����ش�
													������.get����().showPokeMons();

													System.out.println("�� �� ���ϸ����� �ٲٽðڽ��ϱ�? (������: 0��)");
													System.out.print("��ȣ �Է�: ");
													selected_menu_num = scanner.next();
													Music buttonSound7 = new Music("��ư��.mp3", false);
													buttonSound7.start();
													
													// ���찡 ������ �ִ� ���ϸ� ���� ���� ���ڸ� �Է� ���� ��
													if (Integer.parseInt(selected_menu_num) >= 1 && Integer
															.parseInt(selected_menu_num) <= ������.get����().getOwned_PokeMon().size()) {
														
														//�����忡 �ִ� ���ϸ�� �ٲٷ��� �ϴ� ���ϸ��� �̸��� �ٸ� ��
														if(������.getMyPokemon().getName() != ������.get����().getOwned_PokeMon()
																.get(Integer.parseInt(selected_menu_num) - 1).getName()) {
															
															
															System.out.print("��� �� " + ������.getMyPokemon().getName() + "!! ");

															Thread.sleep(1000);

															������.changePokemon(������.get����().getOwned_PokeMon()
																	.get(Integer.parseInt(selected_menu_num) - 1));

															System.out.println("���� " + ������.getMyPokemon().getName() + "!! ");

															������.getMyPokemon().showPicture();

															break;
														}
														else {
															System.out.println();
															System.out.println(������.getMyPokemon().getName() + "�� �̹� �������Դϴ�!!");
															oneLine.pressEnter();
														}

														
													}
													// 0�� �Է½�
													else if (selected_menu_num.equals("0")) {
														break;
													} else {
														System.out.println();
														System.out.println("�ٽ� �Է����ּ���!!");
														oneLine.pressEnter();
													}

												}

											}
											// 3. ������ ����
											else if (selected_menu_num.equals("3")) {
												������.get����().showItemBag();
												System.out.println("� �������� ����Ͻðڽ��ϱ�?");
												System.out.print("��ȣ �Է�: ");
												selected_menu_num = scanner.next();
												Music buttonSound7 = new Music("��ư��.mp3", false);
												buttonSound7.start();

												// ���Ϻ� ���
												if (selected_menu_num.equals("1")) {

													System.out.println("������ �ִ� ���ϸ��� ���� �� �����ϴ�!");
													oneLine.pressEnter();

												}
												// ȸ���� ���
												else if (selected_menu_num.equals("2")) {

													// ���찡 ȸ������ ���� ��!
													if (������.get����().getItembag().getPotion().size() != 0) {

														������.get����().getItembag().getPotion().remove(0)
																.healPokeMon(������.get����().getOwned_PokeMon().get(0));

													} else if (������.get����().getItembag().getPotion().size() == 0) {

														System.out.println("ȸ������ �����ϴ�!!");
														oneLine.pressEnter();

													}

												}

											}
											// 0. ��������
											else if (selected_menu_num.equals("0")) {
												System.out.println();
												System.out.println("Ʈ���̳ʿ� �����߿��� ���� �� �� �����ϴ�!");
												oneLine.pressEnter();
											}
											// �߸� �Է�������
											else {
												System.out.println();
												System.out.println("�ٽ� �Է����ּ���!");
												oneLine.pressEnter();
											}

											// �����ϸ��� ü���� 0�϶�
											if (������.getMyPokemon().getHp() == 0) {
												System.out.println(������.getMyPokemon().getName() + "�� �����߽��ϴ�!");

												break;
											}
											// �߻����ϸ��� ü���� 0�϶�
											else if (������.getOtherPokemon().getHp() == 0) {
												
												������.showBattleField();
												System.out.println(������.getOtherPokemon().getName() + "�� �����߽��ϴ�!");
												
												oneLine.pressEnter();
												// ����ġ�� �ش�(Ʈ���̳ʿ� �ο�� �߰� ����ġ ȹ��)
												������.getMyPokemon().increaseExp(������.getOtherPokemon().getDrop_exp() + 20);
												
												oneLine.pressEnter();

												// Ʈ���̳ʰ� ���ϸ��� ���� ���� ��
												if (count + 1 < ������.getTrainer().getOwned_PokeMon().size()) {
													// ��� Ʈ���̳� ù��° ���ϸ� ����
													if (������.getTrainer().getOwned_PokeMon().get(count).getHp() == 0) {
														
														System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
														
														System.out.println(������.getTrainer().getName() + ": " + "�̷�.. ����!" + ������.getOtherPokemon().getName());
														
														// ���� ���ϸ��� ����
														������.outOfMap(������.getTrainer().getOwned_PokeMon().get(count));
														
														count++;
														
														// �ٸ� ���ϸ��� ���������� ����
														������.comeToMap(������.getTrainer().getOwned_PokeMon().get(count));
														
														System.out.println();
														
														System.out.println(������.getTrainer().getName() + ": " + "����! " + ������.getOtherPokemon().getName());
														
														// ���ο� ���ϸ� ������ ������!
														������.getOtherPokemon().showPicture();
														
													}

												}
												// Ʈ���̳ʰ� ���ϸ��� ���� ��
												else {
													
													//Ʈ���̳� ���� ����
													trainerMusic.close();
													
													//Ʈ���̳� �¸� ���� ����
													Music trainerVictory = new Music("Ʈ���̳ʽ¸�.mp3", false);
													trainerVictory.start();
													
													oneLine.pressEnter();
													
													System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													System.out.println(������.getTrainer().getName() + "���� �ºο��� �̰�� !");
													System.out.println();

													oneLine.pressEnter();
													
													// Ʈ���̳ʰ� ���쿡�� ���� �ش�!
													System.out.println();
													������.getTrainer().giveMoney(������.get����());
													System.out.println();

													// Ʈ���̳ʰ� ���� �Ұ� ���·� �ٲ۴�
													������.getTrainer().setBattleAvailable(false);

													// �������� ������
													������.outOfMap();
													
													System.out.println("��Ͻ����� �̵��Ͻ÷��� �ƹ�Ű�� �Է����ּ���!");

													oneLine.pressEnter();

													//Ʈ���̳� �¸� ���� ����!
													trainerVictory.close();

													// ��Ͻ� �޴��� �ٽ� ������
													break gotoForest;

												}

											}

										}

									}
									// Ʈ���̳ʰ� ������ �Ұ��� �� ��
									else {

										System.out.println(
												��Ͻ�.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1).getName()
														+ "�ʹ� �ο� �� �����ϴ�!");

									}

								}
								// 0�� �ڷΰ���
								else if (selected_menu_num.equals("0")) {

									break;
								}
								// �߸� �Է½�!
								else {
									System.out.println();
									System.out.println("�ٽ��Է����ּ���!");
									oneLine.pressEnter();
								}

							}

						}
						// 3. �������� �ݴ´�.
						else if (selected_menu_num.equals("3")) {


							while (true) {

								��Ͻ�.showItems();

								System.out.println("��� �������� �����ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t\t (�ڷΰ��� : 0��)");
								System.out.print("��ȣ �Է�: ");
								
								try {

									selected_menu_num = scanner.next();
									Music buttonSound = new Music("��ư��.mp3", false);
									buttonSound.start();

									// 1������ ������ �ִ� �ִ� ������ ��ȣ������ �Է� ���� ��!
									if (Integer.parseInt(selected_menu_num) >= 1
											&& Integer.parseInt(selected_menu_num) <= ��Ͻ�.getDroppedItem().size()) {

										// ���� ���ڸ� �����ϴ� ����
										int count = 0;

										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

										System.out.println("5�� ���� 1~9�� ������ �������� ������ �Ѱ��� ���ڸ� �Ȱ��� 5�� �̻� �Է� �ϸ� �������� ȹ���Ͻ� �� �ֽ��ϴ�!");
										System.out.print("���� �Ͻ÷��� �ƹ�Ű�� �Է����ּ���!!");
										scanner.next();
										Music buttonSound1 = new Music("��ư��.mp3", false);
										buttonSound1.start();

										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										System.out.println("����!!");
										System.out.println();

										// �ð� �������ִ� ������ ��ü ����(5�ʱ��� ī��Ʈ)
										CountSecondThread itemThread = new CountSecondThread(5);
										itemThread.start();
										itemThread.join();

										// ���� ����!!
										do {

											int random_num = random.nextInt(9) + 1;
											
											System.out.println(random_num + "�Է�!");
											
											try {
												int num = scanner.nextInt();
												Music buttonSound2 = new Music("��ư��.mp3", false);
												buttonSound2.start();

												if (random_num == num) {
													count++;
												}
											} catch (InputMismatchException e) {
												System.out.println("�߸� �Է��ϼ̽��ϴ�!");
											}
											

										} while (itemThread.getSecond() < 5);

										if (count >= 5) {
											System.out.println("����");

											oneLine.pressEnter();

											System.out.println(��Ͻ�.getDroppedItem()
													.get(Integer.parseInt(selected_menu_num) - 1).getName() + "�� �־����ϴ�!");

											// ���� �������� ���� ��������!

											����.receiveItem(
													��Ͻ�.getDroppedItem().remove(Integer.parseInt(selected_menu_num) - 1));

										} else {
											System.out.println("����!");
											oneLine.pressEnter();
										}

										System.out.println("�ƹ�Ű�� �Է��ϼ���!");
										scanner.next();

									}
									// 0�� �Է� �ڷΰ���
									else if (selected_menu_num.equals("0")) {
										break;
									} 
									//�߸��Է�������!
									else {
										System.out.println();
										System.out.println("�ٽ� �Է����ּ���!");
										oneLine.pressEnter();
									}

								} catch (NumberFormatException e) {
									System.out.println();
									System.out.println("���ڸ� �Է��ϼ���!!");
									oneLine.pressEnter();
								}

							}

						}
						// 4. ������ ���¸� ����
						else if (selected_menu_num.equals("4")) {

							while (true) {

								����.showMenu();
								System.out.println("������ ���ðڽ��ϱ�?");
								System.out.print("��ȣ �Է�: ");
								selected_menu_num = scanner.next();
								Music buttonSound3 = new Music("��ư��.mp3", false);
								buttonSound3.start();

								// 1. ������ �⺻����
								if (selected_menu_num.equals("1")) {
									����.showInformation();
									System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
									scanner.next();
									Music buttonSound1 = new Music("��ư��.mp3", false);
									buttonSound1.start();
								}

								// 2. ������ ���ϸ��
								else if (selected_menu_num.equals("2")) {
									����.showPokeMons();
									����.showPokemonDetail();
//									System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
//									scanner.next();
								}

								// 3. ������ �����۰���
								else if (selected_menu_num.equals("3")) {
									����.showItemBag();
									System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
									scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();
								}

								// 0. �ڷΰ���
								else if (selected_menu_num.equals("0")) {
									break;
								}
								//�߸� �Է½�
								else {
									System.out.println();
									System.out.println("�ٽ� �Է����ּ���!");
									oneLine.pressEnter();
								}

							}

						}
						// 0. ���� �̵��Ѵ�.
						else if (selected_menu_num.equals("0")) {

							��Ͻ�.showOtherMap();
							System.out.println("���� ���ðڽ��ϱ�?");
							System.out.print("��ȣ�̵�: ");
							map_num = scanner.next();
							Music buttonSound = new Music("��ư��.mp3", false);
							buttonSound.start();

							if (map_num.equals("1")) {
								
								// rainSound.close();
								// rainThread.join();
//								rainThread.close();

								// ��Ͻ� ���� ����!
								forestMusic.close();
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								System.out.println();
								System.out.println("���ʸ����� �̵��մϴ�....");
								System.out.println();
								LoadingThread loadingThread2 = new LoadingThread();
								loadingThread2.start();
								loadingThread2.join();

								

								break;

							} else if (map_num.equals("3")) {
								
								//rainSound.close();
//								rainThread.close();

								// ��Ͻ� ���� ����!
								forestMusic.close();
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								System.out.println();
								System.out.println("ȸ����Ƽ�� �̵��մϴ�....");
								System.out.println();
								
								LoadingThread loadingThread2 = new LoadingThread();
								loadingThread2.start();
								loadingThread2.join();

								break;
							} else {
								System.out.println();
								System.out.println("�ٽ� �Է����ּ���!");
								oneLine.pressEnter();
							}

						}
						// 11.�ڵ� ���!
						else if(selected_menu_num.equals("11")) {
							
							System.out.println();
							System.out.println("�ڵ� ����� �����մϴ�!");
							oneLine.pressEnter();
							
							Thread waitingPokemonThread = new WaitingPokemonThread();
							waitingPokemonThread.start();
							waitingPokemonThread.join();

							// ��Ͻ� ���� ����
							forestMusic.close();
							
							// �߻����ϸ� �Ⱦ� ����
							Music wildMusic = new Music("�߻����ϸ�.mp3", true);
							wildMusic.start();

							Thread.sleep(1000);

							// ��Ͻ� �ȿ� �ִ� ���͵��� ���ڸ� ������ ����
							int pokemon_num = ��Ͻ�.getAppearingPokeMon().size();
							// ���� ���ڸ� �޾Ƽ� ������ ����
							int randam_num = random.nextInt(pokemon_num);

							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

							System.out.println(��Ͻ�.getAppearingPokeMon().get(randam_num).getName() + "�� ��Ÿ�����ϴ�!!!");
							��Ͻ�.getAppearingPokeMon().get(randam_num).showPicture();
							
							AutoBattleThread autoBattleThread = new AutoBattleThread(����, ��Ͻ�.getAppearingPokeMon().get(randam_num), ������);
							autoBattleThread.start();
							autoBattleThread.join();

							// �߻� ���ϸ� ���� ����
							wildMusic.close();
							
							// �߻� ���ϸ� �¸� ���ǽ���
							Music wildVictoy = new Music("�߻����ϸ�¸�.mp3", false);
							wildVictoy.start();

							System.out.println(������.getOtherPokemon().getName() + "�� �����߽��ϴ�!");

							oneLine.pressEnter();

							System.out.println();

							// ����ġ�� �ش�
							������.getMyPokemon().increaseExp(������.getOtherPokemon().getDrop_exp());

							Thread.sleep(1000);

							// ������ ���� ���� �Ǽ� �ٽ� ����Ʈ�� �����!
							������.getOtherPokemon().levelUp(������.getOtherPokemon().getLevel());

							// �������� ������
							������.outOfMap();

							System.out.println();
							System.out.println("��Ͻ����� �̵��Ͻ÷��� �ƹ�Ű�� �Է����ּ���!");

							oneLine.pressEnter();
							
							// �߻� ���ϸ� �¸� ���� ����
							wildVictoy.close();
							
							// ��Ͻ� ���� Ʋ�� ���ؼ� do-while������ ��!
							break gotoForest;

						
							
						}
						// �߸� ������ ��
						else {
							System.out.println();
							System.out.println("�ٽ� �Է����ּ���!");
							oneLine.pressEnter();
						}

					}
					
				} while (map_num.equals("2"));
				
				
			}
			
			// ȸ����Ƽ
			else if(map_num.equals("3")) {
				
				// ȸ����Ƽ ���� ����
				Music cityMusic = new Music("ȸ����Ƽ.mp3", true);
				cityMusic.start();
				
				ȸ����Ƽ.comeToMap(����);
				
				while (true) {
					
					ȸ����Ƽ.showMenu();
					System.out.println("������ �Ͻðڽ��ϱ�?");
					System.out.print("��ȣ �Է�: ");
					selected_menu_num = scanner.next();
					Music buttonSound = new Music("��ư��.mp3", false);
					buttonSound.start();
					
					// 1. ���ϸ� ��ȣ�翡�� ���� �Ǵ�.
					if(selected_menu_num.equals("1")) {
						
						System.out.println();
						
						// "������� ���� ���ϸ� ��ȣ�� �Դϴ�!"
						ȸ����Ƽ.getNurse().sayDialogue(0);
						
						Thread.sleep(1000);
						
						while(true) {
							
							ȸ����Ƽ.getNurse().showMenu();
							
							// "������ ���͵帱���? "
							ȸ����Ƽ.getNurse().sayDialogue(1);
				
							System.out.print("��ȣ �Է�: ");
							selected_menu_num = scanner.next();
							Music buttonSound1 = new Music("��ư��.mp3", false);
							buttonSound1.start();
							
							// 1. ���ϸ� ȸ��
							if(selected_menu_num.equals("1")) {
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("������ ���ϸ���� ��ȣ�翡�� �ǳ��ش�!");

								oneLine.pressEnter();
								
								RecoverPokemonThread recoverPokemonThread = new RecoverPokemonThread();
								recoverPokemonThread.start();
								recoverPokemonThread.join();

								for (int i = 0; i < ����.getOwned_PokeMon().size(); i++) {
									���ʸ���.getMom().healPokeMon(����.getOwned_PokeMon().get(i));
								}

								oneLine.pressEnter();
								

							
							}
							// 2. ���ϸ� �ñ��
							else if (selected_menu_num.equals("2")) {
								
								while(true) {
									����.showPokeMons();
									System.out.println("�� �� ���ϸ��� �ñ�ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t (�ڷΰ��� :0��)");
									System.out.print("��ȣ �Է�: ");
									selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();
									
									if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num) <= ����.getOwned_PokeMon().size()) {
									
										ȸ����Ƽ.getNurse().receivePokeMon(����.getOwned_PokeMon().remove(Integer.parseInt(selected_menu_num)-1));
										
										oneLine.pressEnter();
										
									}
									else if(selected_menu_num.equals("0")) {
										break;
									}
									else {
										System.out.println();
										System.out.println("�ٽ� �Է��� �ּ���!");
										oneLine.pressEnter();
									}
									
									
								}
								
								
								
							}
							// 3. ���ϸ� ã��
							else if (selected_menu_num.equals("3")) {
								
								ȸ����Ƽ.getNurse().showPokeMons();
								System.out.println("�� �� ���ϸ��� ã���ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t (�ڷΰ��� :0��)");
								System.out.print("��ȣ �Է�: ");
								selected_menu_num = scanner.next();
								Music buttonSound2 = new Music("��ư��.mp3", false);
								buttonSound2.start();
								
								System.out.println("���찡 " + ȸ����Ƽ.getNurse().getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1).getName() + "�� ã�ҽ��ϴ�!");
								
								����.getPokeMon(ȸ����Ƽ.getNurse().getOwned_PokeMon().remove(Integer.parseInt(selected_menu_num)-1));
								
								oneLine.pressEnter();
								
								
							}
							// 0. ������
							else if (selected_menu_num.equals("0")) {
								break;
							}
							// �߸� ������ ��
							else {
								System.out.println();
								System.out.println("�ٽ� �Է����ּ���!");
								oneLine.pressEnter();
							}
						}
						
						
					}
					// 2. ��Ʈ���ο��� ���� �Ǵ�.
					else if(selected_menu_num.equals("2")) {
						
						while(true) {
							ȸ����Ƽ.getMart_owner().showItems();
							System.out.println("���� �ܾ� : " + ����.getMoney() + "��");
							System.out.println("������ ��ðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t\t (�ڷΰ��� :0��)");
							System.out.print("��ȣ �Է� : ");
							selected_menu_num = scanner.next();
							Music buttonSound1 = new Music("��ư��.mp3", false);
							buttonSound1.start();
							
							//1. ���Ϻ�
							if(selected_menu_num.equals("1")) {
							
								while(true) {
									
									System.out.println("�� ���� �����Ͻðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t\t (�ڷΰ��� : 0��)");
									System.out.print("���� �Է�: ");
									second_selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();
									
									int item_num = Integer.parseInt(second_selected_menu_num);
									
									// ���찡 ���� �ְų� ���Ϻ��� ������ ������ ��
									if(����.getMoney() >= 200 && item_num > 0 && item_num <= ȸ����Ƽ.getMart_owner().getOwned_pokeball().size()) {
										// ������� ���Ϻ��� �Է� ����
										for (int i = 0; i < item_num; i++) {
											// ���쿡�� ���� ����!
											����.getItembag().getPokeball().add(ȸ����Ƽ.getMart_owner().getOwned_pokeball().remove(0));
											// ������ ���� ����
											����.giveMoney(200);
												
										}
										
										System.out.println("���찡 ���Ϻ� " + item_num + "���� �����߽��ϴ�!");
										
										oneLine.pressEnter();
										
										break;
										
									}
									else if (second_selected_menu_num.equals("0")) {
										break;
									}
									
									else {
										System.out.println();
										System.out.println("�ٽ��Է����ּ���!");
										oneLine.pressEnter();
									}
								
								}
								
							}
							//2. ȸ����
							else if(selected_menu_num.equals("2")) {
								
								while(true) {

									System.out.println("�� ���� �����Ͻðڽ��ϱ�? \t\t\t\t\t\t\t\t\t\t\t (�ڷΰ��� : 0��)");
									System.out.print("���� �Է�: ");
									second_selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();
									
									int item_num = Integer.parseInt(second_selected_menu_num);
										
									// ���찡 ���� �ְų� ���Ϻ��� ������ ������ ��
									if(����.getMoney() >= 300 && item_num > 0 && item_num <= ȸ����Ƽ.getMart_owner().getOwned_potion().size()) {
										// ������� ���Ϻ��� �Է� ����
										for (int i = 0; i < item_num; i++) {
											// ���쿡�� ���� ����!
											����.getItembag().getPotion().add(ȸ����Ƽ.getMart_owner().getOwned_potion().remove(0));
											// ������ ���� ����
											����.giveMoney(300);
											
										}
										
										System.out.println("���찡 ȸ���� " + item_num + "���� �����߽��ϴ�!");

										oneLine.pressEnter();
										
										break;
										
									}
									else if (second_selected_menu_num.equals("0")) {
										break;
									}
									
									else {
										System.out.println();
										System.out.println("�ٽ��Է����ּ���!");
										oneLine.pressEnter();
									}
									
								}
								
								
							}
							//0. ������
							else if(selected_menu_num.equals("0")) {
								break;
							}
							else {
								System.out.println();
								System.out.println("�߸��Է��߽��ϴ�!");
								oneLine.pressEnter();
							}
						}
						
						
					}
					// 3. ���忡�� ���� �Ǵ�.
					else if(selected_menu_num.equals("3")) {
						
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("����: �� ����! ���� �ʰ� ȸ���� ������ ������ ���ٴ�");
						
						oneLine.pressEnter();
						
						System.out.println("����: ���� �̱�� ���ϸ� ������ ���� �� �ִ�");
						
						oneLine.pressEnter();
						
						System.out.println("����: ������ ������ �׷��� ������ ������?...");
						
						oneLine.pressEnter();
						
						//ȸ����Ƽ ���� ����
						cityMusic.close();
						
						//���� Ʈ���̳� ���� ����
						Music gymTrainerMusic = new Music("����Ʈ���̳�.mp3", true);
						gymTrainerMusic.start();
						
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						
						// ������ ����
						������.comeToMap(����);
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						������.comeToMap(ȸ����Ƽ.getGym_trainer());
						
						// ��� Ʈ���̳� ���ϸ� ���� ������!
						ȸ����Ƽ.getGym_trainer().getOwned_PokeMon().get(0).showPicture();
						
						int count = 0;
						
						//��� ���ϸ� �ڵ� ����!
						AutoAttackThread attackThread = new AutoAttackThread(������, ������.getMyPokemon(), ������.getOtherPokemon());
						attackThread.start();
						
						//���� ����
						while(true) {

							������.showBattleField();
							������.showMenu();

							selected_menu_num = scanner.next();
							Music buttonSound1 = new Music("��ư��.mp3", false);
							buttonSound1.start();
							
							attackThread.close();

							// 1. �ο��
							if (selected_menu_num.equals("1")) {

								������.fight();

							}
							// 2. ���ϸ�
							else if (selected_menu_num.equals("2")) {

								while (true) {
									// ������ ���ϸ� ����Ʈ�� �����ش�
									������.get����().showPokeMons();

									System.out.println("�� �� ���ϸ����� �ٲٽðڽ��ϱ�? (������: 0��)");
									System.out.print("��ȣ �Է�: ");
									selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("��ư��.mp3", false);
									buttonSound2.start();

									// ���찡 ������ �ִ� ���ϸ� ���� ���� ���ڸ� �Է� ���� ��
									if (Integer.parseInt(selected_menu_num) >= 1
											&& Integer.parseInt(selected_menu_num) <= ������.get����()
													.getOwned_PokeMon().size()) {
										System.out.print("��� �� " + ������.getMyPokemon().getName() + "!! ");
										������.changePokemon(������.get����().getOwned_PokeMon()
												.get(Integer.parseInt(selected_menu_num) - 1));

										System.out.println("���� " + ������.getMyPokemon().getName() + "!! ");
										break;
									}
									// 0�� �Է½�
									else if (selected_menu_num.equals("0")) {
										break;
									} else {
										System.out.println();
										System.out.println("�ٽ� �Է����ּ���!!");
										oneLine.pressEnter();
									}

								}

							}
							// 3. ������ ����
							else if (selected_menu_num.equals("3")) {
								������.get����().showItemBag();
								System.out.println("� �������� ����Ͻðڽ��ϱ�?");
								System.out.print("��ȣ �Է�: ");
								selected_menu_num = scanner.next();
								Music buttonSound7 = new Music("��ư��.mp3", false);
								buttonSound7.start();

								// ���Ϻ� ���
								if (selected_menu_num.equals("1")) {

									System.out.println("������ �ִ� ���ϸ��� ���� �� �����ϴ�!");
									oneLine.pressEnter();

								}
								// ȸ���� ���
								else if (selected_menu_num.equals("2")) {

									// ���찡 ȸ������ ���� ��!
									if (������.get����().getItembag().getPotion().size() != 0) {

										������.get����().getItembag().getPotion().remove(0)
												.healPokeMon(������.get����().getOwned_PokeMon().get(0));

									} else if (������.get����().getItembag().getPotion().size() == 0) {

										System.out.println("ȸ������ �����ϴ�!!");
										oneLine.pressEnter();

									}

								}

							}
							// 0. ��������
							else if (selected_menu_num.equals("0")) {
								System.out.println();
								System.out.println("Ʈ���̳ʿ� �����߿��� ���� �� �� �����ϴ�!");
								oneLine.pressEnter();
							}
							// �߸� �Է�������
							else {
								System.out.println();
								System.out.println("�ٽ� �Է����ּ���!");
								oneLine.pressEnter();
							}

							// �����ϸ��� ü���� 0�϶�
							if (������.getMyPokemon().getHp() == 0) {
								System.out.println(������.getMyPokemon().getName() + "�� �����߽��ϴ�!");

								break;
							}
							// �߻����ϸ��� ü���� 0�϶�
							else if (������.getOtherPokemon().getHp() == 0) {
								
								������.showBattleField();
								System.out.println(������.getOtherPokemon().getName() + "�� �����߽��ϴ�!");
								
								oneLine.pressEnter();
								// ����ġ�� �ش�(Ʈ���̳ʿ� �ο�� �߰� ����ġ ȹ��)
								������.getMyPokemon().increaseExp(������.getOtherPokemon().getDrop_exp() + 20);
								
								oneLine.pressEnter();

								// Ʈ���̳ʰ� ���ϸ��� ���� ���� ��
								if (count + 1 < ������.getTrainer().getOwned_PokeMon().size()) {
									// ��� Ʈ���̳� ù��° ���ϸ� ����
									if (������.getTrainer().getOwned_PokeMon().get(count).getHp() == 0) {
										
										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										
										System.out.println(������.getTrainer().getName() + ": " + "�̷�.. ����!" + ������.getOtherPokemon().getName());
										
										// ���� ���ϸ��� ����
										������.outOfMap(������.getTrainer().getOwned_PokeMon().get(count));
										
										count++;
										
										// �ٸ� ���ϸ��� ���������� ����
										������.comeToMap(������.getTrainer().getOwned_PokeMon().get(count));
										
										System.out.println();
										
										System.out.println(������.getTrainer().getName() + ": " + "����! " + ������.getOtherPokemon().getName());
										
										// ���ο� ���ϸ� ������ ������!
										������.getOtherPokemon().showPicture();
										
									}

								}
								// Ʈ���̳ʰ� ���ϸ��� ���� ��
								else {
									
									gymTrainerMusic.close();
									
									//Ʈ���̳� �¸� ���� ����
									Music trainerVictory = new Music("����Ʈ���̳ʽ¸�.mp3", false);
									trainerVictory.start();
									
									oneLine.pressEnter();
									
									System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
									System.out.println(������.getTrainer().getName() + "���� �ºο��� �̰�� !");
									System.out.println();

									oneLine.pressEnter();
									
									// Ʈ���̳ʰ� ���쿡�� ���� �ش�!
									System.out.println();
									������.getTrainer().giveMoney(������.get����());
									oneLine.pressEnter();
									
									System.out.println("����: ��! ����!! ����ѵ�...");
									
									oneLine.pressEnter();
									
									System.out.println("����: ���� �̱� �񰡷� ȸ�������� ����!!");
									
									oneLine.pressEnter();
									
									System.out.println("���찡 ���ϸ����(ȸ������)�� ������ϴ�!");
									
									oneLine.pressEnter();
									
									����.setBadge(1);
									
									// Ʈ���̳ʰ� ���� �Ұ� ���·� �ٲ۴�
									������.getTrainer().setBattleAvailable(false);

									// �������� ������
									������.outOfMap();
									
									System.out.println("ȸ����Ƽ�� �̵��Ͻ÷��� �ƹ�Ű�� �Է����ּ���!");

									oneLine.pressEnter();

									//Ʈ���̳� �¸� ���� ����!
									trainerVictory.close();

									break;

								}

							}

						}
						
					}
					// 4. ������ ���¸� ����
					else if (selected_menu_num.equals("4")) {

						while (true) {

							����.showMenu();
							System.out.println("������ ���ðڽ��ϱ�?");
							System.out.print("��ȣ �Է�: ");
							selected_menu_num = scanner.next();
							Music buttonSound3 = new Music("��ư��.mp3", false);
							buttonSound3.start();

							// 1. ������ �⺻����
							if (selected_menu_num.equals("1")) {
								����.showInformation();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
								scanner.next();
								Music buttonSound1 = new Music("��ư��.mp3", false);
								buttonSound1.start();
							}

							// 2. ������ ���ϸ��
							else if (selected_menu_num.equals("2")) {
								����.showPokeMons();
								����.showPokemonDetail();
//								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
//								scanner.next();
							}

							// 3. ������ �����۰���
							else if (selected_menu_num.equals("3")) {
								����.showItemBag();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (�ڷΰ��� : 0�� �Է�)");
								scanner.next();
								Music buttonSound2 = new Music("��ư��.mp3", false);
								buttonSound2.start();
							}

							// 0. �ڷΰ���
							else if (selected_menu_num.equals("0")) {
								break;
							}
							//�߸� �Է½�
							else {
								System.out.println();
								System.out.println("�ٽ� �Է����ּ���!");
								oneLine.pressEnter();
							}

						}

					}
					// 0. ���� �̵��Ѵ�.
					else if (selected_menu_num.equals("0")) {

						ȸ����Ƽ.showOtherMap();
						System.out.println("�ص� : 4");
						System.out.println("���� ���ðڽ��ϱ�?");
						System.out.print("��ȣ�̵�: ");
						map_num = scanner.next();
						Music buttonSound1 = new Music("��ư��.mp3", false);
						buttonSound1.start();
						

						if (map_num.equals("2")) {
							// ȸ������ ���� ����
							cityMusic.close();
							
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							
							System.out.println();
							System.out.println("��Ͻ����� �̵��մϴ�....");
							System.out.println();
							LoadingThread loadingThread2 = new LoadingThread();
							loadingThread2.start();
							loadingThread2.join();

							break;
						} else if (map_num.equals("1")) {
							System.out.println();
							System.out.println("��Ͻ��� ������ �� �� �ֽ��ϴ�!");
							oneLine.pressEnter();
						}
						else if(map_num.equals("4")) {
							
							if(����.getBadge() == 1) {
								
								break;
							}
							else {
								System.out.println();
								System.out.println("������ �־�� �� �� �ֽ��ϴ�!!");
								oneLine.pressEnter();
							}
						
						}
						else {
							System.out.println();
							System.out.println("�߸� �Է��ϼ̽��ϴ�!");
							oneLine.pressEnter();
						}

					}
					
					// �߸� �Է� ���� ��
					else {
						System.out.println();
						System.out.println("�ٽ� �Է����ּ���!");
						oneLine.pressEnter();
					}
				}
				
			}
			else if(map_num.equals("4")) {
				System.out.println("���ڻ�: �� ����! �����ϳ�!");
				
				oneLine.pressEnter();
				
				System.out.println("���ڻ�: �ڳ״� ������ ��� ������ ���ϸ� Ʈ���̳ʰ� �Ǿ��ٳ�!!");
				
				oneLine.pressEnter();
				
				System.out.println("���ڻ�: �����ϳ�!!");
				
				oneLine.pressEnter();
				
				Ending ending = new Ending();
				ending.win();
				
				break;
				
			}
			
		}

	}
	
}
