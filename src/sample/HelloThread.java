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
public class HelloThread extends Thread
{
    public void run()
    {
        System.out.println("run");
    }

    public static void main(String args[])
    {
        System.out.println("main before");
        HelloThread t = new HelloThread();
        t.start();
        System.out.println("main after");
    }

}
