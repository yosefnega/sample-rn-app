package global;

import org.junit.Before;

public class BaseFeature {

    private final Platform platform;

    BaseFeature() {
//        this.platform = Platform.fromString(System.getenv("XTC_PLATFORM"));
        this.platform = Platform.fromString("Android");
    }

    @Before
    public void start() {
        AppManager.init(this.platform);
    }


}
