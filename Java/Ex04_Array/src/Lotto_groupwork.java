import java.util.Arrays;

/*
 *1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
      (int)(Math.random()*45 + 1)
      lotto[0] = 44 , lotto[1] = 1 .... lotto[5] = 33
 *2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요  (중복값 검증 :별찍기 비슷)
 *3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요  (정렬 : 자리바꿈)
 *4. 위 결과를 담고 있는 배열을 출력하세요 (화면 출력)

 추후에는 별도의 클래스 분리해서 Lotto.java ..... 
 현재 main 함수 안에서 사용 ....연습...

조별 1개 입니다
  
 */
public class Lotto_groupwork {

    public static void main(String[] args) {

        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = (int) (Math.random() * 45 + 1);
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
//                    lotto[j] = (int) (Math.random() * 45 + 1);
                    i--;   // 다시 돌리기
                    break;
                }
            }
        }
        
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf(lotto[i] + " ");
         
        }
        System.out.println();
        
//        for (int i = 0; i < lotto.length; i++) {      //정렬이 되지만 불필요한 과정이 있음
//            for (int j = 0; j < lotto.length; j++) {
//                if (lotto[i] < lotto[j]) {
//                    int tmp = lotto[i];
//                    lotto[i] = lotto[j];
//                    lotto[j] = tmp;
//
//                }
//            }System.out.println(Arrays.toString(lotto));
//
//        }
        for (int i = 0; i < lotto.length; i++) {
            for (int j = i+1; j < lotto.length; j++) {
                if (lotto[i] > lotto[j]) {
                    int tmp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = tmp;
                    System.out.println(Arrays.toString(lotto));

                }
            }

        }
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf(lotto[i] + " ");
        }

    }

}
