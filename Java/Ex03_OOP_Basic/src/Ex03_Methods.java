import kr.or.bit.Mouse;
import kr.or.bit.NoteBook;

public class Ex03_Methods {

    public static void main(String[] args) {
        
        NoteBook notebook = new NoteBook();
        Mouse mouse = new Mouse();
        //mouse¡÷º“
        Mouse mouse2 = notebook.handle(mouse);
        System.out.println(mouse2.x);
        System.out.println(mouse2.y);
        Mouse mouse3 = new Mouse();
        System.out.println(mouse3);
        System.out.println(mouse);
            
        
    }

}
