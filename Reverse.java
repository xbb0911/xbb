package com.xbb;

import java.util.Scanner;

/*
 * �ַ�����ת
 * ����������¼�롱abc��		
 * ����������cba��
 * 
 * ������
 * 		A:����¼��һ���ַ���
 * 		B:д����ʵ���ַ����ķ�ת
 * 			a:���ַ������ű������õ���ÿһ���ַ�ƴ�ӳ��ַ�����
 * 			b:���ַ���ת��Ϊ�ַ����飬Ȼ����ַ�������з�ת������ڰ��ַ�����ת��Ϊ�ַ���
 * 		C:���÷���
 * 		D:������
 */
public class Reverse {
	public static void main(String[] args) {
		//����¼��һ���ַ���
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String s = sc.nextLine();
		
		//д����ʵ���ַ����ķ�ת
		
		//���÷���
		String result = reverse(s);
		
		//������
		System.out.println("result:"+result);
	}
	
	
	
	/*
	 * ���ַ������ű������õ���ÿһ���ַ�ƴ�ӳ��ַ�����
	 * 
	 * ������ȷ��
	 * 		����ֵ���ͣ�String
	 * 		�����б�String s
	 */
	
	/*
	public static String reverse(String s) {
		String ss = "";
		
		for(int x=s.length()-1; x>=0; x--) {
			ss += s.charAt(x);
		}
		
		return ss;
	}
	*/
	
	//���ַ���ת��Ϊ�ַ����飬Ȼ����ַ�������з�ת������ڰ��ַ�����ת��Ϊ�ַ���
	public static String reverse(String s) {
		//���ַ���ת��Ϊ�ַ�����
		char[] chs = s.toCharArray();
		
		//���ַ�������з�ת
		for(int start=0,end=chs.length-1; start<=end; start++,end--) {
			char temp = chs[start];
			chs[start] = chs[end];
			chs[end] = temp;
		}
		
		//����ڰ��ַ�����ת��Ϊ�ַ���
		String ss = new String(chs);
		return ss;
	}
}
