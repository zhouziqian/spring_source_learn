package com.zhouqi.reflect;

/**
 * @author zhouqi
 * @date 2017/12/19 9:55
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + classLoader);
        System.out.println("parent loader:" + classLoader.getParent());
        System.out.println("grandparent  loader:" + classLoader.getParent().getParent());
    }
}
