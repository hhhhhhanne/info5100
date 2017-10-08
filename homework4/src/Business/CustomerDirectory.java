/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerDir;

    public CustomerDirectory() {
        this.customerDir = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerDir() {
        return customerDir;
    }

    public void setCustomerDir(ArrayList<Customer> customerDir) {
        this.customerDir = customerDir;
    }
    
    
}
