/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import static sample.Deadlock.threadMessage;

/**
 *
 * @author dushantha.eranga
 */
public class Friend
{
    private final String name;

    public Friend(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public synchronized void bow(Friend bower)
    {
        threadMessage("Before " + this.name + ": " + bower.getName() + " has bowed to me");
//            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
        bower.bowBack(this);
        threadMessage("After " + this.name + ": " + bower.getName() + " has bowed to me");
    }

    public void bowBack(Friend bower)
    {
        threadMessage(this.name + ": " + bower.getName() + " has bowed back to me");
//            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
    }
}
