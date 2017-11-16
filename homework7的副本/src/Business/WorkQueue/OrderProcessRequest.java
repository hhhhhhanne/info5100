/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;


/**
 *
 * @author zhaoxiaohan
 */
public class OrderProcessRequest extends WorkRequest{
    private String shipping;

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String toString(){
        return super.getVaccine().getVaccineName();
    }



}
