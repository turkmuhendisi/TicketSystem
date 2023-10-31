import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException,SQLException {
        //Defined start time for program performance test
        //long startTime = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2001-08-26");



        //Program performance test
        //long endTime = System.currentTimeMillis();
        //long duration = endTime - startTime;
        //System.out.println("run time: " + duration);


        // Account creation test
        /*AccountCreation testAccount = new AccountCreation();
        testAccount.accountCreator("Berat", "Koca", date, "5059046023", 11);

        //Card creation test
        CardCreation testCard = new CardCreation();

        testCard.studentCardCreation("Berat","Koca",date);
        SystemConnection connection = new SystemConnection();
        connection.loginSystem("5059046023");

        PaymentService payment = new PaymentService();
        payment.payment(200);*/


        // User data getting test
        /*SystemConnection connection = new SystemConnection();
        connection.loginSystem("5419664523");*/

        /*System.out.println("////////// Ticket System //////////");
        System.out.println("\n1-Login\n2-Register");
        Scanner input = new Scanner(System.in);
        int entry = input.nextInt();
        if (entry==1) {
            System.out.println("Enter the phone number: ");
            String phone = input.next();
            SystemConnection connection = new SystemConnection();
            connection.loginSystem(phone);
        }*/




    }
}