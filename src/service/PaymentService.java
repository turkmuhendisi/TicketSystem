package service;

import repository.DatabaseTransactions;

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
