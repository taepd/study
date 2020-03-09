import java.util.Arrays;

public class Ex02_Arrays_Quiz {

    public static void main(String[] args) {
        //수학과 학생들의 기말고사 시험점수
        
        int[] score = new int[] {79,88,97,54,56,95};
        int max = score[0];  //max >> 79
        int min = score[0];  //min >> 79
        
        //제어문을 사용해서 max변수에 시험점수 최댓값을, min변수에 최솟값을 담으세요
        //출력되는 결과는: max = 97, min = 54
        //단 for문을 한 번만 사용하세요
        
        for(int i=0; i<score.length;i++) {
//           if(score[i]>max) {
//               max=score[i];
//           }
//           if(score[i]<min) {
//               min=score[i];
//           }
            max=(score[i]>max)?score[i]:max;   //삼항연산자 활용하자
            min=(score[i]<min)?score[i]:min;
     
           
        }System.out.println("max: "+max+", min: "+min);
        
        int[] number = new int[10];
        //10개의 방의 값을 1~10까지 값으로 초기화 하세요
        //number[0] >> 1,,,,,,,,number[9] >>10
        //for문 사용
        
        for(int i=0;i<number.length;i++) {
            number[i]=i;
        }System.out.println(Arrays.toString(number));
       
        
        //어느 학생의 기말고사 시험점수(5과목)
        int sum =0;
        float average = 0f;
        int[] jumsu = {100,55,90,60,78};
        
        //1. 총 과목 수
        //2. 과목의 합
        //3. 과목의 평균
        //단 2,3 문제는 하나의 for으로 해결하세요
        

        for(int i=0;i<jumsu.length;i++) {
            sum+=jumsu[i];
            
            if(i==jumsu.length-1) {
            average = (float)sum/jumsu.length;
            }
        }


        System.out.printf("총과목수[%d], 총점[%d], 평균[%f]\n",jumsu.length,sum,average);
        
        
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
