
//import java.io.*;
import java.util.*;

public class sortingAlgorithm {
	public sortingAlgorithm() {
		sc = new Scanner(System.in);
		rwf = new ReadWriteFile();
		selectInputParamters();
	}
	
	
	public void selectSortType() {
		System.out.println("Please select the follwing for the Sorting method which you want to use");
		System.out.println("Press 1 for Bubble Sort.");
		System.out.println("Press 2 for Selection Sort.");
		System.out.println("Press 3 for Insertion Sort.");
		System.out.println("Press 4 for Merge Sort.");
		System.out.println("Press 5 for Quick Sort.");
		System.out.println("Press 6 for Heap Sort.");
		System.out.println("Press 7 for Counting Sort.");
		System.out.println("Press 8 for Radix Sort.");
		int index = sc.nextInt();
		if(index==1) {
			System.out.println("Bubble Sort has been selected");
			// Perform Bubble sort here
			sortType = new sortBubble();
		}
		else if(index==2) {
			System.out.println("Selection Sort has been selected");
			// Perform Selection sort here
			sortType = new sortSelection();
		}
		else if(index==3) {
			System.out.println("Insertion Sort has been selected");
			// Perform Insertion sort here
			sortType = new sortInsertion();
		}
		else if(index==4) {
			System.out.println("Merge Sort has been selected");
			// Perform Merge sort here
			sortType = new sortMerge();
		}
		else if(index==5) {
			System.out.println("Quick Sort has been selected");
			// Perform Quick sort here
			sortType = new sortQuick();
		}
		else if(index==6) {
			System.out.println("Heap Sort has been selected");
			// Perform Heap sort here
			sortType = new sortHeap();
		}
		else if(index==7) {
			System.out.println("Counting Sort has been selected");
			// Perform Radix sort here
			sortType = new sortCounting(MAX_INDEX);
		}
		else if(index==8) {
			System.out.println("Radix Sort has been selected");
			// Perform Counting sort here
		}
		else {
			System.out.println("Wrong index has been selected. Performing Bubble Sort");
			sortType = new sortBubble();
		}
		long startTime = System.nanoTime();
		sortType.sortArray(arrData);
		long endTime = System.nanoTime();
		sortType.displayElements(arrData);
		System.out.println(endTime-startTime);
		rwf.saveOutputData(arrData);
	}
	
	
	private void selectInputParamters() {
		System.out.println("Number of input paramters in the array");
		int index = sc.nextInt();
		arrData = new int[index];
	}
	
	public void inputData() {
		System.out.println("Fill the data in the input bucket");
		rwf.GenerateRawData(arrData, MAX_INDEX);
		//for(int i=0;i<arrData.length;i++) {
			//arrData[i] = sc.nextInt();
		//}
	}
	
	private Scanner sc;
	private int[] arrData;
	private ISorting sortType;
	private ReadWriteFile rwf;
	private static final int MAX_INDEX = 10000;

}
