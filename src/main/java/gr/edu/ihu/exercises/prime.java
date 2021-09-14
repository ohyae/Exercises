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
public class prime {
    
    int i, j, flag;
    
    public void findPrime(int N){
        // Traverse each number from 1 to N
        // with the help of for loop
        for (i = 2; i <= N; i++)
        {            
            // flag variable to tell
            // if i is prime or not
            flag = 1;

            for (j = 2; j <= i-1; j++)
            {
                if (i % j == 0)
                {
                    flag = 0;
                    break;
                }
            }

            // flag = 1 means i is prime
            // and flag = 0 means i is not prime
            if (flag == 1)
                System.out.print(i + " ");
        }
    }
    
    public static void main (String[] args) {
        
        prime p = new prime();
        p.findPrime(20);        
        
    }
}
