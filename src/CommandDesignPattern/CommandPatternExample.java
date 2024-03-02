package CommandDesignPattern;
/*
The Command Design Pattern is a behavioral design pattern that turns a request into a stand-alone object,
allowing parameterization of clients with different requests, queuing of requests, and support for undoable operations.

The Command Pattern encapsulates a request as an object, allowing for the separation of sender and receiver.
Commands can be parameterized, meaning you can create different commands with different parameters without changing
the invoker(responsible for initiating command execution).
It decouples the sender (client or invoker) from the receiver (object performing the operation),
providing flexibility and extensibility.
The pattern supports undoable(action or a series of actions that can be reversed or undone in a system)
operations by storing the state or reverse commands.

 */
public class CommandPatternExample {
    public static void main(String[] args) {
        // create device
        TV tv = new TV();
        Stereo stereo = new Stereo();

        //create command object
        Command turnOntvCommand = new TurnOnCommand(tv);
        Command turnOffTvCommand = new TurnOffCommand(tv);

        Command adjustVolume = new AdjustVolumeCommand(stereo);
        Command changeChannel = new ChangeChannelCommand(tv);

        // create remote control
        RemoteControl remoteControl = new RemoteControl();

        //set and execute command
        remoteControl.setCommand(turnOntvCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffTvCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(adjustVolume);
        remoteControl.pressButton();

        remoteControl.setCommand(changeChannel);
        remoteControl.pressButton();
    }
}
