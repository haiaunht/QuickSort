
package assignment2_hai.au_bui_csd335;

/**
 * @author HaiAu Bui
 * Assignment 2, CSD 335
 * Professor Abbott
 */
public class Assignment2_HaiAu_Bui_CSD335 {
    public static long nano_1;
    public static long nano_2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //----------------------------------------------------------------//
        //-------testing quicksort with sorted ASC array------------------//
        //----------------------------------------------------------------//
        int[] sortedASC = TestData.sortedNonSequentialInts( 1000000 );
        
        //output nano time before quicksort
        nano_1 = System.nanoTime();
        System.out.println("nanoTime before: " + nano_1 );
        QuickSortImplement.Quicksort( sortedASC, 0, sortedASC.length-1 );
        
        //output nano times after quicksort and the differences
        nano_2 = System.nanoTime();        
        System.out.println("nanoTime after:  " + nano_2 );
        System.out.println("Elapsed during the quick sort of the sorted ASC array: " + (nano_2 - nano_1));
        
        
        System.out.println();
        System.out.println("--------------");
        System.out.println();
        
        
        //----------------------------------------------------------------//
        //--------testing quicksort with sorted DESC array ---------------//
        //----------------------------------------------------------------//
        int[] sortedDESC = TestData.sortedDescending( 1000000 );
         
        //output the nanotime before quicksort
        nano_1 = System.nanoTime();
        System.out.println("nanoTime before: " + nano_1 );        
        //calling QuickSort from QuickSortImplement class to sorted the array
        QuickSortImplement.Quicksort( sortedDESC, 0, sortedDESC.length-1 );
             
        //output nano times after quicksort and the differences
        nano_2 = System.nanoTime();
        System.out.println("nanoTime after:  " + nano_2 );
        System.out.println("Elapsed during the quick sort of the sorted DESC array: " + (nano_2 - nano_1));
        
        
        
        System.out.println();
        System.out.println("--------------");
        System.out.println();
        
        //----------------------------------------------------------------//
        //---------testing quicksort with nearly sorted ASC array---------//
        //----------------------------------------------------------------//
        int[] nearlySorted = TestData.nearlySortedASC( 1000000 );
        
        //output nano time before quicksort
        nano_1 = System.nanoTime();
        System.out.println("nanoTime before: " + nano_1 );        
        //calling QuickSort from QuickSortImplement class to sorted the array
        QuickSortImplement.Quicksort( nearlySorted, 0, nearlySorted.length-1 );
        
        //output nano time after quicksort
        nano_2 = System.nanoTime();
        System.out.println("nanoTime after:  " + nano_2 );
        System.out.println("Elapsed during the quick sort of the nearly sorted ASC array: " + (nano_2 - nano_1));
        
        
        System.out.println();
        System.out.println("--------------");
        System.out.println();
        
        
        //----------------------------------------------------------------//
        //----------testing quicksort with random array ------------------//
        //----------------------------------------------------------------//
        int[] random = TestData.randomizedInts( 1000000  );
        
        //output nano time before quicksort
        nano_1 = System.nanoTime();
        System.out.println("nanoTime before: " + nano_1 );        
        //calling QuickSort from QuickSortImplement class to sorted the array
        QuickSortImplement.Quicksort( random, 0, random.length-1 );
        
        //output nano time after quicksort
        nano_2 = System.nanoTime();
        System.out.println("nanoTime after:  " + nano_2 );
        System.out.println("Elapsed during the quick sort of the random array: " + (nano_2 - nano_1));
        
    }
    
}
