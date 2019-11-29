package thread;

public class PrintOnebyoneThread implements Runnable{
	
	//����
	String sentence; // �ѱ��ھ� ����� ������ ������ ����
	
	//������
	//��ü�� ���� �Ҷ� �������� �Ű������� 
	//����� ������ ��ü������ ����
	public PrintOnebyoneThread(String str) {
		this.sentence = str;
	}
	
	//��ü�� start�� ���� �� �����ϴ� �κ�
	@Override
	public void run() {
		
		//��ü ���� sentence�� ���̱��� �ݺ��� --> String�� length!
		for (int i = 0; i < this.sentence.length(); i++) {
			
			//substring(0, n) --> �ε��� 0���� n-1���� ���!
			System.out.print(sentence.substring(i, i+1));
			try {
				// 1.5�� �� �ѱ��� �ѱ��ھ� ���!
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
