package DesignPatterns.Behavioural.CommandDesignPattern;


//invoker class
public class RemoteControl {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public  void pressButton(){
        command.execute();
    }
}
