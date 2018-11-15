public class Profiler {
    static long tick() {
        return System.nanoTime();
    }

    static long diff(long t0, long t1) {
        return t1 - t0;
    }
}
