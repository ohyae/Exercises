/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.edu.ihu.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 *
 * @author Hyae
 */
public class problemC {
    
    //defines east, west, north, south movements
    private static int[] dx = {1 , -1 , 0 , 0};
    private static int[] dy = {0 , 0 , 1 , -1};
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //first line gives the total number of rows and columns
        //input bounds of rows and cols are within the maximum val of "int"
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        //next sequence reads the contents of the map
        char[][] map = new char[rows][cols];
        for (int i = 0; i < rows; i++){
            map[i] = sc.next().toCharArray();            
        }
                
        //gives the value in the map given the coordinate points
        int[][] zone = new int[map.length][map[0].length]; 
        int pool = 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zone[i][j] == 0) {
                    bfs(new Coordinate(i , j), map, zone, pool);
                    pool++;
                }        
            }
        }
        
        //number of queries (sets of locations)
        int n = sc.nextInt();
        
        //reads the starting and ending coordinates
        for (int i = 0; i < n; i++){
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;
            
            //if user can start from r1,c1 and move to r2,c2, and
            //if the value in the coordinates are equal, print user group
            //binary can only stay in points mark with 0
            //decimal can only stay in points mark with 1
            if (zone[r1][c1] == zone[r2][c2]){
                System.out.println(map[r1][c1] == '0' ? "binary" : "decimal");
            } else {
                System.out.println("neither");            
            }                    
        }
        sc.close();
    }
    
    //Breadth First Search Traversal Algorithm
    public static void bfs(Coordinate start, char[][] map, int[][] zone, int pool) {

    ArrayDeque<Coordinate> q = new ArrayDeque<>(); //initialize deque holding the data
    q.offer(start); //inserts starting coordinates to the deque
    zone[start.r][start.c] = pool;

        while (!q.isEmpty()){
            Coordinate curr = q.poll(); //returns and removes the coordinates at the head of the queue
            //defines reference points
            int r1 = curr.r; 
            int c1 = curr.c; 

            for (int i = 0; i < 4; i++){ 
                //defines next destination/lookup points
                int r2 = r1 + dx[i];
                int c2 = c1 + dy[i];

                //if next points is within the bounds of the map, and
                //if group type is the same, add to the dequeu
                if (r2 >= 0 && r2 < map.length && c2 >= 0 && c2 < map[0].length){
                    if (map[r2][c2] == map[r1][c1] && zone[r2][c2] < 2){
                        zone[r2][c2] = pool;
                        q.offer(new Coordinate(r2, c2)); //inserts the coordinates to the deque
                    }                 
                }
            }    
        }
    }

    
}

class Coordinate {
    int r, c;

    Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        Coordinate temp = (Coordinate) o;
        return ((r == temp.r) && (c == temp.c));
    } 
}
