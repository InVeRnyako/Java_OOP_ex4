package View.Commands;

import View.Console;

public class ListPersons extends Command{

    private String desription = "Список людей";

    public ListPersons(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().print("Список людей:");
        getConsole().listPersons();
    }

    
}
