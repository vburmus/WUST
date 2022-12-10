package Task1;
import java.util.*;
import java.util.Collections;

public class BucketSort {

        static void bucketSort(int arr[], int n, int x )
        {
            if (n <= 0)
                return;

            ArrayList<Integer>[] buckets = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                buckets[i] = new ArrayList<>();
            }


            for (int i = 0; i < arr.length; i++) {
                int idx = arr[i]*n  / x ;
                buckets[idx].add(arr[i]);
            }

            for(int i = 0,index = 0; i < n; i++,index++){
                if(buckets[i].size()!=0)
                System.out.println(buckets[i]);
            }
            //
            for (int i = 0; i < n; i++) {
                Collections.sort(buckets[i]);
            }
            //
            System.out.println("_______________________________________________________");
            for(int i = 0,index = 0; i < n; i++,index++){
                if(buckets[i].size()!=0)
                    System.out.println(buckets[i]);
            }
            System.out.println("_______________________________________________________");
            for (int i = 0,index = 0; i < n; i++) {
                for (int j = 0; j < buckets[i].size(); j++,index++) {
                    arr[index] = buckets[i].get(j);
                }
            }

        }



    }




