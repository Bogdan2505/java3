package hw7;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        try {
            start(TestC.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void start(Class c) throws NoSuchMethodException {
        //  Method[] methodsAfter = c.getAnnotations(@AfterSuite);
        Method[] methods = c.getDeclaredMethods();

        //  int count = 1;
        int countA = 0;
        int countB = 0;

        for (Method m : methods) {

            if (m.getAnnotation(AfterSuite.class) != null) {
                countA++;
            }
            if (m.getAnnotation(BeforeSuite.class) != null) {
                countB++;
            }
        }
        if (countA != 1 || countB != 1) {
            throw new RuntimeException();
        }

        TestC.before();
        for (Method m : methods) {
            // Method m = c.getMethod("advAnnotatedMethod", null);
            if (m.getAnnotation(Test.class) != null) {
                Test test = m.getAnnotation(Test.class);
                if (test.value() == 1) {
                    TestC.test1();
                } else if (test.value() == 2) {
                    TestC.test2();
                } else if (test.value() == 3) {
                    TestC.test3();
                }
            }
        }
        TestC.after();
    }

}
