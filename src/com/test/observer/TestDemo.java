package com.test.observer;

public class TestDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ServerManager sm = new ServerManager();
        AObserver a    = new AObserver(sm);
        BObserver b = new BObserver(sm);
        sm.setData(5);
        sm.deleteObserver(a);//ע���۲��ߣ��Ժ󱻹۲��������ݱ仯�Ͳ���֪ͨ�����ע���Ĺ۲���
        sm.setData(10);
    }

}