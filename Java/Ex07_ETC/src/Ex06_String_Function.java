import java.util.StringTokenizer;

/* String 클래스(문자열)
 * 수많은 함수... 문자열 자르고 합치고 뽑아내고
 * Stirng: static 함수 + 일반 함수
 * 10개 암기
*/






public class Ex06_String_Function {

    public static void main(String[] args) {
        //초기화
        String str=""; //빈 문자열의 초기화, null로 초기화하면 메모리값을 안갖는다.
        
        //배열도 당연히 가능
        String[] strarr = {"aaa","bbb","ccc"};
        for(String s : strarr) {
            System.out.println(s);
        }
        
        //함수
        String ss = "hello";       
        String concatstr =ss.concat("world");  //concat: 문자열 연결
        System.out.println(concatstr);
 
        
        boolean bo = ss.contains("hel"); //contains: 포함된 문자sequnce있는지 유무
        System.out.println(bo);
        
 
        bo = concatstr.contentEquals("hel");    
        System.out.println(bo);
        
                
        
        
        String ss2 = "a b c d"; //heap [a][ ][b][ ][c][ ][d]
        System.out.println(ss2.length());  //7. 공백도 길이에 포함
        
        String filename = "hello java world";
        System.out.println(filename.indexOf("h")); //index 배열방의 첨자
        System.out.println(filename.indexOf("java")); //6. 문자열 시작점 알려줌
        
        System.out.println(filename.indexOf("폭망")); //-1. 해당 인자가 문자열에 포함되지 않는다는 의미
        //신문기사 검색 indexof 사용시 0보다 큰 값이 나온다 > 최소 1개는 있다
        if(filename.indexOf("world") !=-1){
            System.out.println("world 문자열이 포함되어 있다");
        }
        
        System.out.println(filename.lastIndexOf("a")); //가장 나중에 위치한 a의 index값 리턴
        
        //많이 쓰는 String 메서드들
        //length, indexOf, substring, replace, split
        String result = "superman";
        System.out.println(result.substring(0)); //superman
        System.out.println(result.substring(2)); //perman. 해당 index부터 시작하는 문자열 리턴
        System.out.println(result.substring(1,2));//u. index값 1<=문자열<2를 리턴
        System.out.println(result.substring(0,0)); // 아무것도 안나옴. 왜냐면 0<=문자열<0 이 되버리기 때문
        
        //Quiz
        String filename2 = "1.txt";  //hong.png 여도 작동해야 함
        //여기서 파일명과 확장자를 분리해서 출력해보세요
        System.out.println("파일명: "+ filename2.substring(0,filename2.indexOf(".")));
        System.out.println("확장자명: "+filename2.substring(filename2.indexOf(".")+1));

        //replace (치환 함수)
        String s4= "ABCDADDDDDA";
        
        String result4 = s4.replace("DDDD", "오늘은 금요일입니다.");
        System.out.println("reslut4 : "+result4);
        result4 = s4.replace("A", "가");    // 앞 매개변수 문자를 뒤 매개변수 문자로 치환
        System.out.println(result4);
        
        //charAt
        System.out.println(s4.charAt(0)); //A. 
        
        //endsWith
        System.out.println(s4.endsWith("DDA")); //true. 
        
        //equalsIgnoreCase
        System.out.println(s4.equalsIgnoreCase("abcdaddddDA")); //true.
        
        //hashCode
        System.out.println(s4.hashCode()); //주소값 출력
        
        //Today Point: split
        String s6 = "슈퍼맨,팬티,노랑색,우하하,우하하";
        String[] namearray = s6.split(",");
        for(String s: namearray) {
            System.out.println(s);
        }
        
        //정규표현식 (java, javascript, Oracle, C#) 공통적인 규칙
        //특수한 문자로 패턴 설계 > 설계한 형식대로 입력 들어오는지 검증
        //주민번호(숫자 6자리 - 문자 숫자 7자리) >> 표현 >> 사용자가 입력한 주민번호가 미리 정의한 패턴과 일치
        //전화번호, 차량번호, 우편번호, 도메인 주소, 이메일 주소
        
        //010-{\d4}-0000 정규표현
        //010-444-0000 >> (false)
        //010-1111-0000 >> (true)
        
        //패턴 과제 .. 정규 표현식 조사하기
        // . 정규표현 문법 >> \.  >> \. 자바에서 인지하려면  \t, \n처럼 \\.으로 해야함
        
        
        String filename3 = "bit.hwp";  
//        String[] namearry = filename3.split("."); //split은 정규표현식을 인자로 줘야 한다
        String[] namearry = filename3.split("\\."); //이렇게 넣어줘야 작동
        for(String s5: namearry) {
            System.out.println(s5);
          
        }
        
        
        //StringTokenizer (참고만)
        String s7 = "a/b,c.d-f"; //a b c d f 추출
        StringTokenizer sto = new StringTokenizer(s7, "/,.-"); 
        while(sto.hasMoreTokens()) {                 //StringTokenizer는 while문으로만 출력 가능
            System.out.println(sto.nextToken());
        }
        
        
        //넌센스
        String s8="홍                길                  동";
        // >"홍길동"으로 출력되게 해보기
        
//        StringTokenizer sto2 = new StringTokenizer(s8, " "); //요런 식으로 공백제거 가능
//        while(sto2.hasMoreTokens()) {                 
//            System.out.print(sto2.nextToken());
//        }System.out.println();
        
        //더 쉬운 방법
        System.out.println(s8.replace(" ", "")); //훨씬 편하다
        
        
        //trim
        String s9= "        홍길동          ";
        System.out.println(">"+s9+"<");
        System.out.println(">"+s9.trim()+"<");
        
        
        
        String s10="       홍     길    동      ";
        //홍길동 출력
        String re = s10.trim();
        String re2 = re.replace(" ", "");
        System.out.println(re2);  //무식한 방법
        
        //****** 여러 개의 함수를 연결해서 사용(method chain 기법)
        System.out.println(s10.trim().replace(" ", ""));
       
        
        //Quiz-1
        int sum=0;
        String[] numarr = {"1","2","3","4","5"};
        //문제: 배열에 있는 문자값들의 합을 sum변수에 담아서 출력: 결과 15
        
        for( String i : numarr) {
            sum+=Integer.parseInt(i);
        }
        System.out.println(sum);
        
        //Quiz-2
        String jumin = "123456-1234567";
        //위 주민번호의 합을 구하세요
        jumin = jumin.replace("-", "");
        System.out.println(jumin);
        
        int sum2=0;
        for(int i=0; i<jumin.length();i++) {
            sum2+=(jumin.charAt(i)-'0');
        }
        System.out.println(sum2);
        
        
        //선생님 해답
        String jumin2="123456-1234567";
        //위 주민번호의 합을 구하세요_1
        int sum3=0;
        for(int i = 0 ; i < jumin2.length() ; i++) {
            String numstr =jumin2.substring(i, i+1);    //문자열을 각 요소 문자열로 쪼갠다
            if(numstr.equals("-")) continue;  // - 일 때 계속 진행
            sum3+= Integer.parseInt(numstr);  // 문자열을 int로 형변환
        } 
        System.out.println("주민번호 합:" + sum2);
        
      //위 주민번호의 합을 구하세요_2
        String jumin3="123456-1234567";
        String[] numarr2 = jumin3.replace("-","").split("");  //replace로 -를 제거하고 split을 이용해 배열화한다.
        int sum4=0;
        for(String i : numarr2) {
            sum4+= Integer.parseInt(i); 
        }
        System.out.println("주민번호 합2:" + sum3);
        
      //위 주민번호의 합을 구하세요_3
        String jumin4 = jumin3.replace("-", "");
        int sum5=0;
        for(int i = 0 ; i < jumin4.length() ;i++) {
            sum5+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));  //String.valueOf() 스트링 값으로 변환
        }
        System.out.println("주민번호 합4:" + sum5);
        
        
  
        
        
        
        
        
        
        
    }

}
