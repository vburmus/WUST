package Task1;

import static Task1.BucketSort.bucketSort;

public class Main {

    public static void main(String args[])
    {
        int arr[] = {23,31, 64, 16, 89, 70, 41, 79, 15, 66, 99, 89, 14, 48, 68, 24, 98, 50, 70, 10, 59, 40};
        bucketSort(arr, 4,100);

        System.out.println("Sorted array is " );
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }}
