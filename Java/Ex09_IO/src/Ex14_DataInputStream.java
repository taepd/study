import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {

    public static void main(String[] args) {
        
        int sum=0;
        int score=0;
        FileInputStream fis = null;
        DataInputStream dis = null;
        
        try {
            fis = new FileInputStream("score.txt");
            dis = new DataInputStream(fis);
            while(true) {
                score = dis.readInt();
                System.out.println("score int 타입: "+score);
                sum+=score;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("예외 발생: "+e.getMessage());
            System.out.println("sum 결과: "+sum);   //예외가 나도 연산은 반영됨
        }finally {
            try {
                dis.close();
                fis.close();
            }catch (Exception e) {
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
