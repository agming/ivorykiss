package taop.datastructure.mystring;

import java.util.Arrays;

// 旋转字符串：把字符串前面的m个字符移动到字符串的尾部
public class RotateString {

	public static void main(String[] args) {
		RotateString r = new RotateString();
		String[] arr = "I am a student.".split(" ");
//		r.leftRotateString1(arr, 4);
//		r.leftRotateString2(arr, 4);
//		r.leftRotateStringL1(arr, 2);
//		r.leftRotateStringL2(arr, 8);
		r.leftRotateStringL3(arr);
	}
	
	// 工具方法：将一个数组的第0个字符串移动到最末
	private void leftShiftOne(char[] arr) { // n为字符串长度
		char c = arr[0];
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			arr[i - 1] = arr[i];
		}
		arr[len - 1] = c;
	}
	// 解法一：暴力移位法。复杂度最高：O(m*n)
	void leftRotateString1(char[] arr, int m) { // m为要移动的字符数，即从字符串左起计算，>=1
		while(m > 0) {
			leftShiftOne(arr);
			m--;
		}
		System.out.println(arr);
	}
	
	// 工具方法：自身字符串转置。abc→cba
	void reverseString(char[] arr, int from, int to) { // from, to 都包含
		while(to - from > 0) {
			char c = arr[from];
			arr[from] = arr[to];
			arr[to] = c;
			from++;
			to--;
		}
	}
	void reverseString(String[] arr, int from, int to) { // from, to 都包含
        while(to - from > 0) {
            String c = arr[from];
            arr[from] = arr[to];
            arr[to] = c;
            from++;
            to--;
        }
    }
	
	// 解法二：三步反转法 (X^T·Y^T)^T=YX
	void leftRotateString2(char[] arr, int m) {
		int len = arr.length;
		reverseString(arr, 0, m - 1);
		reverseString(arr, m, len - 1);
		reverseString(arr, 0, len - 1);
	}
	
	// 例1：链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
	void leftRotateStringL1(char[] arr, int m) {
		int len = arr.length;
		reverseString(arr, 0, m - 1);
		reverseString(arr, m, len - 1);
		System.out.println(arr);
	}
	
	// 例2：编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，要求：长度为n的字符串操作时间复杂度为O(n)，空间复杂度为O(1)。 例如，原字符串为”Ilovebaofeng”，m=8，输出结果为：”baofengIlove”。
	void leftRotateStringL2(char[] arr, int m) {
		int len = arr.length;
	    int i = len - m;
		reverseString(arr, 0, i);
		reverseString(arr, i + 1, len - 1);
		reverseString(arr, 0, len - 1);
		System.out.println(arr);
	}
	
	// 例3：单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
	void leftRotateStringL3(String[] arr) {
	    reverseString(arr, 0, arr.length - 1);
	    System.out.println(Arrays.toString(arr));
	}
}

