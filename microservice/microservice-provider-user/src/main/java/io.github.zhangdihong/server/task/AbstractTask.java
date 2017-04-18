package io.github.zhangdihong.server.task;

import java.util.Calendar;

/**
 * <p>Project: io.github.zhangdihong.server.task</p>
 * <p>Title: AbstractTask.java</p>
 * <p/>
 * <p>Description: AbstractTask </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public abstract class AbstractTask implements Runnable {
    private int cycle;
    private int index;
    private int id;

    public AbstractTask(int id,int after) {
        int second = Calendar.getInstance().get(Calendar.MINUTE)*60 + Calendar.getInstance().get(Calendar.SECOND);
        this.cycle = second / 3600;
        this.index = (second + after) % 3600;
        this.id = id;
    }

    public int getCycle() {
        return cycle;
    }

    public int getIndex() {
        return index;
    }

    public int getId() {
        return id;
    }

   public void countDown(){
       this.cycle -= 1;
   }

}
