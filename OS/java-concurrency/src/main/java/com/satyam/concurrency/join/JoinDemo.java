package com.satyam.concurrency.join;

/*
join() : Wait until this thread finishes
* **/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinDemo {
    private static final Logger logger = LoggerFactory.getLogger(JoinDemo.class);
    public static void main(String[] args) throws InterruptedException {
        logger.info("\n\n==================== NEW RUN ====================\n");
        Thread worker = new Thread(()->{
            logger.info("Worker started");
            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                logger.error(e.getMessage());
            }
            logger.info("Worker finished");
        });
        worker.start();
        logger.info("Main waiting");
        worker.join();
        logger.info("Main completed");
    }
}
