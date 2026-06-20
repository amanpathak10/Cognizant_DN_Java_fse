public class CommandPatternExample {
    interface Command { void execute(); }
    static class Light { void on(){ System.out.println("Light ON"); } void off(){ System.out.println("Light OFF"); } }
    static class LightOnCommand implements Command { private Light light; LightOnCommand(Light l){ this.light=l; } public void execute(){ light.on(); } }
    static class LightOffCommand implements Command { private Light light; LightOffCommand(Light l){ this.light=l; } public void execute(){ light.off(); } }
    static class RemoteControl { private Command slot; public void setCommand(Command c){ slot=c; } public void press(){ if(slot!=null) slot.execute(); } }

    public static void main(String[] args){
        Light light = new Light();
        RemoteControl rc = new RemoteControl();
        rc.setCommand(new LightOnCommand(light)); rc.press();
        rc.setCommand(new LightOffCommand(light)); rc.press();
    }
}
