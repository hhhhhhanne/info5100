/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class SupplierDirectory {
    private ArrayList<SupplierEnterprise> supplierEnterpriseList;

    public SupplierDirectory() {
        supplierEnterpriseList = new ArrayList<SupplierEnterprise>();
    }

    public ArrayList<SupplierEnterprise> getSupplierEnterpriseList() {
        return supplierEnterpriseList;
    }

    public void setSupplierEnterpriseList(ArrayList<SupplierEnterprise> supplierEnterpriseList) {
        this.supplierEnterpriseList = supplierEnterpriseList;
    }
    
}
