package com.zhb.study.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zhb.study.aop.entity.BaseInterface;
import com.zhb.study.aop.entity.Student;

public class ProxyJDK implements InvocationHandler {
    
    private Object target;
    
    public ProxyJDK(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before doning....");
        Object object = method.invoke(target, args);
        System.out.println("proxy after doing...");
        return object;
    }
    
    public <T> T getInstance() {
        return (T)Proxy.newProxyInstance(ProxyJDK.class.getClassLoader(), target.getClass().getInterfaces(), this);
    }
    
    public static void main(String[] args) {
        ProxyJDK proxyJDK = new ProxyJDK(new Student());
        BaseInterface student = proxyJDK.getInstance();
        student.doing();
    }
    
    

}
