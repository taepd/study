import java.util.Arrays;

//배열은(Array) 객체다
//1. 배열은 객체이므로 (new를 통해서 생성)
//2. new를 통해서 heap 메모리에 생성된다
//3. 고정배열(정적 배열) : 배열의 크기는 한 번 정해지면 고정된다
//4. 자료구조의 기본




public class Ex01_Array_Basic {

    public static void main(String[] args) {
        int s, s1, s2, s3;
        int[] score = new int[3]; //방을 3개 만듬   //방 번호(첨자, index)
       
        score[0]=10; //각각의 방에 (index)
        score[1]=20;
        score[2]=30;
        System.out.println(score[0]);
        
        //방의 갯수는 항상 index 값보다 1 크다
        
//        score[3] = 40;  //마지막 방의 index >> 2
        //java.lang.ArrayIndexOutOfBoundsException
        //예외가 발생했어요(문제가 생겼어요)
        //그래서 컴파일러가 강제로 프로그램을 종료
        //문제가 발생했을 때 일단 실행할 수 있는 방법:
        //-> try catch구문: 오류를 해결하는 것이 아닌 프로그램의 강제종료를 막음
        
        //Array 배열(for문과 잘 어울림)
        for(int i=0;i<score.length;i++) {
            System.out.printf("[%d]=%d\t",i,score[i]);
        }
        System.out.println();
        
        //Tip. Array를 도와주는 클래스
        //toString()
        String result=Arrays.toString(score);  //지금 쓰지 마세요 for문 충분히 연습하고
        System.out.println(result);
        
        //sort()
        Arrays.sort(score);  //시험 문제 빵점 연습할 땐 쓰지 마세요
        
        //입사 배열 sort 문제 많이 나옴
        
        //Today Point
        //배열 3가지
        int[] arr=new int[5]; //기본(방의 갯수)
        int[] arr2=new int[] {100,200,300}; // 초기값을 통해서 방이 만들어지고 초기화
        int[] arr3= {11,22,33,44,55}; //컴파일러가 알아서 new 자동 생성
        //javascript : (var)let cararr =[1,2,3,4,5];
        
        
        for(int i =0; i<arr3.length;i++) {
            System.out.println(arr3[i]);
        }
        
        //배열은 객체다(new...memory >>heap)
        int[] arr4;
        arr4 = new int[] {21,22,23,24,25};
        System.out.println("arr4: "+arr4);
        //배열의 할당(주소값 할당)
        int[] arr5 = arr4;
        //증명
        System.out.println(arr4==arr5);  //같은 주소값을 참조함
        
        String[] strarr = new String[] {"가","나","다라마"};
        char[] ch = new char [10];  //빈문자 '\u0000'
        for(int i =0; i<ch.length;i++) {
            System.out.println(">"+ch[i]+"<");  //빈문자 보이게 하기 위해 꺽쇠 삽입
        }
        
        //8가지 기본타입 + String >> Array 타입 가능
        //***클래스타입(사용자 정의 타입) >>Array 타입 가능
        //Car c = new Car();
        //Car c2 = new Car();
        //Car c3 = new Car();
        //.....
        //이렇게 하는 것보다,
        
        //Car[] cars = new Car[10];  //이렇게 쓰는게 편하다. 배열의 장점
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
