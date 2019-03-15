package test.fanxing;

public class Singleton{
private Singleton(){}
private static Singleton singleton = null;
public static Singleton getSingleton(){
if(null == singleton){
synchronized (Singleton.class) {
	if(null == singleton){
		singleton = new Singleton();
	}
}
}
return singleton;

}
}