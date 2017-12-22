package com.zhouqi.proxy;

/**
 * @author zhouqi
 * @date 2017/12/19 10:36
 */
public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {

        //开始对该方法进行性能监视
        PerformanceMonitor.begin(
                "com.zhouqi.proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //结束对该方法进行性能监视
        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        //开始对该方法进行性能监视
        PerformanceMonitor.begin(
                "com.zhouqi.proxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //结束对该方法进行性能监视
        PerformanceMonitor.end();
    }
}
