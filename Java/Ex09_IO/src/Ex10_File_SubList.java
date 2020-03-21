import java.io.File;
import java.util.ArrayList;

public class Ex10_File_SubList {
	static int totalfiles = 0;
	static int totaldirs = 0;

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("사용법: java [실행할 파일명] [경로명]");
			System.out.println("예시: java Ex10_File_SubList C:\\Temp");
			System.exit(0);
		}

		File f = new File(args[0]);

		// 경로명 체크(폴더여야 함)
		if (!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);
		}

		// 정상적인 경로, 폴더
		printFileList(f);
		System.out.println("누적 총 파일 수: " + totalfiles);
		System.out.println("누적 총 폴더 수: " + totaldirs);

	}

	static void printFileList(File dir) {
		System.out.println("[Full Path: " + dir.getAbsolutePath() + "]");
		ArrayList<Integer> subdir = new ArrayList<Integer>();
		File[] files = dir.listFiles();
		// C:\\Temp
		// files[0] >> a.txt
		// files[1] >> aaaa

		for (int i = 0; i < files.length; i++) {
			String filename = files[i].getName(); // 폴더명 or 파일명
			if (files[i].isDirectory()) {
				filename = "<DIR> [" + filename + "]"; // 폴더라면 이렇게
				subdir.add(i); // 하위폴더 어레이리스트 files배열에서 폴더인 것의 인덱스가 저장
			} else {
				filename = filename + "/" + files[i].length() + "Byte"; // 파일이라면 이렇게
			}
			System.out.println("   " + filename);

		}
		int dirnum = subdir.size(); // 폴더 개수
		int filenum = files.length - dirnum; // 파일개수

		// 누적값(폴더 맻개 파일 몇개)
		totaldirs += dirnum;
		totalfiles += filenum;

		System.out.println("[Current dirNum] : " + dirnum);
		System.out.println("[Current fileNum] : " + filenum);
		System.out.println("******************************");

		// Point
		for (int i = 0; i < subdir.size(); i++) {
			int index = subdir.get(i);
			printFileList(files[index]); // subdir에 저장한 files의 index값 이용
		}
	}
}
