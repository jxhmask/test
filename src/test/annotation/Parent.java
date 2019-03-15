package test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parent<T> {

	private Class<T> entity;

	public Parent() {
		init();
	}

	@SuppressWarnings("unchecked")
	public List<SortableField> init(){
		List<SortableField> list = new ArrayList<SortableField>();
		/**getClass().getGenericSuperclass()���ر�ʾ�� Class ����ʾ��ʵ�壨�ࡢ�ӿڡ��������ͻ� void��
		 * ��ֱ�ӳ���� Type(Class<T>�����е�����)��Ȼ����ת��ParameterizedType����
		 * 	getActualTypeArguments()���ر�ʾ������ʵ�����Ͳ����� Type ��������顣
		 * 	[0]������������е�һ���ˡ���
		 * 	�����֮���ǻ�ó���ķ��Ͳ�����ʵ�����͡���*/
		entity = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
//		FieldMeta filed = entity.getAnnotation(FieldMeta.class);
		
		if(this.entity!=null){
			
			/**�������������ֶΣ�����������������Ĭ�ϣ��������ʺ�˽���ֶΣ����������̳е��ֶ�
			 * entity.getFields();ֻ���ض�������ʾ�����ӿڵ����пɷ��ʹ����ֶ�
			 * ��class��getDeclared**()�������صĶ������з���Ȩ�޵��ֶΡ������ȣ�
			 * �ɿ�API
			 * */
			Field[] fields = entity.getDeclaredFields();
//			
			for(Field f : fields){
				//��ȡ�ֶ��а���fieldMeta��ע��
				FieldMeta meta = f.getAnnotation(FieldMeta.class);
				if(meta!=null){
					SortableField sf = new SortableField(meta, f);
					list.add(sf);
				}
			}
			
			//���ض�������ʾ�����ӿڵ����пɷ��ʹ�������
			Method[] methods = entity.getMethods();
			
			for(Method m:methods){
				FieldMeta meta = m.getAnnotation(FieldMeta.class);
				if(meta!=null){
					SortableField sf = new SortableField(meta,m.getName(),m.getReturnType());
					list.add(sf);
				}
			}
			//���ַ������½�FieldSortCom��ʵ��Comparator�ӿڣ�����дcompare����ʵ������
//			Collections.sort(list, new FieldSortCom());
			Collections.sort(list, new Comparator<SortableField>() {
				@Override
				public int compare(SortableField s1,SortableField s2) {
					return s1.getMeta().order()-s2.getMeta().order();
//					return s1.getName().compareTo(s2.getName());//Ҳ������compare���Ƚ�
				}
				
			});
		}
		return list;
		
	}
}
