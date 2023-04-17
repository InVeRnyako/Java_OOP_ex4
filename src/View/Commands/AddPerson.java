package View.Commands;

import View.Console;

public class AddPerson extends Command{

    Console console;
    private String desription = "Добавить человека";

    public AddPerson(Console console) {
        super(console);
        this.console = console;
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        console.print("Введите данные человека. Если данных нет, оставьте пустым");
        console.print("Имя:");
        String fullName = console.read();
        console.print("Дата рождения:");
        String birthDate = console.read();
        console.print("Дата смерти");
        String deathDate = console.read();
        if (console.addPerson(fullName,birthDate,deathDate))
            console.print("Человек успешно добавлен");
        else
            console.print("Ошибка при добавлении человека. Проверьте вводимые данные");
    }
    
    
}
