/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
//This class contains methods concerned in treats integrity of input datas

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Thiago
 */
public class DataIntegraty {
    
    public static boolean is_number(String variavel){
        try {                        
            
            Integer.parseInt(variavel);                    
        } catch (Exception e) {
            
            return false;
        }
        
        return true;
    }
    
    public static boolean is_text(String variavel){
        
        if (variavel==null || variavel.trim().equals(""))            
            return false;
        
        else
            return true;               
        
    }    

    public static boolean is_date(String variavel){
        
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd");
            Calendar datatemp = Calendar.getInstance();
            datatemp.setTime(formatoData.parse(variavel));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Calendar StringtoDate(String variavel){

        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd");
        Calendar datatemp = Calendar.getInstance();
        try {
                
                datatemp.setTime(formatoData.parse(variavel));            
        } catch (Exception e) {
        }
            
        return datatemp;        
        
    }
    
    

    
}
