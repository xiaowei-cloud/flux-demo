package ex.example.ng;

import org.testng.annotations.Test;

/**
 * 忽略测试
 */
public class TestIgnore {

    @Test
    public void test1(){
        System.out.println("TestIgnore.test1");
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("TestIgnore.test2");
    }

    @Test(enabled = true)
    public void test3(){
        System.out.println("TestIgnore.test3");
    }
}
