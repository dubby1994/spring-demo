package hello;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 1000)
    public void fixedRate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("fixedRate\t:\t" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "10 * * * * *")
    public void cron() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("cron\t\t:\t" + dateFormat.format(new Date()));
    }
}
