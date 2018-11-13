import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSort {
    private int[] arr;

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public void sortGreater() {
        IntStream.range(0, this.arr.length).forEach(x -> {
            IntStream.range(0, this.arr.length).forEach(y -> {
                if (y > 0 && this.arr[y - 1] < this.arr[y]) {
                    BubbleSort.swap(this.arr, y - 1, y);
                }
            });
        });
    }

    public void sortLess() {
        IntStream.range(0, this.arr.length).forEach(x -> {
            IntStream.range(0, this.arr.length).forEach(y -> {
                if (y > 0 && this.arr[y - 1] > this.arr[y]) {
                    BubbleSort.swap(this.arr, y - 1, y);
                }
            });
        });
    }

    public String print() {
        return Arrays.stream(this.arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * arr.length);

        BubbleSort test = new BubbleSort(arr);

        System.out.print("Original array is ");
        System.out.println('[' + test.print() + ']');
        test.sortGreater();
        System.out.print("New array is sorted by greater than ");
        System.out.println('[' + test.print() + ']');
        test.sortLess();
        System.out.print("New array is sorted by less than ");
        System.out.println('[' + test.print() + ']');
    }
}
