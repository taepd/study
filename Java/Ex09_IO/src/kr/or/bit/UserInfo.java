package kr.or.bit;

import java.io.Serializable;

/*
 * 객체 통신
 * 객체(Car, Tv) 네트워크, 파일 간(txt파일에 객체 write/read), 프로세스 간의 통신(a.class, b.class)
 * 직렬화: 객체를 분해해서 줄을 세워 보내는 과정
 * 역직렬화: 분해된 객체를 다시 조립하는 과정
 * 실습
 * 대상 >> 파일 > 객체 write(직렬화)
 * 대상>> 파일 > 객체 read(역직렬화)
 * 
 * 단 본드로 붙어있는 것은 직렬화 불가  >> implements Serializable 있어야만 직렬화 가능
*/




public class UserInfo implements Serializable {
    private String name;
    private String pwd;
    private int age;
    
    public UserInfo() {}
    public UserInfo(String name, String pwd, int age) {
        this.name=name;
        this.pwd=pwd;
        this.age=age;
    }
    @Override
    public String toString() {
        return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
    }
    
    
    
    
}
