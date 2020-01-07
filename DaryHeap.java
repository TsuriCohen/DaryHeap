package test_results;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.*;
import java.lang.System.*;
import java.util.Scanner;


public class DaryHeap {
	
    public static int d;
    private int[] heap;
    private int heapSize;
    
    public DaryHeap(int capacity) {
    	heapSize = 0;
    	heap = new int[capacity + 1];
    	for(int i = 0 ; i < heap.length ; i++) {
    		heap[i] = -1;
    	}
    }
    
    public boolean isEmpty() {
    	return heapSize == 0;
    }
    
    public boolean isFull(){
        return heapSize == heap.length;
    }
    
    private int parent(int i){
        return (i-1)/d;
    }
    
    private int jthChild(int i,int j){
        return (d*i)+j;
    }
  
    public void insert(int x){
        if(isFull())
            System.out.println("Heap is full, No space to insert new element");
        heap[heapSize++] = x;
        heapifyUp(heapSize-1);  
    }
    
    public int delete(int x){
        if(isEmpty())
            System.out.println("Heap is empty, No element to delete");
        int key = heap[x];
        heap[x] = heap[heapSize -1];
        heapSize--;
        maxDaryHeapify(x);
        return key;
    }
    
    private void heapifyUp(int i) {
        int temp = heap[i];
        while(i>0 && temp > heap[parent(i)]){
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    
    
	public static int getMin(int[] inputArray){ 
	    int minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  } 
	
	public int largestSon(int i) {
		return largestSon(i,0,0);
	}
	
	public int largestSon(int i, int largestSonATM, int getIndex) {
		largestSonATM = getMin(heap);
		for(int j = 1; j < d+1; j++) {
			if (heapSize > jthChild(i, j) 
					&& heap[jthChild(i, j)] > largestSonATM) {
				largestSonATM = heap[jthChild(i, j)];
				getIndex = jthChild(i, j);
			}
		}
		return getIndex;
	}
	
	public void maxDaryHeapify(int i) {
		maxDaryHeapify(i,0,0);
	}
	public void maxDaryHeapify(int i, int largest, int temp){
		if (largestSon(i) != 0
				&& heapSize >= largestSon(i) 
				&& heap[largestSon(i)] > heap[i]) {
			largest = largestSon(i);
		} else largest = i;
		if (largest!= i) {
			temp = heap[largest];
			heap[largest] = heap[i];
			heap[i] = temp;
			maxDaryHeapify(largest);	
		}
		
	}
	
    public void printHeap()
    {
        System.out.print("the " + d+"'ary heap is:  ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
    
	public static LinkedList makeList(String filePath) {
		Scanner scan = null;
		LinkedList ll = new LinkedList(0);
		try {
			
			File text = new File(filePath);
			scan = new Scanner(text);
			
			
		} catch (IOException e) {
			System.out.println("FILE NOT FOUND!");
		}
		while (scan.hasNextInt()) {
			ll.addAtTail(scan.nextInt());
		}
		
		return ll;
	}
	
	//EXTRACT-MAX
	public void extractMax() {
		delete(0);
	}
	
    public void userInsert(int x){ //let the user to insert a new element 
    							   //to the heap, with a solution for a situation
        if(isFull()) {			   //that the heap's array is full
        	int[] temp = heap;
        	heap = new int[temp.length*2];
        	for(int i = 0; i < temp.length ; i++) {
        		heap[i] = temp[i];
        	}
        }
        heap[heapSize++] = x;
        heapifyUp(heapSize-1);  
    }
    
    public void heapIncreasedKey(int i, int key) {
    	if(key < heap[i]) {
    		System.out.println("new key is smaller then the current key");
    	}
    	heap[i] = key;
    	while(i>1 && heap[parent(i)] < heap[i]) {
    		int temp = heap[i];
    		heap[i] = heap[parent(i)];
    		heap[parent(i)] = temp;
    	}
    }
    
    public void getDepth() { //get the Depth/Height of the d-ary heap
		double[] arr1 = new double[heapSize];
    	for(int i = 0 ; i < arr1.length ; i++) {
    		arr1[i] = Math.pow((double)d, i);
    	}
		
		int heapDepth = 0;
		
		for(int i = 0 ; i< arr1.length ; i++) {
			if(heapSize > (int)arr1[i])
			heapDepth = i+1;
		}
		
		System.out.println("the depth is: " + heapDepth);
    }
    
//	ooo        ooooo       .o.       ooooo ooooo      ooo 
//	`88.       .888'      .888.      `888' `888b.     `8' 
//	888b     d'888      .8"888.      888   8 `88b.    8  
//	8 Y88. .P  888     .8' `888.     888   8   `88b.  8  
//	8  `888'   888    .88ooo8888.    888   8     `88b.8  
//	8    Y     888   .8'     `888.   888   8       `888  
//	o8o        o888o o88o     o8888o o888o o8o        `8      
    
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please paste here your file path:");
		String str1 = scanner.nextLine();
		
		System.out.println("Please Enter your desierd d, for the dAry heap sort");
		d = scanner.nextInt();
		
		LinkedList list = makeList(str1); // Creates a linked list,
										  // And insert the file's data in its nodes
		
		DaryHeap heap1 = new DaryHeap(list.getSize()); // Creates an empty heap
		
		for(int i = 0 ; i < heap1.heap.length-1 ; i++) { 
			heap1.insert(list.find(i+1).getData());
		} // That for loop takes each node of the linked list, 
		  // and insert it's nodes in the new heap, using the insert function
		  // So each element inserted right to its place at the d-ary heap

		heap1.printHeap();
		heap1.userInsert(41);
		heap1.userInsert(44);
		heap1.userInsert(46);
		heap1.userInsert(47);
		heap1.userInsert(49);
		heap1.userInsert(48);
		heap1.printHeap();

		heap1.heapIncreasedKey(2, 100);
		heap1.printHeap();
		
		heap1.getDepth();


		


		


    }

}










