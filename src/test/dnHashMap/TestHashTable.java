package test.dnHashMap;

import java.util.HashMap;
import java.util.Hashtable;


/**
 * HashMap extends AbstractMap implements Map, Cloneable, Serialization
 * HashTable extends Dictionary implements Map, Cloneable, Seriablization
 * 
 * Dictionary 没有具体的实现方法，只有抽象方法(全是方法的声明)； AbstractMap实现Map接口，实现了许多具体的方法，如equals()，toString()
 * 
 * 
 * HashTable 中方法如put(),get(),size(),remove() 加入syncronized,对 该对象进行了加锁
 * 
 * HashTable 中的key，value都不允许为null
 * @author Administrator
 *
 */
public class TestHashTable {
	public static void main(String[] args) {
		Hashtable<String, String> t1 = new Hashtable<String, String>();
		
		t1.put("1", "asdf");
		Hashtable<String, String> t2 = new Hashtable<String, String>();
		t2.put("1", "asdf");
		HashMap<String, String> t3 = new HashMap<String, String>();
		t3.put("1", "asdf");
		HashMap<String, String> t4 = new HashMap<String, String>();
		t4.put("1", "asdf");
		System.out.println(t1.equals(t2));
		System.out.println(t1.equals(t3));
		System.out.println(t3.equals(t4));
	}
	
	
	interface a{
		public void printA();
	}
	
	abstract class b implements a{
		public void printA(){
			
		}
	}
	
	
	public class c extends b{

		
		
	}
}
