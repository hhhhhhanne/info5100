/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Food.Food;
import Business.Person.BenefitPerson;
import Business.Plan.PlanList;
import Business.Region.Region;
import Business.Request.RequestList;
import Business.Role.Role;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class Government extends Enterprise{
    private RequestList supplierRequestList;
    private RequestList userRequestList;
    private PlanList planlist;
    private EnterpriseDirectory enterpriseDirectory;
    private ArrayList<BenefitPerson> benefitPeopleCatalog;

    public Government() {
        super("", EnterpriseType.Government);
        supplierRequestList = new RequestList();
        userRequestList = new RequestList();
        planlist = new PlanList();
        enterpriseDirectory = new EnterpriseDirectory();
        benefitPeopleCatalog = new ArrayList<>();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public RequestList getSupplierRequestList() {
        return supplierRequestList;
    }

    public void setSupplierRequestList(RequestList supplierRequestList) {
        this.supplierRequestList = supplierRequestList;
    }

    public PlanList getPlanlist() {
        return planlist;
    }

    public void setPlanlist(PlanList planlist) {
        this.planlist = planlist;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public RequestList getUserRequestList() {
        return userRequestList;
    }

    public void setUserRequestList(RequestList userRequestList) {
        this.userRequestList = userRequestList;
    }

    public ArrayList<BenefitPerson> getBenefitPeopleCatalog() {
        return benefitPeopleCatalog;
    }

    public void setBenefitPeopleCatalog(ArrayList<BenefitPerson> benefitPeopleCatalog) {
        this.benefitPeopleCatalog = benefitPeopleCatalog;
    }
    
    public BenefitPerson addNewBenefitPerson(String name, String ssn, Region.StateName state) {
        for(BenefitPerson bp: this.benefitPeopleCatalog) {
            if(bp.getSsn().equals(ssn)) {
                JOptionPane.showMessageDialog(null, "SSN had already in this system. Contact customer service for help.");
                return null;
            }
        }
        BenefitPerson newperson = new BenefitPerson(name, ssn, state);
        this.benefitPeopleCatalog.add(newperson);
        return newperson;
    }
    
    public BenefitPerson searchBenefitPersonBySSN(String ssn){ 
        if(ssn.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input a correct SSN.");
            return null;
        }
        BenefitPerson bf = null;
        for(BenefitPerson tempBF: this.benefitPeopleCatalog) {
            if(tempBF.getSsn().equals(ssn)) {
                bf = tempBF;
                break;
            }
        }
        if(bf == null) {
            JOptionPane.showMessageDialog(null, "No account with this SSN number in system.");
        }
        return bf;
    }
    
    public void deleteBenefitPerson(BenefitPerson bp) {
        this.benefitPeopleCatalog.remove(bp);
    }
    
}
