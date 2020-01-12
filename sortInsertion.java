
public class sortInsertion implements ISorting{

	public sortInsertion() {
		
	}
	
	public void sortArray(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			for(int j = i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					swapElements(arr,j,j-1);
				}
				else {
					break;
				}
			}
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
