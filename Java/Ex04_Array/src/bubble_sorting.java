/*Bubble 정렬 조사하고 발표 하기

버블정렬에 대한 정렬 방식을 조사하고 
예제를 만들어 발표하기*/

public class bubble_sorting {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) { // 중복없이 랜덤 수 뽑기

            arr[i] = (int) (Math.random() * 100 + 1);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) { // 랜덤 배열 출력
            System.out.print(arr[i] + " ");
        }
        System.out.println();

//        for (int i = 0; i < arr.length; i++) { // 버블 정렬 알고리즘
//            for (int j = 1; j < arr.length - i; j++) {
//                if (arr[j - 1] > arr[j]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = tmp;
//                    for (int k = 0; k < arr.length; k++) { // 정렬되는 과정 출력
//                        System.out.print(arr[k] + " ");
//
//                    }
//                    System.out.println();
//
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i++) { // 역버블 정렬 알고리즘
            for (int j = arr.length-1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    for (int k = 0; k < arr.length; k++) { // 정렬되는 과정 출력
                        System.out.print(arr[k] + " ");

                    }
                    System.out.println();

                }
            }
        }

    }

}
