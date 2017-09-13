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
public class FinancialAccount extends Account{
    private String bank;
    private String billAdd;
    private String billTel;
    private String number;
    private String fee;
    private Account saving;
    private Account checking;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBillAdd() {
        return billAdd;
    }

    public void setBillAdd(String billAdd) {
        this.billAdd = billAdd;
    }

    public String getBillTel() {
        return billTel;
    }

    public void setBillTel(String billTel) {
        this.billTel = billTel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Account getSaving() {
        return saving;
    }

    public void setSaving(Account saving) {
        this.saving = saving;
    }

    public Account getChecking() {
        return checking;
    }

    public void setChecking(Account checking) {
        this.checking = checking;
    }
}
