package test.dnHashMap;
/**
 * 抽一个DNMap接口
 * @author jxh
 *
 * @param <K>
 * @param <V>
 */
public interface DNMap<K, V> {
	//定义规范 快存
	public V put(K k, V v);
	
	//快取
	public V get(K k);
	
	//内部定义接口
	public interface Entry<K, V>{
		public K getKey();
		
		public V getValue();
	}
}
