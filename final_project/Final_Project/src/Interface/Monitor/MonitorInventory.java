/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Monitor;

import Business.Account.Account;
import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Enterprise.FoodBank;
import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Network.Network;
import Business.Order.Order;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Person.BenefitPerson;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Chance
 */
public class MonitorInventory extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private Account account;
    private InventoryOrganization organization;
    private Network network;
    public MonitorInventory(JPanel userProcessContainer, Account account, Organization organization, Network network, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.network = network;
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Enterprise enterp: network.getGovernment().getEnterpriseDirectory().getEnterpriseDirectory()) {
            if(enterp.getType() == EnterpriseType.FoodBank) {
                FoodBank fb = (FoodBank)enterp;
                for(FoodInventory foodinv : fb.getInventoryList()) {
                    final String foodbankName = fb.getName();
                    dataset.addValue(foodinv.getQuantity(), foodinv.getFood().getName(), foodbankName);
                }
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
            "FoodBank Inventory Monitor",           
            "FoodBank",            
            "Inventory",            
            dataset,          
            PlotOrientation.VERTICAL,           
            true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart, false);
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
