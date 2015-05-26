package datastructure.string;

import java.util.Arrays;
  
// 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
// s1: ABCD s2: BAD true
// s1: ABCD s2: BAE false
// s1: ABCD s2: AAD true
public class StringContain {

	public static void main(String[] args) {
		StringContain s = new StringContain();
		String s1 = "ABCD";
		String s2 = "AD";
		boolean result = s.stringContainSu(s1, s2); 
		System.out.println(result);
	}
	
	// 方法一：暴力法，略。
	// 方法二：可分别将两个字符串进行排序，然后再比较
	boolean stringContainSort(String s1, String s2) {
	    char[] charArr1 = s1.toCharArray();
	    char[] charArr2 = s2.toCharArray();
	    Arrays.sort(charArr1);
	    Arrays.sort(charArr2);
	    for(int i = 0; i < charArr2.length; i++) {
	        if(charArr1[i] == charArr2[i]) {
	            continue;
	        }
	        else {
	            return false;
	        }
	    }
	    return true;
	}
	
	// 方法三：素数法；缺点是容易乘积越界
	boolean stringContainSu(String s1, String s2) {
	    int[] arr = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	    int num = 1;
	    for(int i = 0; i < s1.length(); i++) {
	        num *= arr[s1.charAt(i) - 'A'];    // 将字符串中的字母转化为素数，然后将对应的素数相乘
	    }
	    for(int i = 0; i < s2.length(); i++) {
	        if(num % arr[s2.charAt(i) - 'A'] != 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	// 方法四：签名法
	// 对字符串s1，用位运算（26bit整数表示)计算出一个“签名”，再用B中的字符到A里面进行查找。
	boolean stringContainSign(String s1, String s2) {
        int code = 0;
        for(int i = 0; i < s1.length(); i++) {
            code = code | (1 << (s1.charAt(i) - 'A'));
        }
        for(int i = 0; i < s2.length(); i++) {
            if((code & (1 << (s2.charAt(i) - 'A'))) == 0) {
                return false;
            }
        }
        return true;
	}
	
	void test(String s) {
        int code = 0;
        for(int i = 0; i < s.length(); i++) {
            code = code | (1 << (s.charAt(i) - 'A'));
        }
        System.out.println(code);
	}
	
	// 如果两个字符串的字符一样，但是顺序不一样，被认为是兄弟字符串，比如bad和adb即为兄弟字符串，现提供一个字符串，如何在字典中迅速找到它的兄弟字符串
	// 分析：这个相当于上面的字符串子集的特殊情况，即s1=s2
	// 可用上面的素数法：两个字符串对应的素数积相等；或者签名法：无论什么顺序，其生成的code都一样。
}

