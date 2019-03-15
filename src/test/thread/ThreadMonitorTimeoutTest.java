package test.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadMonitorTimeoutTest {
	private ConcurrentMap<Integer, Long> aliveThreadRefreshTimeMap = new ConcurrentHashMap<>();
	  final Map<Integer, Future<?>> aliveThreadFutureMap = new HashMap<>();
	  private int aliveThreadNum = 0;
	  private ExecutorService cachedThreadPool;

	  private void doOtherThing(int mseconds) throws InterruptedException {

	    for (int i = 0; i < 1000; i++) {
	      int j = i;
	    }
	    Thread.sleep(mseconds);

	  }

	  private Runnable workerThread(final int i, final int sleepTime) {
	    return new Runnable() {
	      @Override
	      public void run() {
	        try {
	          long currentTime = System.currentTimeMillis();
	          aliveThreadRefreshTimeMap.put(i, currentTime);
	          System.out.printf("worker thread#%s start...\n", i);
	          while (true) {
	            doOtherThing(sleepTime);
	            currentTime = System.currentTimeMillis();
	            aliveThreadRefreshTimeMap.replace(i, currentTime);
	          }
	        } catch (InterruptedException e) {
	          System.out.printf("thread %d into InterruptedException, over\n", i);

	        } catch (Exception e) {
	          // TODO: handle exception
	          e.printStackTrace();
	        }
	      }
	    };
	  }

	  Runnable monitorWorker = new Runnable() {
	    @Override
	    public void run() {
	      try {
	        System.out.printf("monitor thread start..., aliveThreadRefreshTimeMap:%s\n", aliveThreadRefreshTimeMap);
	        List<Integer> removeIdList = new ArrayList<>();
	        for (int threadId : aliveThreadRefreshTimeMap.keySet()) {
	          long currentTime = System.currentTimeMillis();
	          long refreshTimes = currentTime - aliveThreadRefreshTimeMap.get(threadId);
	          System.out.printf("thread %d, refreshTimes is %d\n", threadId, refreshTimes);
	          if (refreshTimes > 10000) {
	            System.out.printf("alive thread %d: is %dms to refresh, will restart\n", threadId, currentTime - aliveThreadRefreshTimeMap.get(threadId));
	            aliveThreadFutureMap.get(threadId).cancel(true);
	            aliveThreadNum ++;
	            Future<?> future = cachedThreadPool.submit(workerThread(aliveThreadNum, aliveThreadNum*4000));
	            aliveThreadFutureMap.put(aliveThreadNum,future);
	            removeIdList.add(threadId);
	            System.out.printf("restart success, thread id is:%d\n", aliveThreadNum);
	          }
	        }
	        for (int id : removeIdList) {
	          aliveThreadFutureMap.remove(id);
	          aliveThreadRefreshTimeMap.remove(id);
	        }
	      } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	      }

	    }
	  };

	  @Test
	  public void createTask() {
	    cachedThreadPool = Executors.newCachedThreadPool();
	    for (int i = 0; i < 3; i++) {
	      // aliveCachedThreadPool.execute(adhaAliveDetectTask);
	      Future<?> future = cachedThreadPool.submit(workerThread(i, i*6000));
	      aliveThreadFutureMap.put(i, future);
	      aliveThreadNum++;
	    }
	    // detect monitor task
	    ScheduledExecutorService monitorExecutor = Executors.newScheduledThreadPool(1);
	    monitorExecutor.scheduleAtFixedRate(monitorWorker, 0, 1, TimeUnit.SECONDS);
	    while(true);
	  }
}
