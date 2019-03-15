package test.clone;

import java.util.ArrayList;
import java.util.List;

public class CloneObject implements Cloneable{
	 int i=1;
	 String str = "abc";
	 List<String> l = new ArrayList<String>();
	 
	 public CloneObject(){
		 super();
		 l.add("1");
		 l.add("2");
		 l.add("3");
	 }
	 
	 @Override
	protected Object clone() throws CloneNotSupportedException {
		CloneObject c = (CloneObject)super.clone();
		c.l = (List<String>)((ArrayList<String>)c.l).clone();//实行深复制
		return c;
	}
}
