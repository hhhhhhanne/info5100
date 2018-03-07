/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Region.Region.StateName;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class PersonDirectory {
    private ArrayList<P> personDir;
    
    public PersonDirectory() {
        personDir = new ArrayList<>();
    }

    public ArrayList<P> getPersonDir() {
        return personDir;
    }

    public void setPersonDir(ArrayList<P> personDir) {
        this.personDir = personDir;
    }
    
    public Person addNewPerson(String name) {
        Person p = new Person(name);
        this.personDir.add(p);
        return p;
    }
    
    public Person addSupplierPerson(String name,StateName state) {
        Person p = new Person(name,state);
        this.personDir.add(p);
        return p;
    }
    public void deletePerson(Person p){
        personDir.remove(p);
    }
    
    
    
}
