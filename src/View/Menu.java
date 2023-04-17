package View;

import java.util.ArrayList;
import java.util.List;

import View.Commands.*;

public class Menu {
    private List<Command> list;

    public Menu(Console console){
        list = new ArrayList<>();
        list.add(new AddPerson(console));
        list.add(new ListPersons(console));
        list.add(new Quit(console));
        list.add(new LoadTestTree(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    void execute(int choice){
        list.get(choice - 1).execute();
    }

    public int getCommandsAmount(){
        return list.size();
    }
}
