import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	String baseDir = "C:\\Temp"; //검색할 디렉토리
	String word = "HELLO"; //검색할 단어
	String save = "result.txt";// HELLO 단어가 들어있는 파일을 찿아서 
	//1.txt  >>HELLO
	//2.txt
	void Find() throws IOException{
		File dir = new File(baseDir);
		if(!dir.isDirectory()) {
			System.out.println("basedir : " + "is not directory");
			System.exit(0);
		}
		PrintWriter writer = new PrintWriter(new FileWriter(save));
		BufferedReader br = null;
		
		File[] files = dir.listFiles();
		for(int i = 0 ; i < files.length ; i++) {
			if(!files[i].isFile()) {
				continue; //파일이 아닌경우 아래코드  skip
			}
			//파일이라면 ... 
			br = new BufferedReader(new FileReader(files[i]));
			
			//a.txt >> 한문장씩 read 
			//HELLO WROLD 만세 
			//각 파일의 데이터 라인단위를 읽어서
			String line="";
			while((line = br.readLine()) != null) {
				if(line.indexOf(word) != -1) { //HELLO 단어가 문장에 포함되어 있으면
					writer.write("word" + "=" + files[i].getAbsolutePath() + "\n");
				}
			}
			writer.flush();
		}
		
		br.close();
		writer.close();
		
	}
	
	
	public static void main(String[] args) {
			Ex12_PrintWriter_String_Finder StringFinder = new Ex12_PrintWriter_String_Finder();
			try {
				StringFinder.Find();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
