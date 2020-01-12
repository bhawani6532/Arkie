
public class sortMerge implements ISorting {
	public sortMerge() {
		
	}
	
	public void sortArray(int[] arr) {
		mergeSort(arr,0,arr.length-1);
	}
	
	private void mergeSort(int[] arr, int start, int end) {
		int mid = start + (end-start)/2;
		//if(end)
		if(start < end) {
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			mergeArray(arr,start,mid,end);
		}
		return;
	}
	
	private void mergeArray(int[] arr, int start, int mid, int end) {
		int sizeA1 = mid-start+1;
		int sizeA2 = end-mid;
		int tempStart = start;
		int i;
		int j;
		int x=0;
		int[] tempArray = new int[sizeA1+sizeA2];
		for(i =start,j = mid+1; i<= mid && j<= end;) {
			if(arr[i]<arr[j]) {
				tempArray[x++]= arr[i++];
			}
			else {
				tempArray[x++]= arr[j++];
			}
		}

		while(i<=mid) {
			tempArray[x++] = arr[i++];
		}
		while(j<=end) {
			tempArray[x++] = arr[j++];
		}
		for(int z = 0;z<sizeA1+sizeA2;z++) {
			arr[tempStart++] = tempArray[z];
		}
		
	}
	public void displayElements(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+". " + arr[i] + " ");
		}
	}

}
