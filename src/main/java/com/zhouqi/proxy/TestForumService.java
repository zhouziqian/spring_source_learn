package com.zhouqi.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zhouqi
 * @date 2017/12/19 11:17
 */
public class TestForumService {
/*        public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }*/
/*    public static void main(String[] args) {
        //希望被代理的目标业务类
        ForumService target = new ForumProxyServiceImpl();
//        ForumNoInterFace target = new ForumNoInterFace(); JDK动态代理只能使用接口,Proxy.newProxyInstance方法第二个参数是接口
        //将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(target);

        //根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        //调用代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }*/
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        //通过cglib动态代理实现非接口类的代理
        ForumNoInterFace forumService = (ForumNoInterFace )proxy.getProxy(ForumNoInterFace.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
