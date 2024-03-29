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
public class Consumer implements Runnable
{

    private Drop drop;

    public Consumer(Drop drop)
    {
        this.drop = drop;
    }

    public void run()
    {
        Random random = new Random();
        for (String message = drop.take(); !message.equals("DONE"); message = drop.take())
        {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try
            {
                Thread.sleep(random.nextInt(5000));
            }
            catch (InterruptedException e)
            {
            }
            System.out.println(Thread.currentThread().getName() + " | " + ProducerConsumerExample.t.getState());
        }
    }
}
