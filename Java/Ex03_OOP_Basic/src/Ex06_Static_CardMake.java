import kr.or.bit.Card;

public class Ex06_Static_CardMake {

    public static void main(String[] args) {
       
       
        Card c = new Card();
        c.number=1;
        c.kind="heart";
        c.h=70;
        c.w=50;
        c.cardInfo();
        
        Card c2 = new Card();
        c2.number=2;
        c2.kind="heart";
        c2.cardInfo();
      
        
        
        //53개 제작했는데
        //고객 요구 사항: 크기가 이게 아닌데요
        //h=70, w=50
        //설계도를 다시 변경...
        //53장을 다시 제작...

    }

}
