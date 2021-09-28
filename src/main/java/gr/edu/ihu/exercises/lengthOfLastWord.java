/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.edu.ihu.exercises;

/**
 *
 * @author Ohyae
 */
public class lengthOfLastWord {
    
    public static int findLength(String str){
        
        String[] strArr = str.trim().split("\\s+");
        String lastStr = strArr[strArr.length - 1];  
        return lastStr.length();
    }
    
    public static void main (String[] args){
        
        String str = "Hello World";
        System.out.println("The length of the last word: " + findLength(str));
    }
    
}
