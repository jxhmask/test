package test.annotation;

import java.util.List;

public class TestAnnotation {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Parent c = new Child();
		List<SortableField> list = c.init();//��ȡ�������������ע��
		//������
		for(SortableField l : list){
			System.out.println("�ֶ����ƣ�"+l.getName()+"\t�ֶ����ͣ�"+l.getType()+
					"\tע�����ƣ�"+l.getMeta().name()+"\tע��������"+l.getMeta().description());
		}
	}
}
