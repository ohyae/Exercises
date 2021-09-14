/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.edu.ihu.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author Hyae
 */
public class ZipfGeneratorTest
{
    public static void main(String[] args) {

        int size = 20;
        double skew = 3.5;
        int n = 500; 

        FastZipfGenerator z = new FastZipfGenerator(size, skew); 
        Map<Integer, Integer> counts = computeCounts(z, size, n);
        System.out.println(counts);
    }

    private static Map<Integer, Integer> computeCounts(
        FastZipfGenerator z, int size, int n)
    {
        Map<Integer, Integer> counts = new LinkedHashMap<Integer, Integer>();
        for (int i=1; i<=size; i++)
        {
            counts.put(i, 1);
        }
        for (int i=1; i<=n; i++)
        {
            int k = z.next();
            counts.put(k, counts.get(k)+1);
        }
        return counts;
    }
}

class FastZipfGenerator
{
    private Random random = new Random(0);
    private NavigableMap<Double, Integer> map;

    FastZipfGenerator(int size, double skew)
    {
        map = computeMap(size, skew);
    }

    private static NavigableMap<Double, Integer> computeMap(
        int size, double skew)
    {
        NavigableMap<Double, Integer> map = 
            new TreeMap<Double, Integer>();

        double div = 0;
        for (int i = 1; i <= size; i++)
        {
            div += (1 / Math.pow(i, skew));
        }

        double sum = 0;
        for(int i=1; i<=size; i++)
        {
            double p = (1.0d / Math.pow(i, skew)) / div;
            sum += p;
            map.put(sum,  i-1);
        }
        return map;
    }

    public int next()
    {
        double value = random.nextDouble();
        return map.ceilingEntry(value).getValue()+1;
    }

}