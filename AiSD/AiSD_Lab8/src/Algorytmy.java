import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Algorytmy {

    private int [] los ;

    public Algorytmy(int n) {
        this.los = new int[n];

        for (int i=0; i<los.length; i++) {
            Random gen = new Random();
            int el = gen.nextInt(n+1);
            los[i] = el;
        }
    }

    private int [] copy(int [] array) {
        int [] pom = new int[array.length];
        System.arraycopy(array, 0, pom, 0, array.length);
        return pom;
    }
    public void wyswietl(int n){

        System.out.println(Arrays.toString(aCiag(n)));
        System.out.println(Arrays.toString(bCiag(n)));
        System.out.println(Arrays.toString(cCiag(n)));
        System.out.println(Arrays.toString(dCiag(n)));

    }
    private void bubblesort(int [] tabl) {
        int size = tabl.length;
        for (int i = 0; i < size-1; i++)
        {
            for (int j = 0; j < size-i-1; j++)
            {
                if (tabl[j] > tabl[j+1])
                    swap(tabl, j+1, j);
            }
        }
    }
    private void swap(int [] tabl, int left, int right) {
        int temp = tabl[left];
        tabl[left] = tabl[right];
        tabl[right] = temp;
    }
    private void insertsort(int [] array) {
        for (int i = 1; i < array.length; ++i) {
            int value = array[i];
            int j;
            int temp;
            for (j = i; (j>0 && value<(temp=array[j-1])); --j) {
                array[j] = temp;
            }
            array[j] = value;
        }
    }

    public Integer [] aCiag(int n) {
        ArrayList<Integer> distances = new ArrayList<>();
        int h = 0;
        while (3*h+1 <= n) {
            h=3*h+1;
            distances.add(h);
        }
       // System.out.println(distances);
        return distances.toArray(new Integer[distances.size()]);
    }
    public Integer [] bCiag(int n) {
        ArrayList<Integer> distances = new ArrayList<>();
        int k = 0;
        for (int i = 1; k<=n; i++) {
            k = (int)Math.pow(2, i)-1;
            if (k <= n)
                distances.add(k);
        }
       // System.out.println(distances);
        return distances.toArray(new Integer[distances.size()]);
    }
    public Integer [] cCiag(int n) {
        ArrayList<Integer> distances = new ArrayList<>();
        int k = 0;

        distances.add(1);
        for (int i = 1; k <= n; i++) {
            k = (int)Math.pow(2, i)+1;
            if (k <= n)
                distances.add(k);
        }
       // System.out.println(distances);
        return distances.toArray(new Integer[distances.size()]);
    }
    public Integer [] dCiag(int n) {
        ArrayList<Integer> distances = new ArrayList<>();
        int h = 1;
        int ppn, pn = 0;
        distances.add(pn);
        for (int i = 1; h <= n; i++) {
                distances.add(h);
            ppn = pn;
            pn = h;
            h = ppn + pn;

        }
       // System.out.println(distances);
        return distances.toArray(new Integer[distances.size()]);
    }


    private void shellsort1(int [] array, Integer[] distances) {
        int n = array.length;
        int iteration = 1;
        int actDistance = distances[distances.length - iteration];
        int comp, cur;

        while (actDistance >= 1) {
            for (int i = actDistance; i < n; i++) {
                cur = array[i];
                comp = i;
                while (comp >= actDistance && cur < array[comp - actDistance]) {

                    array[comp] = array[comp - actDistance];
                    comp -= actDistance;


                    array[comp] = cur;
                }
            }
    if(++iteration <= distances.length)
            actDistance = distances[distances.length - iteration];
    else
        actDistance = 0;

        }
    }
    private void shellsort2(int [] array, Integer [] distances) {
        int n = array.length;
        int iteration = 1;
        int actDistance = distances[distances.length-iteration];
        int comp, cur;

        while (actDistance > 1) {
            if (actDistance != 1) {
                for (int i=actDistance; i<n; i++) {
                    cur = array[i];
                    comp = i;
                    while (comp >= actDistance && cur < array[comp-actDistance]) {
                        array[comp] = array[comp-actDistance];
                        comp -= actDistance;
                    }
                    array[comp] = cur;
                }
            }
            iteration++;
            actDistance = distances[distances.length-iteration];
        }
        if (actDistance == 1)
            bubblesort(array);
    }
    private void shellsort3(int [] array, Integer [] distances) {
        int n = array.length;
        int iteration = 1;
        int actDistance = distances[distances.length-iteration];
        int comp, cur;

        while (actDistance>1) {
            if (actDistance != 1) {
                for (int i = actDistance; i < n; i++) {
                    cur = array[i];
                    comp = i;
                    while (comp >= actDistance) {
                        if (cur < array[comp - actDistance])
                            swap(array, comp, comp-actDistance);
                        comp -= actDistance;
                    }
                }
            }
            iteration++;
            actDistance = distances[distances.length-iteration];
        }
        if (actDistance==1) {
            // System.out.println(Arrays.toString(array));
            insertsort(array);
        }
    }

    public void ShellSort1() {
        System.out.println("Wersja 1:");

        int [] pom;
        pom = copy(los);
        Integer [] dystanse = aCiag(los.length);
        long t1 = System.nanoTime();
        shellsort1(pom, dystanse);
        long t2 = System.nanoTime();
        double t = (double)(t2-t1)/1000000;

        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg a: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = bCiag(los.length);
        t1 = System.nanoTime();
        shellsort1(pom, dystanse);
        t2 = System.nanoTime();
        t = (double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg b: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = cCiag(los.length);
        t1 = System.nanoTime();
        shellsort1(pom, dystanse);
        t2 = System.nanoTime();
        t = (double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg c: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = dCiag(los.length);
        t1 = System.nanoTime();
        shellsort1(pom, dystanse);
        t2 = System.nanoTime();
        t = (double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg d: " + String.format("%1.2f",t) + " ms");


    }
    public void ShellSort2() {
        System.out.println("Wersja 2:");

        int [] pom;
        pom = copy(los);
        Integer [] dystanse = aCiag(los.length);
        long t1 = System.nanoTime();
        shellsort2(pom, dystanse);
        long t2 = System.nanoTime();
        double t =(double) (t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg a: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = bCiag(los.length);
        t1 = System.nanoTime();
        shellsort2(pom, dystanse);
        t2 = System.nanoTime();
         t =(double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg b: " + String.format("%1.2f",t) +  " ms");

        pom = copy(los);
        dystanse = cCiag(los.length);
        t1 = System.nanoTime();
        shellsort2(pom, dystanse);
        t2 = System.nanoTime();
        t =(double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg c: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = dCiag(los.length);
        t1 = System.nanoTime();
        shellsort2(pom, dystanse);
        t2 = System.nanoTime();
        t = (double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg d: " + String.format("%1.2f",t) + " ms");


    }
    public void ShellSort3() {
        System.out.println("Wersja 3:");

        int [] pom;
        pom = copy(los);
        Integer [] dystanse = aCiag(los.length);
        long t1 = System.nanoTime();
        shellsort3(pom, dystanse);
        long t2 = System.nanoTime();
        double t = (double) (t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg a: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = bCiag(los.length);
        t1 = System.nanoTime();
        shellsort3(pom, dystanse);
        t2 = System.nanoTime();
        t = (double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg b: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = cCiag(los.length);
        t1 = System.nanoTime();
        shellsort3(pom, dystanse);
        t2 = System.nanoTime();
        t = (double)(t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg c: " + String.format("%1.2f",t) + " ms");

        pom = copy(los);
        dystanse = dCiag(los.length);
        t1 = System.nanoTime();
        shellsort3(pom, dystanse);
        t2 = System.nanoTime();
        t =(double) (t2-t1)/1000000;
        //System.out.println(Arrays.toString(pom));
        System.out.println("Ciąg d: " + String.format("%1.2f",t) + " ms");



    }

}