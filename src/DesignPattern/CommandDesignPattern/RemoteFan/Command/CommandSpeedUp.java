package DesignPattern.CommandDesignPattern.RemoteFan.Command;

import DesignPattern.CommandDesignPattern.RemoteFan.Fan.Fan;
public class CommandSpeedUp implements Command {
    Fan fan;
    int del;

    public CommandSpeedUp(Fan fan, int del) {
        this.fan = fan;
        this.del = del;
    }

    @Override
    public void execute( ) {
        fan.speedUp(del);
    }
}
