package tests;

import com.microsoft.appcenter.appium.Factory;
import global.BaseFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class SampleTest {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();


    @Before
    public void init(){
        System.out.println("initialize");
    }

    @Test
    public void test(){
        System.out.println("test has run");
    }


    @After
    public void clean() {
        System.out.println("cleanup");

    }
}
