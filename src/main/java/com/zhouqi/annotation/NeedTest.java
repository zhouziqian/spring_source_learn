package com.zhouqi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhouqi
 * @date 2017/12/20 17:40
 */

@Retention(RetentionPolicy.RUNTIME)//①声明注解的保留期限
@Target(ElementType.METHOD)//②声明可以使用该注解的目标类型
public @interface NeedTest {//③定义注解
    boolean value() default true;//④声明注解成员
}



   /*       SOURCE：注解信息仅保留在目标类代码的源码文件中，但对应的字节码文件将不再保留；
            CLASS：注解信息将进入目标类代码的字节码文件中，但类加载器加载字节码文件时不会将注解加载到JVM中，也即运行期不能获取注解信息；
            RUNTIME：注解信息在目标类加载到JVM后依然保留，在运行期可以通过反射机制读取类中注解信息。
            Target(ElementType.METHOD)表示NeedTest这个注解只能应用到目标类的方法上，注解的应用目标在java.lang.annotation.ElementType类中定义：
            TYPE：类、接口、注解类、Enum声明处，相应的注解称为类型注解；
            FIELD：类成员变量或常量声明处，相应的注解称为域值注解；
            METHOD：方法声明处，相应的注解称为方法注解；
            PARAMETER：参数声明处，相应的注解称为参数注解；
            CONSTRUCTOR：构造函数声明处，相应的注解称为构造函数注解；
            LOCAL_VARIABLE：局部变量声明处，相应的注解称为局域变量注解；
            ANNOTATION_TYPE：注解类声明处，相应的注解称为注解类注解，ElementType. TYPE包括ElementType.ANNOTATION_TYPE；
            PACKAGE：包声明处，相应的注解称为包注解。 */