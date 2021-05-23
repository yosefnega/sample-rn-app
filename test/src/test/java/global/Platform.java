package global;

public enum Platform {

    ANDROID("Android", "UIAutomator2"),
    IOS("ios", "XCUITest");

    private final String type;
    private final String automator;

    Platform(String type, String automator) {
        this.type = type;
        this.automator = automator;
    }

    public String getType(){
        return this.type;
    }

    public String getAutomator(){
        return this.automator;
    }

    public  static Platform fromString(String type) {
        for (Platform platform: Platform.values()){
                if (platform.type.equals(type)){
                    return platform;
                }
        }
        return null;
    }
}
