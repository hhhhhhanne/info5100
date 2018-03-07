/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Region.Region;

/**
 *
 * @author Chance
 */
public class Person extends P{

    public Person(String name) {
        super(name);
    }

    public Person(String name, Region.StateName state) {
        super(name, state);
    }
    
}
