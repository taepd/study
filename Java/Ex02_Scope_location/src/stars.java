import java.util.Scanner;

public class stars {
    
    public static void main(String[] args) {
     //백준 별찍기 1   
//     Scanner sc = new Scanner(System.in);    
//     int n = Integer.parseInt(sc.nextLine());
//     
//     for(int i=1;i<=n;i++) {
//         for(int j=1;j<=i;j++) {
//             System.out.print("*");
//         }System.out.println();
//     }
     //별찍기 2
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=(n-i);j++) {
//                System.out.print(" ");
//            }for(int j=1;j<=i;j++) {
//                System.out.print("*");
//            }System.out.println(); 
//        }
     //별찍기 3번
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     for(int i=0;i<n;i++) {
//         for(int j=1;j<=(n-i);j++) {   //i만큼 별수가 줄어듬
//             System.out.print("*");
//         }System.out.println();
//     }
      //별찍기 4번
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=0;i<n;i++) {
//            for(int j=1;j<=i;j++) {  //공백을 i개만큼 추가
//                System.out.print(" ");
//            }for(int j=1;j<=(n-i);j++) {
//                System.out.print("*"); //별을 n-i개만큼 추가
//            }System.out.println();   //줄바꿈
//        }
    //별찍기 5번
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++) { //공백을 n-i개만큼 추가
                System.out.print(" ");
            }for(int j=1;j<=2*i-1;j++) { //별을 2i-1개만큼 추가
                System.out.print("*");
            }System.out.println(); //줄바꿈
        }
    //별찍기 6번
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for(int i=1;i<=n;i++) {  
          for(int j=1;j<i;j++) {  //공백 i-1개 입력
              System.out.print(" ");
          }for(int j=1;j<=2*(n-i)+1;j++) { //별 2*(n-i)+1개 입력
               System.out.print("*");
          }System.out.println(); //줄바꿈
      }
     //별찍기 7번
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt(); 
     for(int i=1;i<=2*n-1;i++) {    //전체 줄 수 
         if(i<=n) {                 //상단부
           for(int j=1;j<=n-i;j++) {   //공백 
               System.out.print(" ");
           }for(int j=1;j<=2*i-1;j++) {
               System.out.print("*");  // 별
           }System.out.println();     
         }else {                     //하단부
        	 for(int j=1;j<=i-n;j++) { //공백
        		 System.out.print(" ");
        	 }
             for(int j=1;j<=2*(2*n-i)-1;j++) { //별
            	 System.out.print("*");
             }System.out.println();
           }
     }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
