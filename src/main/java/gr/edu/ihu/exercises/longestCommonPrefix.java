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
public class longestCommonPrefix {    
        
    private static int i,j,k;
    
    public static String getMinStr(String[] strs){
        
        String minStr = strs[0];
        for(i=1; i<strs.length; i++) {
            if(strs[i].length()<minStr.length()){
                minStr = strs[i];
            }            
        }
        return minStr; 
    }
    
    public static String findPrefix(String[] strs){
        
        String minStr = getMinStr(strs);
        int minStrLength = minStr.length();
        
        if (strs.length==0){
            return "";
        }
        
        for(j=0; j<strs.length;j++){
            for(k=0;k<minStrLength;k++){
                if(minStr.charAt(k)!=strs[j].charAt(k)){
                    break;
                }
            }
        }
        
        if(k<minStrLength){
            minStrLength = k;
        }
        
        return minStr.substring(0, minStrLength);
    }
    
    public static void main (String[] args){
        
        String[] strs = {"occult","occupy","occupation","occupancy"};
        String[] strs2 = {"the","quick","brown","fox"};
        
        System.out.println("The longest common prefix for the strings is: " + findPrefix(strs));
        System.out.println("The longest common prefix for the strings is: " + findPrefix(strs2));
    }
    
}
