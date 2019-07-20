package org.testing.day20190711;

import org.testng.annotations.*;

/**
 * 注解
 */
public class TestNgDemo1 {
    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是@BeforeTest注解");
    }
    @BeforeMethod
    public void beforMethod(){
        System.out.println("这是@BeforeMethod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("这是@Test注解testCase1");
    }
    @Test
    public  void testCase2(){
        System.out.println("这是@Test注解testCase2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是@AfterMethod注解afterMethod");
    }
    @AfterTest
    public void afterTest1(){
        System.out.println("这是@@AfterTest注解afterTest1");
    }
}
