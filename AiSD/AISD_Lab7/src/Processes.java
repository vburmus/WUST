import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static java.util.Arrays.sort;

public class Processes {
    private Integer [] decreasingArray;
    private Integer [] increasingArray;
    private Integer [] randomArray;

    public Processes(int n)
    {
        this.randomArray = new Integer[n];
        this.increasingArray = new Integer[n];
        this.decreasingArray = new Integer[n];

        for (int i = 0; i < n; i++)
        {
            Random generator = new Random();
            int el = generator.nextInt(n);
            increasingArray[i] = el;
            decreasingArray[i] = el;
            randomArray[i] = el;
        }
        sort(increasingArray);
        sort(decreasingArray, Collections.reverseOrder());
    }

    public void showProcesses()
    {
        System.out.println("Ciąg losowy: " + Arrays.toString(randomArray));
        System.out.println("Ciąg posortowany rosnąco: " + Arrays.toString(increasingArray));
        System.out.println("Ciąg posortowany malejąco: " + Arrays.toString(decreasingArray));
    }

    public Integer[] getDecreasingArray() {
        return decreasingArray;
    }

    public Integer[] getIncreasingArray() {
        return increasingArray;
    }

    public Integer[] getRandomArray() {
        return randomArray;
    }

    public void setDecreasingArray(Integer[] decreasingArray) {
        this.decreasingArray = decreasingArray;
    }

    public void setIncreasingArray(Integer[] increasingArray) {
        this.increasingArray = increasingArray;
    }

    public void setRandomArray(Integer[] randomArray) {
        this.randomArray = randomArray;
    }
}
