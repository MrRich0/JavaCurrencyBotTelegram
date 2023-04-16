package org.example;

import java.time.LocalTime;

public class Message {
    public void sendingMessages(String hour, RateResponceDto information) {

        if (hour.trim().equalsIgnoreCase("Вимкнути повідомлення")) {
            System.out.println(information);
        } else {

            while (true) {

                LocalTime localtime = LocalTime.now();
                String time = String.valueOf(localtime.getHour());

                if (time.equals(hour)) {
                    if (localtime.getMinute() < 1) {
                        System.out.println(information);
                    }
                }
            }
        }
    }
}

