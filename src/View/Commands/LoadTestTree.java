package View.Commands;

import View.Console;

public class LoadTestTree extends Command{

    String description = "Загрузить тестовое дерево.";

    public LoadTestTree(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() {
        getConsole().loadTestTree();
        getConsole().print("Тестовое дерево успешно загружено.");
    }
    
}
