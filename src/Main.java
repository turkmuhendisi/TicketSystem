import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException,SQLException {
        //Defined start time for program performance test
        //long startTime = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2001-08-26");

        //Card creation test
        /*CardCreation testCard = new CardCreation();
        testCard.studentCardCreation("Samet Berkant","Koca", date);*/

        //Program performance test
        //long endTime = System.currentTimeMillis();
        //long duration = endTime - startTime;
        //System.out.println("run time: " + duration);


        // Account creation test
        /*AccountCreation testAccount = new AccountCreation();
        testAccount.accountCreator("Samet Berkant", "Koca", date, "5419664523", 2);*/


        // User data getting test
        SystemConnection connection = new SystemConnection();
        connection.loginSystem("5419664523");
    }
}