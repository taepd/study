import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IO_Groupwork {
    static int totalfiles = 0;
    static int totaldirs = 0;

    public static void main(String[] args) throws IOException {

        // java ExDos C:\Temp mkdir newDir
        // java ExDos C:\Temp rename file.txt file2.txt
        // java ExDos C:\Temp delete new.txt

        if (args.length != 2 && args.length != 3 && args.length != 4) {
            System.out.println("사용법 : [java파일명] [디렉토리경로] mkdir [생성디렉토리명]");
            System.out.println("사용법 : [java파일명] [디렉토리경로] rename [파일명] [새로운 파일명]");
            System.out.println("사용법 : [java파일명] [디렉토리경로] delete [파일명]");
            System.out.println("사용법 : [java파일명] [디렉토리경로] copy [파일명] [새로운 파일명]");
            System.out.println("사용법 : [java파일명] [디렉토리경로] type [파일명]");
            System.out.println("사용법 : [java파일명] [디렉토리경로] dir");
            System.exit(0);
        }

        File f = new File(args[0]);
        if (!f.exists() || !f.isDirectory()) { // 존재하지 않거나 디렉토리 아니라면
            System.out.println("유효하지 않은 디렉토리입니다");
            System.exit(0);
        }

        // mkdir
        if (args[1].equals("mkdir")) {
            String path = "";
            path = f + "\\" + args[2];
            File newfile = new File(path);
            if (newfile.exists()) {
                System.out.println("이미 존재하는 디렉토리입니다");
            } else {
                newfile.mkdir();
            }
        }

        // rename
        if (args[1].equals("rename")) {
            String path = "";
            path = f + "\\" + args[2];
            File f1 = new File(path);
            // 원본 파일이 존재하지 않을 때
            if (!f1.exists()) {
                System.out.println("존재하지 않는 파일(폴더)입니다.");
            } else {
                f1.renameTo(new File(f + "\\" + args[3]));
            }

        }

        // delete
        if (args[1].equals("delete")) {
            String path = "";
            path = f + "\\" + args[2];
            File newfile = new File(path);
            if (!newfile.exists()) {
                System.out.println("존재하지 않는 파일(폴더)입니다.");
            } else {
                newfile.delete();
                System.out.println("삭제했습니다.");
            }
        }

        // copy
        if (args[1].equals("copy")) {
            String path = "";
            path = f + "\\" + args[2];
            File f1 = new File(path);
            // 원본 파일이 존재하지 않을 때
            if (!f1.exists()) {
                System.out.println("존재하지 않는 파일입니다.");
                // 바꾸려는 것이 파일인지 체크
            } else if (!f1.isFile()) {
                System.out.println("파일이 아닙니다.");
            } else {
                File f2 = new File(f + "\\" + args[3]);
                f2.createNewFile();
                FileReader fr = new FileReader(path);
                FileWriter fw = new FileWriter(f2.toString());
                try {

                    int data = 0;
                    while ((data = fr.read()) != -1) {
                        fw.write(data);
                    }
                    fw.flush();
                } catch (Exception e) {
                } finally {
                    fr.close();
                    fw.close();
                }
            }

        }
        // type(파일내용 보여주기)
        if (args[1].equals("type")) {
            String path = "";
            path = f + "\\" + args[2];
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("존재하지 않는 파일입니다.");
            } else {
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                    String line = "";
                    for (int i = 0; (line = br.readLine()) != null; i++) {
                        System.out.println(line);
                    }
                } catch (Exception e) {

                } finally {
                    fr.close();
                    br.close();
                }
            }
        }
        if (args[1].equals("dir")) {
            File di = new File(args[0]);
            if (!f.exists() || !f.isDirectory()) {// 존재하지않거나 디렉토리에없다면
                System.out.println("유효하지 않은 디렉토리 입니다.");
                System.exit(0);
            } else {
                printFileList(di);
            }
        }
    }

    static void printFileList(File dir) {

        System.out.println("[파일 full path: ]" + dir.getAbsolutePath());
        ArrayList<Integer> subdir = new ArrayList<Integer>();
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            String filename = files[i].getName();
            if (files[i].isDirectory()) {
                filename = "<DIR> [" + filename + "]";
                subdir.add(i);
            } else {
                filename = filename + "/" + files[i].length() + "byte";
            }
            System.out.println(" " + filename);
        }
        int dirnum = subdir.size(); // 폴더의 개수
        int filenum = files.length - dirnum; // 파일개수

        totaldirs += dirnum; // 총 누적 폴더 개수
        totalfiles += filenum; // 총 파일 누적 개수
        System.out.println("[현재 폴더개수 " + dirnum + "]");
        System.out.println("[현재 파일개수 " + filenum + "]");
        System.out.println("**************************");

    }

}
