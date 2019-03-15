package test.clone;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneObject c = new CloneObject();
		CloneObject c2 = (CloneObject)c.clone();
		System.out.println(c2.str);
		
		
		c2.l.add(0, "2");
		c2.str = "11";
		System.out.println(c.str + "----" + c.l.get(0));
		System.out.println(c2.str + "----" + c2.l.get(0));
		
	}
}
