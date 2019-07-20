package org.testing.day20190711;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 校验
 */
public class TestNgDemo2 {
    // 校验 a == a

    /**第一个 值 实际值
     * 第二个 值 预期
     * a,b 不相等 抛出异常
     * assertEquals 判断 两个值是否相等 不相等 抛出异常
     */
    @Test
    public void asserEqualTest(){
        String a = "asdf";
        String b = "asdadf";
        Assert.assertEquals(a,b,"a不等于b");
    }

    /**
     * assertNotEquals() 判断两个值不相等 相等 则抛出异常
     */
    @Test
    public void asserNotEqualTest(){
        int a = 1;
        int b = 1;
        Assert.assertNotEquals(1,1);
    }
    @Test
    public void asserNullTest(){
        String a = "";
        Assert.assertNull(a);
    }
    @Test
    public void asserNotNullTest(){
        String a = null;
        Assert.assertNotNull(a);
    }
    @Test
    public void asserFalseTest(){
        Boolean a = true;
        Assert.assertFalse(a);
    }
}
