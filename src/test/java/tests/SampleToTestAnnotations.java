package tests;

import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class SampleToTestAnnotations {

    @BeforeSuite(alwaysRun=true)
    public void beforeSuite ()
    {
        System.out.println("before Suite");

    }

    @BeforeTest(alwaysRun=true)
    public void beforeTest ()
    {
        System.out.println("        before Test");

    }

    @BeforeClass(alwaysRun=true)
    public void beforeClass ()
    {
        System.out.println("            before Class");

    }

    @BeforeMethod(alwaysRun=true)
    public void beforeMethod ()
    {
        System.out.println("                before Method");

    }

    @Test(groups="sample")
    public void test1 ()
    {
        System.out.println("                    inside test1");
       // assertTrue(false);



    }

    @Test(groups="test")
    public void test2()
    {
        System.out.println("                    inside test2");
    }

    @Test(groups= {"sample" , "test"})
    public void test3()
    {
        System.out.println("                    inside test3");
    }


    @AfterMethod(alwaysRun=true)
    public void afterMethod ()
    {
        System.out.println("                after Method");

    }

    @AfterClass(alwaysRun=true)
    public void afterClass ()
    {
        System.out.println("            after Class");

    }

    @AfterTest(alwaysRun=true)
    public void AfterTest () {
        System.out.println("        after Test");

    }

    @AfterSuite(alwaysRun=true)
    public void AfterSuite ()
    {
        System.out.println("after Suite");

    }
}
