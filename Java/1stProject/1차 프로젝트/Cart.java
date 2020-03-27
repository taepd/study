import java.util.ArrayList;
 class Cart implements Manager{

	int count=0;
	int totalprice;
	ArrayList<Product> cartArray= new ArrayList<Product>();
	
//카트목록 보여주는.................
	public void show() {
		System.out.println(cartArray.toString());
		for(int i=0;i<cartArray.size();i++) {
		totalprice=cartArray.get((int)i).getPrice();
		}
		count = cartArray.size();
		System.out.println("총 물건의 개수는 " + count + "입니다.");
		System.out.println("총 가격은 " + totalprice + "입니다.");
	}
	
 //카트에 프로덕트 추가.
	public void add(Product product) {
		cartArray.add(product);
		count++;
	}

//카트에 프로덕트 삭제.
	public void remove(Product product) { 

		for(int i=0;i<cartArray.size();i++) {
		if(cartArray.get(i)==product) { //cart에 해당 product가 있으면 삭제한다.
			cartArray.remove(i);
			count--;
			totalprice-=cartArray.get(i).getPrice();
		}else {
			System.out.println("장바구니에 없는 상품입니다.");
			return;
		}
		} 	
		
	}
//**인터페이스 때문에 놔둔 애이고, parameter로 product 받는게 맞지않을까 해서 위에 오버로딩 시킴**
		public void add() {			
		}
		public void remove() {			
		}
		@Override
		public String toString() {
			return "Cart [cartArray=" + cartArray + "]";
		}		
}
