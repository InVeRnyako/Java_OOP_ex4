package Presenter;


import Model.TreeActions;
import View.View;

public class Presenter {

    private View view;
    private TreeActions service;

    public Presenter(View view, TreeActions service){
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        service.setPresenter(this);
    }

    public String listPersons() {
        return service.showAll();
    }

    public void loadTestTree() {
        service.loadTestTree();
    }
    
    public Boolean addPerson(String fullName, String yearOfBirth, String yearOfDeath){
        return service.addPersonByText(fullName,yearOfBirth,yearOfDeath);
    }
}
