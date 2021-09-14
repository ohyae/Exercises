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
public class isTwoSum {
    
    private static int i,j;
    
    public static int[] isTwoSum(int[] nums, int target){
        for(i = 0; i < nums.length; i++){
            for(j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    System.out.println(nums[i] + "," + nums[j]);
                }
            }
        }
        return null;
    } 
    
    public static void main(String[] args){
        int[] nums = {2,3,5,6,8};
        int target = 8;

        isTwoSum(nums, target);        
        
    } 
    
}
