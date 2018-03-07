/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Account.Account;
import Business.Account.Account.AccountStatus;
import Business.Enterprise.Agent;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Enterprise.FoodBank;
import Business.Enterprise.FoodBank.FoodBankType;
import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.OrganizationType;
import Business.Person.BenefitPerson;
import Business.Person.Person;
import Business.Region.Region;
import Business.Region.Region.StateName;
import Business.Role.GovernmentRole;
import Business.Role.InventoryRole;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.Role.ServiceRole;
import Business.Role.SystemAdminRole;
import Business.Role.UserRole;

/**
 *
 * @author Chance
 */
public  class ConfigureASystem {
    public static Business configure() {
        Business business = Business.getInstance();
                
        Network ma_1 = business.createAndAddNetwork(StateName.Massachusetts);
        ma_1.getGovernment().getPlanlist().addPlan("Basic SNAP Benefits", 130, 150);
        ma_1.getGovernment().getPlanlist().addPlan("Cash Assistance for Household 1",130f, 303.70f);
        
        Food food_1 = new Food("Potato", 0.24f);
        business.getFoodCatalog().add(food_1);
        Food food_2 = new Food("Tomato", 0.40f);
        business.getFoodCatalog().add(food_2);
        Food food_3 = new Food("Egg", 0.1f);
        business.getFoodCatalog().add(food_3);
        Food food_4 = new Food("Milk", 0.15f);
        business.getFoodCatalog().add(food_4);
        //-----------------------------------------------------------------------
        FoodBank foodbank_1 = (FoodBank)ma_1.getGovernment().getEnterpriseDirectory().addEnterprise("The Greater Boston Food Bank", EnterpriseType.FoodBank);
        foodbank_1.setFbtype(FoodBankType.GovernmentAgency);
        FoodInventory foodinv_11 = new FoodInventory(food_1, 200);
        foodbank_1.getInventoryList().add(foodinv_11);
        FoodInventory foodinv_12 = new FoodInventory(food_2, 200);
        foodbank_1.getInventoryList().add(foodinv_12);
        FoodInventory foodinv_13 = new FoodInventory(food_3, 200);
        foodbank_1.getInventoryList().add(foodinv_13);
        
        Agent agent_1 = (Agent)foodbank_1.getEdir().addEnterprise("International Ministry Food Pantry", EnterpriseType.Agent);
        agent_1.setFoodBank(foodbank_1);
        FoodInventory foodinv_1 = new FoodInventory(food_1, 200);
        agent_1.getInventoryList().add(foodinv_1);
        FoodInventory foodinv_2 = new FoodInventory(food_2, 200);
        agent_1.getInventoryList().add(foodinv_2);
        FoodInventory foodinv_3 = new FoodInventory(food_3, 200);
        agent_1.getInventoryList().add(foodinv_3);
                
        Organization org_1 = agent_1.getOdir().addOrganiztion("Inventory Org", OrganizationType.Inventory);
        Person emp_1 = org_1.getPersonDirectory().addNewPerson("Inventory_Employee1");
        Account newInvAccount = business.getAccountDirectory().addAccount("inv1", "inv1", new InventoryRole(), emp_1);
        org_1.getAccountDirectory().addAccount(newInvAccount);
        
        Organization org_2 = agent_1.getOdir().addOrganiztion("Service Org", OrganizationType.Service);
        Person emp_2 = org_2.getPersonDirectory().addNewPerson("Service_Employee1");
        Account newSerAccount = business.getAccountDirectory().addAccount("serv1", "serv1", new ServiceRole(), emp_2);
        org_2.getAccountDirectory().addAccount(newSerAccount);
        
        Agent agent_2 = (Agent)foodbank_1.getEdir().addEnterprise("Elizabeth Peabody House Food Pantry", EnterpriseType.Agent);
        agent_2.setFoodBank(foodbank_1);
        
        Agent agent_3 = (Agent)foodbank_1.getEdir().addEnterprise("Catholic Charities Choice Pantry at Somerville", EnterpriseType.Agent);
        agent_3.setFoodBank(foodbank_1);
        
        Agent agent_4 = (Agent)foodbank_1.getEdir().addEnterprise("Food 4 All-Sha4cd", EnterpriseType.Agent);
        agent_4.setFoodBank(foodbank_1);
        
        Agent agent_5 = (Agent)foodbank_1.getEdir().addEnterprise("Hearty Meals for All", EnterpriseType.Agent);
        agent_5.setFoodBank(foodbank_1);
        
        FoodBank foodbank_2 = (FoodBank)ma_1.getGovernment().getEnterpriseDirectory().addEnterprise("The Food Bank of Western Massachusetts", EnterpriseType.FoodBank);
        foodbank_2.setFbtype(FoodBankType.Non_Profit);
        foodbank_2.setFbtype(FoodBankType.GovernmentAgency);
        FoodInventory foodinv_21 = new FoodInventory(food_1, 150);
        foodbank_2.getInventoryList().add(foodinv_21);
        FoodInventory foodinv_22 = new FoodInventory(food_2, 400);
        foodbank_2.getInventoryList().add(foodinv_22);
        FoodInventory foodinv_23 = new FoodInventory(food_3, 280);
        foodbank_2.getInventoryList().add(foodinv_23);
        
        FoodBank foodbank_3 = (FoodBank)ma_1.getGovernment().getEnterpriseDirectory().addEnterprise("Worcester County Food Bank", EnterpriseType.FoodBank);
        foodbank_3.setFbtype(FoodBankType.GovernmentAgency);
        foodbank_3.setFbtype(FoodBankType.GovernmentAgency);
        FoodInventory foodinv_31 = new FoodInventory(food_4, 800);
        foodbank_3.getInventoryList().add(foodinv_31);
        
        FoodBank foodbank_4 = (FoodBank)ma_1.getGovernment().getEnterpriseDirectory().addEnterprise("Merrimack Valley Food Bank", EnterpriseType.FoodBank);
        foodbank_4.setFbtype(FoodBankType.Non_Profit);
        //-----------------------------------------------------------------------
        Network in_1 = business.createAndAddNetwork(StateName.Indiana);
        in_1.getGovernment().getPlanlist().addPlan("Basic SNAP Benefits Indiana", 130, 200);
        
        Person employee = business.getPersonDirectory().addNewPerson("Sys");
        Account ua = business.getAccountDirectory().addAccount("sys", "sys", new SystemAdminRole(), employee);
        
        Person gov_rep = business.getPersonDirectory().addNewPerson("MA Government");
        Account maacc = business.getAccountDirectory().addAccount("ma", "ma", new GovernmentRole(), gov_rep);
        ma_1.getGovernment().getAccountDirectory().addAccount(maacc);
        ma_1.setStateAccount(maacc);
        Person gov_rep2 = business.getPersonDirectory().addNewPerson("IN Government");
        Account inacc = business.getAccountDirectory().addAccount("in", "in", new GovernmentRole(), gov_rep2);
        in_1.getGovernment().getAccountDirectory().addAccount(inacc);
        in_1.setStateAccount(inacc);
        
        //Bankma_1.getGovernment().getEnterpriseDirectory()
        
        //Person person_1 = business.getPersonDirectory().addNewPerson("Chance");
        BenefitPerson newperson = ma_1.getGovernment().addNewBenefitPerson("chance", "1111111111", StateName.Massachusetts);
        Account user_1 = business.getAccountDirectory().addAccount("ch", "ch", new UserRole(), newperson);
        user_1.setStatus(AccountStatus.Registered);
        return business;
    }
}
