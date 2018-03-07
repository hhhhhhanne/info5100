/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Region;
import java.util.ArrayList;

/**
 *
 * @author Chance
 */
public class RegionDirectory {
    private ArrayList<Region> statesDirectory;
    
    public RegionDirectory() {
        this.statesDirectory = new ArrayList<>();
    }
    
    public Region addState(String name) {
        Region temp = null;
        for(Region tempState: this.statesDirectory) {
            if(tempState.getname().getStateName().equals(name)) {
                temp = tempState;
            }
        }
        if(temp == null) {
            temp = new Region(name);
        }
        return temp;
    }

    public ArrayList<Region> getStatesDirectory() {
        return statesDirectory;
    }

    public void setStatesDirectory(ArrayList<Region> statesDirectory) {
        this.statesDirectory = statesDirectory;
    }
}
