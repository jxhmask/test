package test.linkedhashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("1", "1");
		m1.put("3", "3");
		m1.put("2", "2");
		m1.put("4", "4");
		Iterator<String> it =  m1.keySet().iterator();
		while(it.hasNext()){
			System.out.println("m1: " + it.next());
		}
		
		System.out.println();
		
		Map<String, String> m2 = new LinkedHashMap<String, String>();
		m2.put("1", "1");
		m2.put("3", "3");
		m2.put("2", "2");
		m2.put("4", "4");
		Iterator<String> it2 =  m2.keySet().iterator();
		while(it2.hasNext()){
			System.out.println("m2: " + it2.next());
		}
		
		
		
	}
}
