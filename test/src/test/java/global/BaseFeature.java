package global;

import org.junit.Before;

public class BaseFeature {


    @Before
    public void start() {
        AppManager.init(System.getenv("XTC_PLATFORM"));
    }
}
