import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static java.util.Arrays.*;

public class Algorithms {
    public static final int INT = 1_000;
    public static final String S = " mks";
    private Processes processes;
    public Algorithms(Processes processes){
        this.processes = processes;
    }

    public Processes getProcesses() {
        return processes;
    }

    private Integer[] copyArray(Integer[] array){
        int size  = array.length;
       Integer[] helpArray = new Integer[size];
       System.arraycopy(array, 0, helpArray, 0, size);
        return helpArray;
    }

    private void oneInsertsort(Integer [] array){
        for (int i=1; i<array.length; ++i) {
            int value = array[i],j,temp;
            for (j=i; (j>0 && value<(temp=array[j-1])); --j)
                array[j]=temp;

            array[j]=value;
        }
        //System.out.println(Arrays.toString(array));
    }
    public void insertionSort(){
        Integer[] array;

        long t1,t2,t;
        System.out.println("Algorytm InsertSort: ");

        array = copyArray(getProcesses().getRandomArray());
        t1 = System.nanoTime();
        oneInsertsort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane losowe: " + t + S);

        array = copyArray(getProcesses().getIncreasingArray());
        t1 = System.nanoTime();
        oneInsertsort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane rosnąco: " + t+ S);

        array = copyArray(getProcesses().getDecreasingArray());
        t1 = System.nanoTime();
        oneInsertsort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane malejąco: " + t + S + "\n");


    }

    private void swap(Integer [] tabl, int left, int right) {
        if (left!=right) {
            int temp = tabl[left];
            tabl[left] = tabl[right];
            tabl[right] = temp;
        }
    }
    private void oneBubbleSort(Integer [] array) {
        for (int i=1; i< array.length; ++i) {
            for (int left=0; left<(array.length-i); ++left)
            {
                int right = left+1;
                if (array[left]>array[right])
                    swap(array, left, right);
            }

        }
    }
    public void bubbleSort(){
        Integer[] array;
       long t1,t2,t;
        System.out.println("Algorytm BubbleSort: ");

        array = copyArray(getProcesses().getRandomArray());
        t1 = System.nanoTime();
        oneBubbleSort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane losowe: " + t + S);

        array = copyArray(getProcesses().getIncreasingArray());
        t1 = System.nanoTime();
        oneBubbleSort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane rosnąco: " + t+ S);

        array = copyArray(getProcesses().getDecreasingArray());
        t1 = System.nanoTime();
        oneBubbleSort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane malejąco: " + t + S + "\n");

    }

    private void oneSelectSort(Integer [] array) {
        int size = array.length;
        for (int current = 0; current < size-1; ++current ) {
            int min = current ;
            for (int check = current + 1; check<size; ++check) {
                if (array[check] < array[min])
                    min=check;
            }
            swap(array, min, current );
        }
    }
    public void selectionSort(){
        Integer[] array;
        long t1,t2,t;
        System.out.println("Algorytm SelectionSort: ");

        array = copyArray(getProcesses().getRandomArray());
        t1 = System.nanoTime();
        oneSelectSort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane losowe: " + t + S);

        array = copyArray(getProcesses().getIncreasingArray());
        t1 = System.nanoTime();
        oneSelectSort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane rosnąco: " + t+ S);

        array = copyArray(getProcesses().getDecreasingArray());
        t1 = System.nanoTime();
        oneSelectSort(array);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane malejąco: " + t + S + "\n");

    }

    private int partition(Integer [] array, int start, int end) {
        Random random = new Random();
        int rand = start+random.nextInt(end-start);
        swap(array, start, rand);
        int value = array[start];
        int indexBigger = start+1, indexLower = end-1;
        do {
            while(indexBigger <= indexLower && array[indexBigger] <= value)
                indexBigger++;
            while(array[indexLower] > value)
                indexLower--;
            if(indexBigger < indexLower)
                swap(array,indexBigger,indexLower);
        } while (indexBigger < indexLower);
        swap(array, indexLower, start);
        return indexLower;
    }

    private void oneQuickSort(Integer [] array, int start, int end) {
        if (end-start > 1) {
            int partition = partition(array, start, end);
            oneQuickSort(array, start, partition);
            oneQuickSort(array, partition+1, end);
        }
    }
    public void quickSort(){
        Integer[] array;
        long t1,t2,t;
        System.out.println("Algorytm QuickSort: ");
        array = copyArray(getProcesses().getRandomArray());
        int size = array.length;
        t1 = System.nanoTime();
        oneQuickSort(array,0,size);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane losowe: " + t + S);

        array = copyArray(getProcesses().getIncreasingArray());
        t1 = System.nanoTime();
        oneQuickSort(array,0,size);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane rosnąco: " + t+ S);

        array = copyArray(getProcesses().getDecreasingArray());
        t1 = System.nanoTime();
        oneQuickSort(array,0,size);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane malejąco: " + t + S + "\n");

    }
    private void sink(Integer [] heap, int index, int n) {
        int indexNajw = 2*index+1;
        if (indexNajw < n) {
            if (indexNajw+1 < n && heap[indexNajw] < heap[indexNajw+1])
                indexNajw++;
            if (heap[index] < heap[indexNajw]) {
                swap(heap, index, indexNajw);
                sink(heap, indexNajw, n);
            }
        }
    }

    private void heapAdjustment(Integer [] heap, int n) {
        for (int i=(n-1)/2; i>=0; i--)
            sink(heap, i, n);
    }
    private void oneHeapSort(Integer [] array, int n) {
        heapAdjustment(array, n);
        for (int i = n-1; i>0; i--) {
            swap(array, i, 0);
            sink(array, 0, i);
        }
    }
    public void heapSort(){
        Integer[] array;
        long t1,t2,t;
        System.out.println("Algorytm HeapSort: ");
        array = copyArray(getProcesses().getRandomArray());
        int size = array.length;
        t1 = System.nanoTime();
        oneHeapSort(array,size);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane losowe: " + t + S);

        array = copyArray(getProcesses().getIncreasingArray());
        t1 = System.nanoTime();
        oneHeapSort(array,size);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane rosnąco: " + t+ S);

        array = copyArray(getProcesses().getDecreasingArray());
        t1 = System.nanoTime();
        oneHeapSort(array,size);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane malejąco: " + t + S + "\n");

    }

    private void oneMergesort(Integer [] array, int l, int r) {
        if (l<r) {
            int m = (l+r)/2;
            oneMergesort(array, l, m);
            oneMergesort(array, m+1, r);
            merge(array, l, m, r);
        }

    }

    private void merge(Integer [] array, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        Integer [] left = new Integer[n1];
        Integer [] right = new Integer[n2];

        System.arraycopy(array, l, left, 0, n1);
        for (int j=0; j<n2; ++j)
            right[j] = array[m+1+j];

        int i=0, j=0;
        int k=l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
    public void mergeSort(){
        Integer[] array;
        long t1,t2,t;
        System.out.println("Algorytm MergeSort: ");
        array = copyArray(getProcesses().getRandomArray());
        int size = array.length;
        t1 = System.nanoTime();
        oneMergesort(array,0,size-1);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane losowe: " + t + S);

        array = copyArray(getProcesses().getIncreasingArray());
        t1 = System.nanoTime();
        oneMergesort(array,0,size-1);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane rosnąco: " + t+ S);

        array = copyArray(getProcesses().getDecreasingArray());
        t1 = System.nanoTime();
        oneMergesort(array,0,size-1);
        t2 = System.nanoTime();
        t = (t2-t1)/ INT;
        System.out.println("Dane posortowane malejąco: " + t + S + "\n");

    }

}
