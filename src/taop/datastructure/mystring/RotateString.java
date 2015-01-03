package taop.datastructure.mystring;

public class RotateString {

	public static void main(String[] args) {
		RotateString rotateString = new RotateString();
		String str = "abcdef";
		rotateString.leftRotateString(str.toCharArray(), 6, 2);
		
	}
	
	void leftShiftOne(char[] arr, int n) {
		char c = arr[0];
		for(int i = 1; i < n; i++) {
			arr[i - 1] = arr[i];
		}
		arr[n - 1] = c;
	}
	
	void leftRotateString(char[] arr, int n, int m) {
		while(m > 0) {
			leftShiftOne(arr, n);
			m--;
		}
		System.out.println(arr);
	}

}

