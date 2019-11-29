/*
 * 최초시작시간: 5월 2일 11시 시작!
 * 수정 시간 : 
 * 수정 내용 :
 * 
 * <간략한 게임 시나리오>
 * 1.주인공인 지우가 오박사에게 포켓몬 한마리를 받음.
 * 2.야생포켓몬과 포켓몬 트레이너와 싸워서 포켓몬을 키움.
 * 3.체육관의 포켓몬 관장과 싸워서 뱃지 2개를 얻으면 게임 끝!
 * 
 * <시작 포켓몬>
 * 1.파이리 2.이상해씨 3.꼬부기
 * 
 * <맵>
 * 1.태초마을 (Map1_Pallet_Town)
 * 2.상록숲 (Map2_Viridian_Forest)
 * 3.회색시티 (Map3_Pewter_City)
 * 4.달맞이 산 (Map4_Mt_Moon)
 * 5.블루시티 (Map5_Cerulean City)
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

		// 변수 선언
		String selected_menu_num; // 입력 받을 변수
		String second_selected_menu_num; // 입력 받을 변수가 2개일 경우 따로 쓰는 변수!
		OneLine oneLine = new OneLine(); // 한줄을 띄고 엔터를 입력받기 위한 객체

		// 오박사 객체 생성
		Dr_OH 오박사 = new Dr_OH("오박사", "태초마을");

		// 지우 객체 생성
		MainCharacter 지우 = new MainCharacter("지우");
		
		// 배경음악 객체 생성
		Music introMusic = new Music("오프닝.mp3", true);
		Music Dr_ohMusic = new Music("오박사.mp3", true);
	
		// 맵 객체 생성
		Village 태초마을 = new Village("태초마을");
		ViridianForest 상록숲 = new ViridianForest("상록숲");
		City 회색시티 = new City("회색시티");

		Battlefield 전투장 = new Battlefield("전투장");
		
		//오프닝 음악 시작
		introMusic.start();
		
		//로고 쓰레드 시작
		LogoThread logoThread = new LogoThread();
		logoThread.start();
		logoThread.join();
		
		oneLine.pressEnter();
		
		// 게임 설명!
		

		//오프닝 음악 종료
		introMusic.close();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		LoadingThread loadingThread = new LoadingThread();
		loadingThread.start();
		loadingThread.join();

		//오박사 음악 시작
		Dr_ohMusic.start();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		// <오박사 오프닝>
		// [start]
		// 오박사 오프닝 대사를 함
		// 차례대로 대사가 나옴
		// Enter를 눌러야 다음 대사로 넘어감
		for (int i = 0; i < 11; i++) {
		
			Thread onebyoneThread = new Thread(new PrintOnebyoneThread(오박사.getDialogue().get(i)));
			onebyoneThread.start();
			
			// "너의 이름은 뭐지?" 이후 이름을 물어봐야 함
			if (i == 7) {
				System.out.println("\n\n");
				String name = "지우"; // scanner.next();
				지우.setName(name);
				System.out.println(지우.getName() + "!!");
				System.out.println("\n\n");
			}
			System.out.println();
			oneLine.pressEnter();
		}

		// [end]
		
		//오박사 음악 종료
		Dr_ohMusic.close();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("태초마을로 이동합니다....");
		System.out.println();

		LoadingThread loadingThread1 = new LoadingThread();
		loadingThread1.start();
		loadingThread1.join();

		// 태초마을로 오박사가 들어옴
		태초마을.setDr_oh(오박사);
		
		String map_num = "1";
		
		Opening:
		while (true) {
			
			
			// 태초마을
			if(map_num.equals("1")) {
				
				//태초마을 시작
				Music villageMusic = new Music("태초마을.mp3", true);
				villageMusic.start();
				
				// 태초마을로 지우 들어옴
				태초마을.comeToMap(지우);
				
				while (true) {

					태초마을.showMenu();
					System.out.println("무엇을 하시겠습니까?");
					System.out.print("번호 입력: ");
					selected_menu_num = scanner.next();
					Music buttonSound = new Music("버튼음.mp3", false);
					buttonSound.start();

					// 1. 오박사에게 말을 건다
					if (selected_menu_num.equals("1")) {

						// 지우가 포켓몬을 가지고 있지 않을때
						if (지우.getOwned_PokeMon().size() == 0) {
							
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							
							// 처음 오박사에게 갔을 때 오박사가 지우에게 포켓몬을 주는 상황
							oneLine.pressEnter();
							오박사.sayDialogue(11);
							oneLine.pressEnter();
							오박사.sayDialogue(12);
							oneLine.pressEnter();
							오박사.sayDialogue(13);
							oneLine.pressEnter();
							오박사.sayDialogue(14);
							oneLine.pressEnter();

							// 지우가 포켓몬 선택
							while (true) {
								오박사.showPokeMon();
								System.out.println("몇 번 포켓몬을 가지시겠습니까?");
								System.out.print("번호 입력 : ");
								selected_menu_num = scanner.next();
								Music buttonSound1 = new Music("버튼음.mp3", false);
								buttonSound1.start();

								// 1~3번 입력 했을 시
								if (selected_menu_num.equals("1") || selected_menu_num.equals("2")
										|| selected_menu_num.equals("3")) {

									System.out.println(
											오박사.getOwned_PokeMon().get(Integer.parseInt(selected_menu_num) - 1).getName()
													+ "를 선택하셨습니다!");
									
									오박사.getOwned_PokeMon().get(Integer.parseInt(selected_menu_num) - 1).showPicture();
									

									System.out.println();
									System.out.println("정말로 가지시겠습니까?");
									System.out.println("1.예 2.아니요");
									System.out.print("번호 입력 : ");
									second_selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();
									System.out.println();

									// 1.예
									if (second_selected_menu_num.equals("1")) {

										// 오박사 포켓몬 리스트에 있는 선택된 포켓몬을
										// 지우의 포켓몬 리스트로 이동한다
										지우.getPokeMon(오박사.givePokeMon(Integer.parseInt(selected_menu_num)));

										oneLine.pressEnter();
										
										Thread.sleep(1000);
										
										System.out.println(
												"지우는 오박사에게로 부터 " + 지우.getOwned_PokeMon().get(0).getName() + "를 받았다!!");
										oneLine.pressEnter();

										오박사.sayDialogue(15);
										oneLine.pressEnter();

										break;

									}
									// 2.아니요
									else {

									}

								}
								// 잘못 입력했을 시
								else {
									System.out.println();
									System.out.println("잘못 입력하셨습니다!");
									System.out.println("1~3번만 입력해주세요!!");
									oneLine.pressEnter();
								}

							}

						}
						// 지우가 포켓몬을 가지고 있을 떄
						else {

							// 오박사 포켓볼을 가지고 있을 때
							if (오박사.getOwned_PokeBall().size() != 0) {
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								// 지우가 포켓몬을 받고 다시 오박사에게 말하면 포켓볼을 준다!
								oneLine.pressEnter();
								오박사.sayDialogue(16);
								oneLine.pressEnter();

								// 지우가 오박사에게로 부터 포켓볼 5개를 받는다.
								for (int i = 0; i < 5; i++) {
									지우.receiveItem(오박사.givePokeBall());
								}
								
								Thread.sleep(1000);
								
								System.out.println("오박사에게 포켓볼 5개를 받았습니다!");
								oneLine.pressEnter();

								오박사.sayDialogue(17);
								oneLine.pressEnter();

								오박사.sayDialogue(18);
								oneLine.pressEnter();
							}
							// 오박사 지우에게 포켓볼을 주고 한개 없을 때
							else if (오박사.getOwned_PokeBall().size() == 0) {

								scanner.nextLine();
								오박사.sayDialogue(18);
								scanner.nextLine();

							}

						}

					}
					// 2. 엄마에게 말을 건다
					else if (selected_menu_num.equals("2")) {
						
						System.out.println();
						
						// 지우가 포켓몬이 없을 때
						if (지우.getOwned_PokeMon().size() == 0) {
							태초마을.getMom().sayDialogue(0);
							oneLine.pressEnter();
						}
						// 지우가 포켓몬이 있을 때
						else if (지우.getOwned_PokeMon().size() >= 1) {

							// 처음 엄마가 돈을 줄때(엄마 돈이 3000원 있을 때)
							if (태초마을.getMom().getMoney() == 3000) {
								
								태초마을.getMom().sayDialogue(1);
								
								oneLine.pressEnter();
								
								Thread.sleep(1000);
								// 엄마가 지우에게 3000원을 준다
								지우.receiveMoney(태초마을.getMom().giveMoney(3000));

								oneLine.pressEnter();
								태초마을.getMom().sayDialogue(2);

								oneLine.pressEnter();
								태초마을.getMom().sayDialogue(3);

								oneLine.pressEnter();

							}
							// 엄마가 돈을 주고 나서
							// 엄마의 기본 기능을 할때(포켓몬 회복, 돈을 입출금 기능)
							else {
								oneLine.pressEnter();
								태초마을.getMom().sayDialogue(4);
								oneLine.pressEnter();
								
								while (true) {
									
									태초마을.getMom().showMomsMenu();
									System.out.println("무엇을 하시겠습니까?");
									System.out.print("번호입력: ");
									selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();
									

									// 1.포켓몬 회복
									if (selected_menu_num.equals("1")) {
										System.out.println();
										System.out.println("지우의 포켓몬들을 엄마에게 맡긴다!");
										System.out.println();
										
										oneLine.pressEnter();
										
										RecoverPokemonThread recoverPokemonThread = new RecoverPokemonThread();
										recoverPokemonThread.start();
										recoverPokemonThread.join();
										
										for (int i = 0; i < 지우.getOwned_PokeMon().size(); i++) {
											태초마을.getMom().healPokeMon(지우.getOwned_PokeMon().get(i));
										}
										
										oneLine.pressEnter();

									}
									// 2.돈을 찾는다
									else if (selected_menu_num.equals("2")) {

										while (true) {
											
											try {
												태초마을.showAccount(지우);
												System.out.println("얼마를 찾으시겠습니까? \t\t\t\t\t\t\t\t\t\t    (뒤로가기 : 0번 입력)");
												System.out.print("금액 입력: ");
												String money = scanner.next();
												Music buttonSound3 = new Music("버튼음.mp3", false);
												buttonSound3.start();

												// 0 입력 시 뒤로가기
												if (money.equals("0")) {
													break;
												}
												// 금액 입력시
												else if(Integer.parseInt(money) >= 0 && Integer.parseInt(money) <= 태초마을.getMom().getMoney()){
													System.out.println();
													// 입력한 금액 만큼 지우에게 돈을 준다
													지우.setMoney(지우.getMoney() + 태초마을.getMom().giveMoney(Integer.parseInt(money)));
													
													System.out.println();
													System.out.println("지우가 " + money + "원을 찾았습니다!");
													oneLine.pressEnter();
													
												}
												else {
													System.out.println();
													System.out.println("금액을 초과하였습니다!");
													oneLine.pressEnter();

												}
												
											} catch (NumberFormatException e) {
												System.out.println();
												System.out.println("숫자만 입력해 주세요!");
												oneLine.pressEnter();

											}
											
										}

									}
									// 3.돈을 맡긴다
									else if (selected_menu_num.equals("3")) {

										while (true) {
											try {
												태초마을.showAccount(지우);
												System.out.println("얼마를 맡기시겠습니까? \t\t\t\t\t\t\t\t\t\t    (뒤로가기 : 0번 입력)");
												System.out.print("금액 입력: ");
												String money = scanner.next();
												Music buttonSound3 = new Music("버튼음.mp3", false);
												buttonSound3.start();

												// 0 입력 시 뒤로가기
												if (money.equals("0")) {
													break;
												}
												// 금액 입력시
												else if(Integer.parseInt(money) >= 0 && Integer.parseInt(money) <= 지우.getMoney()) {
													// 입력한 금액 만큼 지우가 엄마에게 돈을 맡긴다
													태초마을.getMom().receiveMoney(지우.giveMoney(Integer.parseInt(money)));
													System.out.println();
													System.out.println(지우.getName() +"가 엄마에게 " + money + "원을 맡겼습니다!");
													oneLine.pressEnter();
												}
												else {
													System.out.println();
													System.out.println("금액이 초과하였습니다!");
													
													oneLine.pressEnter();
												}
												
											} catch (NumberFormatException e) {
												System.out.println();
												System.out.println("숫자만 입력해 주세요!");
		
												oneLine.pressEnter();
											}
											
											
										}

									}
									// 0.그만 대화하기
									else if (selected_menu_num.equals("0")) {
										break;
									}
									// 잘못 입력 했을 때
									else {
										System.out.println();
										System.out.println("다시 입력해주세요!");
										oneLine.pressEnter();
									}
								}

							}

						}

					}
					// 3. 지우의 상태를 본다
					else if (selected_menu_num.equals("3")) {

						while (true) {

							지우.showMenu();
							System.out.println("무엇을 보시겠습니까?");
							System.out.print("번호 입력: ");
							selected_menu_num = scanner.next();
							Music buttonSound3 = new Music("버튼음.mp3", false);
							buttonSound3.start();

							// 1. 지우의 기본정보
							if (selected_menu_num.equals("1")) {
								지우.showInformation();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
								scanner.next();
								Music buttonSound4 = new Music("버튼음.mp3", false);
								buttonSound4.start();
							}

							// 2. 지우의 포켓몬들
							else if (selected_menu_num.equals("2")) {
								지우.showPokeMons();
								지우.showPokemonDetail();
//								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
//								scanner.next();
							}

							// 3. 지우의 아이템가방
							else if (selected_menu_num.equals("3")) {
								지우.showItemBag();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
								scanner.next();
								Music buttonSound4 = new Music("버튼음.mp3", false);
								buttonSound4.start();
							}

							// 0. 뒤로가기
							else if (selected_menu_num.equals("0")) {
								break;
							}
							//잘못 입력시
							else {
								System.out.println();
								System.out.println("다시 입력해주세요!");
								oneLine.pressEnter();
							}

						}

					}
					// 0. 맵을 이동한다.
					else if (selected_menu_num.equals("0")) {
						
						// 지우가 포켓몬을 한마리도 가지고 있지 않을 때는
						// 태초마을 벗어날 수 없다.
						if (지우.getOwned_PokeMon().size() == 0) {
							System.out.println();
							System.out.println("지우에게는 포켓몬이 없습니다!!");
							System.out.println("오박사에게 가면 포켓몬을 얻을 수 있습니다!");
							oneLine.pressEnter();
						} else {
							
							태초마을.showOtherMap();
							System.out.println("어디로 가시겠습니까?");
							System.out.print("번호이동: ");
							map_num = scanner.next();
							Music buttonSound4 = new Music("버튼음.mp3", false);
							buttonSound4.start();
							
							if(map_num.equals("2")) {
								
								태초마을.outOfMap();
								
								//태초마을 음악 종료
								villageMusic.close();
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								System.out.println();
								System.out.println("상록숲으로 이동합니다....");
								System.out.println();
								LoadingThread loadingThread2 = new LoadingThread();
								loadingThread2.start();
								loadingThread2.join();

								break;
							}
							else if (map_num.equals("3")) {
								System.out.println();
								System.out.println("상록숲을 지나서 갈 수 있습니다!");
								oneLine.pressEnter();
							}
							else {
								System.out.println();
								System.out.println("다시 입력해주세요!");
								oneLine.pressEnter();
							}
							
						}

					}
					else if(selected_menu_num.equals("개발자모드")) {
						System.out.println("개발자 모드가 실행됩니다!");
						System.out.println();
						지우.getOwned_PokeMon().remove(0);
						지우.getOwned_PokeMon().add(new Charmander("파이리", 15));
						System.out.println(지우.getOwned_PokeMon().get(0).getName() + "의 레벨이 15가 되었습니다!");
						oneLine.pressEnter();
					}
					// 잘못 입력 했을 시
					else {
						System.out.println();
						System.out.println("다시 입력해주세요!");
						oneLine.pressEnter();
					}

				}
				
			}
			
			// 상록숲
			else if(map_num.equals("2")) {
				
				//비 오는 여부!! true이면 오는 거고 false이면 안옴!
				//boolean random_weather = random.nextBoolean();
				
				gotoForest:
				do {
					// 상록숲 음악 시작
					Music forestMusic = new Music("상록숲.mp3", true);
					forestMusic.start();
					
					// 비소리 객체 생성
					//Music rainSound = new Music("비소리.mp3", true);
					
					// true이면 비오는 소림 틈
					//if(random_weather) {
					//	rainSound.start();
					//}
					
					상록숲.comeToMap(지우);

//					RainThread rainThread = new RainThread(지우, 상록숲);
//					rainThread.start();
					while(true) {
						상록숲.showMenu();
						//if(random_weather) {
						//	System.out.println("비가 오는 중입니다!!");
						//}
						System.out.println("무엇을 하시겠습니까? \t\t\t\t\t\t\t\t\t\t  (자동전투 : 11번)");
						System.out.print("번호 입력: ");
						selected_menu_num = scanner.next();
						Music buttonSound4 = new Music("버튼음.mp3", false);
						buttonSound4.start();

						// 1. 야생포켓몬을 기다린다
						if (selected_menu_num.equals("1")) {

//							rainThread.close();
							
							Thread waitingPokemonThread = new WaitingPokemonThread();
							waitingPokemonThread.start();
							waitingPokemonThread.join();

							// 상록숲 음악 종료
							forestMusic.close();
							
							// 야생포켓몬 옴악 시작
							Music wildMusic = new Music("야생포켓몬.mp3", true);
							wildMusic.start();

							Thread.sleep(1000);

							// 상록숲 안에 있는 몬스터들의 숫자를 변수에 저장
							int pokemon_num = 상록숲.getAppearingPokeMon().size();
							// 랜덤 숫자를 받아서 변수에 저장
							int randam_num = random.nextInt(pokemon_num);

							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

							System.out.println(상록숲.getAppearingPokeMon().get(randam_num).getName() + "가 나타났습니다!!!");
							상록숲.getAppearingPokeMon().get(randam_num).showPicture();
							
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							
							전투장.comeToMap(지우);
							전투장.comeToMap(상록숲.getAppearingPokeMon().get(randam_num));
							
							//상대 포켓몬 자동 공격!
							AutoAttackThread attackThread = new AutoAttackThread(전투장, 전투장.getMyPokemon(), 전투장.getOtherPokemon());
							attackThread.start();

							while (true) {
								전투장.showBattleField();
								전투장.showMenu();
								
								selected_menu_num = scanner.next();
								Music buttonSound5 = new Music("버튼음.mp3", false);
								buttonSound5.start();
								
								attackThread.close();
								
								
								// 1. 싸운다
								if (selected_menu_num.equals("1")) {

									전투장.fight();

								}
								// 2. 포켓몬
								else if (selected_menu_num.equals("2")) {

									while (true) {
										// 지우의 포켓몬 리스트를 보여준다
										전투장.get지우().showPokeMons();

										System.out.println("몇 번 포켓몬으로 바꾸시겠습니까? (나가기: 0번)");
										System.out.print("번호 입력: ");
										selected_menu_num = scanner.next();
										Music buttonSound6 = new Music("버튼음.mp3", false);
										buttonSound6.start();
										
										// 지우가 가지고 있는 포켓몬 범위 내의 숫자를 입력 했을 시
										if (Integer.parseInt(selected_menu_num) >= 1 && Integer
												.parseInt(selected_menu_num) <= 전투장.get지우().getOwned_PokeMon().size()) {
											
											//전투장에 있는 포켓몬과 바꾸려고 하는 포켓몬의 이름이 다를 때
											if(전투장.getMyPokemon().getName() != 전투장.get지우().getOwned_PokeMon()
													.get(Integer.parseInt(selected_menu_num) - 1).getName()) {
												
												
												System.out.print("들어 와 " + 전투장.getMyPokemon().getName() + "!! ");

												Thread.sleep(1000);

												전투장.changePokemon(전투장.get지우().getOwned_PokeMon()
														.get(Integer.parseInt(selected_menu_num) - 1));

												System.out.println("가랏 " + 전투장.getMyPokemon().getName() + "!! ");

												전투장.getMyPokemon().showPicture();

												break;
											}
											else {
												System.out.println();
												System.out.println(전투장.getMyPokemon().getName() + "은 이미 전투중입니다!!");
												oneLine.pressEnter();
											}

											
										}
										// 0번 입력시
										else if (selected_menu_num.equals("0")) {
											break;
										} else {
											System.out.println();
											System.out.println("다시 입력해주세요!!");
											oneLine.pressEnter();
										}

									}

								}
								// 3. 아이템 가방
								else if (selected_menu_num.equals("3")) {
									전투장.get지우().showItemBag();
									System.out.println("어떤 아이템을 사용하시겠습니까?");
									System.out.print("번호 입력: ");
									selected_menu_num = scanner.next();
									Music buttonSound7 = new Music("버튼음.mp3", false);
									buttonSound7.start();

									// 포켓볼 사용
									if (selected_menu_num.equals("1")) {

										// 지우가 포켓볼이 있을 떄!
										if (전투장.get지우().getItembag().getPokeball().size() != 0) {
											// 지우 포켓몬이 잡히기 전 포켓몬 보유 숫자를 저장
											int priorPokemonNum = 전투장.get지우().getOwned_PokeMon().size();

											// 지우가 포켓볼을 사용함
											전투장.get지우().getItembag().getPokeball().remove(0).usePokeBall(전투장.get지우(),
													전투장.getOtherPokemon());

											// 포켓몬을 잡았을 경우 나감 경기장으로 나감
											if (전투장.get지우().getOwned_PokeMon().size() == priorPokemonNum + 1) {
												
												상록숲.getAppearingPokeMon().remove(randam_num);
												
												wildMusic.close();
												
												break gotoForest;
											}
											System.out.println();
										} else if (전투장.get지우().getItembag().getPokeball().size() == 0) {
											System.out.println();
											System.out.println("포켓볼이 없습니다!");
											oneLine.pressEnter();
										}

									}
									// 회복약 사용
									else if (selected_menu_num.equals("2")) {

										// 지우가 회복약이 있을 떄!
										if (전투장.get지우().getItembag().getPotion().size() != 0) {

											//물약 먹는소리!
											Music potionSound = new Music("포션.mp3", false);
											potionSound.start();
											
											전투장.get지우().getItembag().getPotion().remove(0)
													.healPokeMon(전투장.get지우().getOwned_PokeMon().get(0));

										} else if (전투장.get지우().getItembag().getPotion().size() == 0) {
											System.out.println();
											System.out.println("회복약이 없습니다!!");
											oneLine.pressEnter();
										}

									}

								}
								// 0. 도망간다
								else if (selected_menu_num.equals("0")) {
									System.out.println();
									System.out.println("지우가 도망을 갑니다!");
									oneLine.pressEnter();
									// 야생 포켓몬 음악 종료
									wildMusic.close();

									// 상록숲 음악 틀기 위해서 do-while문으로 감!
									break gotoForest;
								}
								// 잘못 입력했을시
								else {
									System.out.println();
									System.out.println("다시 입력해주세요!");
									oneLine.pressEnter();
								}

								// 내포켓몬의 체력이 0일때
								if (전투장.getMyPokemon().getHp() == 0) {
									System.out.println(전투장.getMyPokemon().getName() + "는 기절했습니다!");

									break;
								}
								// 야생포켓몬의 체력이 0일때
								else if (전투장.getOtherPokemon().getHp() == 0) {
									
									// 야생 포켓몬 음악 종료
									wildMusic.close();
									
									// 야생 포켓몬 승리 음악시작
									Music wildVictoy = new Music("야생포켓몬승리.mp3", false);
									wildVictoy.start();

									전투장.showBattleField();
									System.out.println(전투장.getOtherPokemon().getName() + "는 기절했습니다!");

									oneLine.pressEnter();

									System.out.println();

									// 경험치를 준다
									전투장.getMyPokemon().increaseExp(전투장.getOtherPokemon().getDrop_exp());

									Thread.sleep(1000);

									// 죽으면 레벨 업이 되서 다시 리스트에 저장됨!
									전투장.getOtherPokemon().levelUp(전투장.getOtherPokemon().getLevel());

									// 전투장을 나가다
									전투장.outOfMap();

									System.out.println();
									System.out.println("상록숲으로 이동하시려면 아무키나 입력해주세요!");

									oneLine.pressEnter();
									
									// 야생 포켓몬 승리 음악 종료
									wildVictoy.close();
									
									// 상록숲 음악 틀기 위해서 do-while문으로 감!
									break gotoForest;

								}

							}

						}
						// 2. 트레이너와 배틀을 한다.
						else if (selected_menu_num.equals("2")) {
							
							//싸운 트레이너 숫자를 담는 변수
							//트레이너를 이기면 count가 1증가!
							int count = 0;
							
							while (true) {

								상록숲.showTrainers();

								System.out.println("몇번 트레이너와 대결을 하시겠습니까? \t\t\t\t\t\t\t\t\t\t(뒤로가기: 0번)");
								System.out.print("번호 입력: ");
								selected_menu_num = scanner.next();
								Music buttonSound5 = new Music("버튼음.mp3", false);
								buttonSound5.start();

								// 1~3번 입력시!
								if (Integer.parseInt(selected_menu_num) >= 1
										&& Integer.parseInt(selected_menu_num) <= 상록숲.getFieldTrainer().size()) {

									// 트레이너가 전투가 가능 할 때
									if (상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1)
											.isBattleAvailable() == true) {

										// 상록숲 음악 종료
										forestMusic.close();

										// 트레이너 음악 시작
										Music trainerMusic = new Music("트레이너.mp3", true);
										trainerMusic.start();
										
										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										
										// 전투장 입장
										전투장.comeToMap(지우);
										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										전투장.comeToMap(상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1));
										
										// 상대 트레이너 포켓몬 사진 보여줌!
										상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1).getOwned_PokeMon().get(0).showPicture();

										//상대 포켓몬 자동 공격!
										AutoAttackThread attackThread = new AutoAttackThread(전투장, 전투장.getMyPokemon(), 전투장.getOtherPokemon());
										attackThread.start();
										
										// 전투 시작
										while (true) {

											전투장.showBattleField();
											전투장.showMenu();

											selected_menu_num = scanner.next();
											Music buttonSound6 = new Music("버튼음.mp3", false);
											buttonSound6.start();
											
											attackThread.close();

											// 1. 싸운다
											if (selected_menu_num.equals("1")) {

												전투장.fight();

											}
											// 2. 포켓몬
											else if (selected_menu_num.equals("2")) {

												while (true) {
													// 지우의 포켓몬 리스트를 보여준다
													전투장.get지우().showPokeMons();

													System.out.println("몇 번 포켓몬으로 바꾸시겠습니까? (나가기: 0번)");
													System.out.print("번호 입력: ");
													selected_menu_num = scanner.next();
													Music buttonSound7 = new Music("버튼음.mp3", false);
													buttonSound7.start();
													
													// 지우가 가지고 있는 포켓몬 범위 내의 숫자를 입력 했을 시
													if (Integer.parseInt(selected_menu_num) >= 1 && Integer
															.parseInt(selected_menu_num) <= 전투장.get지우().getOwned_PokeMon().size()) {
														
														//전투장에 있는 포켓몬과 바꾸려고 하는 포켓몬의 이름이 다를 때
														if(전투장.getMyPokemon().getName() != 전투장.get지우().getOwned_PokeMon()
																.get(Integer.parseInt(selected_menu_num) - 1).getName()) {
															
															
															System.out.print("들어 와 " + 전투장.getMyPokemon().getName() + "!! ");

															Thread.sleep(1000);

															전투장.changePokemon(전투장.get지우().getOwned_PokeMon()
																	.get(Integer.parseInt(selected_menu_num) - 1));

															System.out.println("가랏 " + 전투장.getMyPokemon().getName() + "!! ");

															전투장.getMyPokemon().showPicture();

															break;
														}
														else {
															System.out.println();
															System.out.println(전투장.getMyPokemon().getName() + "은 이미 전투중입니다!!");
															oneLine.pressEnter();
														}

														
													}
													// 0번 입력시
													else if (selected_menu_num.equals("0")) {
														break;
													} else {
														System.out.println();
														System.out.println("다시 입력해주세요!!");
														oneLine.pressEnter();
													}

												}

											}
											// 3. 아이템 가방
											else if (selected_menu_num.equals("3")) {
												전투장.get지우().showItemBag();
												System.out.println("어떤 아이템을 사용하시겠습니까?");
												System.out.print("번호 입력: ");
												selected_menu_num = scanner.next();
												Music buttonSound7 = new Music("버튼음.mp3", false);
												buttonSound7.start();

												// 포켓볼 사용
												if (selected_menu_num.equals("1")) {

													System.out.println("주인이 있는 포켓몬은 잡을 수 없습니다!");
													oneLine.pressEnter();

												}
												// 회복약 사용
												else if (selected_menu_num.equals("2")) {

													// 지우가 회복약이 있을 떄!
													if (전투장.get지우().getItembag().getPotion().size() != 0) {

														전투장.get지우().getItembag().getPotion().remove(0)
																.healPokeMon(전투장.get지우().getOwned_PokeMon().get(0));

													} else if (전투장.get지우().getItembag().getPotion().size() == 0) {

														System.out.println("회복약이 없습니다!!");
														oneLine.pressEnter();

													}

												}

											}
											// 0. 도망간다
											else if (selected_menu_num.equals("0")) {
												System.out.println();
												System.out.println("트레이너와 전투중에는 도망 갈 수 없습니다!");
												oneLine.pressEnter();
											}
											// 잘못 입력했을시
											else {
												System.out.println();
												System.out.println("다시 입력해주세요!");
												oneLine.pressEnter();
											}

											// 내포켓몬의 체력이 0일때
											if (전투장.getMyPokemon().getHp() == 0) {
												System.out.println(전투장.getMyPokemon().getName() + "는 기절했습니다!");

												break;
											}
											// 야생포켓몬의 체력이 0일때
											else if (전투장.getOtherPokemon().getHp() == 0) {
												
												전투장.showBattleField();
												System.out.println(전투장.getOtherPokemon().getName() + "는 기절했습니다!");
												
												oneLine.pressEnter();
												// 경험치를 준다(트레이너와 싸우면 추가 경험치 획득)
												전투장.getMyPokemon().increaseExp(전투장.getOtherPokemon().getDrop_exp() + 20);
												
												oneLine.pressEnter();

												// 트레이너가 포켓몬이 남아 있을 때
												if (count + 1 < 전투장.getTrainer().getOwned_PokeMon().size()) {
													// 상대 트레이너 첫번째 포켓몬 죽음
													if (전투장.getTrainer().getOwned_PokeMon().get(count).getHp() == 0) {
														
														System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
														
														System.out.println(전투장.getTrainer().getName() + ": " + "이런.. 들어와!" + 전투장.getOtherPokemon().getName());
														
														// 죽은 포켓몬은 나감
														전투장.outOfMap(전투장.getTrainer().getOwned_PokeMon().get(count));
														
														count++;
														
														// 다른 포켓몬이 전투장으로 들어옴
														전투장.comeToMap(전투장.getTrainer().getOwned_PokeMon().get(count));
														
														System.out.println();
														
														System.out.println(전투장.getTrainer().getName() + ": " + "가랏! " + 전투장.getOtherPokemon().getName());
														
														// 새로운 포켓몬 사진을 보여줌!
														전투장.getOtherPokemon().showPicture();
														
													}

												}
												// 트레이너가 포켓몬이 없을 때
												else {
													
													//트레이너 음악 종료
													trainerMusic.close();
													
													//트레이너 승리 음악 시작
													Music trainerVictory = new Music("트레이너승리.mp3", false);
													trainerVictory.start();
													
													oneLine.pressEnter();
													
													System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
													System.out.println(전투장.getTrainer().getName() + "와의 승부에게 이겼다 !");
													System.out.println();

													oneLine.pressEnter();
													
													// 트레이너가 지우에게 돈을 준다!
													System.out.println();
													전투장.getTrainer().giveMoney(전투장.get지우());
													System.out.println();

													// 트레이너가 전투 불가 상태로 바꾼다
													전투장.getTrainer().setBattleAvailable(false);

													// 전투장을 나가다
													전투장.outOfMap();
													
													System.out.println("상록숲으로 이동하시려면 아무키나 입력해주세요!");

													oneLine.pressEnter();

													//트레이너 승리 음악 종료!
													trainerVictory.close();

													// 상록숲 메뉴로 다시 나간다
													break gotoForest;

												}

											}

										}

									}
									// 트레이너가 전투가 불가능 할 때
									else {

										System.out.println(
												상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1).getName()
														+ "와는 싸울 수 없습니다!");

									}

								}
								// 0번 뒤로가기
								else if (selected_menu_num.equals("0")) {

									break;
								}
								// 잘못 입력시!
								else {
									System.out.println();
									System.out.println("다시입력해주세요!");
									oneLine.pressEnter();
								}

							}

						}
						// 3. 아이템을 줍는다.
						else if (selected_menu_num.equals("3")) {


							while (true) {

								상록숲.showItems();

								System.out.println("몇번 아이템을 주으시겠습니까? \t\t\t\t\t\t\t\t\t\t\t (뒤로가기 : 0번)");
								System.out.print("번호 입력: ");
								
								try {

									selected_menu_num = scanner.next();
									Music buttonSound = new Music("버튼음.mp3", false);
									buttonSound.start();

									// 1개에서 떨어져 있는 최대 아이템 번호까지를 입력 했을 때!
									if (Integer.parseInt(selected_menu_num) >= 1
											&& Integer.parseInt(selected_menu_num) <= 상록숲.getDroppedItem().size()) {

										// 맞춘 숫자를 저장하는 변수
										int count = 0;

										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

										System.out.println("5초 동안 1~9의 숫자중 랜덤으로 나오는 한개의 숫자를 똑같이 5번 이상 입력 하면 아이템을 획득하실 수 있습니다!");
										System.out.print("시작 하시려면 아무키나 입력해주세요!!");
										scanner.next();
										Music buttonSound1 = new Music("버튼음.mp3", false);
										buttonSound1.start();

										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										System.out.println("시작!!");
										System.out.println();

										// 시간 측정해주는 쓰레드 객체 생성(5초까지 카운트)
										CountSecondThread itemThread = new CountSecondThread(5);
										itemThread.start();
										itemThread.join();

										// 게임 시작!!
										do {

											int random_num = random.nextInt(9) + 1;
											
											System.out.println(random_num + "입력!");
											
											try {
												int num = scanner.nextInt();
												Music buttonSound2 = new Music("버튼음.mp3", false);
												buttonSound2.start();

												if (random_num == num) {
													count++;
												}
											} catch (InputMismatchException e) {
												System.out.println("잘못 입력하셨습니다!");
											}
											

										} while (itemThread.getSecond() < 5);

										if (count >= 5) {
											System.out.println("성공");

											oneLine.pressEnter();

											System.out.println(상록숲.getDroppedItem()
													.get(Integer.parseInt(selected_menu_num) - 1).getName() + "을 주었습니다!");

											// 주은 아이템이 지우 가방으로!

											지우.receiveItem(
													상록숲.getDroppedItem().remove(Integer.parseInt(selected_menu_num) - 1));

										} else {
											System.out.println("실패!");
											oneLine.pressEnter();
										}

										System.out.println("아무키나 입력하세요!");
										scanner.next();

									}
									// 0번 입력 뒤로가기
									else if (selected_menu_num.equals("0")) {
										break;
									} 
									//잘못입력했을시!
									else {
										System.out.println();
										System.out.println("다시 입력해주세요!");
										oneLine.pressEnter();
									}

								} catch (NumberFormatException e) {
									System.out.println();
									System.out.println("숫자만 입력하세요!!");
									oneLine.pressEnter();
								}

							}

						}
						// 4. 지우의 상태를 본다
						else if (selected_menu_num.equals("4")) {

							while (true) {

								지우.showMenu();
								System.out.println("무엇을 보시겠습니까?");
								System.out.print("번호 입력: ");
								selected_menu_num = scanner.next();
								Music buttonSound3 = new Music("버튼음.mp3", false);
								buttonSound3.start();

								// 1. 지우의 기본정보
								if (selected_menu_num.equals("1")) {
									지우.showInformation();
									System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
									scanner.next();
									Music buttonSound1 = new Music("버튼음.mp3", false);
									buttonSound1.start();
								}

								// 2. 지우의 포켓몬들
								else if (selected_menu_num.equals("2")) {
									지우.showPokeMons();
									지우.showPokemonDetail();
//									System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
//									scanner.next();
								}

								// 3. 지우의 아이템가방
								else if (selected_menu_num.equals("3")) {
									지우.showItemBag();
									System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
									scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();
								}

								// 0. 뒤로가기
								else if (selected_menu_num.equals("0")) {
									break;
								}
								//잘못 입력시
								else {
									System.out.println();
									System.out.println("다시 입력해주세요!");
									oneLine.pressEnter();
								}

							}

						}
						// 0. 맵을 이동한다.
						else if (selected_menu_num.equals("0")) {

							상록숲.showOtherMap();
							System.out.println("어디로 가시겠습니까?");
							System.out.print("번호이동: ");
							map_num = scanner.next();
							Music buttonSound = new Music("버튼음.mp3", false);
							buttonSound.start();

							if (map_num.equals("1")) {
								
								// rainSound.close();
								// rainThread.join();
//								rainThread.close();

								// 상록숲 음악 종료!
								forestMusic.close();
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								System.out.println();
								System.out.println("태초마을로 이동합니다....");
								System.out.println();
								LoadingThread loadingThread2 = new LoadingThread();
								loadingThread2.start();
								loadingThread2.join();

								

								break;

							} else if (map_num.equals("3")) {
								
								//rainSound.close();
//								rainThread.close();

								// 상록숲 음악 종료!
								forestMusic.close();
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								
								System.out.println();
								System.out.println("회색시티로 이동합니다....");
								System.out.println();
								
								LoadingThread loadingThread2 = new LoadingThread();
								loadingThread2.start();
								loadingThread2.join();

								break;
							} else {
								System.out.println();
								System.out.println("다시 입력해주세요!");
								oneLine.pressEnter();
							}

						}
						// 11.자동 사냥!
						else if(selected_menu_num.equals("11")) {
							
							System.out.println();
							System.out.println("자동 사냥을 시작합니다!");
							oneLine.pressEnter();
							
							Thread waitingPokemonThread = new WaitingPokemonThread();
							waitingPokemonThread.start();
							waitingPokemonThread.join();

							// 상록숲 음악 종료
							forestMusic.close();
							
							// 야생포켓몬 옴악 시작
							Music wildMusic = new Music("야생포켓몬.mp3", true);
							wildMusic.start();

							Thread.sleep(1000);

							// 상록숲 안에 있는 몬스터들의 숫자를 변수에 저장
							int pokemon_num = 상록숲.getAppearingPokeMon().size();
							// 랜덤 숫자를 받아서 변수에 저장
							int randam_num = random.nextInt(pokemon_num);

							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

							System.out.println(상록숲.getAppearingPokeMon().get(randam_num).getName() + "가 나타났습니다!!!");
							상록숲.getAppearingPokeMon().get(randam_num).showPicture();
							
							AutoBattleThread autoBattleThread = new AutoBattleThread(지우, 상록숲.getAppearingPokeMon().get(randam_num), 전투장);
							autoBattleThread.start();
							autoBattleThread.join();

							// 야생 포켓몬 음악 종료
							wildMusic.close();
							
							// 야생 포켓몬 승리 음악시작
							Music wildVictoy = new Music("야생포켓몬승리.mp3", false);
							wildVictoy.start();

							System.out.println(전투장.getOtherPokemon().getName() + "는 기절했습니다!");

							oneLine.pressEnter();

							System.out.println();

							// 경험치를 준다
							전투장.getMyPokemon().increaseExp(전투장.getOtherPokemon().getDrop_exp());

							Thread.sleep(1000);

							// 죽으면 레벨 업이 되서 다시 리스트에 저장됨!
							전투장.getOtherPokemon().levelUp(전투장.getOtherPokemon().getLevel());

							// 전투장을 나가다
							전투장.outOfMap();

							System.out.println();
							System.out.println("상록숲으로 이동하시려면 아무키나 입력해주세요!");

							oneLine.pressEnter();
							
							// 야생 포켓몬 승리 음악 종료
							wildVictoy.close();
							
							// 상록숲 음악 틀기 위해서 do-while문으로 감!
							break gotoForest;

						
							
						}
						// 잘못 눌렀을 시
						else {
							System.out.println();
							System.out.println("다시 입력해주세요!");
							oneLine.pressEnter();
						}

					}
					
				} while (map_num.equals("2"));
				
				
			}
			
			// 회색시티
			else if(map_num.equals("3")) {
				
				// 회색시티 음악 시작
				Music cityMusic = new Music("회색시티.mp3", true);
				cityMusic.start();
				
				회색시티.comeToMap(지우);
				
				while (true) {
					
					회색시티.showMenu();
					System.out.println("무엇을 하시겠습니까?");
					System.out.print("번호 입력: ");
					selected_menu_num = scanner.next();
					Music buttonSound = new Music("버튼음.mp3", false);
					buttonSound.start();
					
					// 1. 포켓몬 간호사에게 말을 건다.
					if(selected_menu_num.equals("1")) {
						
						System.out.println();
						
						// "어서오세요 저는 포켓몬 간호사 입니다!"
						회색시티.getNurse().sayDialogue(0);
						
						Thread.sleep(1000);
						
						while(true) {
							
							회색시티.getNurse().showMenu();
							
							// "무엇을 도와드릴까요? "
							회색시티.getNurse().sayDialogue(1);
				
							System.out.print("번호 입력: ");
							selected_menu_num = scanner.next();
							Music buttonSound1 = new Music("버튼음.mp3", false);
							buttonSound1.start();
							
							// 1. 포켓몬 회복
							if(selected_menu_num.equals("1")) {
								
								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								System.out.println("지우의 포켓몬들을 간호사에게 건내준다!");

								oneLine.pressEnter();
								
								RecoverPokemonThread recoverPokemonThread = new RecoverPokemonThread();
								recoverPokemonThread.start();
								recoverPokemonThread.join();

								for (int i = 0; i < 지우.getOwned_PokeMon().size(); i++) {
									태초마을.getMom().healPokeMon(지우.getOwned_PokeMon().get(i));
								}

								oneLine.pressEnter();
								

							
							}
							// 2. 포켓몬 맡기기
							else if (selected_menu_num.equals("2")) {
								
								while(true) {
									지우.showPokeMons();
									System.out.println("몇 번 포켓몬을 맡기시겠습니까? \t\t\t\t\t\t\t\t\t\t (뒤로가기 :0번)");
									System.out.print("번호 입력: ");
									selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();
									
									if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num) <= 지우.getOwned_PokeMon().size()) {
									
										회색시티.getNurse().receivePokeMon(지우.getOwned_PokeMon().remove(Integer.parseInt(selected_menu_num)-1));
										
										oneLine.pressEnter();
										
									}
									else if(selected_menu_num.equals("0")) {
										break;
									}
									else {
										System.out.println();
										System.out.println("다시 입력해 주세요!");
										oneLine.pressEnter();
									}
									
									
								}
								
								
								
							}
							// 3. 포켓몬 찾기
							else if (selected_menu_num.equals("3")) {
								
								회색시티.getNurse().showPokeMons();
								System.out.println("몇 번 포켓몬을 찾으시겠습니까? \t\t\t\t\t\t\t\t\t\t (뒤로가기 :0번)");
								System.out.print("번호 입력: ");
								selected_menu_num = scanner.next();
								Music buttonSound2 = new Music("버튼음.mp3", false);
								buttonSound2.start();
								
								System.out.println("지우가 " + 회색시티.getNurse().getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1).getName() + "을 찾았습니다!");
								
								지우.getPokeMon(회색시티.getNurse().getOwned_PokeMon().remove(Integer.parseInt(selected_menu_num)-1));
								
								oneLine.pressEnter();
								
								
							}
							// 0. 나가기
							else if (selected_menu_num.equals("0")) {
								break;
							}
							// 잘못 눌렀을 시
							else {
								System.out.println();
								System.out.println("다시 입력해주세요!");
								oneLine.pressEnter();
							}
						}
						
						
					}
					// 2. 마트주인에게 말을 건다.
					else if(selected_menu_num.equals("2")) {
						
						while(true) {
							회색시티.getMart_owner().showItems();
							System.out.println("현재 잔액 : " + 지우.getMoney() + "원");
							System.out.println("무엇을 사시겠습니까? \t\t\t\t\t\t\t\t\t\t\t (뒤로가기 :0번)");
							System.out.print("번호 입력 : ");
							selected_menu_num = scanner.next();
							Music buttonSound1 = new Music("버튼음.mp3", false);
							buttonSound1.start();
							
							//1. 포켓볼
							if(selected_menu_num.equals("1")) {
							
								while(true) {
									
									System.out.println("몇 개를 구입하시겠습니까? \t\t\t\t\t\t\t\t\t\t\t (뒤로가기 : 0번)");
									System.out.print("갯수 입력: ");
									second_selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();
									
									int item_num = Integer.parseInt(second_selected_menu_num);
									
									// 지우가 돈이 있거나 포켓볼이 수량이 남았을 떄
									if(지우.getMoney() >= 200 && item_num > 0 && item_num <= 회색시티.getMart_owner().getOwned_pokeball().size()) {
										// 수량대로 포켓볼이 입력 받음
										for (int i = 0; i < item_num; i++) {
											// 지우에게 돈이 들어옴!
											지우.getItembag().getPokeball().add(회색시티.getMart_owner().getOwned_pokeball().remove(0));
											// 지우의 돈이 나감
											지우.giveMoney(200);
												
										}
										
										System.out.println("지우가 포켓볼 " + item_num + "개를 구입했습니다!");
										
										oneLine.pressEnter();
										
										break;
										
									}
									else if (second_selected_menu_num.equals("0")) {
										break;
									}
									
									else {
										System.out.println();
										System.out.println("다시입력해주세요!");
										oneLine.pressEnter();
									}
								
								}
								
							}
							//2. 회복약
							else if(selected_menu_num.equals("2")) {
								
								while(true) {

									System.out.println("몇 개를 구입하시겠습니까? \t\t\t\t\t\t\t\t\t\t\t (뒤로가기 : 0번)");
									System.out.print("갯수 입력: ");
									second_selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();
									
									int item_num = Integer.parseInt(second_selected_menu_num);
										
									// 지우가 돈이 있거나 포켓볼이 수량이 남았을 떄
									if(지우.getMoney() >= 300 && item_num > 0 && item_num <= 회색시티.getMart_owner().getOwned_potion().size()) {
										// 수량대로 포켓볼이 입력 받음
										for (int i = 0; i < item_num; i++) {
											// 지우에게 돈이 들어옴!
											지우.getItembag().getPotion().add(회색시티.getMart_owner().getOwned_potion().remove(0));
											// 지우의 돈이 나감
											지우.giveMoney(300);
											
										}
										
										System.out.println("지우가 회복약 " + item_num + "개를 구입했습니다!");

										oneLine.pressEnter();
										
										break;
										
									}
									else if (second_selected_menu_num.equals("0")) {
										break;
									}
									
									else {
										System.out.println();
										System.out.println("다시입력해주세요!");
										oneLine.pressEnter();
									}
									
								}
								
								
							}
							//0. 나가기
							else if(selected_menu_num.equals("0")) {
								break;
							}
							else {
								System.out.println();
								System.out.println("잘못입력했습니다!");
								oneLine.pressEnter();
							}
						}
						
						
					}
					// 3. 관장에게 말을 건다.
					else if(selected_menu_num.equals("3")) {
						
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("웅이: 오 지우! 드디어 너가 회색이 관장이 나한테 오다니");
						
						oneLine.pressEnter();
						
						System.out.println("웅이: 나를 이기면 포켓몬 배지를 얻을 수 있다");
						
						oneLine.pressEnter();
						
						System.out.println("웅이: 하지만 순순히 그렇게 되지는 않을껄?...");
						
						oneLine.pressEnter();
						
						//회색시티 음악 종료
						cityMusic.close();
						
						//관장 트레이너 음악 시작
						Music gymTrainerMusic = new Music("관장트레이너.mp3", true);
						gymTrainerMusic.start();
						
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						
						// 전투장 입장
						전투장.comeToMap(지우);
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						전투장.comeToMap(회색시티.getGym_trainer());
						
						// 상대 트레이너 포켓몬 사진 보여줌!
						회색시티.getGym_trainer().getOwned_PokeMon().get(0).showPicture();
						
						int count = 0;
						
						//상대 포켓몬 자동 공격!
						AutoAttackThread attackThread = new AutoAttackThread(전투장, 전투장.getMyPokemon(), 전투장.getOtherPokemon());
						attackThread.start();
						
						//전투 시작
						while(true) {

							전투장.showBattleField();
							전투장.showMenu();

							selected_menu_num = scanner.next();
							Music buttonSound1 = new Music("버튼음.mp3", false);
							buttonSound1.start();
							
							attackThread.close();

							// 1. 싸운다
							if (selected_menu_num.equals("1")) {

								전투장.fight();

							}
							// 2. 포켓몬
							else if (selected_menu_num.equals("2")) {

								while (true) {
									// 지우의 포켓몬 리스트를 보여준다
									전투장.get지우().showPokeMons();

									System.out.println("몇 번 포켓몬으로 바꾸시겠습니까? (나가기: 0번)");
									System.out.print("번호 입력: ");
									selected_menu_num = scanner.next();
									Music buttonSound2 = new Music("버튼음.mp3", false);
									buttonSound2.start();

									// 지우가 가지고 있는 포켓몬 범위 내의 숫자를 입력 했을 시
									if (Integer.parseInt(selected_menu_num) >= 1
											&& Integer.parseInt(selected_menu_num) <= 전투장.get지우()
													.getOwned_PokeMon().size()) {
										System.out.print("들어 와 " + 전투장.getMyPokemon().getName() + "!! ");
										전투장.changePokemon(전투장.get지우().getOwned_PokeMon()
												.get(Integer.parseInt(selected_menu_num) - 1));

										System.out.println("가랏 " + 전투장.getMyPokemon().getName() + "!! ");
										break;
									}
									// 0번 입력시
									else if (selected_menu_num.equals("0")) {
										break;
									} else {
										System.out.println();
										System.out.println("다시 입력해주세요!!");
										oneLine.pressEnter();
									}

								}

							}
							// 3. 아이템 가방
							else if (selected_menu_num.equals("3")) {
								전투장.get지우().showItemBag();
								System.out.println("어떤 아이템을 사용하시겠습니까?");
								System.out.print("번호 입력: ");
								selected_menu_num = scanner.next();
								Music buttonSound7 = new Music("버튼음.mp3", false);
								buttonSound7.start();

								// 포켓볼 사용
								if (selected_menu_num.equals("1")) {

									System.out.println("주인이 있는 포켓몬은 잡을 수 없습니다!");
									oneLine.pressEnter();

								}
								// 회복약 사용
								else if (selected_menu_num.equals("2")) {

									// 지우가 회복약이 있을 떄!
									if (전투장.get지우().getItembag().getPotion().size() != 0) {

										전투장.get지우().getItembag().getPotion().remove(0)
												.healPokeMon(전투장.get지우().getOwned_PokeMon().get(0));

									} else if (전투장.get지우().getItembag().getPotion().size() == 0) {

										System.out.println("회복약이 없습니다!!");
										oneLine.pressEnter();

									}

								}

							}
							// 0. 도망간다
							else if (selected_menu_num.equals("0")) {
								System.out.println();
								System.out.println("트레이너와 전투중에는 도망 갈 수 없습니다!");
								oneLine.pressEnter();
							}
							// 잘못 입력했을시
							else {
								System.out.println();
								System.out.println("다시 입력해주세요!");
								oneLine.pressEnter();
							}

							// 내포켓몬의 체력이 0일때
							if (전투장.getMyPokemon().getHp() == 0) {
								System.out.println(전투장.getMyPokemon().getName() + "는 기절했습니다!");

								break;
							}
							// 야생포켓몬의 체력이 0일때
							else if (전투장.getOtherPokemon().getHp() == 0) {
								
								전투장.showBattleField();
								System.out.println(전투장.getOtherPokemon().getName() + "는 기절했습니다!");
								
								oneLine.pressEnter();
								// 경험치를 준다(트레이너와 싸우면 추가 경험치 획득)
								전투장.getMyPokemon().increaseExp(전투장.getOtherPokemon().getDrop_exp() + 20);
								
								oneLine.pressEnter();

								// 트레이너가 포켓몬이 남아 있을 때
								if (count + 1 < 전투장.getTrainer().getOwned_PokeMon().size()) {
									// 상대 트레이너 첫번째 포켓몬 죽음
									if (전투장.getTrainer().getOwned_PokeMon().get(count).getHp() == 0) {
										
										System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
										
										System.out.println(전투장.getTrainer().getName() + ": " + "이런.. 들어와!" + 전투장.getOtherPokemon().getName());
										
										// 죽은 포켓몬은 나감
										전투장.outOfMap(전투장.getTrainer().getOwned_PokeMon().get(count));
										
										count++;
										
										// 다른 포켓몬이 전투장으로 들어옴
										전투장.comeToMap(전투장.getTrainer().getOwned_PokeMon().get(count));
										
										System.out.println();
										
										System.out.println(전투장.getTrainer().getName() + ": " + "가랏! " + 전투장.getOtherPokemon().getName());
										
										// 새로운 포켓몬 사진을 보여줌!
										전투장.getOtherPokemon().showPicture();
										
									}

								}
								// 트레이너가 포켓몬이 없을 때
								else {
									
									gymTrainerMusic.close();
									
									//트레이너 승리 음악 시작
									Music trainerVictory = new Music("관장트레이너승리.mp3", false);
									trainerVictory.start();
									
									oneLine.pressEnter();
									
									System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
									System.out.println(전투장.getTrainer().getName() + "와의 승부에게 이겼다 !");
									System.out.println();

									oneLine.pressEnter();
									
									// 트레이너가 지우에게 돈을 준다!
									System.out.println();
									전투장.getTrainer().giveMoney(전투장.get지우());
									oneLine.pressEnter();
									
									System.out.println("웅이: 오! 지우!! 대단한데...");
									
									oneLine.pressEnter();
									
									System.out.println("웅이: 나를 이긴 댓가로 회색배지를 주지!!");
									
									oneLine.pressEnter();
									
									System.out.println("지우가 포켓몬배지(회색배지)를 얻었습니다!");
									
									oneLine.pressEnter();
									
									지우.setBadge(1);
									
									// 트레이너가 전투 불가 상태로 바꾼다
									전투장.getTrainer().setBattleAvailable(false);

									// 전투장을 나가다
									전투장.outOfMap();
									
									System.out.println("회색시티로 이동하시려면 아무키나 입력해주세요!");

									oneLine.pressEnter();

									//트레이너 승리 음악 종료!
									trainerVictory.close();

									break;

								}

							}

						}
						
					}
					// 4. 지우의 상태를 본다
					else if (selected_menu_num.equals("4")) {

						while (true) {

							지우.showMenu();
							System.out.println("무엇을 보시겠습니까?");
							System.out.print("번호 입력: ");
							selected_menu_num = scanner.next();
							Music buttonSound3 = new Music("버튼음.mp3", false);
							buttonSound3.start();

							// 1. 지우의 기본정보
							if (selected_menu_num.equals("1")) {
								지우.showInformation();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
								scanner.next();
								Music buttonSound1 = new Music("버튼음.mp3", false);
								buttonSound1.start();
							}

							// 2. 지우의 포켓몬들
							else if (selected_menu_num.equals("2")) {
								지우.showPokeMons();
								지우.showPokemonDetail();
//								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
//								scanner.next();
							}

							// 3. 지우의 아이템가방
							else if (selected_menu_num.equals("3")) {
								지우.showItemBag();
								System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t   (뒤로가기 : 0번 입력)");
								scanner.next();
								Music buttonSound2 = new Music("버튼음.mp3", false);
								buttonSound2.start();
							}

							// 0. 뒤로가기
							else if (selected_menu_num.equals("0")) {
								break;
							}
							//잘못 입력시
							else {
								System.out.println();
								System.out.println("다시 입력해주세요!");
								oneLine.pressEnter();
							}

						}

					}
					// 0. 맵을 이동한다.
					else if (selected_menu_num.equals("0")) {

						회색시티.showOtherMap();
						System.out.println("앤딩 : 4");
						System.out.println("어디로 가시겠습니까?");
						System.out.print("번호이동: ");
						map_num = scanner.next();
						Music buttonSound1 = new Music("버튼음.mp3", false);
						buttonSound1.start();
						

						if (map_num.equals("2")) {
							// 회색마을 음악 종료
							cityMusic.close();
							
							System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
							
							System.out.println();
							System.out.println("상록숲으로 이동합니다....");
							System.out.println();
							LoadingThread loadingThread2 = new LoadingThread();
							loadingThread2.start();
							loadingThread2.join();

							break;
						} else if (map_num.equals("1")) {
							System.out.println();
							System.out.println("상록숲을 지나서 갈 수 있습니다!");
							oneLine.pressEnter();
						}
						else if(map_num.equals("4")) {
							
							if(지우.getBadge() == 1) {
								
								break;
							}
							else {
								System.out.println();
								System.out.println("뱃지가 있어야 갈 수 있습니다!!");
								oneLine.pressEnter();
							}
						
						}
						else {
							System.out.println();
							System.out.println("잘못 입력하셨습니다!");
							oneLine.pressEnter();
						}

					}
					
					// 잘못 입력 했을 때
					else {
						System.out.println();
						System.out.println("다시 입력해주세요!");
						oneLine.pressEnter();
					}
				}
				
			}
			else if(map_num.equals("4")) {
				System.out.println("오박사: 오 지우! 축하하네!");
				
				oneLine.pressEnter();
				
				System.out.println("오박사: 자네는 배지를 얻어 진정한 포켓몬 트레이너가 되었다네!!");
				
				oneLine.pressEnter();
				
				System.out.println("오박사: 축하하네!!");
				
				oneLine.pressEnter();
				
				Ending ending = new Ending();
				ending.win();
				
				break;
				
			}
			
		}

	}
	
}
