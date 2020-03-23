import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
 
public class Regular_Expression {
//    static String data = "";
//    static String regExp;
    static Scanner sc = new Scanner(System.in); //ÀÔ·Â
 
    public static void main(String[] args) throws Exception {
 
        while (true) {
            System.out.println("1.ÀÌ¸§ 2.ºñ¹Ğ¹øÈ£ 3.ÇÚµåÆù¹øÈ£ 4.ÀÌ¸ŞÀÏ 5.ÁÖ¹Î¹øÈ£ 6.³¡³»±â");
            int a = sc.nextInt();
            sc.nextLine();
 
            switch (a) {
            
            case 1:
                name();
                break;
            case 2:
                pwd();
                break;
            case 3:
                phone();
                break;
            case 4:
                email();
                break;
            case 5:
                jumin();
                break;
            case 6:
                System.out.println("Á¾·áÇÕ´Ï´Ù");
                System.exit(0);
                break;
                
            default:System.out.println("Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
            break;
 
            }
        }
    }
 
    public static void name() {
        
        System.out.println("1.ÀÌ¸§ ÀÔ·Â:");
        // ^ ¶óÀÎÀÇ Ã³À½ÀÌ³ª ¹®ÀÚ¿­ÀÇ Ã³À½À» Ç¥½Ã
        //[] ¾È¿¡ ÀÖ´Â ¹®ÀÚ Áß ÇÏ³ª, ¹üÀ§´Â '-'·Î ÁöÁ¤
        //+¾Õ¿¡´Â ÇÑ ±ÛÀÚ ÀÌ»óÀÇ ´Ü¾î°¡ ¹İµå½Ã ¿Í¾ß ÇÑ´Ù. 0¹øÀÌ»ó ¹İº¹
        //$¹®ÀåÀÇ ³¡
        String regExpaa = "^[¤¡-¤¾°¡-ÆR]+$";
        
        String data = sc.nextLine();
        
       //Á¤±ÔÇ¥Çö½ÄÀÌ ÆĞÅÏ¿¡ ÀÏÄ¡ÇÏ´ÂÁö ¿©ºÎ¸¦ Å×½ºÆ®ÇÑ´Ù.
       //java.util.regex ÆĞÅ°Áö¿¡ ÀÖ´Â Match Å¬·¡½º¿Í Pattern Å¬·¡½º¸¦ »ç¿ëÇÏ¿© 
       //¹®ÀÚ¿­À» Á¤±ÔÇ¥Çö½ÄÀ¸·Î °ËÁõÇÒ ¼ö ÀÖ´Ù.
       boolean b = data.matches(regExpaa); // true ,false
 
        if (b == true) {
            System.out.println("¿Ã¹Ù¸¥ Çü½ÄÀÔ´Ï´Ù , Â¦Â¦Â¦!!");
        } else {
            System.out.println("ÀÌ¸§¿¡´Â ÇÑ±Û¸¸ µé¾î¿Ã¼ö ÀÖ¾î¿ä.");
        }
 
    }
 
    public static void pwd() {
        System.out.println("2.ºñ¹Ğ¹øÈ£ ÀÔ·Â:");
        //[] ´ë°ıÈ£ ¾ÈÀÇ Çü½Ä ÀÏÄ¡¸¦ ÀÇ¹Ì
        //[A-Za-z ¼Ò¹®ÀÚaºÎÅÍ ´ë¹®ÀÚZ ±îÁö¿Í 0-9 ¼ıÀÚ
        //^ :¹®ÀÚ¿­ÀÇ ½ÃÀÛÀ» ³ªÅ¸³¿
        //{} : ¼±Çà¹®ÀÚ°¡ ³ªÅ¸³ª´Â È½¼ö ¶Ç´Â ¹üÀ§¸¦ ³ªÅ¸³½´Ù
        //!@#$%^~*+=- Æ¯¼ö¹®ÀÚ Æ÷ÇÔ
        //{6,20} ¹İº¹°¹¼ö¸¦ ÀÇ¹Ì
        //?=.* Àû¾îµµ ÇÏ³ª
        String regExp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$";
        String data = sc.nextLine();
 
        boolean b1 = data.matches(regExp); // true ,false À¯È¿¼º °Ë»ç
 
        if (b1 == true) {
            System.out.println("¿Ã¹Ù¸¥ Çü½ÄÀÔ´Ï´Ù , Â¦Â¦Â¦!!");
        } else {
            System.out.println("Àß¸ø ÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. 8~20ÀÚ »çÀÌ¿¡ Àû¾îµµ ÇÏ³ªÀÇ ¿µ¾î´ë¹®ÀÚ,Æ¯¼ö¹®ÀÚ°¡ Æ÷ÇÔµÇ¾î¾ß ÇÕ´Ï´Ù.");
        }
    }
 
    public static void phone() {
        System.out.println("3.ÈŞ´ë¹øÈ£ ÀÔ·Â:");
        // ÇÚµåÆù ¾ÕÀÚ¸®(010)
        // °¡¿îµ¥ 4ÀÚ¸®
        // ¸¶Áö¸· 4ÀÚ¸®
        //010Àº È®Á¤Áö¾î³õ°í
        // \d ¼ıÀÚ(Á¤¼ö)
        //{} °ıÈ£ ¾ÈÀÇ ¼ıÀÚ¸¸Å­ ¾ÕÀÇ ¹®ÀÚ¿­À» ¹İº¹
 
        String regExp = "(010)-?\\d{4}-?\\d{4}";
        String data = sc.nextLine();
 
        boolean b2 = data.matches(regExp); // true ,false À¯È¿¼º °Ë»ç
 
        if (b2 == true) {
            System.out.println("¿Ã¹Ù¸¥ Çü½ÄÀÔ´Ï´Ù, Â¦Â¦Â¦!!!");
        } else {
            System.out.println("ÈŞ´ëÀüÈ­´Â 010-xxxx-xxxx ¸¸ µé¾î¿Ã¼ö ÀÖ¾î¿ä. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä!!");
        }
 
    }
 
    public static void email() {
        //@¾Õ¿¡ ¿µ¾î´ë¼Ò¹®ÀÚ ¼ıÀÚ¸¸
        //@µÚ¿¡´Â ¿µ¾î´ë¼Ò¹®ÀÚ¸¸
        //.(Á¡)µÚ¿¡´Â ¿µ¾î´ë¼Ò¹®ÀÚ¸¸
        //{} : ¼±Çà¹®ÀÚ°¡ ³ªÅ¸³ª´Â È½¼ö ¶Ç´Â ¹üÀ§¸¦ ³ªÅ¸³½´Ù
        System.out.println("4.E-Mail ÀÔ·Â:");
 
        String regExp = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        String data = sc.nextLine();
 
        boolean b3 = data.matches(regExp); // true ,false À¯È¿¼º °Ë»ç
 
        if (b3 == true) {
            System.out.println("¿Ã¹Ù¸¥ Çü½ÄÀÔ´Ï´Ù , Â¦Â¦Â¦!!");
        } else {
            System.out.println("E-mail Çü½ÄÀº ex)csyong92@kosta.com ÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·Â ÇÏ¼¼¿ä ");
        }
    }
    public static void jumin(){
          System.out.println("5.ÁÖ¹Î¹øÈ£ ÀÔ·Â:");
          //| : or¸¦ ³ªÅ¸³¿
          //\d ¼ıÀÚ(Á¤¼ö) (0~9)
          //{} ¹®ÀÚ¿­ ¹İº¹ °¹¼ö¸¦ ÀÇ¹Ì - ÀÚ¸®¼ö
          //[1-4] 1~4±îÁö ¼ıÀÚ Çü½ÄÀ» ÀÇ¹Ì
          String regExp = "^\\d{6}-[1-4]\\d{6}";
          String data = sc.nextLine();
          
          boolean b4 = data.matches(regExp); // true ,false À¯È¿¼º °Ë»ç
          
          if(b4 == true){
             System.out.println("¿Ã¹Ù¸¥ Çü½ÄÀÔ´Ï´Ù , Â¦Â¦Â¦!!");
          }
          else {
             System.out.println("ÁÖ¹Î¹øÈ£ Çü½ÄÀº xxxxxx-xxxxxxxÀÌ°í, µŞÀÚ¸® Ã¹¹øÂ° ¹øÈ£´Â 1~4¸¸ ÀÔ·Â °¡´É ÇÕ´Ï´Ù.");
          }
       }
 
    
}