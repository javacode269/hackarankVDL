package DesignPattern.CommandDesignPattern.RemoteFan.Remote;


import DesignPattern.CommandDesignPattern.Bank.ICommand;
import DesignPattern.CommandDesignPattern.RemoteFan.Command.CommandSpeedDown;
import DesignPattern.CommandDesignPattern.RemoteFan.Command.CommandSpeedUp;
import DesignPattern.CommandDesignPattern.RemoteFan.Fan.Fan;

import  DesignPattern.CommandDesignPattern.RemoteFan.Command.Command;
//Invoker
public class Remote {




    //driver code
    public static void main(String[] args) {
        Fan fan = new Fan(0);
        Command speedUp10 = new CommandSpeedUp(fan,10);
        Command speedDown5 = new CommandSpeedDown(fan,5);

        fan.exec();


    }
}
