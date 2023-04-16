package org.example;

public enum TimeNotification {
    NINE("21:36:10"),
    TEN("21:35:50"),
    ELEVEN("11:00:00"),
    TWELVE("12:00:00"),
    THIRTEEN("13:00:00"),
    FOURTEEN("14:00:00"),
    FIFTEEN("15:00:00"),
    SIXTEEN("16:00:00"),
    SEVENTEEN("16:00:00"),
    EIGHTEEN("18:00:00"),
    OFF_NOTIFY("-01:00:00");
    private String time;

    TimeNotification(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
