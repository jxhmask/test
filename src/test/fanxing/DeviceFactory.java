package test.fanxing;

class Device{
public void print(){
}
}

class Mouse extends Device{
public void print(){
System.out.println("Mouse");
}
}
class Keyboard extends Device{
public void print(){
System.out.println("Keyboard");
}
}

public class DeviceFactory{
	public Device getDevice(String name){
		Device device = null;
	switch(name){
	case "Mouse" : device = new Mouse();
	case "Keyboard" :  device = new Keyboard();
	}
	return device;
}
}