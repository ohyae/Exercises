/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.edu.ihu.exercises;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Hyae
 */
public class TenKindsOfPeople {
    
    private static final int[][] DIRECTIONS = { {0,-1}, {1,0}, {0,1}, {-1,0} };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] map = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            map[r] = sc.next().toCharArray();
        }

        int[][] groupedMap = groupMap(map);
        int n = sc.nextInt();
        for (int i = 0 ; i < n; i++) {
            Coordinate from = new Coordinate( sc.nextInt() - 1, sc.nextInt() - 1 );
            Coordinate to   = new Coordinate( sc.nextInt() - 1, sc.nextInt() - 1 );

            if (groupedMap[from.r][from.c] == groupedMap[to.r][to.c] ) {
                System.out.println( map[from.r][from.c] == '0' ? "binary" : "decimal" );
            } else {
                System.out.println("neither");
            }
        }
        sc.close();
    }

    public static int[][] groupMap(char[][] map) {
        int[][] grouped = new int[map.length][map[0].length];

        ArrayDeque<Coordinate> q = new ArrayDeque<>();
        char currentType = '0';
        int currentGroup = 2;

        for (int r = 0 ; r < map.length; r++) {
            for (int c = 0 ; c < map[0].length; c++) {
                if (grouped[r][c] > 1) {
                    continue;
                }
                currentType = map[r][c];
                grouped[r][c] = currentGroup;
                q.add(new Coordinate(r, c));
                while(!q.isEmpty()) {
                    Coordinate curr = q.poll();

                    for (int i = 0 ; i < DIRECTIONS.length; i++) {
                        int newCoordR = curr.r + DIRECTIONS[i][0];
                        int newCoordC = curr.c + DIRECTIONS[i][1];

                        if (newCoordR >= 0 && newCoordR < map.length && newCoordC >= 0 && newCoordC < map[0].length) {
                            if (grouped[newCoordR][newCoordC] < 2 && map[newCoordR][newCoordC] == currentType) {
                                grouped[newCoordR][newCoordC] = currentGroup;
                                q.add(new Coordinate(newCoordR, newCoordC));
                            }
                        }
                    }
                }
                currentGroup++;
            }
        }

        return grouped;
    }


    public static class Coordinate {
        int r, c;

        Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Coordinate ){
                Coordinate coord = (Coordinate) o;
                if (coord.r == this.r && coord.c == this.c) {
                    return true;
                }
            }
            return false;
        }
    }

}
