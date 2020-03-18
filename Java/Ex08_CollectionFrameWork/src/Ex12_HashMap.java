import java.util.HashMap;
import java.util.Scanner;

public class Ex12_HashMap {

    public static void main(String[] args) {
        //일상 생활에서 (회원가입 >> 로그인 >> id, pwd)
        HashMap loginmap = new HashMap();
        loginmap.put("kim", "kim1004");
        loginmap.put("scott","tiger");
        loginmap.put("lee", "kim1004");
        //우리 시스템 가입된 회원 정보(id, pwd)
        //id(o), pwd(o) 회원(환영)
        //id(o), pwd(x) 실패(비밀번호 입력)
        
        
        //id(x), pwd(o)
        //id(x), pwd(x)
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("ID, PWD 입력해 주세요");
            System.out.println("ID");
            String id = sc.nextLine().trim().toLowerCase();
            
            System.out.println("PWD");
            String pwd = sc.nextLine().trim();
            
            if(!loginmap.containsKey(id)) {  //id검증
                System.out.println("ID 틀려요.. 재입력 하세요");
            }else {
                //ID(o)
                //비번만 검증
                if(loginmap.get(id).equals(pwd)) {
                    System.out.println("회원님 방가방가^^");
                    break;
                }else {
                    System.out.println("비번을 확인하세요");
                }
            }
        }
        
        
        
        
        
    }

}
