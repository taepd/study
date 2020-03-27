import java.io.Serializable;

public class Product implements Serializable{
	private int pnumber;
	private int price;
	private String pname;
    private int quantity;
    private String kind;
	
        
    public Product(String pname, int pnumber, int price, int quantity, String kind) {
        this.pnumber = pnumber;
        this.price = price;
        this.pname = pname;
        this.quantity = quantity;
        this.kind = kind;
    }
    
//    public Product(String pname, int pnumber, int price, int quantity) {
//        this.pnumber = pnumber;
//        this.price = price;
//        this.pname = pname;
//        this.quantity = quantity;
//    }
    
    

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPnumber() {
        return pnumber;
    }

    public void setPnumber(int pnumber) {
        this.pnumber = pnumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Product [pname=" + pname + ", price=" + price + ", pnumber=" + pnumber + ", quantity=" + quantity
                + ", kind=" + kind + "]";
    }



}

//class IPhone extends Product {
//
//    public IPhone(String pname, int pnumber, int price, int quantity) {
//        super(pname, pnumber, price, quantity);
//        super.setKind("¾ÆÀÌÆù");
//    }
//    
//   
//}
//
//class MacBook extends Product {
//    public MacBook(String pname, int pnumber, int price, int quantity) {
//        super(pname, pnumber, price, quantity);
//        super.setKind("¸ÆºÏ");
//    }
//
//}
//
//class IPad extends Product {
//    public IPad(String pname, int pnumber, int price, int quantity) {
//        super(pname, pnumber, price, quantity);
//        super.setKind("¾ÆÀÌÆÐµå");
//    }
//
//}