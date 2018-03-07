/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Monitor;

import Business.Account.Account;
import Business.Business;
import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Network.Network;
import Business.Order.Order;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Person.BenefitPerson;
import Business.Plan.Plan;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Chance
 */
public class MonitorBenefit extends javax.swing.JPanel {

    /**
     * Creates new form MonitorBenefit
     */
    private JPanel userProcessContainer;
    private Business business;
    private Account account;
    private InventoryOrganization organization;
    private Network network;
    public MonitorBenefit(JPanel userProcessContainer, Account account, Organization organization, Network network, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.network = network;
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Food food: this.business.getFoodCatalog()) {
            int count = 0;
            final String name = food.getName();
            for (Account ac : network.getGovernment().getAccountDirectory().getAccountCatalog()) {
                if (ac.getPerson() instanceof BenefitPerson) {
                    if (ac.getStatus() == Account.AccountStatus.Approved || ac.getStatus() == Account.AccountStatus.Activate) {
                        BenefitPerson bp = (BenefitPerson) ac.getPerson();
                        for(Order order: bp.getOrderDirectory().getOrderDirectory()) {
                            for(FoodInventory foodinv: order.getOffer()) {
                                if(foodinv.getFood() == food) {
                                    count += foodinv.getQuantity();
                                }
                            }
                        }
                    }
                }
            }
            dataset.setValue(name, new Double(count));
        }
        JFreeChart chart = ChartFactory.createPieChart(      
            "Benefit foods Monitor",  // chart title 
            dataset,        // data    
            true,           // include legend   
            true, 
            false);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        this.add("chartPanel", chartPanel);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}