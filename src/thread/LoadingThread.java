package thread;

public class LoadingThread extends Thread{
	
	String loadingbar = "�ε��ߢ�������������������������������������������������������������������������������������������������������������������������������������������������������������������"; 
	
	@Override
	public void run() {
		for (int i = 0; i < loadingbar.length(); i++) {
			System.out.print(loadingbar.substring(i, i+1));
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
