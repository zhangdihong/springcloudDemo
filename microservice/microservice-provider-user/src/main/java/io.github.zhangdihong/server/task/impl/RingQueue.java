package io.github.zhangdihong.server.task.impl;

import io.github.zhangdihong.server.task.AbstractRingQueue;
import io.github.zhangdihong.server.task.runable.Slot;
import io.github.zhangdihong.server.task.runable.Steper;
import io.github.zhangdihong.server.task.runable.Task;

/**
 * <p>Project: io.github.zhangdihong.server.task.impl</p>
 * <p>Title: RingQueue.java</p>
 * <p/>
 * <p>Description: RingQueue </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public class RingQueue extends AbstractRingQueue {

    @Override
    public int add(Task task) {
        return slots[task.getIndex()].addTask(task);

    }

    @Override
    public void remve(int slotIndex, int taskId) {
        slots[slotIndex].removeTask(taskId);
    }

    @Override
    public void replaceSlot(int slotIndex, Task task) {
        remve(slotIndex,task.getId());
        add(task);
    }

    @Override
    public Slot nextStep(int slotIndex) {
        return slots[slotIndex];
    }

    @Override
    public void initData() {
    }
    public void start(){
        new Thread(new Steper(this)).start();
    }
}
