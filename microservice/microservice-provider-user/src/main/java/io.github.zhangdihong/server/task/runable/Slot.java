package io.github.zhangdihong.server.task.runable;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>Project: io.github.zhangdihong.server.model</p>
 * <p>Title: Slot.java</p>
 * <p/>
 * <p>Description: Slot </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public class Slot {
    private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue();


    ConcurrentLinkedQueue<Task> getTasks(){
        return tasks;
    }

    public int addTask(Task task){
        tasks.add(task);
        return task.getIndex();
    }

    public void removeTask(int taskId){
        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()){
            if(it.next().getId() == taskId){
                it.remove();
            }
        }
    }

}
