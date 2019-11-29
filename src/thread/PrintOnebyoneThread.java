package thread;

public class PrintOnebyoneThread implements Runnable{
	
	//변수
	String sentence; // 한글자씩 출력할 문장을 저장할 변수
	
	//생성자
	//객체를 생성 할때 생성자의 매개변수로 
	//출력할 문장을 객체변수에 저장
	public PrintOnebyoneThread(String str) {
		this.sentence = str;
	}
	
	//객체의 start를 했을 때 실행하는 부분
	@Override
	public void run() {
		
		//객체 변수 sentence의 길이까지 반복함 --> String은 length!
		for (int i = 0; i < this.sentence.length(); i++) {
			
			//substring(0, n) --> 인덱서 0에서 n-1까지 출력!
			System.out.print(sentence.substring(i, i+1));
			try {
				// 1.5초 씩 한글자 한글자씩 출력!
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
