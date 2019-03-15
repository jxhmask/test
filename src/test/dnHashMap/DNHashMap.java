package test.dnHashMap;

import java.util.ArrayList;
import java.util.List;

public class DNHashMap<K, V> implements DNMap<K, V> {

	//定义数组的默认大小 位移效率最高
	private static int defaultLength = 1 << 4;
	//扩容因子 why 0.75  扩容不容易发生  冲突概率增加 导致get 或者put时间增多
	//因为冲突需使用大量的链表空间
	private static double defaultAddSizeFacor = 0.75;
	
	//使用我们solt数量
	private int useSize;
	
	//Map的数组结构
	private Entry<K, V>[] table = null;
	
	public DNHashMap(){
		this(defaultLength, defaultAddSizeFacor);
	}
	
	//构造方法
	public DNHashMap(int length, double defaultAddSizeFacor){
		if(length < 0){
			throw new IllegalArgumentException("参数不能为负数" + length);
		}
		if(defaultAddSizeFacor <= 0 || Double.isNaN(defaultAddSizeFacor)){
			throw new IllegalArgumentException("扩容参数不能为负数或者0或者是空");
		}
		this.defaultLength = length;
		this.defaultAddSizeFacor = defaultAddSizeFacor;
		table = new Entry[defaultLength];
	}
	
	//快存
	@Override
	public V put(K k, V v) {
		if(useSize > defaultLength*defaultAddSizeFacor){
			//2倍扩容
			up2Size();
		}
		//将找到的位置保证在数组方位内
		int index = getIndex(k, table.length);
		Entry<K, V> entry = table[index];
		
		//说明通过hash散列算法找到的位置是我是第一个来
		if(entry == null){
			table[index] = new Entry(k, v, null);
			useSize++;
		}else if(entry != null){
			//形成链表， 将原有的entry挤下去，然后我占用当前位置 然后我的next属性指向entry
			table[index] = new Entry(k, v, entry);
		}
		
		return table[index].getValue();
	}
	//获取使用solt数量
	public int userSize(){
		return useSize;
	}
	
	//获取位置下标
	private int getIndex(K k, int length) {
		int m = length - 1;
		//保证我们的下标值就在这个数组length内
		int index = hash(k.hashCode()) & m;
		//index >=0 ? index : -index
		return 0;
	}
	//降低碰撞概率的算法
	private int hash(int hashCode) {
		hashCode = hashCode^((hashCode>>>20) ^ (hashCode>>>12));
		return hashCode^((hashCode>>>7) ^ (hashCode>>>4));
	}

	//2倍扩容方法
	public void up2Size(){
		Entry<K, V> [] newTable = new Entry[defaultLength<<1];
		//这里对老数组存放的Entry对象进行再散列
		againHash(newTable);
	}

	//将当前数组里面的对象再次散列到newTable
	private void againHash(DNHashMap<K, V>.Entry<K, V>[] newTable) {
		List<Entry<K,V>> entryList = new ArrayList<Entry<K,V>>();
		for(int i = 0; i< table.length; i++){
			if(table[i] == null){
				continue;
			}
			//处理我们table[i]对象不为空的情况（可能是链表结构）
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
				//超级大的递归
				put(entry.getKey(), entry.getValue());
			}
			
		}
		
	}
	
	private void foundEntryByNext(DNHashMap<K, V>.Entry<K, V> entry,
			List<DNHashMap<K, V>.Entry<K, V>> entryList) {
		if(entry != null && entry.next != null){
			//说明这个位置的entry对象已经形成了链表结构
			entryList.add(entry);
			//递归算法
			foundEntryByNext(entry.next, entryList);
		}else{
			//处理为空
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
		//k 找到的entry.getKey
		if(k == entry.getKey() || k.equals(entry.getKey())){
			return entry.getValue();
		}else if(entry.next != null){
			//精妙的递归
			return findValueByEqualKey(k, entry.next);
		}
		return null;
	}

	class Entry<K, V> implements DNMap.Entry<K, V>{
		K k;
		V v;
		Entry<K, V> next;
		//加一构造方法
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
