package datastructure.string;

import java.util.Arrays;
  
// ���������ֱ�����ĸ��ɵ��ַ���A���ַ���B���ַ���B�ĳ��ȱ��ַ���A�̡����ʣ���������ж��ַ���B��������ĸ�Ƿ����ַ���A�
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
	
	// ����һ�����������ԡ�
	// ���������ɷֱ������ַ�����������Ȼ���ٱȽ�
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
	
	// ����������������ȱ�������׳˻�Խ��
	boolean stringContainSu(String s1, String s2) {
	    int[] arr = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	    int num = 1;
	    for(int i = 0; i < s1.length(); i++) {
	        num *= arr[s1.charAt(i) - 'A'];    // ���ַ����е���ĸת��Ϊ������Ȼ�󽫶�Ӧ���������
	    }
	    for(int i = 0; i < s2.length(); i++) {
	        if(num % arr[s2.charAt(i) - 'A'] != 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	// �����ģ�ǩ����
	// ���ַ���s1����λ���㣨26bit������ʾ)�����һ����ǩ����������B�е��ַ���A������в��ҡ�
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
	
	// ��������ַ������ַ�һ��������˳��һ��������Ϊ���ֵ��ַ���������bad��adb��Ϊ�ֵ��ַ��������ṩһ���ַ�����������ֵ���Ѹ���ҵ������ֵ��ַ���
	// ����������൱��������ַ����Ӽ��������������s1=s2
	// ����������������������ַ�����Ӧ����������ȣ�����ǩ����������ʲô˳�������ɵ�code��һ����
}

