import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Payment {
		//방법1
		HashMap<String, Cart> cartManager = new HashMap<String, Cart>();
		User user = new User();
		//방법2
		CartManager cartManager1 = new CartManager();

		//user의 cart에 있는 것 
		public void order() {
			//방법1
			Map<String, Cart> map = (Map<String, Cart>) cartManager.get(user.getId());
			for(int i=0;i<map.size();i++) {
		     map.get(i); //cart에 i번째 있는 product를 의미.
			}
			//방법2
			cartManager1.show(); //카트목록보여줌.
		}
		public void pay() {

			save(); // paymentDB에 저장.
		}
		 private void save() {
		        File file = new File("PaymentDB.txt");
		        
		        try{
		            FileOutputStream fos = new FileOutputStream(file);
		            BufferedOutputStream bos = new BufferedOutputStream(fos);
		            ObjectOutputStream oos = new ObjectOutputStream(bos);  //직렬화 저장을 위한 보조스트림
		            
		            oos.writeObject(cartManager.get(user.getId())); 
		                                        // writeObject 메서드를 이용해서 직렬화 저장
		            oos.close();
		            bos.close();
		            fos.close();
		        }catch(Exception e){
		            System.out.println("에러발생!!!");
		            e.printStackTrace();
		        }
		        System.out.println("저장되었습니다.");
		    }
		    //I/O를 위한 역직렬화 로드
		    void load() {
		        File file = new File("PaymentDB.txt");
		        try{
		            FileInputStream fis = new FileInputStream(file);
		            BufferedInputStream bis = new BufferedInputStream(fis);
		            ObjectInputStream oos = new ObjectInputStream(bis); //역직렬화를 위한 보조스트림
		            
		            cartManager = (HashMap)oos.readObject(); //readObject메서드를 이용해서 역직렬화
		                                                  //리턴값이 Object이므로 다운캐스팅           
		            oos.close();
		            bis.close();
		            fis.close();
		            
		        }catch(Exception e){
		            System.out.println("불러오는데 실패하였습니다.");
		            e.printStackTrace();
		        }
		    }
			
}