package test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // ע�����class�ֽ����ļ��д��ڣ�������ʱ����ͨ�������ȡ��
@Target({ElementType.FIELD,ElementType.METHOD})//����ע�������Ŀ��**���÷�Χ�ֶΡ�ö�ٵĳ���/����
@Documented//˵����ע�⽫��������javadoc��
public @interface FieldMeta {

	/**
	 * �Ƿ�Ϊ���к�
	 * @return
	 */
	boolean id() default false;
	/**
	 * �ֶ�����
	 * @return
	 */
	String name() default "";
	/**
	 * �Ƿ�ɱ༭
	 * @return
	 */
	boolean editable() default true;
	/**
	 * �Ƿ����б�����ʾ
	 * @return
	 */
	boolean summary() default true;
	/**
	 * �ֶ�����
	 * @return
	 */
	String description() default "";
	/**
	 * �����ֶ�
	 * @return
	 */
	int order() default 0;
}
