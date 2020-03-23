package Quiz;

import java.io.Serializable;


//도서 클래스

public class Book implements Serializable {

      private final String isbn;

      private String title;

      private String price;



      public Book(String isbn, String title,String price){

             this.isbn = isbn;

             this.title = title;

             this.price = price;

      }

      public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String ISBN(){

             return isbn;

      }

      public String toString(){

             return String.format("ISBN:%s 이름:%s 가격:%s", isbn, title,price);        }

}
