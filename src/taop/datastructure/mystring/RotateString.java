package taop.datastructure.mystring;

import java.util.Arrays;

// ��ת�ַ��������ַ���ǰ���m���ַ��ƶ����ַ�����β��
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
	
	// ���߷�������һ������ĵ�0���ַ����ƶ�����ĩ
	private void leftShiftOne(char[] arr) { // nΪ�ַ�������
		char c = arr[0];
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			arr[i - 1] = arr[i];
		}
		arr[len - 1] = c;
	}
	// �ⷨһ��������λ�������Ӷ���ߣ�O(m*n)
	void leftRotateString1(char[] arr, int m) { // mΪҪ�ƶ����ַ����������ַ���������㣬>=1
		while(m > 0) {
			leftShiftOne(arr);
			m--;
		}
		System.out.println(arr);
	}
	
	// ���߷����������ַ���ת�á�abc��cba
	void reverseString(char[] arr, int from, int to) { // from, to ������
		while(to - from > 0) {
			char c = arr[from];
			arr[from] = arr[to];
			arr[to] = c;
			from++;
			to--;
		}
	}
	void reverseString(String[] arr, int from, int to) { // from, to ������
        while(to - from > 0) {
            String c = arr[from];
            arr[from] = arr[to];
            arr[to] = c;
            from++;
            to--;
        }
    }
	
	// �ⷨ����������ת�� (X^T��Y^T)^T=YX
	void leftRotateString2(char[] arr, int m) {
		int len = arr.length;
		reverseString(arr, 0, m - 1);
		reverseString(arr, m, len - 1);
		reverseString(arr, 0, len - 1);
	}
	
	// ��1������ת������һ�������һ����k�����磬����Ϊ1��2��3��4��5��6��k=2����ת��2��1��6��5��4��3����k=3����ת��3��2��1��6��5��4����k=4����ת��4��3��2��1��6��5���ó���ʵ�֡�
	void leftRotateStringL1(char[] arr, int m) {
		int len = arr.length;
		reverseString(arr, 0, m - 1);
		reverseString(arr, m, len - 1);
		System.out.println(arr);
	}
	
	// ��2����д������ԭ�ַ����а��ַ���β����m���ַ��ƶ����ַ�����ͷ����Ҫ�󣺳���Ϊn���ַ�������ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)�� ���磬ԭ�ַ���Ϊ��Ilovebaofeng����m=8��������Ϊ����baofengIlove����
	void leftRotateStringL2(char[] arr, int m) {
		int len = arr.length;
	    int i = len - m;
		reverseString(arr, 0, i);
		reverseString(arr, i + 1, len - 1);
		reverseString(arr, 0, len - 1);
		System.out.println(arr);
	}
	
	// ��3�����ʷ�ת������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䣬�����е����Կո��������Ϊ������������ź���ͨ��ĸһ���������磬���롰I am a student.�����������student. a am I����
	void leftRotateStringL3(String[] arr) {
	    reverseString(arr, 0, arr.length - 1);
	    System.out.println(Arrays.toString(arr));
	}
}

