/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.edu.ihu.exercises;

/**
 *
 * @author Hyae
 */
public class reverseInteger {
    
   
    public static int reverse(int n) {
        
        int reverse = 0;
        int remainder;
        
        while (n>0){
            remainder = n%10;
            reverse = reverse*10 + remainder;
            n = n/10;  
        }
        return reverse;        
    }
    
    public static void main (String[] args) {
        
        int n = 12345;
        System.out.println("The reverse of " + n + ":" + reverse(n));
        
    }
    
}
