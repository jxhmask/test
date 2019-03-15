package test.dnHashMap;
/**
 * ��һ��DNMap�ӿ�
 * @author jxh
 *
 * @param <K>
 * @param <V>
 */
public interface DNMap<K, V> {
	//����淶 ���
	public V put(K k, V v);
	
	//��ȡ
	public V get(K k);
	
	//�ڲ�����ӿ�
	public interface Entry<K, V>{
		public K getKey();
		
		public V getValue();
	}
}
