package test.propertyDescripter;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class Person {
	private String tId;  
    
    private String id;   
  
    public String getId1() {  
        return id;  
    }  
  
    public void setId1(String id) {  
        this.id = id;  
    }
  
    public String gettId() {  
        return tId;  
    }  
  
    public void settId(String tId) {  
        this.tId = tId;  
    }  
    
    
    public static void main(String[] args)  
            throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {  
        Person p = new Person();  
        p.setId1("0");  
        PropertyDescriptor prop = new PropertyDescriptor("id", Person.class);  
  
        // ��ȡgetter�����������ȡidֵ  
        Object str = prop.getReadMethod().invoke(p);  
  
        // ��ȡsetter���������丳ֵ  
        prop.getWriteMethod().invoke(p, "1");  
  
        System.out.println("��ȡIDֵ:" + str);  
        System.out.println("��ֵID:" + p.getId1());  
    }  
}
