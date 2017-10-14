/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HumanResources.PersonDirectory;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class PersonDirectory {
    private ArrayList<Person> personlist;

    public PersonDirectory() {
        personlist= new ArrayList();
    }

    public ArrayList<Person> getPersonlist() {
        return personlist;
    }

    public void setPersonlist(ArrayList<Person> personlist) {
        this.personlist = personlist;
    }
    public Person newPerson(){
        Person p = new Person();
        personlist.add(p);
        return p;
    }
    public void removePerson(Person p) {
        personlist.remove(p);
    }
    
    public Person findPersonByLastName(String lastName) {
        for(Person p : personlist) {
            if(p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }
}
