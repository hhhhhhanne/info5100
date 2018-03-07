/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import Business.Account.Account;
import Business.Enterprise.Supplier;
import Business.Network.Network;
import Business.Region.Region;

/**
 *
 * @author Chance
 */
public class SupplierRequest extends Request{

    private Account account;
    private Supplier supplier;
    private String status;

    public SupplierRequest(Account account,Supplier supplier) {
        super(RequestType.SupplierRequest);
        this.supplier=supplier;
        this.account=account;
        this.status = "Processing";
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
 
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
