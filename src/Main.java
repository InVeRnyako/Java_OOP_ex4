import Model.TreeActions;
import Presenter.Presenter;
import View.Console;
import View.View;

public class Main {
    // Продолжаем грейдить наш проект с гениологическим древом.
    // Изменить древо, сделать класс параметизированным.

    public static void main(String[] args) {
        
        View view =  new Console();
        TreeActions treeActions = new TreeActions();
        Presenter presenter = new Presenter(view, treeActions);

        view.start();
    }

}