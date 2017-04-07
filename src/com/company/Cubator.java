package com.company;

/**
 * Created by admin on 07.04.2017.
 */
public class Cubator extends  Thread{

    private int result = 0;

    private Consumer consumer;

    public Cubator(Consumer cons, int res) {
        consumer = cons;
        result = res;
    }


    @Override
    public synchronized void start() {
        result = result * result * result;

        consumer.sum(result, 0, 0);
    }
}
