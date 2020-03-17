import java.util.Stack;

import kr.or.bit.Coin;

public class Ex05_Stack_Collection {

    public static void main(String[] args) {
        //Stack 클래스(LIFO)는 Java가 제공
        //Stack 활용 > 웹브라우저 구현
        
        
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        System.out.println(stack.pop()); //B가 먼저 나옴
        System.out.println(stack.pop()); //그 다음 A가 나옴
        //System.out.println(stack.pop()); //예외 발생
        System.out.println(stack.isEmpty());  //비어있나 확인
        
        //동전박스
        Stack<Coin> coinbox = new Stack<Coin>();
        coinbox.push(new Coin(100));
        coinbox.push(new Coin(50));
        coinbox.push(new Coin(500));
        coinbox.push(new Coin(100));
        
        while(!coinbox.isEmpty()) {
            Coin coin = coinbox.pop();
            System.out.println("꺼낸 동전: "+ coin.getValue()+"원");
        }
        
        
        
        
        
        
        
        
        
        
        

    }

}
