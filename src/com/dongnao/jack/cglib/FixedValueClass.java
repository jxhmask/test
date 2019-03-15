package com.dongnao.jack.cglib;

import net.sf.cglib.proxy.FixedValue;

public class FixedValueClass implements FixedValue {
    
    @Override
    public Object loadObject() throws Exception {
        System.out.println("invoke fixedValue");
        return 123;
    }
    
}
