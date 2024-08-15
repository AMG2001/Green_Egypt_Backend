package tech.amg.user_service.domain.enums;

public enum Credintial {
    USER("USER"),
    STAFF("STAFF"),
    ADMIN("ADMIN");

    private final String stringValue;

    Credintial(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

}
