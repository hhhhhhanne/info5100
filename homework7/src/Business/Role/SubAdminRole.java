/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SubProviderOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import UserInterface.SubAdminRole.SubAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author zhaoxiaohan
 */
public class SubAdminRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SubAdminWorkAreaJPanel(userProcessContainer, account, (SubProviderOrganization)organization, enterprise, business);
    }
}
