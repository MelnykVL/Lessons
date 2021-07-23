package edu.lessons.multithreading;

class JThread extends Thread {

    JThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());

        int counter = 1;
        while (!isInterrupted()) {
            System.out.println("Loop " + counter++);
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());

    }

}

public class ThreadWithInterrupt {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        JThread t = new JThread("JThread");
        t.start();

        try {
            Thread.sleep(50);
            t.interrupt();
            Thread.sleep(150);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.println("Main thread finished...");

    }
}
