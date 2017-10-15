/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SystemAdministration;

import Utils.HashUtil;
import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public UserAccount newUserAccount() {
        UserAccount ua = new UserAccount();
        userAccountList.add(ua);
        return ua;
    }
    
    public void removeUserAccount(UserAccount ua) {
        userAccountList.remove(ua);
    }
    
    public UserAccount searchUserAccount(String userName) {
        for(UserAccount ua : userAccountList) {
            if(ua.getUserName().equals(userName)) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount isValidUser(String username, String pwd){
        /*This method will take a user name and password and determine if the user
        exists in the directory database. If found it returns the user account if 
        not it returns null*/
        //For each useraccount in the user directory do the following step
        //If (useraccount id matches userid and useraccount password matches pwd) then return the useraccount object
        //Otherwise continue until no more to check
        //Return null if not found
        for(UserAccount ua : userAccountList){
            if(ua.getUserName().equals(username)&&(ua.getPwd().equals(HashUtil.hash(pwd, "SHA1")))){
                return ua;
            }
        }
        return null;
    }
    
}
