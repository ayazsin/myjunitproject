package com.techproed.tests;

import org.junit.*;

public class Day02_FirstJUnitClass {

    //@Test : Create a test case. This let us create and run test cases
    //@Before : Runs before each @Test annotation. Used for repeated pre-condition
    //@After : Runs after each @Test annotation. Used for repeated post conditions
    //@AfterClass , @BeforeClass
    //@Ignore : This is used to skip test cases

    @Before
    public void setUp(){
        System.out.println("This is setup method");
    }

    @Test
    public void test1() {
        System.out.println("Test case 1");
    }
//    This is setup method
//    Test case 1
//    This is tear down method

    @Ignore  //Test ignored.
    @Test
    public void test2(){
        System.out.println("Test case 2");
    }

    @Test
    public void test3() {
        System.out.println("Test case 3");
    }
//    This is setup method
//    Test case 3
//    This is tear down method

    @After
    public void tearDown() {
        System.out.println("This is tear down method");
    }

    //JUNIT ASSERTIONS:
    //We use assertions If expected = actual

    @Test
    public void assertion() {
        System.out.println("Test case 4");
        //1. Assert.assertTrue(statement)
        Assert.assertTrue(3==3);//pass
        //2. Assert.assertFalse(statement)
//        Assert.assertFalse(3==3);//fails
        Assert.assertFalse(4==5);//pass
        Assert.assertFalse("Selenium".contains("a"));//pass
        Assert.assertEquals("java","java");
//        Assert.assertEquals("java","javascript");

//        This is setup method
//        Test case 4
//        This is tear down method

        }


    }


