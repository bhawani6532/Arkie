
public class sortHeap implements ISorting {
	public sortHeap() {
	
	}
	
	public void sortArray(int[] arr) {
		for( int j = 0;j<arr.length;j++) {
			for(int i = (arr.length - j)/2 - 1; i>=0;i--) {
				maxHeapify(arr,i, arr.length-j);
				swapElements(arr,0,arr.length-j-1);
			}
		}
	}
	
	public void displayElements(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+". " + arr[i] + " ");
		}
	}
	
	private void maxHeapify(int[] arr, int x, int p) {
		int arr_size = p;
		if((arr_size-1)>= 2*x+1) {
			if(arr[x]< arr[2*x] || arr[x]< arr[2*x+1])
				if(arr[2*x+1] > arr[2*x]) {
					swapElements(arr,2*x+1,x);
					maxHeapify(arr,2*x+1,arr_size);
				}
				else {
					swapElements(arr,2*x,x);
					 maxHeapify(arr,2*x,arr_size);
				}
		}
		else if((arr_size-1)>= 2*x && arr[x]< arr[2*x]) {
			swapElements(arr,2*x,x);
			maxHeapify(arr,2*x,arr_size);
		}
		else {
			return;
		}
		return;
	}
	
	private void swapElements(int[] arr, int x, int y) {
		int intTemp;
		intTemp = arr[x];
		arr[x] = arr[y];
		arr[y] = intTemp;
	}
}
