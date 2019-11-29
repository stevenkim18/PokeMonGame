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
		
		System.out.println("\t\t\t\t\t    ������ ������ ���÷��� Enter�� �����ּ���!");
		
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
		System.out.println("�������������������������������������������������������������������������������������������������������� ���� ���� ����������������������������������������������������������������������������������������������������������������");
		System.out.println("<���� ��ǥ>");
		System.out.println("ȸ����Ƽ�� ���� ���̸� �̰ܼ� �ְ��� ���ϸ� Ʈ���̳ʰ� ����");
		System.out.println("");
		System.out.println("<���� ����>");
		System.out.println(" - ���ΰ� ����� ó�� ���ڻ翡 ���ϸ��� �޴´�");
		System.out.println(" - ���� ����� ���ϸ��� ������ �߻� ���ϸ��̳� Ʈ���̳ʿ� �ο��� ���ϸ��� ������ �� �ִ�");
		System.out.println(" - ���� ���ϸ��� ��Ƽ� ���������� ���ϸ��� ������ �ٴ� �� �ִ�");
		System.out.println();
		System.out.println("<�� ����>");
		System.out.println(" 1. ���ʸ���");
		System.out.println(" - ���ΰ� ���찡 ������ �����ϴ� �����ν� ���ϸ� Ʈ���̳ʰ� �Ǳ� ���� ���� ���ǵ��� �޴� ����̴�");
		System.out.println(" 2. ��Ͻ�");
		System.out.println(" - Ǯ �Ӽ��� ���ϸ���� �ʿ� �ִ�");
		System.out.println(" - ��� �� �� �ִ� Ʈ���̳ʵ��� �ִ�");
		System.out.println(" - �ʿ� ������ �����۵��� �ֿ� �� �ִ�");
		System.out.println(" 3. ȸ����Ƽ");
		System.out.println(" - ���ϸ��� ȸ�� ��ų �� �ִ� ��ȣ��� �������� �� �� �ִ� ��Ʈ������ �ִ�");
		System.out.println(" - ���� ������ ȸ����Ƽ�� ���� ���̰� �ִ�");
		System.out.println(" - ���̿��� ��Ʋ���� �̱�� ���ϸ� ������ ��� ������ ���� ��ų �� �ִ�!");
		System.out.println();
		System.out.println(" * ���� ������ ���ʸ��� - ��Ͻ� - ȸ����Ƽ ���̸� �ٷ� ���� �ִ� ������ �̵� ����! *");
		System.out.println();
		System.out.println("������ ���� �Ͻ÷��� Enter�� �����ּ���!!");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

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

