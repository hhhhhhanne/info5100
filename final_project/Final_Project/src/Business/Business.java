/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Account.AccountDirectory;
import Business.Food.Food;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Plan.PlanList;
import Business.Region.Region;
import Business.Request.RequestList;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class Business extends Organization{
    private static Business business;
    private ArrayList<Network> networkList;
    private RequestList foodbankRequestList;
    private RequestList foodTransRequestList;
    private ArrayList<Food> foodCatalog;
    private Business() {
        super("Food For Free");
        networkList = new ArrayList<>();
        foodbankRequestList = new RequestList();
        foodTransRequestList = new RequestList();
        foodCatalog = new ArrayList<>();
    }

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork(Region.StateName state) {
        for(Network ntw:this.networkList) {
            if(ntw.getName().equals(state.getStateName())) {
                JOptionPane.showMessageDialog(null, "Network name already exist.");
                return null;
            }
        }
        Network network = new Network(state);
        networkList.add(network);
        return network;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public RequestList getFoodbankRequestList() {
        return foodbankRequestList;
    }

    public void setFoodbankRequestList(RequestList foodbankRequestList) {
        this.foodbankRequestList = foodbankRequestList;
    }
    


    public RequestList getFoodTransRequestList() {
        return foodTransRequestList;
    }

    public void setFoodTransRequestList(RequestList foodTransRequestList) {
        this.foodTransRequestList = foodTransRequestList;
    }
    
    public ArrayList<Food> getFoodCatalog() {
        return foodCatalog;
    }

    public void setFoodCatalog(ArrayList<Food> foodCatalog) {
        this.foodCatalog = foodCatalog;
    }
    public Food AddfoodtoFoodList(){
        Food food=new Food();
        foodCatalog.add(food);
        return food;
    }
    public void deletefoodfromList(Food fo){
        foodCatalog.remove(fo);
    }
}
