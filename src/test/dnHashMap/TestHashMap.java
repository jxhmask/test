package test.dnHashMap;

public class TestHashMap {
	public static void main(String[] args){
		DNMap<String, String> dnMap = new DNHashMap<String, String>();
		for(int i=0; i<100; i++){
			dnMap.put("key" + i, "value" + i);
		}
	
		System.out.println("=====存的值进行验证========");
		for(int i=0; i<100; i++){
			System.out.println("key:" + "key" + i + "   value:" + dnMap.get("key" + i));
		}
	}
}
