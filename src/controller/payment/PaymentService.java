package controller.payment;

import controller.account.UserInformationService;
import model.db_operations.DatabaseTransactions;

public class PaymentService {

    DatabaseTransactions databaseTransactions;
    public PaymentService() {
        databaseTransactions = new DatabaseTransactions();
    }

    void payment(int setBalance){
        int cardID = (int) UserInformationService.getUserListInstance().get(5);
        databaseTransactions.cardDataUpdate(setBalance,cardID);
    }
}
