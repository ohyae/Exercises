package gr.edu.ihu.exercises;

import java.util.Scanner;

/**
 *
 * @author Phyae
 */
public class problemA {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); //the number of cases           
        
        for (int i = 0; i < n; i++){
            
            // the limit for the inputs are still within the maximum value of an "int" (which is 2^31−1)
            int r = sc.nextInt(); // expected revenue if you do not advertise
            int e = sc.nextInt(); // expected revenue if you do advertise
            int c = sc.nextInt(); //cost of advertising  
            
            int nr = e - c; //net revenue when using advertisements                        

            if (nr > r){
                System.out.println("advertise");            
            } else if (nr < r) {
                System.out.println("do not advertise");            
            } else {
                System.out.println("does not matter");
            }            
        }
        
    }    
}