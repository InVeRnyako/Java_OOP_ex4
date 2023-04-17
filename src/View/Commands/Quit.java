package View.Commands;

import View.Console;

public class Quit extends Command{

    private String desription = "Выход";

    public Quit(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().quit();
    }
    
}
