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

		//변수 선언
		String selected_menu_num; // 입력 받을 변수
		String second_selected_menu_num; // 입력 받을 변수가 2개일 경우 따로 쓰는 변수! 
		OneLine oneLine = new OneLine(); // 한줄을 띄고 엔터를 입력받기 위한 객체
		PrintOnebyone print = new PrintOnebyone();
		
		// 오박사 객체 생성
		Dr_OH 오박사 = new Dr_OH("오박사", "태초마을");

		// 지우 객체 생성
		MainCharacter 지우 = new MainCharacter("지우");
		
		// 맵 객체 생성
		Village 태초마을 = new Village("태초마을");
		ViridianForest 상록숲 = new ViridianForest("상록숲");
		City 회색시티 = new City("회색시티");
		
		Battlefield 전투장 = new Battlefield("전투장");

		Logo 로고 = new Logo();
		로고.showLogo();
		
		oneLine.pressEnter();
		
		Thread loadingThread = new LoadingThread();
		loadingThread.start();
		loadingThread.join();
		//loadingThread.interrupted();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //25
		
		oneLine.pressEnter();
		
		// <오박사 오프닝>
		// [start] 
		// 오박사 오프닝 대사를 함
		// 차례대로 대사가 나옴
		// Enter를 눌러야 다음 대사로 넘어감
		for (int i = 0; i < 11; i++) {
			System.out.print("                                                                       ");
			print.printSentence(오박사.getDialogue().get(i));
			
			//"너의 이름은 뭐지?" 이후 이름을 물어봐야 함
			if(i == 6) {
				System.out.print("이름 입력 : ");
				String name = "지우"; // scanner.next();
				지우.setName(name);
				System.out.println(지우.getName()+"!!");
				
			}
		}
		
		//[end]
		
		//loadingThread.start();
		//loadingThread.join();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //25
		
		oneLine.pressEnter();
		
		//태초마을로 지우 들어옴
		태초마을.comeToMap(지우);
		
		//태초마을로 오박사가 들어옴
		태초마을.setDr_oh(오박사);
		
		//태초마을
		while(true) {
			
			태초마을.showMenu();
			System.out.println("무엇을 하시겠습니까?");
			System.out.print("번호 입력: ");
			selected_menu_num = scanner.next();
			
			//1. 오박사에게 말을 건다
			if(selected_menu_num.equals("1")) {
				
				// 지우가 포켓몬을 가지고 있지 않을때
				if(지우.getOwned_PokeMon().size() == 0) {

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
					
					//지우가 포켓몬 선택
					while(true) {
						오박사.showPokeMon();
						System.out.println("몇 번 포켓몬을 가지시겠습니까?");
						System.out.print("번호 입력 : ");
						selected_menu_num = scanner.next();
						
						//1~3번 입력 했을 시
						if(selected_menu_num.equals("1") || selected_menu_num.equals("2") || selected_menu_num.equals("3")) {
							
							System.out.println(오박사.getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1).getName() + "를 선택하셨습니다!");
							oneLine.pressEnter();					
							
							System.out.println();
							System.out.println("정말로 가지시겠습니까?");
							System.out.println("1.예 2.아니요");
							System.out.print("번호 입력 : ");
							second_selected_menu_num = scanner.next();
							System.out.println();
							
							//1.예
							if(second_selected_menu_num.equals("1")) {
								
								//오박사 포켓몬 리스트에 있는 선택된 포켓몬을
								//지우의 포켓몬 리스트로 이동한다
								지우.getPokeMon(오박사.givePokeMon(Integer.parseInt(selected_menu_num)));
								
								oneLine.pressEnter();					
								System.out.println("지우는 오박사에게로 부터 " + 지우.getOwned_PokeMon().get(0).getName() + "를 받았다!!");
								oneLine.pressEnter();					
								
								오박사.sayDialogue(15);
								oneLine.pressEnter();					
								
								break;
								
							}
							//2.아니요
							else {
								
							}
							
						}
						//잘못 입력했을 시
						else {
							
							oneLine.pressEnter();					
							System.out.println("잘못 입력하셨습니다!");
							System.out.println("1~3번만 입력해주세요!!");
							oneLine.pressEnter();					
							
						}
						
					}
					
				}
				//지우가 포켓몬을 가지고 있을 떄
				else {
					
					//오박사 포켓볼을 가지고 있을 때
					if(오박사.getOwned_PokeBall().size() != 0) {
						//지우가 포켓몬을 받고 다시 오박사에게 말하면 포켓볼을 준다!
						scanner.nextLine();
						오박사.sayDialogue(16);
						scanner.nextLine();
						
						//지우가 오박사에게로 부터 포켓볼 5개를 받는다.
						for (int i = 0; i < 5; i++) {
							지우.receiveItem(오박사.givePokeBall());
						}
						
						System.out.println("오박사에게 포켓볼 5개를 받았습니다!");
						scanner.nextLine();
						
						오박사.sayDialogue(17);
						scanner.nextLine();
						
						오박사.sayDialogue(18);
						scanner.nextLine();
					}
					//오박사 지우에게 포켓볼을 주고 한개 없을 때
					else if(오박사.getOwned_PokeBall().size() == 0){
						
						scanner.nextLine();
						오박사.sayDialogue(18);
						scanner.nextLine();
						
					}
					
				}
				
			}
			//2. 엄마에게 말을 건다
			else if (selected_menu_num.equals("2")) {
				
				//지우가 포켓몬이 없을 때
				if(지우.getOwned_PokeMon().size() == 0) {
					oneLine.pressEnter();
					태초마을.getMom().sayDialogue(0);
					oneLine.pressEnter();
				}
				//지우가 포켓몬이 있을 때
				else if(지우.getOwned_PokeMon().size() >=1) {
					
					//처음 엄마가 돈을 줄때(엄마 돈이 3000원 있을 때)
					if(태초마을.getMom().getMoney() == 3000) {
						oneLine.pressEnter();
						
						태초마을.getMom().sayDialogue(1);
						
						//엄마가 지우에게 3000원을 준다
						지우.receiveMoney(태초마을.getMom().giveMoney(3000));
						
						oneLine.pressEnter();
						System.out.println("지우가 엄마에게로부터 3000원을 받았습니다!");
						
						oneLine.pressEnter();
						태초마을.getMom().sayDialogue(2);
						
						oneLine.pressEnter();
						태초마을.getMom().sayDialogue(3);
						
						oneLine.pressEnter();
						
					}
					//엄마가 돈을 주고 나서 
					//엄마의 기본 기능을 할때(포켓몬 회복, 돈을 입출금 기능)
					else {
						oneLine.pressEnter();
						태초마을.getMom().sayDialogue(4);
						
						while(true) {
							
							oneLine.pressEnter();
							System.out.println("무엇을 하시겠습니까?");
							System.out.println("1.포켓몬 회복 2.돈을 찾는다 3.돈을 맡긴다 0.그만대화하기");
							System.out.print("번호입력: ");
							selected_menu_num = scanner.next();
							
							//1.포켓몬 회복
							if (selected_menu_num.equals("1")) {
								System.out.println("지우의 포켓몬들을 엄마에게 맡긴다!");
								
								oneLine.pressEnter();
								
								for (int i = 0; i < 지우.getOwned_PokeMon().size(); i++) {
									태초마을.getMom().healPokeMon(지우.getOwned_PokeMon().get(i));
								}
							
								
							}
							//2.돈을 찾는다
							else if(selected_menu_num.equals("2")) {
								
								while(true) {
									System.out.println("찾을 수 있는 돈 : " + 태초마을.getMom().getMoney() + "원");
									System.out.println("얼마를 찾으시겠습니까?");
									System.out.print("금액 입력 (뒤로가기 0입력): ");
									String money = scanner.next();
									
									//0 입력 시 뒤로가기
									if(money.equals("0")) {
										break;
									}
									//금액 입력시
									else {
										// 입력한 금액 만큼 지우에게 돈을 준다
										지우.receiveMoney(태초마을.getMom().giveMoney(Integer.parseInt(money)));
									}
									
								}
								
							}
							//3.돈을 맡긴다
							else if(selected_menu_num.equals("3")) {
								
								while(true) {
									System.out.println("지우의 현재 잔액 : " + 지우.getMoney() + "원");
									System.out.println("얼마를 맡기시겠습니까?");
									System.out.print("금액 입력 (뒤로가기 0입력): ");
									String money = scanner.next();
									
									//0 입력 시 뒤로가기
									if(money.equals("0")) {
										break;
									}
									//금액 입력시
									else {
										// 입력한 금액 만큼 지우가 엄마에게 돈을 맡긴다
										태초마을.getMom().receiveMoney(지우.giveMoney(Integer.parseInt(money)));
									}
								}
								
								
							}
							//0.그만 대화하기
							else if(selected_menu_num.equals("0")) {
								break;
							}
							//잘못 입력 했을 때
							else {

								oneLine.pressEnter();					
								System.out.println("잘못 입력하셨습니다!");
								oneLine.pressEnter();					
								
							}
						}
						
						
					}
					
					
					
				}
				
				
			}
			//3. 지우의 상태를 본다
			else if (selected_menu_num.equals("3")) {
				
				while(true) {
					
					지우.showMenu();
					System.out.println("무엇을 보시겠습니까?");
					System.out.print("번호 입력: ");
					selected_menu_num = scanner.next();
					
					//1. 지우의 기본정보
					if(selected_menu_num.equals("1")) {
						지우.showInformation();
						System.out.print("나가기(아무키나입력)");
						scanner.next();
					}
					
					//2. 지우의 포켓몬들
					else if (selected_menu_num.equals("2")) {
						지우.showPokeMons();
						지우.showPokemonDetail();
						System.out.print("나가기(아무키나입력)");
						scanner.next();
					}
					
					//3. 지우의 아이템가방
					else if (selected_menu_num.equals("3")) {
						지우.showItemBag();
						System.out.print("나가기(아무키나입력)");
						scanner.next();
					}
					
					//0. 뒤로가기
					else if (selected_menu_num.equals("0")) {
						break;
					}
					
				}
				
			}
			//0. 맵을 이동한다.
			else if (selected_menu_num.equals("0")) {
				oneLine.pressEnter();				
				//지우가 포켓몬을 한마리도 가지고 있지 않을 때는
				//태초마을 벗어날 수 없다.
				if(지우.getOwned_PokeMon().size() == 0) {
					System.out.println("지우에게는 포켓몬이 없습니다!!");
					System.out.println("오박사에게 가면 포켓몬을 얻을 수 있습니다!");
				}
				else {
					태초마을.outOfMap();
					break;
				}
				oneLine.pressEnter();
				
			}
			//잘못 입력 했을 시
			else {
				System.out.println();
				System.out.println("다시 입력해주세요!");
				System.out.println();
			}
			
		} // 처음 메뉴로 돌아감!
		
		
		//상록숲
		지우.getOwned_PokeMon().add(new Charmander("파이리" , 11));
		지우.getOwned_PokeMon().add(new Charmander("꼬부기" , 14));
		지우.getItembag().getPokeball().add(new PokeBall("포켓볼", 200));
		지우.getItembag().getPokeball().add(new PokeBall("포켓볼", 200));
		지우.getItembag().getPokeball().add(new PokeBall("포켓볼", 200));
		지우.getItembag().getPokeball().add(new PokeBall("포켓볼", 200));
		지우.getItembag().getPotion().add(new Potion("회복약", 300));
		
		
		while(true) {
			
			상록숲.comeToMap(지우);
			
			상록숲.showMenu();
			System.out.println("무엇을 하시겠습니까?");
			System.out.print("번호 입력: ");
			selected_menu_num = scanner.next();
			
			//1. 야생포켓몬을 기다린다
			if(selected_menu_num.equals("1")) {
				
				System.out.println();
				System.out.println("기다리는 중....");
				System.out.println();
				
				oneLine.pressEnter();
				// 상록숲 안에 있는 몬스터들의 숫자를 변수에 저장
				int pokemon_num = 상록숲.getAppearingPokeMon().size();
				// 랜덤 숫자를 받아서 변수에 저장
				int randam_num = random.nextInt(pokemon_num);
				
				System.out.println(상록숲.getAppearingPokeMon().get(randam_num).getName() + "가 나타났습니다!!!");
				
				전투장.comeToMap(지우);
				전투장.comeToMap(상록숲.getAppearingPokeMon().get(randam_num));
				
				while(true) {
					전투장.showBattleField();
					전투장.showMenu();
					
					selected_menu_num = scanner.next();
					
					//1. 싸운다
					if(selected_menu_num.equals("1")) {
						
						전투장.fight();
						
					}
					//2. 포켓몬
					else if(selected_menu_num.equals("2")) {
						
						while(true) {
							//지우의 포켓몬 리스트를 보여준다
							전투장.get지우().showPokeMons();
							
							System.out.println("몇 번 포켓몬으로 바꾸시겠습니까? (나가기: 0번)");
							System.out.print("번호 입력: ");
							selected_menu_num = scanner.next();
							
							//지우가 가지고 있는 포켓몬 범위 내의 숫자를 입력 했을 시
							if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num) <= 전투장.get지우().getOwned_PokeMon().size()) {
								System.out.print("들어 와 " + 전투장.getMyPokemon().getName() + "!! ");
								전투장.changePokemon(전투장.get지우().getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1));
								
								System.out.println("가랏 " + 전투장.getMyPokemon().getName() + "!! ");
								break;
							}
							// 0번 입력시
							else if(selected_menu_num.equals("0")) {
								break;
							}
							else {
								System.out.println("다시 입력해주세요!!");
							}
							
							
							
						}
						
						
					}
					// 3. 아이템 가방
					else if (selected_menu_num.equals("3")) {
						전투장.get지우().showItemBag();
						System.out.println("어떤 아이템을 사용하시겠습니까?");
						System.out.print("번호 입력: ");
						selected_menu_num = scanner.next();
						
						// 포켓볼 사용
						if(selected_menu_num.equals("1")) {
							
							//지우가 포켓볼이 있을 떄!
							if(전투장.get지우().getItembag().getPokeball().size() != 0) {
								//지우 포켓몬이 잡히기 전 포켓몬 보유 숫자를 저장
								int priorPokemonNum = 전투장.get지우().getOwned_PokeMon().size();
								
								// 지우가 포켓볼을 사용함
								전투장.get지우().getItembag().getPokeball().remove(0).usePokeBall(전투장.get지우(), 전투장.getOtherPokemon());
								
								// 포켓몬을 잡았을 경우 나감 경기장으로 나감
								if(전투장.get지우().getOwned_PokeMon().size() == priorPokemonNum + 1) {
									break;
								}
								System.out.println();
							}
							else if(전투장.get지우().getItembag().getPokeball().size() == 0) {
								
								System.out.println("포켓볼이 없습니다!");
								
							}
							
							
						}
						// 회복약 사용
						else if (selected_menu_num.equals("2")) {
							
							//지우가 회복약이 있을 떄!
							if(전투장.get지우().getItembag().getPotion().size() != 0) {
								
								전투장.get지우().getItembag().getPotion().remove(0).healPokeMon(전투장.get지우().getOwned_PokeMon().get(0));
								
								
							}
							else if(전투장.get지우().getItembag().getPotion().size() == 0) {
								
								System.out.println("회복약이 없습니다!!");
								
							}
							
							
						}
						
					}
					// 0. 도망간다
					else if (selected_menu_num.equals("0")) {
						System.out.println();
						System.out.println("지우가 도망을 갑니다!");
						System.out.println();
						break;
					}
					// 잘못 입력했을시
					else {
						System.out.println();
						System.out.println("다시 입력해주세요!");
						System.out.println();
					}
					
					// 내포켓몬의 체력이 0일때
					if(전투장.getMyPokemon().getHp() == 0) {
						System.out.println(전투장.getMyPokemon().getName() + "는 기절했습니다!");
						
						break;
					}
					// 야생포켓몬의 체력이 0일때
					else if(전투장.getOtherPokemon().getHp() == 0) {
						
						System.out.println(전투장.getOtherPokemon().getName() + "는 기절했습니다!");
						
						System.out.println();
						
						//경험치를 준다
						전투장.getMyPokemon().increaseExp(전투장.getOtherPokemon().getDrop_exp());
						
						//전투장을 나가다
						전투장.outOfMap();
						
						break;
						
					}
					
				}
				
			}
			//2. 트레이너와 배틀을 한다.
			else if(selected_menu_num.equals("2")) {
				
				int count = 0;
				gotoField:
				while(true) {
					
					상록숲.showTrainers();
					
					System.out.println("몇번 트레이너와 대결을 하시겠습니까? (뒤로가기: 0번)");
					System.out.print("번호 입력: ");
					selected_menu_num = scanner.next();
					
					//1~3번 입력시!
					if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num)<= 상록숲.getFieldTrainer().size()) {
						
						//트레이너가 전투가 가능 할 때
						if(상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num)-1).isBattleAvailable() == true) {
							
							// 전투장 입장
							전투장.comeToMap(지우);
							전투장.comeToMap(상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1));
							
							// 전투 시작
							while(true) {
								전투장.showBattleField();
								전투장.showMenu();
								
								selected_menu_num = scanner.next();
								
								//1. 싸운다
								if(selected_menu_num.equals("1")) {
									
									전투장.fight();
									
								}
								//2. 포켓몬
								else if(selected_menu_num.equals("2")) {
									
									while(true) {
										//지우의 포켓몬 리스트를 보여준다
										전투장.get지우().showPokeMons();
										
										System.out.println("몇 번 포켓몬으로 바꾸시겠습니까? (나가기: 0번)");
										System.out.print("번호 입력: ");
										selected_menu_num = scanner.next();
										
										//지우가 가지고 있는 포켓몬 범위 내의 숫자를 입력 했을 시
										if(Integer.parseInt(selected_menu_num) >= 1 && Integer.parseInt(selected_menu_num) <= 전투장.get지우().getOwned_PokeMon().size()) {
											System.out.print("들어 와 " + 전투장.getMyPokemon().getName() + "!! ");
											전투장.changePokemon(전투장.get지우().getOwned_PokeMon().get(Integer.parseInt(selected_menu_num)-1));
											
											System.out.println("가랏 " + 전투장.getMyPokemon().getName() + "!! ");
											break;
										}
										// 0번 입력시
										else if(selected_menu_num.equals("0")) {
											break;
										}
										else {
											System.out.println("다시 입력해주세요!!");
										}
										
										
										
									}
									
									
								}
								// 3. 아이템 가방
								else if (selected_menu_num.equals("3")) {
									전투장.get지우().showItemBag();
									System.out.println("어떤 아이템을 사용하시겠습니까?");
									System.out.print("번호 입력: ");
									selected_menu_num = scanner.next();
									
									// 포켓볼 사용
									if(selected_menu_num.equals("1")) {
									
										System.out.println("주인이 있는 포켓몬은 잡을 수 없습니다!");
										
										
									}
									// 회복약 사용
									else if (selected_menu_num.equals("2")) {
										
										//지우가 회복약이 있을 떄!
										if(전투장.get지우().getItembag().getPotion().size() != 0) {
											
											전투장.get지우().getItembag().getPotion().remove(0).healPokeMon(전투장.get지우().getOwned_PokeMon().get(0));
											
										}
										else if(전투장.get지우().getItembag().getPotion().size() == 0) {
											
											System.out.println("회복약이 없습니다!!");
											
										}
										
										
									}
									
								}
								// 0. 도망간다
								else if (selected_menu_num.equals("0")) {
									System.out.println();
									System.out.println("지우가 도망을 갑니다!");
									System.out.println();
									break;
								}
								// 잘못 입력했을시
								else {
									System.out.println();
									System.out.println("다시 입력해주세요!");
									System.out.println();
								}
								
								// 내포켓몬의 체력이 0일때
								if(전투장.getMyPokemon().getHp() == 0) {
									System.out.println(전투장.getMyPokemon().getName() + "는 기절했습니다!");
									
									break;
								}
								// 야생포켓몬의 체력이 0일때
								else if(전투장.getOtherPokemon().getHp() == 0) {
									
									
									System.out.println(전투장.getOtherPokemon().getName() + "는 기절했습니다!");
									
									System.out.println();
									
									//경험치를 준다(트레이너와 싸우면 추가 경험치 획득)
									전투장.getMyPokemon().increaseExp(전투장.getOtherPokemon().getDrop_exp() + 20);
									
									// 트레이너가 포켓몬이 남아 있을 때
									if(count+1 < 전투장.getTrainer().getOwned_PokeMon().size()) {
										// 상대 트레이너 첫번째 포켓몬 죽음
										if (전투장.getTrainer().getOwned_PokeMon().get(count).getHp() == 0) {

											// 죽은 포켓몬은 나감
											전투장.outOfMap(전투장.getTrainer().getOwned_PokeMon().get(count));
											
											count++;
											
											// 다른 포켓몬이 전투장으로 들어옴
											전투장.comeToMap(전투장.getTrainer().getOwned_PokeMon().get(count));

										}
									}
									//트레이너가 포켓몬이 없을 때
									else {

										System.out.println();
										System.out.println(전투장.getOtherPokemon().getName() + "와의 승부에게 이겼다 !");
										System.out.println();
										
										//트레이너가 지우에게 돈을 준다!
										System.out.println();
										전투장.getTrainer().giveMoney(전투장.get지우());
										System.out.println();
										
										//트레이너가 전투 불가 상태로 바꾼다
										전투장.getTrainer().setBattleAvailable(false);
										
										//전투장을 나가다
										전투장.outOfMap();
										
										//상록숲 메뉴로 다시 나간다
										break gotoField;
										
									}
									
								}
								
							}
						
						}
						//트레이너가 전투가 불가능 할 때
						else {
							
							System.out.println(상록숲.getFieldTrainer().get(Integer.parseInt(selected_menu_num) - 1).getName() + "와는 싸울 수 없습니다!");
							
						}
						
						
					}
					//0번 뒤로가기
					else if(selected_menu_num.equals("0")) {
						break;
					}
					//잘못 입력시!
					else {
						System.out.println();
						System.out.println("다시입력해주세요!");
						System.out.println();
					}
					
				}
				
			}
			// 3. 아이템을 줍는다.
			else if (selected_menu_num.equals("3")) {

			}
			// 4. 지우의 상태를 본다
			else if (selected_menu_num.equals("4")) {
				
				while(true) {
					
					지우.showMenu();
					System.out.println("무엇을 보시겠습니까?");
					System.out.print("번호 입력: ");
					selected_menu_num = scanner.next();
					
					//1. 지우의 기본정보
					if(selected_menu_num.equals("1")) {
						지우.showInformation();
						System.out.print("나가기(아무키나입력)");
						scanner.next();
					}
					
					//2. 지우의 포켓몬들
					else if (selected_menu_num.equals("2")) {
						지우.showPokeMons();
						지우.showPokemonDetail();
						System.out.print("나가기(아무키나입력)");
						scanner.next();
					}
					
					//3. 지우의 아이템가방
					else if (selected_menu_num.equals("3")) {
						지우.showItemBag();
						System.out.print("나가기(아무키나입력)");
						scanner.next();
					}
					
					//0. 뒤로가기
					else if (selected_menu_num.equals("0")) {
						break;
					}
					
				}

			}
			// 0. 맵을 이동한다.
			else if (selected_menu_num.equals("0")) {

			}
			//잘못 눌렀을 시
			else {
				System.out.println();
				System.out.println("다시 입력해주세요!");
				System.out.println();
			}
		}
	}

}
