import java.util.LinkedList;
public class HashTable {
    LinkedList<Integer>[] table;
    int size;
    @SuppressWarnings("unchecked")
    public HashTable(int n) {
        size = n * 2 + 1;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }
    int getIndex(int value) {
        return Math.floorMod(value, size);
    }
    public void insert(int value) {
        int index = getIndex(value);
        if (!table[index].contains(value)) {
            table[index].add(value);
        }
    }
    public boolean search(int value) {
        int index = getIndex(value);
        return table[index].contains(value);
    }
    public void delete(int value) {
        int index = getIndex(value);
        table[index].remove(Integer.valueOf(value));
    }
}
