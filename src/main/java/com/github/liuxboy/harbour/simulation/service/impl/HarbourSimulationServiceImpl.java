package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.domain.biz.Result;
import com.github.liuxboy.harbour.simulation.service.HarbourSimulationService;
import org.apache.avalon.framework.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


/**
 * <p>Title: PossionServiceImpl</p>
 * <p>Copyright: Copyright(c)2016</p>
 * <p>Company: JD.JR </p>
 * <p>Time: 2016/6/2 15:01</p>
 * <p>Description: 描述 </p>
 *
 * @author wyliuchundong
 * @version 1.0
 */
@Service
public class HarbourSimulationServiceImpl implements HarbourSimulationService {
    /**
     * 生产线程
     */
    public static class ProducerThread extends Thread {
        //阻塞队列
        private BlockingQueue<String> queue;
        //产品编号
        int i = 0;
        public ProducerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            //生产产品，推向队列
            for (; ;) {
                String task = "产品" + (++i);
                try {
                    queue.put(task);
                    System.out.println(Thread.currentThread()+"生产了:"+task);
                    sleep(3000);
                } catch (InterruptedException e) {
                    //TODO
                }
            }
        }
    }

    /**
     * 消费线程
     */
    public static class ConsumerThread extends Thread {
        private BlockingQueue<String> queue;
        public ConsumerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            String task = null;
            //消费产品
            try {
                while ((task = queue.take()) != null) {
                    System.out.println(Thread.currentThread()+"消费了:" + task);
                }
            } catch (InterruptedException e) {
                //TODO
            }
        }
    }

    @Override
    public Result simulation() throws ServiceException {
        Result result = new Result();
        result.setAvgInHarborTime("");
        result.setAvgOnBerthTime("");
        result.setAvgWaitBerthTime("");
        result.setAvgWaitChannelTime("");
        result.setAwtAstIndex("");
        result.setBerthUtilizationRatio("");
        return result;
    }

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String>();
        new ProducerThread(queue).start();  //启动生产者线程
        new ConsumerThread(queue).start();  //启动消费者线程
    }
}
