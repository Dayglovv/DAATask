# BST vs Hash Table Performance Analysis

## 1. Introduction
The goal of this project is to compare the performance of a Binary Search Tree (BST) and a Hash Table. Both data structures are implemented in Java. The project tests three operations: insertion, searching, and deletion.
The tests are performed with 100, 1,000, and 10,000 elements.

## 2. Implementation. Binary Search Tree (BST)
The BST stores values in nodes. Smaller values go to the left side, and larger values go to the right side.
The class includes three main methods:
- `insert()` - adds a new value.
- `search()` - checks if a value exists.
- `delete()` - removes a value from the tree.

### Hash Table

The Hash Table uses an array of linked lists. The hash function calculates the index where a value should be stored. If multiple values have the same index, they are stored in the same linked list. This method is called separate chaining.
The class also includes `insert()`, `search()`, and `delete()` methods.

## 3. Time Complexity Analysis

| Operation | BST Best Case | BST Worst Case | Hash Table Best Case | Hash Table Worst Case |
|---|---|---|---|---|
| Insertion | O(1) | O(n) | O(1) | O(n) |
| Searching | O(1) | O(n) | O(1) | O(n) |
| Deletion | O(1) | O(n) | O(1) | O(n) |

A balanced BST usually performs its operations in O(log n) time. However, if the tree becomes unbalanced, operations can take O(n) time.

A Hash Table usually performs operations in expected O(1) time when values are distributed well. In the worst case, many values can have the same hash index, making operations take O(n) time.

## 4. Experimental Results

The program measures execution time in milliseconds using `System.nanoTime()`.

| Number of Elements | Structure | Insertion (ms) | Searching (ms) | Deletion (ms) |
|---|---|----------------|----------------|---------------|
| 100 | BST | 0.7341         | 0.0299         | 0.0627        |
| 100 | Hash Table | 0.1445         | 0.0402         | 0.0532        |
| 1,000 | BST | 0.1703         | 0.2758         | 0.1828        |
| 1,000 | Hash Table | 0.3258         | 0.1769         | 0.2302        |
| 10,000 | BST | 1.4560         | 1.3141         | 1.3758        |
| 10,000 | Hash Table | 1.3524         | 0.6861         | 0.8450        |

## 5. Discussion

For 100 elements, the Hash Table was faster at insertion and deletion, while the BST was faster at searching.

For 1,000 elements, the BST was faster at insertion and deletion, but the Hash Table was faster at searching.

For 10,000 elements, the Hash Table was faster in all three operations. Its search time was 0.6861 ms, compared with 1.3141 ms for the BST. The Hash Table also had lower insertion and deletion times.

These results show that the Hash Table performed better overall in the largest test. However, the results were not the same for every input size. Performance can depend on the tree structure, hash collisions, Java Virtual Machine optimization, and other system conditions.
## 6. Conclusion

In conclusion, the BST and Hash Table have different advantages. A BST is useful when values need to be organized in sorted order. A Hash Table is usually a better choice when fast access to individual values is important.
The experiment helps compare their practical performance with different input sizes. The final conclusion should be based on the measured results from the program.
