package module12;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Car> set = new HashSet<>();
        Car car1 = new Car("mazda", "626");
        Car car2 = new Car("mazda", "626");
        set.add(car1);
        set.add(car2);
        car1.setModel("323");
        // System.out.println(set);

        int[][] arr = new int[][] { {1,  2,  3,  4,  5},
                           {6,  7,  8,  9,  10},
              {11, 12, 13, 14, 15},
              {16, 17, 18, 19, 20}};
//        snake(arr);
//        for (int i = 0; i < arr.length; i++ ) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        int[] ar1 = new int[]{1,2,3,4};
        Set<Integer> set1 = new HashSet<Integer>();
        System.out.println(set1.contains(2));
        List<Integer> list = new ArrayList<>();
        list.size();
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        Integer num1 = new Integer(1);
        Integer num3 = new Integer(1);
        int num2 = 1;
        System.out.println(num1 == num3);
        Map<String, String> map = new Hashtable<>();
        Stack<Integer> stack = new Stack<>();

        getInt(num2);
    }

    private static int[][] snake(int arr[][]) {
        for (int i = 0; i < arr.length; i++ ) {
            if (i % 2 == 0) continue;
            int temp;
            int rightIndex = arr[i].length - 1;
            for (int n = 0; n < arr[i].length; n++) {
                if (rightIndex - n <= 0) break;

                temp = arr[i][n];
                arr[i][n] = arr[i][rightIndex];
                arr[i][rightIndex] = temp;
                rightIndex--;
            }
        }
        return arr;
    }

    public int[] commonElements(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr2.length; i++) {
            if (set.contains(arr2[i])) {
                list.add(arr2[i]);
            }
        }
        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public static Integer getInt(Integer i) {
        int a = 2;
        return a;
    }
}
