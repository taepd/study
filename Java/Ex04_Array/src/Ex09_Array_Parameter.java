

class Human {
    String name;
}

class OverTest {
    int add(int i, int j) {
        return i + j;
    }

    void add(Human human) {
        System.out.println(human.name);
    }

    int add(int param) {
        return param;
    }

    // point : 배열도 타입이다
    int[] add(int[] param) {
        int[] target = new int[param.length];
        for (int i = 0; i < param.length; i++) {
            target[i] = param[i] + 1;
        }

        return target;

    }

    int[] add(int[] so, int[] so2) {       //so2배열값을 받아, so에 입력
        // error없이 동작가능.... 마음대로 코드 작업
//        for (int i = 0; i < so.length; i++) {  //내가 짠거
//            so[i] = so2[so.length - i - 1];
//        }
//        return so;
        int length = (so.length > so2.length) ? so.length : so2.length;
        int[] resultarray = new int[length];
        
        for(int i = 0 ; i < resultarray.length ; i++) {
            resultarray[i] = so[i] + so2[i];
        }
        
        return resultarray;
    }
}

public class Ex09_Array_Parameter {

    public static void main(String[] args) {
        OverTest ot = new OverTest();
        // int[] add(int[] param) error 없이 사용해 보세요
        int[] source = { 10, 20, 30, 40, 50 };
        int[] tmp = new int[5];
        int[] target = ot.add(source);
        for(int ta : target) {
            System.out.println(ta);
        }
        int[] target2 = ot.add(tmp, source);
        for (int ta : target2) {
            System.out.println(ta);
        }

    }
}