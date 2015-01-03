package taop.datastructure.mystring;

// ��ת�ַ��������ַ���ǰ���m���ַ��ƶ����ַ�����β��
public class RotateString {

	public static void main(String[] args) {
		RotateString r = new RotateString();
		char[] arr = "123456".toCharArray();
//		r.reverseString(arr, 1, 4);
		r.leftRotateStringL1(arr, 6, 2);
	}
	
	// �ⷨһ��������λ��
	void leftShiftOne(char[] arr, int n) { // nΪ�ַ�������
		char c = arr[0];
		for(int i = 1; i < n; i++) {
			arr[i - 1] = arr[i];
		}
		arr[n - 1] = c;
	}
	void leftRotateString1(char[] arr, int n, int m) { // nΪ�ַ������ȣ�mΪҪ�ƶ����ַ���
		while(m > 0) {
			leftShiftOne(arr, n);
			m--;
		}
		System.out.println(arr);
	}
	
	// �ⷨ����������ת�� (X^T��Y^T)^T=YX
	void reverseString(char[] arr, int from, int to) {
		while(to - from > 0) {
			char c = arr[from];
			arr[from] = arr[to];
			arr[to] = c;
			from++;
			to--;
		}
	}
	void leftRotateString2(char[] arr, int n, int m) {
		m = m % n;
		reverseString(arr, 0, m - 1);
		reverseString(arr, m, n - 1);
		reverseString(arr, 0, n - 1);
	}
	
	// ��1������ת������һ�������һ����k�����磬����Ϊ1��2��3��4��5��6��k=2����ת��2��1��6��5��4��3����k=3����ת��3��2��1��6��5��4����k=4����ת��4��3��2��1��6��5���ó���ʵ�֡�
	void leftRotateStringL1(char[] arr, int n, int m) {
		m = m % n;
		reverseString(arr, 0, m - 1);
		reverseString(arr, m, n - 1);
		System.out.println(arr);
	}
	
	// ��2����д������ԭ�ַ����а��ַ���β����m���ַ��ƶ����ַ�����ͷ����Ҫ�󣺳���Ϊn���ַ�������ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)�� ���磬ԭ�ַ���Ϊ��Ilovebaofeng����m=7��������Ϊ����baofengIlove����
	void leftRotateStringL2(char[] arr, int n, int m) {
		int i = n - m;
		reverseString(arr, 0, i - 1);
		reverseString(arr, i, n - 1);
		reverseString(arr, 0, n - 1);
		System.out.println(arr);
	}
	
	// ��3�����ʷ�ת������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䣬�����е����Կո��������Ϊ������������ź���ͨ��ĸһ���������磬���롰I am a student.�����������student. a am I����
	// ��
}

