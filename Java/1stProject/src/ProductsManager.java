import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class ProductsManager implements Manager{
    
    ArrayList<Product> productsArray = new ArrayList<Product>();//상품products array
    
    
	//상품내역 보여주기
	public void productsList() {
		for(Object d: productsArray) { //product array를 보여주고 싶다.
		System.out.println(d);
		}
	}	
	//구매내역 ********user 클래스 필요*******
	public void buyHistory() {
	
		}
	//구매자 정보불러오기 ******user 클래스 필요*****
	public void userInfo() {
		
	}
	//수량변경
	public void changeQuantity(Product product,int num) {
		product.setQuantity(num);
		System.out.println(product.getPname()+"의 수량을"+num+"으로 변경하였습니다.");
	}	
	public void add() {};

	public void add(String pname, int pnumber, int price, int quantity, String kind) {
	    productsArray.add(new Product(pname, pnumber, price, quantity, kind)); //product array에 product 추가. 
	    save();
	}
	public void remove() {	
	}
	
    //I/O를 위한 직렬화 저장
    private void save() {
        File file = new File("ProductDB.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);  //직렬화 저장을 위한 보조스트림
            
            oos.writeObject(productsArray); 
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
        File file = new File("ProductDB.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream oos = new ObjectInputStream(bis); //역직렬화를 위한 보조스트림
            
            productsArray = (ArrayList)oos.readObject(); //readObject메서드를 이용해서 역직렬화
                                                  //리턴값이 Object이므로 다운캐스팅
            
            oos.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }
	
}


