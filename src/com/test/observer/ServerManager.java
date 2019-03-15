package com.test.observer;

import java.util.Observable;

/**
 * 被观察者
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
			this.setChanged();//已经改变
			data = num;
		}
		this.notifyObservers("hello,world!");//通知所有的观察者
	}
}
