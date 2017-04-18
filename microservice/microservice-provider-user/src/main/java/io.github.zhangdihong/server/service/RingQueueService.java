package io.github.zhangdihong.server.service;

import io.github.zhangdihong.server.task.runable.Slot;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Project: io.github.zhangdihong.server.service</p>
 * <p>Title: RingQueueService.java</p>
 * <p/>
 * <p>Description: RingQueueService </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/9
 */
public class RingQueueService {
   private static final Slot[] slots = new Slot[30];

    private static ScheduledExecutorService myEx = new ScheduledThreadPoolExecutor(2);
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private volatile Slot currentTask = new Slot();

  public void  moveSlot(){
      myEx.scheduleAtFixedRate(new Runnable() {

          @Override
          public void run() {

               int value = atomicInteger.intValue() > slots.length ? 0:atomicInteger.intValue();
              if(value == 0){
                  atomicInteger.set(0);
              }
                currentTask = slots[value];

                atomicInteger.incrementAndGet();
          }
      },1000L,1000, TimeUnit.MILLISECONDS);

  }
  public void productTask(){

  }
  public void consumeTask(){

  }


}
