package org.yuting.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author twb
 */
public class Nio {

  public static void main(String[] args) throws Exception {

    Thread thread = new Thread(new Runnable() {
      public void run() {
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("before");
        LockSupport.park();
        System.out.println("end");
      }
    });

    thread.start();

    System.out.println("main before");
//    LockSupport.unpark(thread);
    System.out.println("main end");
  }
}
