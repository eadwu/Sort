import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort implements SortAlgorithm {
    private int[] arr;

    BubbleSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void sortGreater() {
        int n = this.arr.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (this.arr[i - 1] > this.arr[i]) {
                    Array.swap(this.arr, i - 1, i);
                    swapped = true;
                }
            }
        }
    }

    @Override
    public void sortLess() {
        int n = this.arr.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (this.arr[i - 1] < this.arr[i]) {
                    Array.swap(this.arr, i - 1, i);
                    swapped = true;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(this.arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length);

        BubbleSort test = new BubbleSort(arr);

        System.out.println("Original array is [" + test.toString() + "]");
        long t0 = Profiler.tick();
        test.sortGreater();
        System.out.println("sortGreater() took approx " + Profiler.diff(t0, Profiler.tick()) + " ns");
        System.out.println("New array is sorted by greater than [" + test.toString() + "]");

        System.out.println("Original array is [" + test.toString() + "]");
        long t1 = Profiler.tick();
        test.sortLess();
        System.out.println("sortLess() took approx " + Profiler.diff(t1, Profiler.tick()) + " ns");
        System.out.println("New array is sorted by less than [" + test.toString() + "]");
    }
}
