/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author zhaoxiaohan
 */
public class Utl {
    
    public Date getStringtoDate(String dateString, String errorMsg)
    {
        Date dateTime = new Date();
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try{
            dateTime = d1.parse(dateString);
        }
        catch (ParseException e) { 
            e.getMessage();
            JOptionPane.showMessageDialog(null, errorMsg);
        }
        return dateTime;
    }
    public int getStringtoInt(String str, String errorMsg)
    {
       int number = 0;
       try{
           number = Integer.parseInt(str);
       }
       catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, errorMsg);
       }
       return number;
    }
}
