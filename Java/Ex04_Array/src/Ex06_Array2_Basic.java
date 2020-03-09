import kr.or.bit.Emp;

public class Ex06_Array2_Basic {

    public static void main(String[] args) {
        
        //2차원(행과 열)
        //[행][열]
        int[][] score = new int[3][2];
        System.out.println(score[0][0]);
        
        score[0][0]=100;
        score[0][1]=200;
        
        score[1][0]=300;
        score[1][1]=400;
        
        score[2][0]=500;
        score[2][1]=600;
        
        //행의 수, 열의 수
        
        //행의 갯수: 배열이름.length >score.length
        
        //열의 갯수: 배열이름[i].length >score[i].length
        //배열이름[0].length >> 0행의 열의 갯수
        
        for(int i=0; i<score.length;i++) {
            for(int j=0;j<score[i].length;j++) {
                System.out.printf("score[%d][%d]=%d\t",i,j,score[i][j]);
                
            }System.out.println();
        }
        
        //Today Point^^
        //개선된 for문, 향상된 for문
        //Java: for(Type 변수명: 배열 or Collection) {실행구문}
        //C# : for(Type 변수명 in 배열 or Collection) {실행구문}
        //JavaScript : for(Type 변수명 in 배열 or Collection) {실행구문}
        
        int[] arr3= {5,6,7,8,9};
//        for(int i=0;i<arr3.length;i++) {
//            System.out.println(arr3[i]);
//        }
        for(int val : arr3) {
            System.out.println(val);
        }
        
        String[] strarr = {"A","B","C","D","FFFF"};
        for(String val : strarr) {
            System.out.println(val);
        }
        
        Emp[] list = {new Emp(1,"A"),new Emp(2,"B"), new Emp(3,"C")};
        //개선된 for문을 사용해서 사번, 이름 출력
        for(Emp val: list) {
            val.empInfoPrint();
        }
        
        //모닝 커피 퀴즈(3분)
        int[][] score3 = new int[][] {
            {11,12},
            {13,14},
            {15,16}
        };
        
        //개선된 for문을 사용해서 배열값 출력
        for( int[] val: score3) {
            for(int val2: val) {
                System.out.print(val2+" ");
            }System.out.println();           
        }
               
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
