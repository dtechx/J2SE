/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.producerconsumer;

import java.util.Random;

/**
 *
 * @author dushantha.eranga
 */
public class Producer implements Runnable
{

    private Drop drop;

    public Producer(Drop drop)
    {
        this.drop = drop;
    }

    public void run()
    {
        String importantInfo[] =
        {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++)
        {
            drop.put(importantInfo[i]);
            try
            {
                Thread.sleep(random.nextInt(5000));
            }
            catch (InterruptedException e)
            {
            }
            System.out.println(Thread.currentThread().getName() + " | " + ProducerConsumerExample.t.getState());
        }
        drop.put("DONE");
    }
}
