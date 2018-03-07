/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Vaccine.Vaccine;

/**
 *
 * @author zhaoxiaohan
 */
public class Inventory {
    private Vaccine vaccine;
    private int num;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }



    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString(){
        return vaccine.getVaccineName();
    }
    
}
