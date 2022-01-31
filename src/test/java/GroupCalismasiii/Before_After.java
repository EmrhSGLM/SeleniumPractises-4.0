package GroupCalismasiii;

import org.junit.*;

public class Before_After {

    @Before
    public  void before(){
        System.out.println("Before metod");
    }

    @Test
    public void test01(){
        System.out.println("Test01 method");
    }

    @Test
    public void test02(){
        System.out.println("Test02 method");
    }

    @Test
    public void test03(){
        System.out.println("Test03 method");
    }

    @After
    public  void after(){
        System.out.println("After method");
    }
}
