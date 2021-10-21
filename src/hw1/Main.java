package hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        change(arr, 1, 2);

        Integer[] arr2 = new Integer[]{1, 2, 3, 4};
        arrInList(arr2);

        Box<Apple> boxApple = new Box<>();
        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange = new Box<>();
        Apple[] arrApple = new Apple[]{new Apple(3), new Apple(4), new Apple(1)};
        Apple[] arrApple2 = new Apple[]{new Apple(3), new Apple(4), new Apple(1)};

        for (int i = 0; i < arrApple.length; i++) {
           boxApple.add(arrApple[i]);
            boxApple2.add(arrApple2[i]);
        }
        System.out.println(boxApple.getWeight());
        boxApple.pourOver(boxApple2);


        boxApple.print();
        boxApple2.clear();
        System.out.println("anouther");
        boxApple2.print();
    }

    public static <T> List<T> change(List<T> arr, int i, int j) {
        T t = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, t);
        return arr;
    }

    public static <T> List<T> arrInList(T[] arr) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }

}
