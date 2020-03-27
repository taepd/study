import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class TransactionManager implements Manager, Serializable{
    
        
    static HashMap<String, ArrayList> transactionList = new HashMap<String, ArrayList>();

    @Override
    public void add() {
      
    }
    @Override
    public void remove() {
    }
    
    
    
    
    
  @Override
    public String toString() {
        return "TransactionManager [transactionList=" + transactionList + "]";
    }
    
   //I/O를 위한 직렬화 저장
    public void save() {
        File file = new File("TransactionDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //직렬화 저장을 위한 보조스트림
            
            oos.writeObject(transactionList); 
                                        // writeObject 메서드를 이용해서 직렬화 저장
            oos.close();
            bos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("에러발생!!!");
            e.printStackTrace();
        }
    }
    //I/O를 위한 역직렬화 로드
    public void load() {
        File file = new File("TransactionDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis); //역직렬화를 위한 보조스트림
            
            transactionList = (HashMap)ois.readObject(); //readObject메서드를 이용해서 역직렬화
                                                  //리턴값이 Object이므로 다운캐스팅
            
            ois.close();
            bis.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }

    

}
