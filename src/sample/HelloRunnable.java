/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;

/**
 *
 * @author dushantha.eranga
 */
public class HelloRunnable implements Runnable
{
    public static void main(String[] args)
    {
        HelloRunnable h = new HelloRunnable();
        Thread t = new Thread(h);
        t.start();
        System.out.println("main");
    }

    @Override
    public void run()
    {
        System.out.println("run");
    }
}
