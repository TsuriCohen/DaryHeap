# daryHeap
d-ary heap and linked list implementations in java.
#### d-ary heap stands for a heap, but on a given d base, and not just binary base.

## Linked list functions:
* linkedlist - Creates a new empty list, with only head node.
* addAtHead - adds a new node at the head of the list.
* addATtail - adds a new node at the tail of the list.
* addAtIndex -adds a new node at the pecified index in the list.
* deleteAtIndex - delete the node at the gives index of the list.
* find(int) - takes node and returns it's index.
* find(node) - takes int as index and returns the node in that index of the list.
* printList - prints a linkedlist to the console.
* listToArray - takes a linkedlist and return an array with the date of the given linkedlist.
* getSize - returns the size of the list.

## D-ary Heap functions:
* daryHeap - takes int, and create an empty heap at the int size, initial each index to -1.
* isEmpty - boolean, return true\false for heap==empty.
* isFull - boolean, return true\false for heap==full.
* parent - take int as index, and return the parent.
* jthChild - takes int i as parent and int j as j'th child, and return the j'th child of i.
* insert - insert to heap (not by user input).
* delete - delete from heap (not by user input).
* heapifyUp - makes heapify algorithem from bottom to root.
* getMin - find the smallest key in the heap and return in.
* largestSon - return the largest son (its max heap, the biggest key is the root).
* maxDaryHeapify - normal heapify algorithem, but for d-ary heap (not only binary heap)
* printHeap - prints the heap to the console, only the keys, not all the array. (it wont print the rest of the array after the index of heap size).
* likedList - takes a file of ints, and make a list of them.
* userInsert - insert new key to the heap by user input.
* heapIncreaseKey - takes int i as index and int key as key, and if key > heap[i], key replace heap[i].
* getDepth - return the depth of the heap.
