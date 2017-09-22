/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airline;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class Airliner {
    private ArrayList<Airplane> airliner;

    public Airliner()
    {
        airliner = new ArrayList<Airplane>();
    }

    public ArrayList<Airplane> getAirliner() {
        return airliner;
    }

    public void setAirliner(ArrayList<Airplane> airliner) {
        this.airliner = airliner;
    }
    
    public Airplane addAirplane(){
        Airplane airp = new Airplane();
        airliner.add(airp);
        return airp;
    }
    
    public Airplane addAirplane(Airplane ap) {
        airliner.add(ap);
        return ap;
    }

    public void deteleAirplane(Airplane a){
        airliner.remove(a);
    }

}
