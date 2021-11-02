package gr.edu.ihu.exercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Ohyae
 */
public class problemB {
    
    public static void main(String[] args) {
        // reads the input and stores the words (key) and their corresponsponding values in a map
        Scanner sc = new Scanner(System.in);
        //BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> defMap = new HashMap<>(); 
                
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().trim().split(" ");
            String command = line[0];
            
            //assigns a value to a word - defMap(key,value)
            if (command.equals("def")) {
                defMap.put(line[1], Integer.parseInt(line[2])); 
            
            //calculates the result
            } else if (command.equals("calc")) {
                
                //prints the given problem/equation
                for (int x = 1; x < line.length; x++) {
                    System.out.print(line[x] + " ");
                }                 

                //checks if every word has a corresponding value                
                boolean known = true;
                for (int x = 1; x < line.length; x += 2) {
                    //prints "unknown" if there is no value defined for a variable
                    if (!defMap.containsKey(line[x])) {
                        known = false;                        
                        break;
                    } 
                }
                
                //if a word has no defined value, return unknown
                if (!known){
                    System.out.println("unknown");
                } else {
                    
                    //calculates the total
                    int total = defMap.get(line[1]);
                    for (int op = 2; op < line.length - 1; op += 2) { //finds the operator
                        if (line[op].equals("+")) {
                            total += defMap.get(line[op + 1]);
                        } else {
                            total -= defMap.get(line[op + 1]);
                        }                    
                    }                     
                    //retrieve the word (key) for the total value
                    if(defMap.containsValue(total)){
                        System.out.println(getKeyByVal(defMap, total));
                    } else {
                        System.out.println("unknown");
                    }                 
                    
                }                
                
            //clears the definitions stored    
            } else {
                defMap.clear();
                break;
            }
             
        }
        sc.close();
    }
    
    //Returns the word (key) given a value
    public static <String, Integer> String getKeyByVal(Map<String, Integer> map, Integer value) {
        for (Map.Entry<String, Integer> word : map.entrySet()){
            if (word.getValue().equals(value)) {
                return (word.getKey());                            
            } 
        } 
        return null;
    }

}