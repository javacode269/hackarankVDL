package DesignPattern.CommandDesignPattern.RemoteFan.Fan;



import DesignPattern.CommandDesignPattern.RemoteFan.Command.Command;

import java.util.Stack;

public class Fan {
    private int speed;
    private Stack<Command> dsCommand;


    public Fan(int speed ) {
        System.out.println("init fan with speed " + speed);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void speedUp(int del) {
        System.out.println("Running command speedup " + del);
        this.setSpeed(speed+del);
    }

    public void speedDown(int del) {
        System.out.println("Running command speedDown " + del);
        this.setSpeed(speed>del?speed-del:0);
    }

    public void addCommand (Command cmd){
        dsCommand.add(cmd);
    }

    public void exec() {
        while (!dsCommand.isEmpty()) {
            Command cmd = dsCommand.pop();
            cmd.execute();
        }
    }
}
