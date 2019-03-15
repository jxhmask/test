package com.dongnao.jack.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Test {
    
    public static void main(String[] args) {
        //Enhancer类是CGLib中的一个字节码增强器
        Enhancer enhancer = new Enhancer();
        
        enhancer.setSuperclass(TargetClass.class);
        enhancer.setCallback(new TargetInterceptor());
        
        TargetClass cglibProxy = (TargetClass)enhancer.create();
        cglibProxy.add();
        //        cglibProxy.del();
        //        cglibProxy.update();
    }
    
}
