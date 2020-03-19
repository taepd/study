package kr.or.bit;


//내가 직접 만드는 자료구조(스텍)
//저장공간: 기본적으로 Array : Object[] stackarr
//저장소 값들이 있는 위치 정보(index)
//기능: push, pop, empty(비어있는지 확인), full(꽉 채워졌는지 확인)


public class MyStack {
    
    private Object[] stackarr; //저장소
    private int maxsize; //최대 크기 강제
    private int top; //배열의 index값 으로 위치 정보
    
    public MyStack(int maxsize) {
        this.maxsize = maxsize;
        stackarr = new Object[maxsize];
        top = -1; //배열의 값이 정해지지 않았을 때 -1을 사용하면 좋다
    }
    
    public boolean isEmpty() {
//        if(top<=-1) return true;
//        else return false;
        return(top<=-1);   //이렇게 해도 작동한다. return 에도 값이 될 수 있는 식을 넣을 수 있다.
    }
    
    public boolean full() {
        if(top==maxsize-1)return true;
        else return false;
    }
    public void push(Object i) {
        //full로 검증하고 구현
        if(full()==false) {
            stackarr[top+1]=i;
            top++;
        }else {
            System.out.println("에러. 푸쉬할 수 없습니다.");
        }
    }
    
    public Object pop() {
        //isEmpty로 검증하고
        if(isEmpty()==false) {            
            return stackarr[top--];
        } else {
            System.out.println("에러 더 팝할게 없습니다.");
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        
        
        MyStack myStack = new MyStack(10);     
        
        System.out.println(myStack.isEmpty());
        
        myStack.push(1);
        
        System.out.println(myStack.isEmpty());
        
        System.out.println(myStack.pop());
        
       for (int i = 0; i < myStack.stackarr.length; i++) {
           myStack.push(i+1);
           System.out.println(myStack.stackarr[i]);
       }

       
      
       System.out.println(myStack.full());
       
       myStack.push(11);
       
       for(Object obj: myStack.stackarr) {
           myStack.pop();
       }

       
       System.out.println(myStack.isEmpty());
       
       myStack.pop();
       


        
        
        
        
    }
    
    
    
    
    
    
    
    

}
