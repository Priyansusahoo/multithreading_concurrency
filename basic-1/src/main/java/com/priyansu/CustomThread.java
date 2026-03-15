package com.priyansu;

class CustomThread extends Thread {
    public void run(){
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println("Thread class - run method executing : EVEN " + i);
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
    }
}