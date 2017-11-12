/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type,String workarea){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Clinic.getValue())){
            organization = new ClinicOrganization();
            organization.setWorkArea(workarea);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Inventory.getValue())){
            organization = new InventoryOrganization();
            organization.setWorkArea(workarea);
            organizationList.add(organization);
        }
        return organization;
    }
}
