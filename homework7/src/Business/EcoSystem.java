/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Vaccine.Vaccine;
import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class EcoSystem extends Organization{
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private ArrayList<String> diseaseCatalog;
    private ArrayList<Vaccine> vaccineCatalog;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        diseaseCatalog = new ArrayList<>();
        vaccineCatalog = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public ArrayList<String> getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public void setDiseaseCatalog(ArrayList<String> diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }

    public ArrayList<Vaccine> getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(ArrayList<Vaccine> vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }



    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public String createAndAddDisease(String disease){
        diseaseCatalog.add(disease);
        return disease;
    }
    public Vaccine createAndAddVaccine(Vaccine vaccine){
        vaccineCatalog.add(vaccine);
        return vaccine;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

       

        return true;
    }
}
