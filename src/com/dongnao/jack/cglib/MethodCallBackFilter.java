package com.dongnao.jack.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class MethodCallBackFilter implements CallbackFilter {
    
    /**
     * return值为被代理类的各个方法在回调数组Callback[]中的位置索引
     */
    public int accept(Method method) {
        if ("add".equals(method.getName())) {
            return 0;
        }
        else if ("del".equals(method.getName())) {
            return 1;
        }
        else if ("update".equals(method.getName())) {
            return 2;
        }
        return 0;
    }
    
}
