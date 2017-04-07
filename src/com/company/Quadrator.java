package com.company;

/**
 * Created by admin on 07.04.2017.
 */
public class Quadrator extends Thread {

    private int result = 0;

    private Consumer consumer;


    public Quadrator(Consumer cons, int res)
    {
        consumer = cons;
        result = res;
    }

    @Override
    public synchronized void start() {
        result = result * result;

        consumer.sum(0, result, 0);
    }
}
