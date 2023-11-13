

import view.register_login.EntryForm;

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
        /*controller.account.AccountCreation testAccount = new controller.account.AccountCreation();
        testAccount.accountCreator("Samet Berkant", "Koca", date, "editkurama@gmail.com");*/

        //model.datamodel.Card creation test
        /*controller.card.CardCreation testCard = new controller.card.CardCreation();

        testCard.studentCardCreation("Teslime","Koca",date);*/
        /*model.db_operations.SystemConnection connection = new model.db_operations.SystemConnection();
        connection.loginSystem("5309760723");

         controller.payment.PaymentService payment = new controller.payment.PaymentService();
        payment.payment(200);*/


        // model.datamodel.User data getting test
        /*model.db_operations.SystemConnection connection = new model.db_operations.SystemConnection();
        connection.loginSystem("5419664523");*/

        /*System.out.println("////////// Ticket System //////////");
        System.out.println("\n1-Login\n2-Register");
        Scanner input = new Scanner(System.in);
        int entry = input.nextInt();
        if (entry==1) {
            System.out.println("Enter your email: ");
            String phone = input.next();
            model.db_operations.SystemConnection connection = new model.db_operations.SystemConnection();
            connection.loginSystem(phone);
        }*/

        EntryForm form = new EntryForm();
    }

}