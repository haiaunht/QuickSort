package assignment2_hai.au_bui_csd335;

import java.util.Random;

/**
 * @author HaiAu Bui
 * Assignment 2, CSD 335
 * Professor Abbott
 */
public class TestData {
    private static final int IncLimit = 7;  // biggest gap between any two ints
    private static Random rand;

    // return a value to be used as a search key
    public static int getNeedle(int max) {
        rand = new Random();
        return rand.nextInt(max);
    }

    // return an array of sorted ints, no duplicate values, and
    // random increments between any two elements in the array
    public static int[] sortedNonSequentialInts(int sz) {
        rand = new Random();
        int[] ary = new int[sz];
     
        ary[0] = rand.nextInt(IncLimit);
        for (int i = 1; i < sz; i++) {
            ary[i] = ary[i - 1] + rand.nextInt(IncLimit) + 1;
        }
        return ary;
    }
    
    // return an array of sorted in descending order, no duplicate values
    // random decrements between any two elements in the array
    public static int[] sortedDescending( int sz ){
        rand = new Random();
        int[] sortedDesc = new int[ sz ];
        
        sortedDesc[sz-1] = rand.nextInt( IncLimit );
        for( int i = sz - 2; i >= 0; i-- ){
            sortedDesc[i] = sortedDesc[i+1] + rand.nextInt(IncLimit) + 1;
        }
        
        return sortedDesc;
    }
    
    // return an array in nearly sorted in asceding order
    // random increments between any two elements in the array
    public static int[] nearlySortedASC ( int sz ){
        int[] nearlySortedASC = new int[ sz ];
        
        nearlySortedASC[0] = rand.nextInt(IncLimit);
        for (int i = 1; i < sz; i++) {
            nearlySortedASC[i] = nearlySortedASC[i - 1] + rand.nextInt(IncLimit) + 1;
            if( i == sz - 1 ){
                int swap = nearlySortedASC[ sz - 1];
                nearlySortedASC[ sz - 1] = nearlySortedASC[ sz - 2];
                nearlySortedASC[ sz - 2 ] = swap;
            }
        } 
        //generate a sortedASC then swap one or two element
        return nearlySortedASC;
    }

    // return an array of shuffled ints, no duplicate values
    public static int[] randomizedInts(int sz) {
        int[] intArray = sortedNonSequentialInts(sz);
        
        for (int i = intArray.length - 1; i > 1; i--) {
            int r = rand.nextInt(i - 1);
            int tmp = intArray[i];
            intArray[i] = intArray[r];
            intArray[r] = tmp;
        }
        return intArray;
    }
    
    
}
