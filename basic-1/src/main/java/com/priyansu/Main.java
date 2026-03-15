package com.priyansu;

class Main {
    public static void main(String[] args) {
        Runnable myRunnable = () -> {
            for (int i = 0; i < 50; i++) {
                if (i % 2 != 0) {
                    System.out.println("Runnable interface - run method executing : ODD " + i);
                }
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException ie) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                    ie.printStackTrace();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        };

        CustomThread t2 = new CustomThread();
        t2.start();
        Thread t1 = new Thread(myRunnable);
        t1.start();
        try {
            //t2.interrupt();
            //t1.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}