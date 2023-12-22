package com.green.greengram3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exam1 {
    @Test
    @DisplayName("테스트1")
    public void test(){
        System.out.println("test1");
        int sum = 2+2;
        Assertions.assertEquals(4, sum); //왼쪽값(기대하는 값)고 오른쪽값(실제 값)같은 비교
    }
    @Test
    public void test2(){
        System.out.println("test1");
        int sum = 2*3;
        Assertions.assertEquals(6, sum);
    }
    @Test
    @DisplayName("MyUtils")
    public void test3(){
        Assertions.assertEquals(4, MyUtils.sum(2,2));
        Assertions.assertEquals(5, MyUtils.sum(2,3));
        Assertions.assertEquals(15, MyUtils.sum(10,5));
        Assertions.assertEquals(18, MyUtils.sum(9,9));

    }
    @Test
    @DisplayName("multi")
    public void test4(){
       MyUtils myUtils = new MyUtils();
        Assertions.assertEquals(16, myUtils.multi(2,8));
        Assertions.assertEquals(18, myUtils.multi(3,6));
        Assertions.assertEquals(20, myUtils.multi(4,5));
        Assertions.assertEquals(30, myUtils.multi(5,6));
    }


}
