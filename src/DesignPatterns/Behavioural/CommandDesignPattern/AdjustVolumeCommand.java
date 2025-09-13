package DesignPatterns.Behavioural.CommandDesignPattern;

//concrete command
public class AdjustVolumeCommand implements Command{

    private Stereo sterio;

    public AdjustVolumeCommand(Stereo sterio) {
        this.sterio = sterio;
    }

    @Override
    public void execute() {
        sterio.adjustVolume();
    }
}
