package datastructure.string;

import java.util.Arrays;
  
// ���������ֱ�����ĸ��ɵ��ַ���A���ַ���B���ַ���B�ĳ��ȱ��ַ���A�̡����ʣ���������ж��ַ���B��������ĸ�Ƿ����ַ���A�

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
	    char sign = arr[0];   // ����λ
	    for(int i = 1; i < arr.length; i++) {
	        int tmp = arr[i] - '0';    // ĳһλ��ֵ
	        // �˴��ж��Ƿ�Խ�磬�˴�������  10*n+tmp �ж�n�Ƿ�Խ�磬��Ϊ��ʹnû��Խ�磬����n*10���п���Խ���ˣ�����Ӧ�ã�ֻ�Ƚ�n��MAX_INT / 10�Ĵ�С������
	        // ��n>MAX_INT/10����ô˵�����һ��ת��ʱ��n*10�ض�����MAX_INT�������ڵ�֪n>MAX_INT/10ʱ����������MAX_INT��
	        // ��n==MAX_INT/10ʱ����ô�Ƚ����һ������c��MAX_INT%10�Ĵ�С�������n==MAX_INT/10��c>MAX_INT%10������������MAX_INT��
	        // ע��MAX_INT%10��ʾȡ��MAX_INT�ĸ�λ���֡�
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

