package io.github.zhangdihong.server.task;

import io.github.zhangdihong.server.task.impl.RingQueue;
import io.github.zhangdihong.server.task.runable.Task;

/**
 * <p>Project: io.github.zhangdihong.server.task</p>
 * <p>Title: TestMain.java</p>
 * <p/>
 * <p>Description: TestMain </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        RingQueue ringQueue = new RingQueue();
        ringQueue.start();
        add(ringQueue);
        Thread.sleep(6000L);
    }
    static void add(RingQueue ringQueue){
        Task task = new Task(1,1) {

            @Override
            public void run() {
                System.out.println("不知道这里该做啥。。。。");
            }
        };
        System.out.println("ringQueue = [" + ringQueue.add(task) + "]");
    }


}
