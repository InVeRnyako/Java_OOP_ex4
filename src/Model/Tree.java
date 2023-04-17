package Model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import Model.Person.Person;
import Model.Person.PersonIterator;

public class Tree<E extends Person> implements Serializable, Iterable<E> {
    private HashSet<E> eData;
    private HashSet<Parent> parentsData;
    


    public Tree(HashSet<E> inputPersons, HashSet<Parent> inputParents) {
        this.eData = inputPersons;
        this.parentsData = inputParents;
    }

    public Tree() {
        this(new HashSet<>(), new HashSet<>());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        String prefix = "";
        for (E person : eData) {
            output.append(prefix);
            output.append(person);
            prefix = ", ";
        }
        return output.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(eData, parentsData);
    }

    public HashSet<E> getEData() {
        return eData;
    }

    public void setEData(HashSet<E> personsData) {
        this.eData = personsData;
    }

    public HashSet<Parent> getParentsData() {
        return parentsData;
    }

    public void setParentsData(HashSet<Parent> parentsData) {
        this.parentsData = parentsData;
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<E>(eData);
    }



}
