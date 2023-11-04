package com.dda.crbc.constants;

public enum RequestStatus {

    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String value;

    RequestStatus(String value) {
        this.value = value;
    }

    public static RequestStatus of(String value) {
        for (RequestStatus status : RequestStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException(value + " is not a valid request status");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
