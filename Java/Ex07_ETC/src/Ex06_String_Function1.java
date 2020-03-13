import java.util.StringTokenizer;

//String 클래스 (문자열)
//수 많은 함수 ... 문자열 자르고 합치고 뽑아내고 ...
//String : static 함수 + 일반 함수 ...
// 10개 암기 ....
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str=""; //문자열의 초기화 ,null
		//int , double 처럼 사용하세요
		String[] strarr = {"aaa","bbb","ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
    
		//함수
		String ss ="hello";
		String concatstr = ss.concat(" world");
		System.out.println(concatstr);
		
		boolean bo = ss.contains("hel");
		System.out.println(bo);
		
		bo = ss.contains("helo");
		System.out.println(bo);
		
		bo = ss.contentEquals("hello");
		System.out.println("bo :" + bo);
		
		String ss2 = "a b c d"; //heap [a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length());
		
		String filename = "hello java world";
		System.out.println(filename.indexOf("h")); //index 배열방의 첨자
		System.out.println(filename.indexOf("java")); //6
		
		System.out.println(filename.indexOf("폭망")); //-1 없어 ....
		//-1 return 원하는 값이 배열에 없어요
		//신문기사 검색  indexof 사용시  0보다 큰값이 .... 최소 1개 있다
		if(filename.indexOf("world") != -1) {
			System.out.println("world 문자열이 포함되어 있다");
		}
		System.out.println(filename.lastIndexOf("a"));
		
		//length() , indexOf() , substring() , replace() , Split() ..
		String result = "superman";
		System.out.println(result.substring(0));
		System.out.println(result.substring(2)); //perman
		System.out.println(result.substring(1,2)); //endIndex - 1  //u
		System.out.println(result.substring(0,0));  //(0,-1)  안나와요
		System.out.println(result.substring(0,1)); //s
		System.out.println(result.substring(1,1));
		System.out.println(result.substring(2,3));
		/*
		  Returns a string that is a substring of this string. 
		  The substring begins at the specified beginIndex 
		  and extends to the character at index endIndex - 1.
		  Thus the length of the substring is endIndex-beginIndex. 
		 */
		
		//Quiz
		String filename2 = "aaaaaaa.wp"; //hong.png 
		//여기서 파일명과 확장자를 분리해서 출력해보세요
		//1  파일명 , txt 확장자
		//hong 파일명 , png 확장자
		//조건 단 위에서 배운것만 사용하세요
		//indexOf , length , substring()
		//hint) 기준점 >> .
		
		int position = filename2.indexOf(".");
		String file = filename2.substring(0,position); //position - 1
		
		String extention = filename2.substring(position + 1, filename2.length());
		String extention2 = filename2.substring(++position);
		
		System.out.println(file);
		System.out.println(extention);
		System.out.println(extention2);
		
		//replace (치환함수)
		String s4 = "ABCDADDDDDA";
		String result4 = s4.replace("DDDDD", "오늘은 금요일 입니다");
		System.out.println("result4 : " + result4);
		
		result4 = s4.replace("A", "a");
		System.out.println("result4 : " + result4);
		
		//ETC ... 
		//String s4 = "ABCDADDDDDA";
		System.out.println(s4.charAt(0));
		System.out.println(s4.charAt(3));
		System.out.println(s4.endsWith("DDDA")); //true
		System.out.println(s4.endsWith("BDDA")); //false
		System.out.println(s4.equalsIgnoreCase("abcdADDDDDA")); //대소문자 구별없이 비교
		
		//Today Point (split)
		String s6 ="슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = s6.split(",");
		for(String s : namearray) {
			System.out.println(s);
		}
		//정규표현식 (java , javascript , Oracle , C#) 공통적인 규칙
		//특수한 문자로 패턴 설계  > 설계한 형식대로 입력 > 검증
		//주민번호(숫자 6자리 - 문자 숫자 7자리) >> 표현  >> 사용자 입력한 주민번호가 미리 정의한 패턴과 일치
		//전화번호 , 핸드폰 , 차량번호 , 우편번호 , 도메인 주소 , 이메일 주소 
		
		//010-{\d4}-0000 정규표현
		//010-444-0000 >> (false)
		//010-1111-0000 >> (true)
		
		//패턴 과제  ...정규식 표현식 조사하기
		// . 정규표현 문법 >> \.   >> \. 자바에서 인지 >> \\.  
		//\t , \n
		String filename3 = "bit.hwp";
		String[] filearray = filename3.split("\\.");
		System.out.println(filearray.length);
		for(String s : filearray) {
			System.out.println(s);
		}
		
		String s7 = "a/b,c.d-f"; //a  b  c  d  f 추출
		StringTokenizer sto = new StringTokenizer(s7,"/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		//넌센스
		String s8="홍           길          동";
		//>>"홍길동"  공백제거
		System.out.println(s8.replace(" ", ""));
		
		String s9="      홍길동           ";
		System.out.println(">"+s9+"<");
		System.out.println(">"+s9.trim()+"<");
		
		String s10="    홍      길      동       ";
		//"홍길동" 출력
		String re = s10.trim();
		String re2 = re.replace(" ", "");
		System.out.println(re2); //무식해요 ....
		
		//***** 여러개의 함수를 연결해서 사용  (method chain 기법)
		System.out.println(s10.trim().replace(" ", "").substring(2));
		
		 //Quiz-1
		   int sum=0;
		   String[] numarr = {"1","2","3","4","5"};
		   //문제: 배열에 있는 문자값들의 합을 sum 변수에 담아서 출력 : 결과 15
		   for(String s : numarr) {
			   sum+=Integer.parseInt(s);
		   }
		   System.out.println("sum : " + sum);
		   
		   
		   
		   
		   
		   
		 //Quiz-2
		   String jumin="123456-1234567";
		   //위 주민번호의 합을 구하세요_1
		   int sum2=0;
		   for(int i = 0 ; i < jumin.length() ; i++) {
			   String numstr =jumin.substring(i, i+1);
			   if(numstr.equals("-")) continue;
			   sum2+= Integer.parseInt(numstr);
		   } 
		   System.out.println("주민번호 합:" + sum2);
		   
		 //위 주민번호의 합을 구하세요_2
		 //String jumin="123456-1234567";
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("주민번호 합2:" + sum3);
		   
		 //위 주민번호의 합을 구하세요_3
		   String jumin4 = jumin.replace("-", "");
		   int sum4=0;
		   for(int i = 0 ; i < jumin4.length() ;i++) {
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("주민번호 합4:" + sum4);
		
	}

}



















