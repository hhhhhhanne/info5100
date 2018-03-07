/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import Business.Account.Account;
import Business.Enterprise.Government;
import Business.Enterprise.Supplier;
import Business.Plan.Plan;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class RequestList {
    private ArrayList<Request> requestList = new ArrayList<>();
    
    public RequestList() {
        requestList = new ArrayList<>();
    }
    
    public void addRequest(Request req) {
        this.requestList.add(req);
    }
    public UserRequest addUserRequest(Government gov, Account account, float income, Plan expplan) {
        if(income < 0 || expplan == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return null;
        }
        UserRequest newuserrequest = new UserRequest(account, income, expplan);
        this.requestList.add(newuserrequest);
        return newuserrequest;
    }
    public FoodRequest addFoodRequest(FoodRequest foodRequest){
        this.requestList.add(foodRequest);
        return foodRequest;
    }

    public ArrayList<Request> getRequestList() {
        return requestList;
    }
    
    public SupplierRequest addSupRequest(Account account, Supplier enter){
        SupplierRequest req= new SupplierRequest(account,enter);
         this.requestList.add(req);
        return req;
    }
}
