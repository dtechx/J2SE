/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;

import java.time.LocalTime;
import java.util.concurrent.ForkJoinTask;

/**
 *
 * @author dushantha.eranga
 */
public class Deadlock
{
    public static int counter = 0;

    public static void main(String[] args)
    {
        Friend balla = new Friend("balla");
        Friend pusa = new Friend("pusa");
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                //threadMessage("Before Inside T1 run");
                balla.bow(pusa);
                //threadMessage("After Inside T1 run");
            }
        }, "T1").start();
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                //threadMessage("Before Inside T2 run");
                pusa.bow(balla);
                //("After Inside T2 run");
            }
        }, "T2").start();
    }
    
    static void threadMessage(String message)
    {
        counter++;
        LocalTime localTime = java.time.LocalTime.now();
        String time = localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond() + ":" + localTime.getNano();
        String threadName = Thread.currentThread().getName();
        System.out.format("%d| %s| %s| %s%n", counter, time, threadName, message);
    }
}
