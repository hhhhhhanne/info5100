/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SubAdminRole;
import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class SubProviderOrganization extends Organization{
    private InventoryOrganization inventoryOrg;
    private ArrayList<ClinicOrganization> clinicOrgList;
    
    public SubProviderOrganization() {
        super(Organization.Type.SubProvider.getValue());
        inventoryOrg = new InventoryOrganization();
        clinicOrgList = new ArrayList<ClinicOrganization>();
    }

    public ClinicOrganization addClinicOrganization(ClinicOrganization co){
        clinicOrgList.add(co);
        return co;
    }
    public InventoryOrganization getInventoryOrg() {
        return inventoryOrg;
    }

    public void setInventoryOrg(InventoryOrganization inventoryOrg) {
        this.inventoryOrg = inventoryOrg;
    }

    public ArrayList<ClinicOrganization> getClinicOrgList() {
        return clinicOrgList;
    }

    public void setClinicOrgList(ArrayList<ClinicOrganization> clinicOrgList) {
        this.clinicOrgList = clinicOrgList;
    }


    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SubAdminRole());
        return roles;
    }
    
}
