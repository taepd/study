
public class ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for(int i = 2; i<10; i++) {
			for(int j = 1; j<10; j++) {
				System.out.printf("%8s",i + "*" + j + "=" + (i*j));
			}System.out.println();

		}		
		int a=0;
		for( a=1; a<=31;a++) {
			if(a%7!=0) {
				System.out.print(a+" ");
			}else System.out.println(a);
		}
		
	}

}
