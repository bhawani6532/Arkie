
public class sortSelection implements ISorting{
	
	
	public void sortArray(int[] arr) {
		int min_index;
		for(int i = 0; i<arr.length;i++) {
			min_index = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min_index]>arr[j]) {
					min_index = j;
				}
			}
			swapElements(arr,min_index,i);
		}
	}
	
	public void displayElements(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+". " + arr[i] + " ");
		}
	}
	
	private void swapElements(int[] arr, int x, int y) {
		int intTemp;
		intTemp = arr[x];
		arr[x] = arr[y];
		arr[y] = intTemp;
	}

}
