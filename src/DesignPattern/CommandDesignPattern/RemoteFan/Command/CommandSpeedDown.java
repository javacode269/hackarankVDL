package DesignPattern.CommandDesignPattern.RemoteFan.Command;

import DesignPattern.CommandDesignPattern.RemoteFan.Fan.Fan;

public class CommandSpeedDown implements Command {
    private Fan fan;
    private int del;

    public CommandSpeedDown(Fan fan, int del) {
        this.fan = fan;
        this.del = del;
    }

    @Override
    public void execute( ) {
        fan.speedDown(del);
    }
}
