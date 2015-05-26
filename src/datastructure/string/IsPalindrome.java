package datastructure.string;

import java.util.Arrays;
  
// 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？

public class IsPalindrome {
    final int MAX_INT = 2147483647;
    final int MIN_INT = -2147483648;
    
	public static void main(String[] args) {
		IsPalindrome s = new IsPalindrome();
		s.strToInt("-29999999993451");
	}
	
	int strToInt(String s) {
	    char[] arr = s.toCharArray();
	    int n = 0;
	    char sign = arr[0];   // 符号位
	    for(int i = 1; i < arr.length; i++) {
	        int tmp = arr[i] - '0';    // 某一位的值
	        // 此处判断是否越界，此处不能用  10*n+tmp 判断n是否越界，因为即使n没有越界，但是n*10就有可能越界了，所以应该：只比较n和MAX_INT / 10的大小，即：
	        // 若n>MAX_INT/10，那么说明最后一步转换时，n*10必定大于MAX_INT，所以在得知n>MAX_INT/10时，当即返回MAX_INT。
	        // 若n==MAX_INT/10时，那么比较最后一个数字c跟MAX_INT%10的大小，即如果n==MAX_INT/10且c>MAX_INT%10，则照样返回MAX_INT。
	        // 注：MAX_INT%10表示取得MAX_INT的个位数字。
	        if (sign == '+' && (n > MAX_INT / 10 || (n == MAX_INT / 10 && tmp > MAX_INT % 10))) {
	            n = MAX_INT;
	            break;
	        }
	        else if (sign == '-' && (n > -MIN_INT / 10 || (n == -MIN_INT / 10 && tmp > -MIN_INT % 10)))
	        {
	            n = MIN_INT;
	            break;
	        }
	        n = 10 * n + tmp;
	    }
	    System.out.println(n);
	    return 0;
	}
	
}

