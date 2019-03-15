package test.aop2;

import java.lang.reflect.InvocationHandler;   
import java.lang.reflect.Method;   
import java.lang.reflect.Proxy;   
 
import java.io.*;   
public class DynamicProxy   
{   
  public static void main( String args[] )   
  {   
    RealSubject real = new RealSubject();   
    SubjectEat proxySubject = (SubjectEat)Proxy.newProxyInstance(Subject.class.getClassLoader(), 
     new Class[]{Subject.class, SubjectEat.class}, 
     new ProxyHandler(real));
         
    //proxySubject.doSomething("hello world");
    proxySubject.eat("rice");
    ((Subject)proxySubject).doSomething("luci");
    //write proxySubject class binary data to file   
    //createProxyClassFile();   
  }   
     
  public static void createProxyClassFile()   
  {   
    String name = "ProxySubject";   
    byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );   
    try  
    {   
      FileOutputStream out = new FileOutputStream( name + ".class" );   
      out.write( data );   
      out.close();   
    }   
    catch( Exception e )   
    {   
      e.printStackTrace();   
    }   
  }   
}  
