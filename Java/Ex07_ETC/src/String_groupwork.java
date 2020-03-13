import java.util.Scanner;
//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ...
//main 함수 Scanner 사용 주민번호 입력받고
//앞:6자리 뒷:7자리
//입력값 : 123456-1234567 
//1. 자리수 체크 (기능)함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수
//3개의 함수 static 

public class String_groupwork {

    static String jumin = "";
    
    static Scanner sc = new Scanner(System.in);
    
    static void checkDigits() {
      
            do {
                System.out.println("주민번호를 입력하세요. 입력 예:123456-1234567");
                jumin = sc.nextLine();
                try {
                    if (jumin.length() == 14) {
                        break;
                    }else
                        throw new Exception("자릿수를 잘못 입력하였습니다. 다시 입력해 주세요.");
                        

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                  
                }
            } while (true);
            

        }
    static void checkGender() {
        do {
            
            try {
                if (1<=(jumin.charAt(7)-'0')&&(jumin.charAt(7)-'0')<=4) {
                    break;
                }else
                    throw new Exception("성별을 잘못 입력하셨습니다. 성별은 1~4 중에서 선택해 주세요. ");
                    

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("주민번호를 입력하세요. 입력 예:123456-1234567");
                jumin = sc.nextLine();
              
            }
        } while (true);

    }
    
    static void gender() {
        if(jumin.charAt(7)=='1'||jumin.charAt(7)=='3') {
            System.out.println("당신은 남자입니다.");
        }else {
            System.out.println("당신은 여자입니다.");
        }
          
    }
        



    public static void main(String[] args) {

    
        checkDigits();
        checkGender();
        System.out.println("주민번호: "+jumin);
        gender();
        


    }

}
