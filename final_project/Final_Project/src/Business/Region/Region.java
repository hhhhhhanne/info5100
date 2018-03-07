/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Region;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Chance
 */
public class Region {
    private StateName name;

    public StateName getName() {
        return name;
    }

    public void setName(StateName name) {
        this.name = name;
    }
    
    public enum StateName{
        Indiana("Indiana"),
        Michigan("Michigan"),
        Massachusetts("Massachusetts"),
        NewYork("NewYork");
        
        private String stateName;
        StateName(String stateName) {
            this.stateName = stateName;
        }
        public String getStateName() {
            return stateName;
        }
        @Override
        public String toString() {
            return stateName;
        }
    }
    
    public Region(String name) {
        for(StateName statename: StateName.values()) {
            if(statename.getStateName().equals(name)) {
                this.name = statename;
            }
        }
        //this.stateProvider = new EnterpriseDirectory();
    }

    public StateName getname() {
        return name;
    }

    public void setname(StateName name) {
        this.name = name;
    }
}
