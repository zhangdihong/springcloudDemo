package io.github.zhangdihong.server.task.runable;

import io.github.zhangdihong.server.task.AbstractTask;

/**
 * <p>Project: io.github.zhangdihong.server.model</p>
 * <p>Title: Task.java</p>
 * <p/>
 * <p>Description: Task </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public abstract class Task extends AbstractTask {

    public Task(int id, int after) {
        super(id, after);
    }
}
