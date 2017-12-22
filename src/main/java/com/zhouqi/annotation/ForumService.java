package com.zhouqi.annotation;

/**
 * @author zhouqi
 * @date 2017/12/20 17:43
 */
public class ForumService {
    @NeedTest(value=true)
    public void deleteForum(int forumId){
        System.out.println("删除论坛模块："+forumId);
    }
    @NeedTest(value=false)
    public void deleteTopic(int postId){
        System.out.println("删除论坛主题："+postId);
    }
}
