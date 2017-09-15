/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

import java.io.File;

/**
 *
 * @author zhaoxiaohan
 */
public class Person {
    private String firstName;
    private String lastName;
    private String dateBirth;
    private int ssn;
    private String tel;
    private String photo;
    public Address address;
    public License license;
    public CreditCard creditCard;
    public FinancialAccount financialAccount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getSsn() {
        return ssn;
    }
    public String getSsnString() {
        return Integer.toString(this.ssn);
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    public void setSsn(String ssn){
        if (!"".equals(ssn)){
        this.ssn = Integer.parseInt(ssn);}
        else this.ssn = 0;
    } 

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public FinancialAccount getFinancialAccount() {
        return financialAccount;
    }

    public void setFinancialAccount(FinancialAccount financialAccount) {
        this.financialAccount = financialAccount;
    }
}
