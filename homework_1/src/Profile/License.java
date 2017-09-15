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
public class License {
    private int number;
    private String sex;
    private String type;
    private String expDate;
    private String state;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getNumberString(){
        return Integer.toString(this.number);
    }
    
    public void setNumber(String number){
       if (!"".equals(number)){
       this.number = Integer.parseInt(number);}
        else this.number = 0;
    } 

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
