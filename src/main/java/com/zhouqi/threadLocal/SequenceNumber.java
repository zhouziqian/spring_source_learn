package com.zhouqi.threadLocal;

/**
 * @author zhouqi
 * @date 2017/12/21 16:13
 */
public class SequenceNumber {
    //①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return 0;
        }
    };
    //②获取下一个序列值
    public Integer getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        //③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread{
        private SequenceNumber sn;
        public TestClient(SequenceNumber sn){
            this.sn=sn;
        }
        @Override
        public void run(){
            //④每个线程打出3个序列值
            for (int i = 0; i < 3; i++) {
                System.out.println("thread["+Thread.currentThread().getName()+
                        "] sn["+sn.getNextNum()+"]");
            }
        }
    }
}
