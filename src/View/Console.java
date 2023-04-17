package View;

import java.util.Scanner;

import Presenter.Presenter;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Boolean work = true;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
    }

    @Override
    public void print(String outString) {
        System.out.println(outString);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)) {
                menu.execute(Integer.parseInt(choice));
            } else {
                fail();
            }
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private Boolean check(String toCheck) {
        return toCheck.matches("[0-9]+") && Integer.parseInt(toCheck) - 1 < menu.getCommandsAmount()
                && Integer.parseInt(toCheck) > 0;
    }

    private void fail() {
        System.out.println("Ошибка ввода.");
    }

    public void listPersons(){
        System.out.println(presenter.listPersons());
    }

    public void quit(){
        System.exit(0);
    }

    public void loadTestTree() {
        presenter.loadTestTree();
    }

    public String read(){
        return scanner.nextLine();
    }

    public Boolean addPerson(String fullName, String yearOfBirth, String yearOfDeath){
        return presenter.addPerson(fullName, yearOfBirth, yearOfDeath);
    }
}
