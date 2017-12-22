package com.zhouqi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhouqi
 * @date 2017/12/19 9:42
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {
        //通过类加载器获得Car对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.zhouqi.reflect.Car");

        //获取默认构造器对象比通过它实例化Car
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        //通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "思域9代");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"白色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,160);
        return car;
    }

    public static void main(String[] args) throws Throwable{
        Car car = initByDefaultConst();
        car.introduce();
    }
}
