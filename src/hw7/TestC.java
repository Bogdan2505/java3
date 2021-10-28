package hw7;

public class TestC {

   @Test(value = 1)
    public static void test1() {
        System.out.println("test1 ");
    }

    @Test(value = 2)
    public static void test2() {
        System.out.println("test2 ");
    }

    @Test(value = 3)
    public static void test3() {
        System.out.println("test3 ");
    }

    @BeforeSuite
    public static void before() {
        System.out.println("test start ");
    }

    @AfterSuite
    public static void after() {
        System.out.println("test end ");
    }
}
