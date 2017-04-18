package io.github.zhangdihong.server.task;

import io.github.zhangdihong.server.task.runable.Slot;
import io.github.zhangdihong.server.task.runable.Task;

/**
 * <p>Project: io.github.zhangdihong.server.task</p>
 * <p>Title: AbstrackRingQueue.java</p>
 * <p/>
 * <p>Description: AbstrackRingQueue </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public abstract class AbstractRingQueue {

    protected Slot[] slots = new Slot[3600];

    public AbstractRingQueue() {
        for (int i = 0; i < 3600; i++) {
            slots[i] = new Slot();
        }
        initData();
    }

    public abstract int   add(Task task);

    public abstract void remve(int slotIndex,int taskId);

    public abstract void replaceSlot(int slotIndex,Task task);

    public abstract Slot nextStep(int slotIndex);

    public abstract void initData();
}
