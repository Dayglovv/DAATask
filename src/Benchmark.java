import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Benchmark {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        System.out.printf(
                "%-10s %-15s %-15s %-15s %-15s%n",
                "Size", "Structure", "Insert(ms)",
                "Search(ms)", "Delete(ms)"
        );
        for (int n : sizes) {
            test(n);
        }
    }
    public static void test(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Collections.shuffle(list, new Random(42));
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = list.get(i);
        }
        BST bst = new BST();
        long start = System.nanoTime();
        for (int x : numbers) {
            bst.insert(x);
        }
        long insertTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int x : numbers) {
            bst.search(x);
        }
        long searchTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int x : numbers) {
            bst.delete(x);
        }
        long deleteTime = System.nanoTime() - start;
        printResult(n, "BST",
                insertTime, searchTime, deleteTime);
        HashTable hash = new HashTable(n);
        start = System.nanoTime();
        for (int x : numbers) {
            hash.insert(x);
        }
        insertTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int x : numbers) {
            hash.search(x);
        }
        searchTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int x : numbers) {
            hash.delete(x);
        }
        deleteTime = System.nanoTime() - start;
        printResult(n, "Hash Table",
                insertTime, searchTime, deleteTime);
    }
    public static void printResult(
            int n, String name,
            long insert, long search, long delete) {
        System.out.printf(
                "%-10d %-15s %-15.4f %-15.4f %-15.4f%n",
                n, name,
                insert / 1000000.0,
                search / 1000000.0,
                delete / 1000000.0
        );
    }
}
