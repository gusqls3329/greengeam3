package com.green.greengram3;

import org.junit.jupiter.api.*;

public class Exam2 {
    @BeforeEach
    public void BeforeEach() {
        System.out.println("BeforeEach");
    }
    @AfterEach
    public void AfterEach() {
        System.out.println("AfterEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    public void test2() {
        System.out.println("test2");
    }

}
