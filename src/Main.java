import view.EntryForm;

import java.sql.SQLException;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException, SQLException {
        //Defined start time for program performance test
        //long startTime = System.currentTimeMillis();

        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2001-08-26");*/


        //Program performance test
        //long endTime = System.currentTimeMillis();
        //long duration = endTime - startTime;
        //System.out.println("run time: " + duration);


        //Account creation test
        /*Service.AccountCreation testAccount = new Service.AccountCreation();
        testAccount.accountCreator("Samet Berkant", "Koca", date, "editkurama@gmail.com");*/

        //Model.Card creation test
        /*Service.CardCreation testCard = new Service.CardCreation();

        testCard.studentCardCreation("Teslime","Koca",date);*/
        /*repository.SystemConnection connection = new repository.SystemConnection();
        connection.loginSystem("5309760723");

         Service.PaymentService payment = new Service.PaymentService();
        payment.payment(200);*/


        // Model.User data getting test
        /*repository.SystemConnection connection = new repository.SystemConnection();
        connection.loginSystem("5419664523");*/

        /*System.out.println("////////// Ticket System //////////");
        System.out.println("\n1-Login\n2-Register");
        Scanner input = new Scanner(System.in);
        int entry = input.nextInt();
        if (entry==1) {
            System.out.println("Enter your email: ");
            String phone = input.next();
            repository.SystemConnection connection = new repository.SystemConnection();
            connection.loginSystem(phone);
        }*/

        EntryForm form = new EntryForm();
    }

}