
public class Main {
    public static void main(String[] args) {
        Processes processes = new Processes(8);
        Algorithms algorithms = new Algorithms(processes);
        algorithms.insertionSort();
        algorithms.bubbleSort();
        algorithms.selectionSort();
        algorithms.quickSort();
        algorithms.heapSort();
        algorithms.mergeSort();

    }
}
