
public class sortCounting implements ISorting {
	private int size;
	public sortCounting() {
		
	}
	public sortCounting(int x) {
		size = x;
	}
	
	public void sortArray(int[] arr) {
		int[] tempArray = new int[size]; //We need to set 10000 as input values: 0<=Ai<10000
		for(int i = 0; i<arr.length ;i++) {
			tempArray[arr[i]]++;
		}
		int tempSize = 0;
		for(int i=0;i<tempArray.length;i++) {
			if(tempArray[i]>0) {
				int sizeCount = tempArray[i];
				for(int j= 0;j<sizeCount;j++) {
					arr[tempSize++] = i;
				}
			}
		}
	}
	
	public void displayElements(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+". " + arr[i] + " ");
		}
	}
	
}
