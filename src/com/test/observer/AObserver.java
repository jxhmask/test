package com.test.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * π€≤Ï’ﬂ
 * @author jxh
 *
 */
public class AObserver implements Observer {

	public AObserver(ServerManager sm) {
		super();
		sm.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("AObserver:" + ((ServerManager)o).getDate() + ";asdfasd adfasdf" + arg);
		//hello 
	}

}
