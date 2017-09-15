/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

/**
 *
 * @author zhaoxiaohan
 */
public class CreditCard {
    private int number;
    private String billTel;
    private String creDate;
    private String expDate;
    private String cvv;

    public int getNumber() {
        return number;
    }

    public String getNumberString() {
        return Integer.toString(this.number);
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public void setNumber(String number){
       if (!"".equals(number)){
       this.number = Integer.parseInt(number);}
        else this.number = 0;
    } 

    public String getBillTel() {
        return billTel;
    }

    public void setBillTel(String billTel) {
        this.billTel = billTel;
    }

    public String getCreDate() {
        return creDate;
    }

    public void setCreDate(String creDate) {
        this.creDate = creDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
