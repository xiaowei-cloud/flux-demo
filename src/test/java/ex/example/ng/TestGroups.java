package ex.example.ng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * 分组测试
 */
public class TestGroups {

    @Test(groups = "man")
    public void test1(){
        System.out.println("TestGroups.test1");
    }

    @Test(groups = "woman")
    public void test2(){
        System.out.println("TestGroups.test2");
    }

    @Test(groups = "woman")
    public void test3(){
        System.out.println("TestGroups.test3");
    }

    @BeforeGroups("woman")
    public void test4(){
        System.out.println("TestGroups.test4");
    }

    @AfterGroups("woman")
    public void test5(){
        System.out.println("TestGroups.test5");
    }
}
