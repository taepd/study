import java.util.HashMap;

class CartManager implements Manager{
	CustomerManager customer = new CustomerManager();
	HashMap<String, Cart> cartManage = new HashMap<String, Cart>();
	
	
	public void add() {
		cartManage.put(customer.customerList.get(key),new Cart()); //새 카트 추가
	}
	public void remove() { //회원이 카트를 삭제하는 일은 없으니 remove는 없음...
		
	}
}