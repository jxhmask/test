package com.test.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲���
 * @author jxh
 *
 */
public class BObserver implements Observer {

	public BObserver(ServerManager sm) {
		super();
		sm.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("AObserver:" + ((ServerManager)o).getDate() + "; " + arg);
		
	}

}
