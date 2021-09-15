package gr.edu.ihu.exercises;

import java.util.Scanner;

/**
 *
 * @author Ohyae
 */
public class isPalindrome {
    
    public static boolean isPalindrome(String str)  
   { 
            // Pointers pointing to the beginning
            // and the end of the string
            int i = 0, j = str.length() - 1;

            // While there are characters to compare
            while (i < j) {

                // If there is a mismatch
                if (str.charAt(i) != str.charAt(j))
                    return false;
                    
                // Increment first pointer and
                // decrement the other
                i++;
                j--;
            }                  
            return true;
   }
    
    public static void main(String[] args)
    {
        String [] strlist = {"abba", "java", "poop", "lol"};        
        
 
        for (String str: strlist) {                       
            if (isPalindrome(str) == true){
                System.out.print(str + " : " + "Yes" + "\n");
            } else {
                System.out.print(str + " : " + "No" + "\n");  
            }
        }
     }          
      
}