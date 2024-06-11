package tst.investing.Infrastructure.enums;

public enum Browsers {
    FIREFOX("firefox"),
    SAFARI("safari"),
    CHROME("chrome"),
    EDGE("edge");

    private final String stringValue;

    Browsers(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return this.stringValue;
    }
    
}
