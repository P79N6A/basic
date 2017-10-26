package com.itcast.basic.cglib.dynamic;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.objectweb.asm.Type;
import org.quartz.JobExecutionContext;

import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2017/10/26.
 */
public class DynamicClassUtilServiceClient {
    private static final Log logger = LogFactory.getLog(DynamicClassUtilServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into DynamicClassUtilServiceClient");
            //定义一个接口
            InterfaceMaker interfaceMaker = new InterfaceMaker();
            interfaceMaker.add(new Signature("doJob", Type.VOID_TYPE,
                    new Type[]{Type.getType(String.class)}), null);
            Class schdulerInface = interfaceMaker.create();
            //创建类生成器
            Enhancer enhancer = new Enhancer();
            enhancer.setInterfaces(new Class[]{schdulerInface});
            enhancer.setSuperclass(DynamicClassUtil.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    String methodName = method.getName();
                    if ("doJob".equals(methodName) && args != null && args[0] instanceof String) {
                        logger.info("doJob开始执行定时任务" + args[0].toString());
                    } else if ("executeInternal".equals(methodName) && args != null && args[0] instanceof JobExecutionContext) {
                        logger.info("开始执行executeInternal");
                    }
                    return null;
                }
            });
            Object object = enhancer.create();
            Method doJob = object.getClass().getMethod("doJob", new Class[]{String.class});
            doJob.invoke(object, new Object[]{"create order job"});
            Method executeInternal = object.getClass().getMethod("executeInternal", new Class[]{JobExecutionContext.class});
            executeInternal.invoke(object, new Object[]{null});
            synchronized (logger) {
                logger.wait();
            }
        } catch (Exception e) {
            logger.info("DynamicClassUtilServiceClient error message is {}", e);
        }
    }
}
