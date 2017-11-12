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
    public SubProviderOrganization() {
        super(Organization.Type.SubProvider.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SubAdminRole());
        return roles;
    }
}
