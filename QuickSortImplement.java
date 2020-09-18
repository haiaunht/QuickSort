package assignment2_hai.au_bui_csd335;

/**
 * @author HaiAu Bui 
 * Assignment 2 - CSD 335
 * Professor Abbott
 */
public class QuickSortImplement {

    /*
    * Partition method return the highest index of the low partition
    * @param i,k: integer use to index first and last of the array
    * @return: integer highest index of the low partition
    */
    public static int Partition(int[] numbers, int i, int k) {
        int low, high, midpoint, pivot, temp;
        boolean done = false;

        // use median of the first, last, and center elements as the pivot
        midpoint = i + (k - i) / 2;

        // compare the first elemnet numbers[i], last element numbers[k] and center element numbers[midpoint]
        // to find which element is the pivot using Median-of-Three
        int first = numbers[i];
        int last = numbers[k];
        int center = numbers[midpoint];

        //if the first < center < last or last < center < first -> center is pivot
        if ((first < center && center < last) || (last < center && center < first)) {
            pivot = center;
        } 
        // if center < first < last or last < first < center -> first is pivot
        else if ((center < first && first < last) || (last < first && first < center)) {
            pivot = first;  
        }
        // if not all the above, last element is the pivot
        else {
            pivot = last;
        }

        //assign low = i and high = k
        low = i;
        high = k;

        while (!done) {

            // Increment l while numbers[l] < pivot
            while (numbers[low] < pivot) {
                ++low;
            }

            // Decrement h while pivot < numbers[h]
            while (pivot < numbers[high]) {
                --high;
            }

            // If there are zero or one elements remaining,
            // all numbers are partitioned. Return h
            if (low >= high) {
                done = true;
            } else {
                // Swap numbers[l] and numbers[h],
                // update l and h
                temp = numbers[low];
                numbers[low] = numbers[high];
                numbers[high] = temp;
                ++low;
                --high;
            }
        }
        //when low >= high, return high
        return high;
    }

    /*
    * Quicksort method will sort the array in ascending order by calling recursively 
    * Partition methods of half left and haft right
    * @param number: array to get sorted
    * @ i,k: integer start at 0
     */
    public static void Quicksort(int[] numbers, int low, int high) {

        //last element in low partition
        int lastElementLowPartition;

        //base case, if low pass high, the partition is already sorted
        if (low >= high) {
            return;
        }

        // if the subarray is less than or equal to 20 elements, do selection sort
        if (high - low <= 20) {
            SelectionSort(numbers, low, high + 1);
        } 
        //if the subarray is larger than 20 do a quicksort
        else {
            lastElementLowPartition = Partition(numbers, low, high);

            //recursively sort low and high partition
            Quicksort(numbers, low, lastElementLowPartition);
            Quicksort(numbers, lastElementLowPartition + 1, high);
        }
    }

    /*
    * SelectionSort method will sort the array in ascending order
    * @param numbers: an array to get sorted    
    * @param start: integer begining index of array numbers
    * @param end: integer end index of array numbers
     */
    private static void SelectionSort(int[] numbers, int start, int end) {
        for (int i = start; i < end; i++) {
            //find index of smallest remaining element
            int indexSmallest = i;

            for (int j = i + 1; j < end; j++) {
                if (numbers[j] < numbers[indexSmallest]) {
                    indexSmallest = j;
                }
            }

            //swap numbers[i] and number[indexSmalles]
            int temp = numbers[i];
            numbers[i] = numbers[indexSmallest];
            numbers[indexSmallest] = temp;
        }
    }

}
