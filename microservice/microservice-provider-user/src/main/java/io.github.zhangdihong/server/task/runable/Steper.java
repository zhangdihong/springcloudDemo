package io.github.zhangdihong.server.task.runable;

import io.github.zhangdihong.server.task.AbstractRingQueue;

import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * <p>Project: io.github.zhangdihong.server.model</p>
 * <p>Title: Steper.java</p>
 * <p/>
 * <p>Description: Steper </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public class Steper implements Runnable {

    private AbstractRingQueue rq;
    private ThreadGroup taskGroup = new ThreadGroup("taskGroup");
    private ThreadGroup stepGroup = new ThreadGroup("slotGroup");
    private ExecutorService taskPool = Executors.newCachedThreadPool(new ThreadFactory() {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(taskGroup, r);
        }
    });
    private ExecutorService stepPool = Executors.newCachedThreadPool(new ThreadFactory() {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(stepGroup, r);
        }
    });

    public Steper(AbstractRingQueue rq) {
        this.rq = rq;
    }

    @Override
    public void run() {
        while (true){
            try {
            int second = Calendar.getInstance().get(Calendar.MINUTE) * 60 + Calendar.getInstance().get(Calendar.SECOND);

            Slot slot = rq.nextStep(second);

            final ConcurrentLinkedQueue<Task> tasks = slot.getTasks();
            stepPool.execute(new Runnable() {

                @Override
                public void run() {
                    Iterator<Task> it = tasks.iterator();
                    while (it.hasNext()){
                        Task task = it.next();
                         if(task.getCycle() <= 0){
                             taskPool.execute(task);
                             it.remove();
                         }else {
                             task.countDown();
                         }
                    }
                }
            });

                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
