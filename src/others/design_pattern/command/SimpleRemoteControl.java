package others.design_pattern.command;

public class SimpleRemoteControl {
    Command slot;

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
