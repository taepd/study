/*
 * <오류>
 * 1. 에러(error): 네트워크 장애, 메모리, 하드웨어(개발자가 코드적으로 해결 불가능)
 * 2. 예외(Exception) : 개발자의 코드에 의해 발생 .. 코드 수정... 해결....
 *    문제: 예외가 발생하면 프로그램은 강제 종료...
 * 3. 예외처리하는 방법: 문제가 생기는 코드를 수정하는 것이 아니고 문제 발생시 비정적인 종료 막는 것
 *                   추후에 문제가 생기는 코드는 수정... 모든 상황을 대비 불가능 잠시 시간을 버는 것
*/

//  try {
//            //문제가 발생할 수 있는 코드(불안한 코드)
//            //만약에 문제가 생기면 catch 블럭으로 넘김
//            
//        } catch (Exception e) {
//             //문제가 생기면 catch하고 문제를 파악
//             //관리자에게 email
//             //로그파일 문제 원인 기록 
//             //강제 종료를 막아줌
//        }        
//        finally {
//            //문제가 발생하든, 발생하지 않든, 강제로 수행되어야 할 코드
//            //DB연결 닫기
//        }



public class Ex01_Exception {

    public static void main(String[] args) {
        
      System.out.println("Main Start");
          
     try {
         System.out.println(0/0);   //문제 발생 코드
    } catch (Exception e) {    //Exception도 클래스. 모든 예외들의 부모클래스 더 세부적인 자식클래스로 적어주면 더 좋다
        System.out.println(e.getMessage());
    }
      
      System.out.println("Main End");
        
        
        

    }

}
