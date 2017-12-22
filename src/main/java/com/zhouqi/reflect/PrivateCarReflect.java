package com.zhouqi.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhouqi
 * @date 2017/12/19 10:03
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.zhouqi.reflect.PrivateCar");
        PrivateCar car = (PrivateCar) clazz.newInstance();
        Field colorField = clazz.getDeclaredField("color");
        //取消Java语言访问检查以访问private变量
        colorField.setAccessible(true);
        colorField.set(car, "红色");

        Method driveMethod = clazz.getDeclaredMethod("drive", (Class[]) null);
        //取消Java语言访问检查以访问protected方法
        driveMethod.setAccessible(true);
        driveMethod.invoke(car, (Object[]) null);
    }

}
