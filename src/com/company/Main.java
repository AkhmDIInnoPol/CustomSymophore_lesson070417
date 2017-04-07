package com.company;

public class Main {



    private static int[] a = {1,2,3};

    private static int[] b = {1,3,4};

    private static int[] c = {1, 3, 2};


    public static void main(String[] args) {
	// write your code here

        Consumer consumer = new Consumer();

        for (int i = 0; i < a.length; i++)
        {
            new Cubator(consumer,a[i]).start();
        }
        for (int i = 0; i < b.length; i++)
        {
            new Quadrator(consumer,b[i]).start();
        }
        for (int i = 0; i < c.length; i++)
        {
            new Prostator(consumer,c[i]).start();
        }

    }
}
