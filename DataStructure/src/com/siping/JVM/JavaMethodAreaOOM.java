package com.siping.JVM;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 方法区和运行时常量池溢出（-XX:PermSize=10M -XX:MaxPermSize=10M）
 * 使用CGlib字节码技术对类增强，很多框架如Spring、Hibernate都使用了这种技术
 * @author siping-yx
 * @date 2017年12月5日
 * @version 1.0
 *
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            
            enhancer.create();
        }
    }
    static class OOMObject {
        
    }
}
