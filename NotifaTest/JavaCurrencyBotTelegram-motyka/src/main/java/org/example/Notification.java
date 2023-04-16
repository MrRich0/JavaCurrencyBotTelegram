package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Notification {
    private ScheduledFuture<?> scheduledFuture;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Notification(RateResponceDto dto, TimeNotification timeReminder) {
        scheduler.execute(() -> sendNotification(dto, timeReminder));
    }

    private void sendNotification(RateResponceDto dto, TimeNotification timeReminder) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime timeReminderObject = LocalTime.parse(timeReminder.getTime(), formatter);
        while (true) {
      
            LocalTime currentTime = LocalTime.now();


            if (currentTime.compareTo(timeReminderObject) >= 0) {
                System.out.println(dto);
                break;
            }
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cancel() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}
