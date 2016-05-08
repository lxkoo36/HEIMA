package com.itheima.heima50;

import android.test.AndroidTestCase;

import junit.framework.Assert;

/*
 *  @项目名：  Heima5.0 
 *  @包名：    com.itheima.heima50
 *  @文件名:   MyTestCase
 *  @创建者:   肖琦
 *  @创建时间:  2015/5/21 10:48
 *  @描述：    TODO
 */
public class MyTestCase
        extends AndroidTestCase
{


    public void testAdd()
    {
        int a = 10;
        int b = 20;
        Assert.assertEquals(20,
                            a + b);
    }
}
