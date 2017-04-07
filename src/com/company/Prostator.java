package com.company;

/**
 * Created by admin on 07.04.2017.
 */
public class Prostator extends Thread {



    private int result = 0;


    private Consumer consumer;


    public Prostator(Consumer cons, int res)
    {
        consumer = cons;
        result = res;
    }

    @Override
    public synchronized void start() {
        consumer.sum(0, 0, result);
    }
}
