/*Given are two one dimensional array A and B which are sorted in ascending 
order. Develop an application to merge them into a single sorted array C that 
contains every item form A and B, in ascending order */

public class MergeSortedArray {
    public static void main(String args[]){
        // you can either input the array or rather initalise the way done below
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 10};

        int[] C = merge(A, B);

        // display the merged Array.class
        System.out.println("Merge sorted array is,");
        for(int num: C){
            System.out.print(num + " ");
        }   
    }
    public static int[] merge(int[] A, int[] B){
        int lengthA = A.length;
        int lengthB = B.length;
        // create new array of size contributed from both.
        int[] C = new int[lengthA + lengthB];

        // create iterators
        int i, j, k;
        i = j = k = 0;

        // start merging arrays 
        while(i < lengthA && j < lengthB){
            if(A[i] < B[j]){
                C[k++] = A[i++];
            }else C[k++] = B[j++];
        }

        // copy remaining elements to the arrays.
        // either only one array can be non-empty.
        while(i < lengthA) C[k++] = A[i++];
        while(j < lengthB) C[k++] = B[j++];
        return C;
    }   
}
