import java.util.Scanner;
import java.awt.font.TextLayout.CaretPolicy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public class Mall {

    Scanner sc = new Scanner(System.in);
    CustomerManager customerManager = new CustomerManager();
    ProductsManager productsManager = new ProductsManager();
    CartManager cartManager = new CartManager();
    TransactionManager transactionManager = new TransactionManager();
    Admin admin = new Admin();
    static String id;
    Mall() {

        File file = new File("CustomerDB.txt");
        File file2 = new File("ProductDB.txt");
        File file3 = new File("CartDB.txt");
        File file4 = new File("TransactionDB.txt");
        
        if (file.exists()) {
            customerManager.load();
        } else {
            // customerList ÆÄÀÏ »ı¼º
            try {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos); // Á÷·ÄÈ­ ÀúÀåÀ» À§ÇÑ º¸Á¶½ºÆ®¸²

                CustomerManager.customerList.put(admin.getId(), admin);
                oos.writeObject(CustomerManager.customerList); 
                // writeObject ¸Ş¼­µå¸¦ ÀÌ¿ëÇØ¼­ Á÷·ÄÈ­ ÀúÀå
                oos.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("¿¡·¯¹ß»ı!!!");
                e.printStackTrace();
            }
        }
        if (file2.exists()) {
            productsManager.load();
        } else {
            // productsArray ÆÄÀÏ »ı¼º
            try {
                FileOutputStream fos = new FileOutputStream(file2);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos); // Á÷·ÄÈ­ ÀúÀåÀ» À§ÇÑ º¸Á¶½ºÆ®¸²

                oos.writeObject(productsManager.productList);
                // writeObject ¸Ş¼­µå¸¦ ÀÌ¿ëÇØ¼­ Á÷·ÄÈ­ ÀúÀå
                oos.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("¿¡·¯¹ß»ı!!!");
                e.printStackTrace();
            }
        }
        
        if (file3.exists()) {
            cartManager.load();
        } else {
            // productsArray ÆÄÀÏ »ı¼º
            try {
                FileOutputStream fos = new FileOutputStream(file3);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos); // Á÷·ÄÈ­ ÀúÀåÀ» À§ÇÑ º¸Á¶½ºÆ®¸²

                oos.writeObject(cartManager.cartList);
                // writeObject ¸Ş¼­µå¸¦ ÀÌ¿ëÇØ¼­ Á÷·ÄÈ­ ÀúÀå
                oos.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("¿¡·¯¹ß»ı!!!");
                e.printStackTrace();
            }
        }
        
        if (file4.exists()) {
            transactionManager.load();
        } else {

            try {
                FileOutputStream fos = new FileOutputStream(file4);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos); // Á÷·ÄÈ­ ÀúÀåÀ» À§ÇÑ º¸Á¶½ºÆ®¸²

                oos.writeObject(transactionManager.transactionList);
                // writeObject ¸Ş¼­µå¸¦ ÀÌ¿ëÇØ¼­ Á÷·ÄÈ­ ÀúÀå
                oos.close();
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("¿¡·¯¹ß»ı!!!");
                e.printStackTrace();
            }
        }

    }

    void mallMain() {
        while (true) {
            switch (mallMainMenu()) {
            case 1: {
                this.signIn();

                break;
            }
            case 2: {
                this.signUp();
                break;
            }
            case 3: {
                System.exit(0);
            }

            }

        }
    }
    
    // ÃÊ±â ¸Ş´º
    int mallMainMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("***************************");
                System.out.println("*******VIP ¾ÖÇÃ½ºÅä¾î*******");
                System.out.println("***************************");
                System.out.println("1. ·Î±×ÀÎ");
                System.out.println();
                System.out.println("2. È¸¿ø °¡ÀÔ");
                System.out.println();
                System.out.println("3. ½Ã½ºÅÛ Á¾·á");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 3) {
                    return menu;
                } else {
                    throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<ÀÔ·Â ¿À·ù>");
                System.out.println("1~3¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
            }
        } while (true);

    }

    // È¸¿ø°¡ÀÔ
    void signUp() {
        System.out.println("È¸¿ø °¡ÀÔ");
        String pwd, name, tel, address;
        
        //ID ÀÔ·Â 
        while(true) {
        System.out.println("ID¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. (5~20ÀÚ. ¿µ¾î ´ë¼Ò¹®ÀÚ, ¼ıÀÚ, _ ¸¸ »ç¿ë°¡´É)");
        String regExpaa = "^[a-zA-Z0-9_]{5,20}+$";      
        id = sc.nextLine();
        boolean b = id.matches(regExpaa); // true ,false
        
            if (b == true) { 
                if(CustomerManager.customerList.containsKey(id)) {
                    System.out.println("ÀÌ¹Ì Á¸ÀçÇÏ´Â IDÀÔ´Ï´Ù.");
                }else {
                    break;
                }

            }else {
            System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
            }
        }
        
        //ºñ¹Ğ¹øÈ£ ÀÔ·Â
        while(true) {
            System.out.println("ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. (8~20ÀÚ.Àû¾îµµ ÇÏ³ªÀÇ ¿µ¾î´ë¹®ÀÚ ¼Ò¹®ÀÚ,¼ıÀÚ,Æ¯¼ö¹®ÀÚ°¡ °¢°¢ Æ÷ÇÔµÇ¾î¾ß ÇÔ)");
            String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";;
            
            pwd = sc.nextLine();
            
            boolean b = pwd.matches(regExp); // true ,false
            
                if (b == true) {            
                break;
                }else {
                System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
                }
            }
      //ÀÌ¸§ ÀÔ·Â
        while(true) {
            //ID ÀÔ·Â 
            System.out.println("ÀÌ¸§À» ÀÔ·ÂÇØÁÖ¼¼¿ä. (ÇÑ±Û¸¸ »ç¿ë°¡´É)");
            String regExp = "^[¤¡-¤¾°¡-ÆR]+$";
            
            name = sc.nextLine();
            
            boolean b = name.matches(regExp); // true ,false
            
                if (b == true) {            
                break;
                }else {
                System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
                }
            }
        
      //ÈŞ´ëÆù ¹øÈ£ ÀÔ·Â
        while(true) {
            //ID ÀÔ·Â 
            System.out.println("ÈŞ´ëÆù ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. ex) 010-123(4)-1234)");
            String regExp = "(01[01679]{1})-(\\d{3,4})-(\\d{4})";
            
            tel = sc.nextLine();
            
            boolean b = tel.matches(regExp); // true ,false
            
                if (b == true) {            
                break;
                }else {
                System.out.println("Çü½ÄÀÌ Àß¸øµÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
                }
            }
        
      //¹è¼ÛÁö ÁÖ¼Ò ÀÔ·Â
        System.out.println("¹è¼ÛÁö ÁÖ¼Ò¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
        address = sc.nextLine();
        
        customerManager.signUp(id, pwd, name, tel, address); // ¸¸µé¾îÁø customer °´Ã¼¸¦ ¸®ÅÏ
    } // È¸¿ø°¡ÀÔ ¸¶Ä¡¸é ·Î±×ÀÎ ÀÌÈÄ È­¸éÀ¸·Î ÁøÀÔÇØ¾ß ÇÑ´Ù

  
    // ·Î±×ÀÎ
    void signIn() {

        System.out.println("**·Î±×ÀÎ**");
        System.out.println("ID¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");   
        id = sc.nextLine();
        System.out.println("ºñ¹Ğ¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
        String pwd = sc.nextLine();
        if (admin.getId().equals(id) && admin.getPwd().equals(pwd)) {
            System.out.println("°ü¸®ÀÚ ·Î±×ÀÎ");
            admin();

        } else if (customerManager.signIn(id, pwd) != null) {
            customer();

        } else {
            System.out.println("ÀÏÄ¡ÇÏ´Â Á¤º¸°¡ ¾ø½À´Ï´Ù.");
        }
    }

    void customer() {

        while (true) {
            switch (this.customerMenu()) {
            case 1: {
                System.out.println("**»óÇ°Á¶È¸**");
                productsManager.productList();
                addCart();
                break;
            }
            case 2: {
                System.out.println("**Àå¹Ù±¸´Ï**");
                cart();
                break;
            }
            case 3: {
                System.out.println("**¸¶ÀÌÆäÀÌÁö**");
                myPage();

                break;
            }

            case 4: {
                return; // returnÇÏ¸é ÇØ´çÇÏ´Â °¡Àå »óÀ§ ¸Ş¼­µå ºí·° Å»Ãâ
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }
    
    // °í°´ ¸Ş´º È­¸é
    int customerMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****°í°´ ¸Ş´º*****");
                System.out.println("*********************************");
                System.out.println("1. »óÇ° ¸ñ·Ï Á¶È¸");
                System.out.println();
                System.out.println("2. Àå¹Ù±¸´Ï");
                System.out.println();
                System.out.println("3. ¸¶ÀÌÆäÀÌÁö");
                System.out.println();
                System.out.println("4. ÀÌÀü ¸Ş´º·Î");
                System.out.println();
                System.out.println("5. ½Ã½ºÅÛ Á¾·á");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 5) {
                    return menu;
                } else {
                    throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<ÀÔ·Â ¿À·ù>");
                System.out.println("1~5¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
            }
        } while (true);

    }
    
    //°ü¸®ÀÚ ÇÁ·Î±×·¥
    void admin() {

        while (true) {
            switch (this.adminMenu()) {
            case 1: {
                productsManager.productList();

                break;
            }
            case 2: {                
                productsManager.add();
                break;
            }
            case 3: {
                System.out.println("**»óÇ° »èÁ¦**");
                productsManager.remove();
                break;
            }
            case 4: {
                System.out.println("**»óÇ° Àç°í º¯°æ**");
                productsManager.changeQuantity();
                break;
            }
            case 5: {
                System.out.println("**È¸¿ø ¸ñ·Ï Á¶È¸**");
                customerManager.userList();
                break;
            }

            case 6: {
                System.out.println("*ÆÇ¸Å ³»¿ª Á¶È¸");
                lookup();
                break;
            }
            case 7: {
                return; // returnÇÏ¸é ÇØ´çÇÏ´Â °¡Àå »óÀ§ ¸Ş¼­µå ºí·° Å»Ãâ
            }
            case 8: {
                System.exit(0);
            }

            }

        }

    }
    
    // °ü¸®ÀÚ ¸Ş´º È­¸é
    int adminMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("******     °ü¸®ÀÚ ¸Ş´º           ********");
                System.out.println("*********************************");
                System.out.println("1. »óÇ° ¸ñ·Ï Á¶È¸");
                System.out.println();
                System.out.println("2. »óÇ° Ãß°¡");
                System.out.println();
                System.out.println("3. »óÇ° »èÁ¦");
                System.out.println();
                System.out.println("4. »óÇ° Àç°í º¯°æ");
                System.out.println();
                System.out.println("5. È¸¿ø Á¤º¸ Á¶È¸");
                System.out.println();
                System.out.println("6. ÆÇ¸Å ³»¿ª Á¶È¸");
                System.out.println();
                System.out.println("7. ÀÌÀü ¸Ş´º·Î");
                System.out.println();
                System.out.println("8. ½Ã½ºÅÛ Á¾·á");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 8) {
                    return menu;
                } else {
                    throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<ÀÔ·Â ¿À·ù>");
                System.out.println("1~8¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
            }
        } while (true);

    }
    
    void lookup() {     
        while (true) {        
            switch (lookUpMenu()) {
            case 1: {
                customerManager.userTransactionList();
            return;
            }
            case 2: {
            System.out.println("È¸¿ø ¾ÆÀÌµğ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
            String userId = sc.nextLine();
            if(customerManager.customerList.containsKey(userId)) {
            customerManager.userTransactionHistory(userId);
            return;
            }
            else {
                System.out.println("ÀÏÄ¡ÇÏ´Â È¸¿øÀÌ ¾ø½À´Ï´Ù.");
                return;
            }
            }    
            case 3: {
                return; // returnÇÏ¸é ÇØ´çÇÏ´Â °¡Àå »óÀ§ ¸Ş¼­µå ºí·° Å»Ãâ
            }
            }
        }
    }
 int lookUpMenu() {
     int menu = 0;
     do {
         try {
             System.out.println("1.¸ğµç È¸¿ø ±¸¸Å ³»¿ª");
             System.out.println();
             System.out.println("2.È¸¿ø ±¸¸Å ³»¿ª"); 
             System.out.println();
             System.out.println("3. ÀÌÀü ¸Ş´º·Î");
             System.out.println();
             menu = Integer.parseInt(sc.nextLine());
             if (1 <= menu && menu <= 3) {
                 return menu;
             } else {
                 throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println("<ÀÔ·Â ¿À·ù>");
             System.out.println("1~3¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
         }
     } while (true);

 }
        
    void addCart() {
        
        while (true) {
            switch (this.addCartMenu()) {
            case 1: {
                System.out.println("Àå¹Ù±¸´Ï¿¡ »óÇ° Ãß°¡");
                productsManager.productList();
                cartManager.add();    
                break;
            }
            case 2: {
                System.out.println("**Àå¹Ù±¸´Ï**");
                cart();
                break;
            }
            case 3: {
                return; // returnÇÏ¸é ÇØ´çÇÏ´Â °¡Àå »óÀ§ ¸Ş¼­µå ºí·° Å»Ãâ
            }
            case 4: {
                System.exit(0);
            }

            }
        }

    }
    

    // »óÇ° Á¶È¸ ÆäÀÌÁö ¸Ş´º È­¸é
    int addCartMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.printf("1. Àå¹Ù±¸´Ï¿¡ »óÇ° Ãß°¡    2.Àå¹Ù±¸´Ï   3.ÀÌÀü ¸Ş´º·Î   4.½Ã½ºÅÛ Á¾·á\n");

                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 4) {
                    return menu;
                } else {
                    throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<ÀÔ·Â ¿À·ù>");
                System.out.println("1~4¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
            }
        } while (true);

    }
    

    

    void cart() {
    	
        while (true) {

        		cartManager.cartList.get(id).show();
			
        	//Àå¹Ù±¸´Ï º¸¿©ÁÖ±â        	
            switch (this.cartMenu()) {
            case 1: {
                System.out.println("**Àå¹Ù±¸´Ï »óÇ° ±¸¸Å**");
                cartManager.buy();  
                break;
            }
            case 2: {
                System.out.println("**Àå¹Ù±¸´Ï ºñ¿ì±â**");
                cartManager.remove();
                break;
            }

            case 3: {
                return; // returnÇÏ¸é ÇØ´çÇÏ´Â °¡Àå »óÀ§ ¸Ş¼­µå ºí·° Å»Ãâ
            }
            case 4: {
                System.exit(0);
            }

            }

        }

    }
    
    // Ä«Æ® ¸Ş´º È­¸é
    int cartMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****Àå¹Ù±¸´Ï ¸Ş´º*****");
                System.out.println("*********************************");
                System.out.println("1. Àå¹Ù±¸´Ï »óÇ° ±¸¸Å");
                System.out.println();
                System.out.println("2. Àå¹Ù±¸´Ï »óÇ° »èÁ¦");
                System.out.println();
                System.out.println("3. ÀÌÀü ¸Ş´º·Î");
                System.out.println();
                System.out.println("4. ½Ã½ºÅÛ Á¾·á");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 4) {
                    return menu;
                } else {
                    throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<ÀÔ·Â ¿À·ù>");
                System.out.println("1~4¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
            }
        } while (true);

    }

    void myPage() {

        while (true) {
            switch (this.myPageMenu()) {
            case 1: {
                System.out.println("**³» Á¤º¸ Á¶È¸**");
                customerManager.MyInfo();
                break;
            }
            case 2: {
                System.out.println("**ÁÖ¹® ³»¿ª**");
                customerManager.myTransactiontHistory();
                break;
            }
            case 3: {
                System.out.println("**Àå¹Ù±¸´Ï**");
                cart();
                
                break;
            }

            case 4: {
                return; // returnÇÏ¸é ÇØ´çÇÏ´Â °¡Àå »óÀ§ ¸Ş¼­µå ºí·° Å»Ãâ
            }
            case 5: {
                System.exit(0);
            }

            }

        }

    }


    // ¸¶ÀÌÆäÀÌÁö ¸Ş´º È­¸é
    int myPageMenu() {
        int menu = 0;
        do {
            try {
                System.out.println();
                System.out.println("*********************************");
                System.out.println("*****¸¶ÀÌ ÆäÀÌÁö ¸Ş´º*****");
                System.out.println("*********************************");
                System.out.println("1. ³» Á¤º¸ Á¶È¸");
                System.out.println();
                System.out.println("2. ÁÖ¹® ³»¿ª");
                System.out.println();
                System.out.println("3. Àå¹Ù±¸´Ï");
                System.out.println();
                System.out.println("4. ÀÌÀü ¸Ş´º·Î");
                System.out.println();
                System.out.println("5. ½Ã½ºÅÛ Á¾·á");
                System.out.println();
                menu = Integer.parseInt(sc.nextLine());
                if (1 <= menu && menu <= 5) {
                    return menu;
                } else {
                    throw new Exception("¸Ş´º ¼±ÅÃ ¹øÈ£°¡ Àß¸ø µÇ¾ú½À´Ï´Ù");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("<ÀÔ·Â ¿À·ù>");
                System.out.println("1~5¹øÀÇ ¸Ş´º Áß ÇÏ³ª¸¦ ¼±ÅÃÇÏ¼¼¿ä");
            }
        } while (true);

    }

    public static void main(String[] args) {

        Mall mall = new Mall();

        mall.mallMain();

    }

}
