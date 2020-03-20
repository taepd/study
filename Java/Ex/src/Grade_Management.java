
    import java.util.*;

    class Grade_Management { 
       static ArrayList record = new ArrayList();  //List 생성
       static Scanner s = new Scanner(System.in);

       public static void main(String args[]) { 
          while(true) { 
             switch(displayMenu()) { 
                case 1 : 
                   inputRecord(); 
                   break; 
                case 2 : 
                   deleteRecord(); 
                   break; 
                case 3 : 
                   sortRecord(); 
                   break; 
                case 4 : 
                   System.out.println("프로그램을 종료합니다."); 
                   System.exit(0); 
             } 
          } // while(true) 
       }

       // menu를 보여주는 메서드 
       static int displayMenu(){ 
          System.out.println("**************************************************"); 
          System.out.println("*                성적 관리 프로그램                                      *"); 
          System.out.println("*                   version 1.0                  *"); 
          System.out.println("*             excerpt from Java의 정석                          *"); 
          System.out.println("**************************************************"); 
          System.out.println(); 
          System.out.println(); 
          System.out.println(" 1. 학생성적 입력하기 "); 
          System.out.println(); 
          System.out.println(" 2. 학생성적 삭제하기 "); 
          System.out.println(); 
          System.out.println(" 3. 학생성적 정렬하여보기(이름순, 성적순) "); 
          System.out.println(); 
          System.out.println(" 4. 프로그램 종료 "); 
          System.out.println(); 
          System.out.println(); 
          System.out.print("원하는 메뉴를 선택하세요.(1~4) : ");

          int menu = 0;

          do { 
             try { 
                menu = Integer.parseInt(s.nextLine()); //입력받은 문자열을 숫자로 변환

                if(menu >= 1 && menu <= 4) { 
                   break; 
                } else { 
                   throw new Exception(); 
                } 
             } catch(Exception e) { //1~4를 제외하고 예외처리
                System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요."); 
                System.out.print("원하는 메뉴를 선택하세요.(1~4) : "); 
             } 
          } while(true);

          return menu; 
       } // public static int displayMenu(){

       // 데이터를 입력받는 메서드 
       static void inputRecord() { 
          System.out.println("1. 학생성적 입력하기"); 
       System.out.println("이름,학번,국어성적,영어성적,수학성적'의 순서로 공백없이 입력하세요."); 
          System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");

          while(true) { 
             System.out.print(">>");

             do { 
                try { 
                   String input = s.nextLine().trim(); //입력받은 s를 공백제거 후 input값으로 넣음

                   if(!input.equalsIgnoreCase("q")) {  //input값의 대소문자 구분없이 q가 아닐때, if문 실행
                      Scanner s2 = new Scanner(input).useDelimiter(","); //입력받은 문자열을 ','로 구분하여 문자열 반환

                      record.add(new Student2(s2.next(), s2.next(), s2.nextInt()
                                   , s2.nextInt(), s2.nextInt())); //List에 입력값을 Student2클래스 형태로 추가
                      System.out.println("잘입력되었습니다. 입력을 마치려면 q를 입력하세요."); 
                      break; 
                   } else { 
                      return;                         
                   } 
                } catch(Exception e) { //예외처리
                   System.out.println("입력오류입니다. 이름, 학번, 국어성적, 영어성적, 수학성적'의 순서로 입력하세요."); 
                   break; 
                } 
             } while(true); 
          } // do-while(true) 
       } // public static void inputRecord() {

       // 데이터를 삭제하는 메서드 
       static void deleteRecord() { 
          while(true) { 
             displayRecord(); 
             System.out.println("삭제하고자 하는 데이터의 학번을 입력하세요.(q:메인화면)"); 
             System.out.print(">>");

             do { 
                try { 
                   String input = s.nextLine().trim(); //입력받은 s를 공백제거 후 input값으로 넣음

                   if(!input.equalsIgnoreCase("q")) {  //input값의 대소문자 구분없이 q가 아닐때, if문 실행
                      int length = record.size();    //record(List)의 사이즈를 가져 옴 
                      boolean found = false;

                      for(int i=0; i < length; i++) {  //레코드의 길이만큼 for문을 실행
                         Student2 student = (Student2)record.get(i);  //저장된 List에서 학생정보를 가져옴
                         if(input.equals(student.studentNo)) {  //삭제하고자 하는 학번의 입력값과 List에서 가져온 학생 데이터의 학번을 비교
                            found = true;  //같으면 found값을 true로
                            record.remove(i);  //List에서 해당 학번의 데이터를 삭제
                            break; 
                         } 
                      } // for(int i=0; i < length; i++) {

                      if(found) {  //found가 true일 때
                         System.out.println("삭제되었습니다."); 
                      } else { 
                         System.out.println("일치하는 데이터가 없습니다."); 
                      } 
                      break; 
                   } else { 
                      return;                         
                   } 
                } catch(Exception e) {  //예외처리
                   System.out.println("입력오류입니다. 다시 입력해 주세요."); 
                   break; 
                } 
             } while(true); 
          } // do-while(true) 
       } // public static void deleteRecord() {

       // 데이터를 정렬하는 메서드       
       static void sortRecord() { 
          while(true) { 
             System.out.print(" 정렬기준을 선탁하세요.(1:이름순 2:총점순 3:메인메뉴) : ");

             int sort = 0;

             do { 
                try { 
                   sort = Integer.parseInt(s.nextLine()); //입력받은 문자열을 숫자로 변환하여 sort변수값으로

                   if(sort >= 1 && sort <= 3) { 
                      break; 
                   } else { //1~3이 아닐 때 예외처리
                      throw new Exception(); 
                   } 
                } catch(Exception e) { 
                   System.out.println("유효하지 않은 입력값입니다. 다시 입력해주세요."); 
                   System.out.print(" 정렬기준을 선탁하세요.(1:이름순 2:총점순 3:메인메뉴) : "); 
                } 
             } while(true);

             if(sort==1) {
             //Collections.sort(List, Comparator)->Comparator가 가리키는 순서에 따라 List를 정렬
                Collections.sort(record, new NameAscending()); //이름순으로 정렬
                displayRecord(); 
             } else if(sort==2) { 
                Collections.sort(record, new TotalDescending()); //총점순으로 정렬
                displayRecord(); 
             } else { 
                return;             
             } 
          } // while(true) 
       }

       // 데이터 목록을 보여주는 메서드 
       static void displayRecord() { 
          int koreanTotal = 0; 
          int englishTotal = 0; 
          int mathTotal = 0; 
          int total = 0;

          System.out.println(); 
          System.out.println("이름 번호 국어 영어 수학 총점 "); 
          System.out.println("======================================");

          int length = record.size();

          if(length > 0) { 
             for (int i = 0; i < length ; i++) { 
                Student2 student = (Student2)record.get(i); 
                System.out.println(student); 
                koreanTotal += student.koreanScore; 
                mathTotal += student.mathScore; 
                englishTotal += student.englishScore; 
                total += student.total; 
             } 
          } else { 
             System.out.println(); 
             System.out.println(" 데이터가 없습니다."); 
             System.out.println(); 
          }

          System.out.println("======================================"); 
          System.out.println("총점: " 
             + Student2.format(koreanTotal+"", 11, Student2.RIGHT) 
             + Student2.format(englishTotal+"", 6, Student2.RIGHT) 
             + Student2.format(mathTotal+"", 6, Student2.RIGHT) 
             + Student2.format(total+"", 8, Student2.RIGHT) 
          ); 
          System.out.println(); 
       } // static void displayRecord() { 
    } // end of class

    // 이름을 오름차순(가나다순)으로 정렬하는 데 사용되는 클래스 
    class NameAscending implements Comparator { 
       public int compare(Object o1, Object o2){ //순서 비교를 위한 인수 비교
          if(o1 instanceof Student2 && o2 instanceof Student2){ //o1과 o2의 참조변수가 Student2 클래스타입으로 형변환이 가능하다면 if문 실행
             Student2 s1 = (Student2)o1;  //o1의 참조변수를 Student2 클래스타입으로 형변환 하여 s1으로 저장
             Student2 s2 = (Student2)o2;

             return (s1.name).compareTo(s2.name);  //s1.name과 s2.name의 비교값 리턴
          } 
          return -1; 
       } 
    }

    // 총점을 내림차순(큰값에서 작은값)으로 정렬하는 데 사용되는 클래스 
    class TotalDescending implements Comparator { 
       public int compare(Object o1, Object o2){ 
          if(o1 instanceof Student2 && o2 instanceof Student2){ 
             Student2 s1 = (Student2)o1; 
             Student2 s2 = (Student2)o2;

             return (s1.total < s2.total)? 1 : (s1.total == s2.total ? 0 : -1);
             //s2의 total값이 크다가 true일 때 1, false일 때 s1과s2값 비교 후 같으면 0, 다르면 -1 리턴
          } 
          return -1; 
       } 
    }

    class Student2 implements Comparable {  //Student2 클래스 선언
       final static int LEFT = 0;   //클래스변수, 인스턴스들간의 공유변수
       final static int CENTER = 1; 
       final static int RIGHT = 2;

       String name = "";   //인스턴스 변수, 초기화
       String studentNo = ""; 
       int koreanScore = 0;
       int mathScore = 0; 
       int englishScore = 0; 
       int total = 0;

       Student2(String name, String studentNo, int koreanScore, int mathScore, int englishScore) { //생성자
          this.name = name; 
          this.studentNo = studentNo; 
          this.koreanScore = koreanScore; 
          this.mathScore = mathScore; 
          this.englishScore = englishScore; 
          total = koreanScore + mathScore + englishScore; 
       }

       public String toString() { 
          return format(name, 4, LEFT) 
             + format(studentNo, 4, RIGHT) 
             + format(""+koreanScore,6, RIGHT) 
             + format(""+mathScore,6, RIGHT) 
             + format(""+englishScore, 6, RIGHT) 
             + format(""+total,8, RIGHT); 
       }

       static String format(String str, int length, int alignment) { 
          int diff = length - str.length();  //매개변수로 받은 length값에 String의 길이를 뺀 변수 diff 선언 
          if(diff < 0) return str.substring(0, length);  //diff가 0보다 작으면 str의 index 0부터  length-1까지 리턴

          char[] source = str.toCharArray();  //str의 문자열을 분해하여 source배열에 삽입
          char[] result = new char[length];  //매개변수로 받은 length의 배열 생성

          // 배열 result를 공백으로 채운다. 
          for(int i=0; i < result.length; i++) 
             result[i] = ' ';

          switch(alignment) {  //정렬방식 선택
             case CENTER :   //가운데 정렬
                System.arraycopy(source, 0, result, diff/2, source.length); 
                break; 
             case RIGHT :   //오른쪽 정렬
                System.arraycopy(source, 0, result, diff, source.length); 
                break; 
             case LEFT :  //왼쪽정렬
             default : 
                System.arraycopy(source, 0, result, 0, source.length); 
          } 
          return new String(result); 
       } // static String format(String str, int length, int alignment) {

       public int compareTo(Object obj) { 
          int result = -1; 
          if(obj instanceof Student2) {  //참조변수 obj를 Student2 클래스타입으로 형변환이 가능하면 if문 실행
             Student2 tmp = (Student2)obj;  //obj를 tmp에 저장
             result = (this.name).compareTo(tmp.name); //문자열 비교 후 같으면 0, 다르면 아스키코드의 차이값 반환
          } 
          return result; 
       } 
    } // class Student2 implements Comparable {


