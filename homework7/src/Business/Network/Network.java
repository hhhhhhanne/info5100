/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.State.State;
import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class Network {
    private String name;
    private ArrayList<State> states;

    public Network() {
       states = new ArrayList<State>();
        
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public State addState(State state){
        states.add(state);
        return state;
    }

    @Override
    public String toString() {
        return name;
    }
}
