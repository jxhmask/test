package test.dnHashMap;

import java.util.HashMap;
import java.util.Hashtable;


/**
 * HashMap extends AbstractMap implements Map, Cloneable, Serialization
 * HashTable extends Dictionary implements Map, Cloneable, Seriablization
 * 
 * Dictionary û�о����ʵ�ַ�����ֻ�г��󷽷�(ȫ�Ƿ���������)�� AbstractMapʵ��Map�ӿڣ�ʵ����������ķ�������equals()��toString()
 * 
 * 
 * HashTable �з�����put(),get(),size(),remove() ����syncronized,�� �ö�������˼���
 * 
 * HashTable �е�key��value��������Ϊnull
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
