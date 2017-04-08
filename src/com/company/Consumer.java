package com.company;

/**
 * Created by admin on 07.04.2017.
 */
public class Consumer {


    private static Object notifierForCubator = new Object();
    private static Object notifierForQuadrator = new Object();
    private static Object notifierForProstator = new Object();


    private final String CUBATOR_NAME = "com.company.Cubator";
    private final String QUADRATOR_NAME = "com.company.Quadrator";
    private final String PROSTATOR_NAME = "com.company.Prostator";

    private volatile String isCubatorEntered = "";
    private volatile String isQuadratorEntered = "";
    private volatile String isProstatorEntered = "";



    private int result = 0;








    public void sum(int resCubator, int resQuadrator, int resProstator)
    {
        String currentThreadClassName = new Exception().getStackTrace()[1].getClassName();;

        if (currentThreadClassName.equals(CUBATOR_NAME))
        {
            System.out.println("Cubator enter");
            if (CUBATOR_NAME.equals(isCubatorEntered))
            {
                synchronized (notifierForCubator)
                {
                    try {
                        notifierForCubator.wait();
                    }
                    catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
            isCubatorEntered = CUBATOR_NAME;
        }

        if (currentThreadClassName.equals(QUADRATOR_NAME))
        {
            System.out.println("Quadrator enter");
            if (QUADRATOR_NAME.equals(isQuadratorEntered))
            {
                synchronized (notifierForQuadrator)
                {
                    try {
                        notifierForQuadrator.wait();
                    }
                    catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }

            isQuadratorEntered = QUADRATOR_NAME;
        }

        if (currentThreadClassName.equals(PROSTATOR_NAME))
        {
            System.out.println("Prostator enter");
            if (PROSTATOR_NAME.equals(isProstatorEntered))
            {
                synchronized (notifierForProstator)
                {
                    try {
                        notifierForProstator.wait();
                    }
                    catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }

            isProstatorEntered = PROSTATOR_NAME;
        }


        met(resCubator, resQuadrator, resProstator);




        // Free resources
        if (currentThreadClassName.equals(CUBATOR_NAME))
        {
            System.out.println("Cubator exit");
            isCubatorEntered = "";
            synchronized (notifierForCubator)
            {
                notifierForCubator.notify();
            }
        }
        if (currentThreadClassName.equals(QUADRATOR_NAME))
        {
            System.out.println("Quadrator exit");
            isQuadratorEntered = "";
            synchronized (notifierForQuadrator)
            {
                notifierForQuadrator.notify();
            }
        }
        if (currentThreadClassName.equals(PROSTATOR_NAME))
        {
            System.out.println("Prostator exit");
            isProstatorEntered = "";
            synchronized (notifierForProstator)
            {
                notifierForProstator.notify();
            }
        }
    }



    private void met(int kube, int kvadro, int simple)
    {
        result = kube + kvadro + simple;

        System.out.println("Current result  = " + result);
    }






}
