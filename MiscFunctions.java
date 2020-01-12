
public class MiscFunctions {
	
	public MiscFunctions() {
		
	}
	
	public boolean isPalindrome(String str, int start, int stringLength) {
		if(start>=stringLength) {
			return true;
		}
		else if(str.charAt(start-1) == str.charAt(stringLength-1)) {
			return isPalindrome(str,start+1,stringLength-1);
		}
		else {
			return false;
		}
	}
	
}
