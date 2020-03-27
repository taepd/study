import java.util.HashMap;
import java.util.Map;

class CartManager extends Cart implements Manager {
	//CustomerManager customer = new CustomerManager();

	HashMap<String, Cart> cartManager = new HashMap<String, Cart>();
	User user = new User();
	
	public void add() {
		cartManager.put(user.getId(),new Cart()); //user의 id마다, 새로운 카트 생성.
	}
	public void remove() { //회원이 카트 자체를 삭제하는 일은 없으니 remove는 없음...
		
	}
	
	
}

