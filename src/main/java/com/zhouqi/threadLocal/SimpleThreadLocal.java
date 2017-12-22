package com.zhouqi.threadLocal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouqi
 * @date 2017/12/21 15:11
 */
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap());

    public void set(Object newValue){
        //①键为线程对象，值为本线程的变量副本
        valueMap.put(Thread.currentThread(),newValue);
    }

    public void get(){
        Thread currentThread = Thread.currentThread();
        //②返回本线程对应的变量
        Object o = valueMap.get(currentThread);
        //③如果在Map中不存在，放到Map中保存起来
        if(null==o && !valueMap.containsKey(currentThread)){
            o=initialValue();
            valueMap.put(currentThread,o);
        }
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    private Object initialValue() {
        return null;
    }
}
