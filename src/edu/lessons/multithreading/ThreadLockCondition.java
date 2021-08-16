package edu.lessons.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockCondition {
    public static void main(String[] args) {

        Store1 store = new Store1();
        Producer1 producer = new Producer1(store);
        Consumer1 consumer = new Consumer1(store);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}

class Store1{

    private int product=0;

    ReentrantLock locker;
    Condition condition;

    Store1(){
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void get() {
        locker.lock();
        try{
            while (product<1)
                condition.await();

            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            condition.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock();
        }

    }

    public void put() {

        locker.lock();
        try{
            while (product>=3)
                condition.await();

            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);

            condition.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock();
        }

    }
}

class Producer1 implements Runnable{

    Store1 store;

    Producer1(Store1 store){
        this.store=store;
    }

    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }

}

class Consumer1 implements Runnable{

    Store1 store;

    Consumer1(Store1 store){
        this.store=store;
    }

    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }

}
