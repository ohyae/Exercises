package gr.edu.ihu.exercises;

import java.util.Random;

/**
 *
 * @author Ohyae
 */
public class RomanToNum {
    
    public int getNum(char r) {
        
        if (r == 'I'){
            return 1;
        }
        if (r == 'V'){
            return 5;
        }
        if (r == 'X'){
            return 10;
        }
        if (r == 'L'){
            return 50;
        }
        if (r == 'C'){
            return 100;
        }
        if (r == 'D'){
            return 500;
        }
        if (r == 'M'){
            return 1000;
        }
        return -1;
    }
    
    public int romToNum(String str){
        int res = 0;
        int i, s1, s2;
        
        for(i = 0; i < str.length(); i++){
            
            s1 = getNum(str.charAt(i));
            
            if(i + 1 < str.length()){
                
                s2 = getNum(str.charAt(i+1));
                
                if (s1>=s2) {
                    res = res + s1;              
  
                } else {
                    res = res + s2 - s1;
                    i++;
                }
                
            } else {
                
                res = res + s1;
                
            }
        
        }
        return res;
    }
    
    /*
    public int toRandom(){
        int index = -1;
        String[] input = new String[10];        
        Random r = new Random();
        for (int j=0; j<input.length; j++) {
            input[j] = "a" + (r.nextInt(1000));
            System.out.println(input[j] + "\n");            
        }
        return index;
    }*/
    
    public static void main(String[] args) {
        
        RomanToNum rm = new RomanToNum();
        String str = "CDLIX";
        System.out.println("Integer for " + str + " : " + rm.romToNum(str));       
        
    }
    

    
}
