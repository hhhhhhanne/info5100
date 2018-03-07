/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Account.Account;
import Business.Account.AccountDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.Government;
import Business.Region.Region.StateName;
import Business.Region.RegionDirectory;

/**
 *
 * @author Chance
 */
public class Network {
    private String name;
    private StateName state;
    //private EnterpriseDirectory enterDir;
    private Government government;
    private Account stateAccount;
    
    public Network(StateName state) {
        this.name = state.getStateName();
        this.state = state;
        //statDir = new RegionDirectory();
        //enterDir = new EnterpriseDirectory();
        this.government = new Government();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
    public EnterpriseDirectory getEnterDir() {
        return enterDir;
    }

    public void setEnterDir(EnterpriseDirectory enterDir) {
        this.enterDir = enterDir;
    }
    
    public RegionDirectory getStatDir() {
        return statDir;
    }

    public void setStatDir(RegionDirectory statDir) {
        this.statDir = statDir;
    }
    * */

    public StateName getState() {
        return state;
    }

    public void setState(StateName state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    public Government getGovernment() {
        return government;
    }

    public Account getStateAccount() {
        return stateAccount;
    }

    public void setStateAccount(Account stateAccount) {
        this.stateAccount = stateAccount;
    }
}
