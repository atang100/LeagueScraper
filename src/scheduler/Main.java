package scheduler;

/**
 * Created by Andy on 6/18/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.run();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
    }
}
