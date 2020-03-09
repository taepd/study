
public class tmp {
    public static void main(String[] args) {
        
        int[] lotto= new int[6]; //배열   
        for(int i=0;i<lotto.length;i++) {
         int random =(int)(Math.random()*45 + 1); //난수생성.   
         lotto[i]=random; //난수를 배열에 하나씩 집어넣음.  
         if(i>=1) {
            if(lotto[i]!=lotto[i-1]) {
                if(lotto[i]<lotto[i-1]) {
                    lotto[i-1]=lotto[i];
                }
                else break;
            }  
         } System.out.println(lotto[i]); 
        }
        
    }
}
