package test.dnHashMap;

import java.util.ArrayList;
import java.util.List;

public class DNHashMap<K, V> implements DNMap<K, V> {

	//���������Ĭ�ϴ�С λ��Ч�����
	private static int defaultLength = 1 << 4;
	//�������� why 0.75  ���ݲ����׷���  ��ͻ�������� ����get ����putʱ������
	//��Ϊ��ͻ��ʹ�ô���������ռ�
	private static double defaultAddSizeFacor = 0.75;
	
	//ʹ������solt����
	private int useSize;
	
	//Map������ṹ
	private Entry<K, V>[] table = null;
	
	public DNHashMap(){
		this(defaultLength, defaultAddSizeFacor);
	}
	
	//���췽��
	public DNHashMap(int length, double defaultAddSizeFacor){
		if(length < 0){
			throw new IllegalArgumentException("��������Ϊ����" + length);
		}
		if(defaultAddSizeFacor <= 0 || Double.isNaN(defaultAddSizeFacor)){
			throw new IllegalArgumentException("���ݲ�������Ϊ��������0�����ǿ�");
		}
		this.defaultLength = length;
		this.defaultAddSizeFacor = defaultAddSizeFacor;
		table = new Entry[defaultLength];
	}
	
	//���
	@Override
	public V put(K k, V v) {
		if(useSize > defaultLength*defaultAddSizeFacor){
			//2������
			up2Size();
		}
		//���ҵ���λ�ñ�֤�����鷽λ��
		int index = getIndex(k, table.length);
		Entry<K, V> entry = table[index];
		
		//˵��ͨ��hashɢ���㷨�ҵ���λ�������ǵ�һ����
		if(entry == null){
			table[index] = new Entry(k, v, null);
			useSize++;
		}else if(entry != null){
			//�γ����� ��ԭ�е�entry����ȥ��Ȼ����ռ�õ�ǰλ�� Ȼ���ҵ�next����ָ��entry
			table[index] = new Entry(k, v, entry);
		}
		
		return table[index].getValue();
	}
	//��ȡʹ��solt����
	public int userSize(){
		return useSize;
	}
	
	//��ȡλ���±�
	private int getIndex(K k, int length) {
		int m = length - 1;
		//��֤���ǵ��±�ֵ�����������length��
		int index = hash(k.hashCode()) & m;
		//index >=0 ? index : -index
		return 0;
	}
	//������ײ���ʵ��㷨
	private int hash(int hashCode) {
		hashCode = hashCode^((hashCode>>>20) ^ (hashCode>>>12));
		return hashCode^((hashCode>>>7) ^ (hashCode>>>4));
	}

	//2�����ݷ���
	public void up2Size(){
		Entry<K, V> [] newTable = new Entry[defaultLength<<1];
		//������������ŵ�Entry���������ɢ��
		againHash(newTable);
	}

	//����ǰ��������Ķ����ٴ�ɢ�е�newTable
	private void againHash(DNHashMap<K, V>.Entry<K, V>[] newTable) {
		List<Entry<K,V>> entryList = new ArrayList<Entry<K,V>>();
		for(int i = 0; i< table.length; i++){
			if(table[i] == null){
				continue;
			}
			//��������table[i]����Ϊ�յ����������������ṹ��
			foundEntryByNext(table[i], entryList);
		}
		if(entryList.size() > 0){
			useSize = 0;
			defaultLength = defaultLength<<1;
			table = newTable;
			for(Entry<K, V> entry:entryList){
				if(entry.next != null){
					entry.next = null;
				}
				//������ĵݹ�
				put(entry.getKey(), entry.getValue());
			}
			
		}
		
	}
	
	private void foundEntryByNext(DNHashMap<K, V>.Entry<K, V> entry,
			List<DNHashMap<K, V>.Entry<K, V>> entryList) {
		if(entry != null && entry.next != null){
			//˵�����λ�õ�entry�����Ѿ��γ�������ṹ
			entryList.add(entry);
			//�ݹ��㷨
			foundEntryByNext(entry.next, entryList);
		}else{
			//����Ϊ��
			entryList.add(entry);
		}
		
	}


	@Override
	public V get(K k) {
		int index = getIndex(k, table.length);
		if(table[index] == null){
			throw new NullPointerException();
		}
		return findValueByEqualKey(k, table[index]);
	}
	
	private V findValueByEqualKey(K k, DNHashMap<K, V>.Entry<K, V> entry) {
		//k �ҵ���entry.getKey
		if(k == entry.getKey() || k.equals(entry.getKey())){
			return entry.getValue();
		}else if(entry.next != null){
			//����ĵݹ�
			return findValueByEqualKey(k, entry.next);
		}
		return null;
	}

	class Entry<K, V> implements DNMap.Entry<K, V>{
		K k;
		V v;
		Entry<K, V> next;
		//��һ���췽��
		public Entry(K k, V v, Entry<K, V> next){
			this.k = k;
			this.v = v;
			this.next = next;
		}
		
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}
		
	}
	

}
