package com.dda.crbc.constants;

public enum UserType {

    ADMINISTRATOR("Admin"),
    APPLICANT("Applicant");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public static UserType of(String value) {
        for (UserType userType : UserType.values()) {
            if (userType.getValue().equals(value)) {
                return userType;
            }
        }
        throw new IllegalArgumentException(value + " is not a valid user type");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
