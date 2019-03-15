package test.lock;

public class OptimisticLock {
	//��ǰ�İ汾��
	private static int version = 0;
	
	public static void invoke(int v, String value){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(version != v){
			System.out.println("�汾�Ų�һ�£��ع�����" + value);
		}else{
			v ++;
			version = v;
			System.out.println("�汾һ��" + value);
		}
	}
	
	
	public static void main(String[] args) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i = 0; i < 3; i++){
					OptimisticLock.invoke(OptimisticLock.version, "A");
					
				}			
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i = 0; i < 3; i++){
					OptimisticLock.invoke(OptimisticLock.version, "B");
					
				}			
			}
			
		}).start();
	}
	
}
