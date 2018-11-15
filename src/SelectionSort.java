import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSort implements SortAlgorithm {
    private int[] arr;

    SelectionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void sortGreater() {
        IntStream.range(0, this.arr.length).forEach(x -> {
            IntStream.range(x + 1, this.arr.length).forEach(y -> {
                if (this.arr[y] > this.arr[x]) {
                    Array.swap(this.arr, y, x);
                }
            });
        });
    }

    @Override
    public void sortLess() {
        IntStream.range(0, this.arr.length).forEach(x -> {
            IntStream.range(x + 1, this.arr.length).forEach(y -> {
                if (this.arr[y] < this.arr[x]) {
                    Array.swap(this.arr, y, x);
                }
            });
        });
    }

    @Override
    public String print() {
        return Arrays.stream(this.arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length);

        SelectionSort test = new SelectionSort(arr);

        System.out.print("Original array is ");
        System.out.println('[' + test.print() + ']');

        long t0 = Profiler.tick();
        test.sortGreater();
        System.out.println("sortGreater() took approx " + Profiler.diff(t0, Profiler.tick()) + " ns");
        System.out.print("New array is sorted by greater than ");
        System.out.println('[' + test.print() + ']');

        long t1 = Profiler.tick();
        test.sortLess();
        System.out.println("sortLess() took approx " + Profiler.diff(t1, Profiler.tick()) + " ns");
        System.out.print("New array is sorted by less than ");
        System.out.println('[' + test.print() + ']');
    }
}
