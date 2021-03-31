/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dushantha.eranga
 */
public class ProducerConsumerExample
{
    public static Thread t = Thread.currentThread();
    
    public static void main(String[] args)
    {
        System.out.println("||| " + Thread.currentThread().getName() + " | " + t.getState());
        
        Drop drop = new Drop();
        Thread producer = new Thread(new Producer(drop), "ProducerThread");        
        Thread consumer = new Thread(new Consumer(drop), "ConsumerThread");
        
        System.out.println("||| " + Thread.currentThread().getName() + " | " + t.getState());
        
        producer.start();
        
        System.out.println("||| " + Thread.currentThread().getName() + " | " + t.getState());
        
        consumer.start();
        
        System.out.println("||| " + Thread.currentThread().getName() + " | " + t.getState());
        
        for (int i = 0; i < 80000000; i++)
        {
            System.out.print("");
        }
        System.out.println("||| " + Thread.currentThread().getName() + " | " + t.getState());
    }
}
