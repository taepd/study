import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

//출력형식 정의
//친척 : printf , String.format()
public class Ex11_PrintWriter {
	public static void main(String[] args) {
		try {
			//파일에 print문을 이용해서 간편하게 입력
			PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
			pw.println("*******************************************");
			pw.println("*             HOMEWORK                    *");
			pw.println("*******************************************");
			pw.printf("%3s : %5d  %5d  %5d  %5.1f", "아무개",100,90,50,(float)((100+90+50)/3));
			pw.println();
			pw.close(); //close() 
			
			//homework.txt read (Line)
			//BufferedReader와 String readLine() 이용해 라인별로 읽어들임
			FileReader fr = new FileReader("C:\\Temp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			String s="";
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			fr.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
			//여기다 .. ^^!
		}
	}

}
