import kr.or.bit.Mouse;
import kr.or.bit.NoteBook;

public class Ex03_Method2 {

	public static void main(String[] args) {
		
		NoteBook notebook = new NoteBook();
		Mouse mouse = new Mouse();
		//mouse аж╪р 
		Mouse mouse2 = notebook.handle(mouse); //public Mouse handle(Mouse m)
		System.out.println(mouse2.x);
		System.out.println(mouse2.y);
		
		
		

	}

}
