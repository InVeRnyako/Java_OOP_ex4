package Model;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Model.Person.Person;
import Model.Person.PersonComparatorByBirthDate;
import Model.Person.PersonComparatorByName;
import Presenter.Presenter;
import View.Commands.LoadTestTree;

public class TreeActions implements TreeData {
    Tree<Person> tree;
    Presenter presenter;

    public TreeActions(Tree<Person> tree) {
        this.tree = tree;
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    public TreeActions() {
        this.tree = new Tree<Person>();
    }

    @Override
    public void saveData() {
        SaveFile sf = new SaveFile();
        sf.saveData(this);
    }

    @Override
    public void readData() {
        SaveFile sf = new SaveFile();
        Object dataFromFile = sf.readData();
        if (dataFromFile instanceof Tree) {
            Tree<Person> readTree = new Tree<>();
            readTree = (Tree) (dataFromFile);
            tree.setParentsData(readTree.getParentsData());
            tree.setEData(readTree.getEData());
        }
        return;
    }

    public String showAll() {
        StringBuilder outputString = new StringBuilder();
        String prefix = "";
        for (Person e : tree.getEData()) {
            outputString.append(prefix);
            outputString.append(e);
            prefix = "\n";
        }
        return outputString.toString();
    }

    public List<Person> sortByName() {
        List<Person> outList = new ArrayList<Person>(tree.getEData());
        outList.sort(new PersonComparatorByName());
        return outList;
    }

    public List<Person> sortByBirthDate() {
        List<Person> outList = new ArrayList<Person>(tree.getEData());
        outList.sort(new PersonComparatorByBirthDate());
        return outList;
    }

    public HashSet<Integer> findAllKidsId(Integer parentId) {
        HashSet<Integer> kidsIdSet = new HashSet<>();
        for (Parent parentKidPair : tree.getParentsData()) {
            if (parentId.equals(parentKidPair.getIdParent())) {
                kidsIdSet.add(parentKidPair.getIdKid());
            }
        }
        return kidsIdSet;
    }

    public HashSet<Integer> findAllParentsId(Integer kidId) {
        HashSet<Integer> parentsIdSet = new HashSet<>();
        for (Parent parentKidPair : tree.getParentsData()) {
            if (kidId.equals(parentKidPair.getIdKid()))
                parentsIdSet.add(kidId);
        }
        return parentsIdSet;
    }

    public HashSet<Person> idToPersonSet(HashSet<Integer> inputIdSet) {
        HashSet<Person> outSet = new HashSet<>();
        for (Person person : tree.getEData()) {
            if (inputIdSet.contains(person.getId()))
                outSet.add(person);
        }
        return outSet;
    }

    public Person findPersonByName(String nameInput) {
        for (Person person : tree.getEData()) {
            if (person.getName().contains(nameInput))
                return person;
        }
        return null;
    }

    public void addPerson(Person newPerson) {
        if (newPerson == null)
            return;
        tree.getEData().add(newPerson);
    }

    public Boolean addPersonByText(String fullName, String yearOfBirth, String yearOfDeath){
        if (fullName.equals(""))
            fullName = null;
        Person personToadd = new Person(getFreeId(), fullName);
        if (yearOfBirth.equals(""))
            personToadd.setBirthYear(null);
        else
            personToadd.setBirthYear(Year.parse(yearOfBirth));
        if (yearOfDeath.equals(""))
            personToadd.setDeathYear(null);
        else
            personToadd.setDeathYear(Year.parse(yearOfDeath));
        addPerson(personToadd);
        System.out.println(fullName);
        return true;
    }

    public void removePerson(Integer indexToRemove) {
        tree.getEData().removeIf((t) -> t.getId().equals(indexToRemove));
    }

    public void addParent(Integer kidId, Integer parentId) {
        if (kidId != parentId)
            tree.getParentsData().add(new Parent(kidId, parentId));
    }

    public void loadTestTree(){
        tree = new Tree<>();
        addPerson(new Person(0, "Михаил Федорович", Year.of(1613), Year.of(1645)));
        addPerson(new Person(1, "Евдокия Стрешнева"));
        addPerson(new Person(2, "Мария Милославская"));
        addPerson(new Person(3, "Алексей Михайлович", Year.of(1645), Year.of(1676)));
        addParent(3, 0);
        addParent(3, 1);

        addPerson(new Person(4, "Наталья Нарышкина"));
        addPerson(new Person(5, "Федор Алексеевич", Year.of(1676), Year.of(1682)));
        addParent(5, 2);
        addParent(5, 3);

        addPerson(new Person(6, "Иван V", Year.of(1682), Year.of(1696)));
        addPerson(new Person(7, "Софья Алексеевна", Year.of(1682), Year.of(1689)));
        addParent(7, 2);
        addParent(7, 3);

        addPerson(new Person(8, "Евдокия Лопухина"));
        addPerson(new Person(9, "Петр I", Year.of(1682), Year.of(1725)));
        addParent(9, 3);
        addParent(9, 4);
    }

    public Integer getFreeId(){
        Integer id = 0;
        for (Person person : tree) {
            if (person.getId() != id)
                return id;
            id++;
        }
        return id;
    }
}
