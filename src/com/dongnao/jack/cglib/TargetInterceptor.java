package com.dongnao.jack.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TargetInterceptor implements MethodInterceptor {
    
    private void before() {
        System.out.println("cglib前置增强");
    }
    
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
            MethodProxy proxy) throws Throwable {
        //        System.out.println(method.getName());
        before();
        proxy.invokeSuper(obj, args);
        //        method.invoke(obj, args);
        after();
        return null;
    }
    
    private void after() {
        System.out.println("cglib后置增强");
    }
    
}
