import java.util.ArrayList;


public class ProductsManager implements Manager{
 
	public static void main(String[] args) {

		ArrayList<Product> productsArray = new ArrayList();//상품products array
		
		productsArray.add(new Product("아이폰",210321,2000,10));
		productsArray.add(new Product("아이폰1",210321,2000,10));
		productsArray.add(new Product("아이폰2",210321,2000,10)); //product array에 product 추가.				
		
	}	
	
	//상품내역 보여주기
	public void productsList(ArrayList arraylist) {
		for(Object d: arraylist) { //product array를 보여주고 싶다.
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
	// ****어따쓸지 모르겠음****
	public void add() {
	}
	public void remove() {	
	}
	
}

class Product{
	private int price;
	private int pnumber;
	private int quantity;
	private String pname;
	Product(){}
	Product(String pname,int pnumber,int price,int quantity) {
		this.price = price;
		this.pname = pname;
		this.pnumber= pnumber;
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Product [price=" + price + ", pnumber=" + pnumber + ", quantity=" + quantity + ", pname=" + pname + "]";
	}
}
class Iphone extends Product{
	
}
class Macbook extends Product{
	
}
class Ipad extends Product{
	
}
