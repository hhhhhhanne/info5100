/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Organization.OrganizationDirectory;
import Business.Request.RequestList;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Chance
 */
public class FoodBank extends Enterprise{
    private EnterpriseDirectory edir;
    private ArrayList<FoodInventory> inventoryList;
    private RequestList inRequestList;
    private RequestList outRequestList;
    private FoodBankType fbtype;
    public FoodBank(String name) {
        super(name, Enterprise.EnterpriseType.FoodBank);
        //System.out.println(name);
        this.edir = new EnterpriseDirectory();
        this.inventoryList = new ArrayList<FoodInventory>();
        this.inRequestList = new RequestList();
        this.outRequestList = new RequestList();
    }

    public EnterpriseDirectory getEdir() {
        return edir;
    }

    public void setEdir(EnterpriseDirectory edir) {
        this.edir = edir;
    }
    public FoodInventory addInventory(FoodInventory foodInventory) {
        inventoryList.add(foodInventory);
        return foodInventory;
    }

    public FoodInventory searchInventory(Food food) {
        for (FoodInventory in : inventoryList) {
            if (in.getFood().getName().equals(food.getName())) {
                return in;
            }
        }
        return null;
    }

    public ArrayList<FoodInventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<FoodInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public RequestList getInRequestList() {
        return inRequestList;
    }

    public void setInRequestList(RequestList inRequestList) {
        this.inRequestList = inRequestList;
    }

    public RequestList getOutRequestList() {
        return outRequestList;
    }

    public void setOutRequestList(RequestList outRequestList) {
        this.outRequestList = outRequestList;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public FoodBankType getFbtype() {
        return fbtype;
    }

    public void setFbtype(FoodBankType fbtype) {
        this.fbtype = fbtype;
    }
    
    public enum FoodBankType{
        Non_Profit("Non_Profit"), GovernmentAgency("Government_Agency");
        
        private String value;
        private FoodBankType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }
}
