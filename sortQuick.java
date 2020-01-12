
public class sortQuick implements ISorting {

	public sortQuick() {
		
	}
	
	public void sortArray(int[] arr) {
		sortData(arr,0,arr.length-1);
	}
	
	private void sortData(int[] arr,int start,int end) {
		if(end>start) {
			int pivot = partitionData(arr,start,end);
			sortData(arr,start,pivot-1);
			sortData(arr,pivot+1,end);	
		}
	}
	
	private int partitionData(int[] arr, int start, int end) {
		int pivot = start;
		swapElements(arr, pivot, end);
		int i = start;
		int j = end-1;
		while(i<=j) {
			while(arr[i]<=arr[end] && i<=j) {
				i++;
			}
			while(j>=i && arr[j]>=arr[end]) {
				j--;
			}
			if(i<j) {
				swapElements(arr,i,j);
			}
		}
		swapElements(arr,i,end);
		pivot = i;
		return pivot;
	}
	
	private void swapElements(int[] arr, int x, int y) {
		int intTemp;
		intTemp = arr[x];
		arr[x] = arr[y];
		arr[y] = intTemp;
	}
	
	public void displayElements(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+". " + arr[i] + " ");
		}
	}
}
