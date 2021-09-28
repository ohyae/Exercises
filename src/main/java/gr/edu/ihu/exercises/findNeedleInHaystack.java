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
public class findNeedleInHaystack {
    
    public static int findNeedle(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return -1;
        
        
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j == haystack.length())
                    break;
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }        
        return -1;
    }
   
    public static void main (String[] args){
        
        String needle = "llo";
        String haystack ="hello";
        
        System.out.println(findNeedle(haystack,needle));
    }
    
}
