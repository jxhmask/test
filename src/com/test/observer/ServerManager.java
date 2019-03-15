package com.test.observer;

import java.util.Observable;

/**
 * ���۲���
 * @author jxh
 *
 */
public class ServerManager extends Observable{
	private int data = 1;
	
	public int getDate(){
		return data;
	}
	public void setData(int num){
		if(data != num){
			this.setChanged();//�Ѿ��ı�
			data = num;
		}
		this.notifyObservers("hello,world!");//֪ͨ���еĹ۲���
	}
}
