import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * I/O
 * 추상클래스
 * InputStream, outPutStream  (Byte)
 * 두 개의 클래스를 상속(재정)하는 클래스를 통해 입출력 작업
 * 
 * 대상에 따라서 
 * 1. Memory: ByteArrayIn ...  /ByteArrayOut ...
 * 2. File(^^): FileInput ... / FileOutput ...
*/


public class Ex01_Stream {

    public static void main(String[] args) throws IOException {

        //byte(-128~127) 정수가 저장 타입
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null; //현재는 메모리를 가지고 있지 않아요
        
        //내가 데이터를 read, write하는 대상을 Memory
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;
        
        input = new ByteArrayInputStream(inSrc);
        //생성자를 통해서 inSrc 배열의 값을 read할 준비
        output = new ByteArrayOutputStream(); //write
        
        System.out.println("outSrc before : "+Arrays.toString(outSrc));
        
        //공식같은 로직(암기)
        int data = 0;
        while((data=input.read())!=-1) { //더 이상 read할 data가 없다면 -1 리턴하므로
            System.out.println("data: "+data);
//            System.out.println("input.read()" +input.read()); //read()함수는 내부적으로 next() 기능 포함한다. 따라서 이 while문에서 read()가 두 번 적용되는 것 
            output.write(data);
            //자기자신에게 data 변수의 값을 read해서 write  
            //write하는 대상이 output  (ByteArrayOutoutStream) 자신의 통로에 read 가지고 있다
        }
        outSrc = output.toByteArray();
        //toByteArray >> 자신이 가지고 있는 값을 배열로 만들어서 그 주소값을 outSrc에게 할당
        System.out.println("outSrc: "+Arrays.toString(outSrc));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
