interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("Light On");
    }

    public void off() {
        System.out.println("Light Off");
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light l) {
        this.light = l;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light l) {
        this.light = l;
    }

    public void execute() {
        light.off();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command c) {
        this.command = c;
    }

    public void pressButton() {
        command.execute();
    }
}

class DesignEx9 {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }
}