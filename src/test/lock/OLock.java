package test.lock;

public class OLock {
	public static int value = 0; // ���߳�ͬʱ���õĲ�������

/**
 * A�߳�Ҫִ�еķ���
 */
public static void invoke(int Avalue, String i)
        throws InterruptedException {
    Thread.sleep(1000L);//�ӳ�ִ��ʱ��
    if (Avalue != value) {//�ж�value�汾
        System.out.println(Avalue + ":" + value + "A�汾��һ��,��ִ��");
        value--;
    } else {
        Avalue++;//�����ݲ���
        value = Avalue;;//�����ݲ���
        System.out.println(i + ":" + value);
    }
}

/**
 * B�߳�Ҫִ�еķ���
 */
public static void invoke2(int Bvalue, String i)
        throws InterruptedException {
    Thread.sleep(1000L);//�ӳ�ִ��ʱ��
    if (Bvalue != value) {//�ж�value�汾
        System.out.println(Bvalue + ":" + value + "B�汾��һ��,��ִ��");
    } else {
        System.out.println("B:����value����,value="+Bvalue);
    }
}

/**
 * ����,�ڴ����:B�߳�ִ�е�ʱ��value�������ǵ�ǰ���µ�
 */
public static void main(String[] args) throws InterruptedException {
    new Thread(new Runnable() {//A�߳�
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    int Avalue = OptimisticLock.value;//A��ȡ��value
                    OptimisticLock.invoke(Avalue, "A");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
    new Thread(new Runnable() {//B�߳�
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    int Bvalue = OptimisticLock.value;//B��ȡ��value
                    OptimisticLock.invoke2(Bvalue, "B");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}}
