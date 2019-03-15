package com.dongnao.jack.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class Test1 {
    
    public static void main(String[] args) {
        //Enhancer类是CGLib中的一个字节码增强器
        Enhancer enhancer = new Enhancer();
        
        enhancer.setSuperclass(TargetClass.class);
        
        enhancer.setCallbackFilter(new MethodCallBackFilter());
        //这里定义了3个增强，3个回掉
        Callback c1 = new TargetInterceptor();
        Callback c2 = NoOp.INSTANCE;
        Callback c3 = new FixedValueClass();
        
        Callback[] callbacks = new Callback[] {c1, c2, c3};
        enhancer.setCallbacks(callbacks);
        
        TargetClass cglibProxy = (TargetClass)enhancer.create();
        cglibProxy.add();
    }
    
}
