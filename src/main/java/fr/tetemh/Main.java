package fr.tetemh;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //    private static Stack<Integer> firsts = new Stack<>();
    private static List<Integer> firsts = new ArrayList<>(100_000_000);
    public static void main(String[] args) {
        firsts.add(2);
        firsts.add(3);

        long start = System.currentTimeMillis();
        for (int i = 5; i < 100_000_000; i+=2) {
            if(Main.first(i)) {
                firsts.add(i);
            }
        }
        long end = System.currentTimeMillis();

//        System.out.println(firsts);
        System.out.println("\n\nTime : " + (end - start) / 1000.0 + "s");
    }

    private static boolean first(int n) {
        if(n < 2) return false;
        double sqrt = Math.sqrt(n);
        for(int f : firsts) {
            if (f < sqrt && n % f != 0) return true;
        }
        return false;
    }
}