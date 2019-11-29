package thread;

import function.OneLine;

public class LogoThread extends Thread{
	
	@Override
	public void run() {
		
		OneLine line = new OneLine();
		
		int second = 300;
		
		do {
			
			try {
				showLogo();
				Thread.sleep(second);
				
				showLogoPlus();
				Thread.sleep(second);
				
				second -= 20;
			} catch (InterruptedException e) {
		
			}
			
		} while (second > 0);
		
		System.out.println("\t\t\t\t\t    게임의 설명을 보시려면 Enter를 눌러주세요!");
		
		line.pressEnter();
		
		gameDescription();
		
	}
	
	
	public void showLogo() {
		System.out.println("\n\n"); // 5
		System.out.println("                                                           .::.");
		System.out.println("                                  		         .;:**'            ");
		System.out.println("                                                        `                  ");
		System.out.println("                             .:XHHHHk.              db.   .;;.     dH  MX   ");
		System.out.println("                           oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN");
		System.out.println("                           QMMMMMb  \"MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM");
		System.out.println("                             `MMMM.  )M> :X!Hk. MMMM   XMM.o\"  .  MMMMMMM X?XMMM MMM>!MMP");
		System.out.println("                              'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `\" MX MMXXMM");
		System.out.println("                               ~MMMMM~ XMM. .XM XM`\"MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP");
		System.out.println("                                ?MMM>  YMMMMMM! MM   `?MMRb.    `\"\"\"   !L\"MMMMM XM IMMM");
		System.out.println("                                 MMMX   \"MMMM\"  MM       ~%:           !Mh.\"\"\" dMI IMMP");
		System.out.println("                                 'MMM.                                             IMX");       //12
		System.out.println("\n\n\n\n\n\n\n\n"); // 6

	}
	
	public void showLogoPlus() {
		System.out.println("\n\n"); // 5
		System.out.println("                                                           .::.");
		System.out.println("                                  		         .;:**'            ");
		System.out.println("                                                        `                  ");
		System.out.println("                             .:XHHHHk.              db.   .;;.     dH  MX   ");
		System.out.println("                           oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN");
		System.out.println("                           QMMMMMb  \"MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM");
		System.out.println("                             `MMMM.  )M> :X!Hk. MMMM   XMM.o\"  .  MMMMMMM X?XMMM MMM>!MMP");
		System.out.println("                              'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `\" MX MMXXMM");
		System.out.println("                               ~MMMMM~ XMM. .XM XM`\"MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP");
		System.out.println("                                ?MMM>  YMMMMMM! MM   `?MMRb.    `\"\"\"   !L\"MMMMM XM IMMM");
		System.out.println("                                 MMMX   \"MMMM\"  MM       ~%:           !Mh.\"\"\" dMI IMMP");
		System.out.println("                                 'MMM.                                             IMX");       //12
		System.out.println("                                    ___  _                  _______                 __  ");
		System.out.println("                                  .' ..](_)                |_   __ \\               |  ] ");
		System.out.println("                                 _| |_  __   _ .--.  .---.   | |__) |  .---.   .--.| |  ");
		System.out.println("                                '-| |-'[  | [ `/'`\\]/ /__\\\\  |  __ /  / /__\\\\/ /'`\\' |  ");
		System.out.println("                                  | |   | |  | |    | \\__., _| |  \\ \\_| \\__.,| \\__/  |");
		System.out.println("                                 [___] [___][___]    '.__.'|____| |___|'.__.' '.__.;__] ");
		System.out.println("\n\n"); // 6

	}
	
	public void gameDescription() {
		System.out.println("──────────────────────────────────────────────────── 게임 설명 ────────────────────────────────────────────────────────");
		System.out.println("<게임 목표>");
		System.out.println("회색시티의 관장 웅이를 이겨서 최고의 포켓몬 트레이너가 되자");
		System.out.println("");
		System.out.println("<게임 설명>");
		System.out.println(" - 주인공 지우는 처음 오박사에 포켓몬을 받는다");
		System.out.println(" - 이후 지우는 포켓몬을 가지고 야생 포켓몬이나 트레이너와 싸워서 포켓몬을 육성할 수 있다");
		System.out.println(" - 또한 포켓몬을 잡아서 여러마리의 포켓몬을 데리고 다닐 수 있다");
		System.out.println();
		System.out.println("<맵 설명>");
		System.out.println(" 1. 태초마을");
		System.out.println(" - 주인공 지우가 게임을 시작하는 마을로써 포켓몬 트레이너가 되기 위해 여러 물건들을 받는 장소이다");
		System.out.println(" 2. 상록숲");
		System.out.println(" - 풀 속성의 포켓몬들이 맵에 있다");
		System.out.println(" - 대결 할 수 있는 트레이너들이 있다");
		System.out.println(" - 맵에 떨어진 아이템들을 주울 수 있다");
		System.out.println(" 3. 회색시티");
		System.out.println(" - 포켓몬을 회복 시킬 수 있는 간호사와 아이템을 살 수 있는 마트주인이 있다");
		System.out.println(" - 최종 보스인 회색시티의 관장 웅이가 있다");
		System.out.println(" - 웅이와의 배틀에서 이기면 포켓몬 배지를 얻고 게임을 종료 시킬 수 있다!");
		System.out.println();
		System.out.println(" * 맵의 순서는 태초마을 - 상록숲 - 회색시티 순이며 바로 옆에 있는 마을만 이동 가능! *");
		System.out.println();
		System.out.println("게임을 시작 하시려면 Enter를 눌러주세요!!");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");

	}
	
	
	public static void main(String[] args) {
		
		LogoThread logoThread = new LogoThread();
		logoThread.gameDescription();
		
	}
	
	
}





/*
 *  ___  _                  _______                 __  
  .' ..](_)                |_   __ \               |  ] 
 _| |_  __   _ .--.  .---.   | |__) |  .---.   .--.| |  
'-| |-'[  | [ `/'`\]/ /__\\  |  __ /  / /__\\/ /'`\' |  
  | |   | |  | |    | \__., _| |  \ \_| \__.,| \__/  |  
 [___] [___][___]    '.__.'|____| |___|'.__.' '.__.;__] 
 */

