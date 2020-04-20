package java_study_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Temp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		String s = bf.readLine(); //String
		StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// 선언

		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken()); //첫번째 호출
			int b = Integer.parseInt(st.nextToken()); //두번째 호출
			bw.write((a+b) + "\n");// 출력
		}
		

//		for (int i = 0; i < n; i += 2) {
//
//			System.out.println(a + b);
//		}


		bw.flush();// 남아있는 데이터를 모두 출력시킴
		bw.close();// 스트림을 닫음

	}
}